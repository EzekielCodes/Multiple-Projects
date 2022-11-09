package postorder.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import postorder.Configuratie;

/**
 *
 * @author evertjan.jacobs
 */
public class DataLayerJDBC {

    private final String dbUrl = "jdbc:mysql://localhost:3306/";
    private final String login = "root";
    private final String pass = "root";
    private final Connection con;

    public DataLayerJDBC(String dbName) throws SQLException {
        createDatabase(dbName);
        this.con = getConnection(dbName);
        this.con.setAutoCommit(false);
    }

    private void createDatabase(String dbName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //create database
            conn = getConnection("");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
            stmt.executeUpdate(sql);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }

            try {
                if (conn != null) {

                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private Connection getConnection(String dbName) throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl + dbName + "?allowMultiQueries=true&serverTimezone=UTC", login, pass);
        return conn;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public List<Bestelling> geefBestellingen() {
        List<Bestelling> bestellingen = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.querySorteerBestellingen);
            while (rs.next()) {
                int bestellingId = rs.getInt("id");
                int klantId = rs.getInt("klant_id");
                Date datum = rs.getDate("datum");
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(datum);
                Bestelling bestelling = new Bestelling(bestellingId, klantId, calendar);

                bestellingen.add(bestelling);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return bestellingen;
    }

    public int geefAantalBestellingenVanOktober() {
        return getValue(Configuratie.queryAantalBestellingOktoberVorigJaar);
    }

    public List<Artikel> geefArtikelenGeleverdInWeekend() {
        List<Artikel> artikelen = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryArtikelenGeleverdInWeekend);
            while (rs.next()) {
                int artikelId = rs.getInt(1);
                String beschrijving = rs.getString(2);
                Artikel artikel = new Artikel(artikelId, beschrijving);
                artikelen.add(artikel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return artikelen;
    }

    public List<Artikel> geefArtikelenNietGeleverd() {
        List<Artikel> artikelen = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryArtikelenNogNietGeleverd);
            while (rs.next()) {
                int artikelId = rs.getInt(1);
                String beschrijving = rs.getString(2);
                Artikel artikel = new Artikel(artikelId, beschrijving);
                artikelen.add(artikel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return artikelen;
    }

    public List<Calendar> geefDatumsBestellingenVanMichel() {
        List<Calendar> datums = new ArrayList<>();
        Statement stmt = null;
        Calendar calendar;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryDataBestellingenMichelHollands);
            while (rs.next()) {
                Date datum = rs.getDate(1);
                calendar = Calendar.getInstance();
                calendar.setTime(datum);
                datums.add(calendar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return datums;
    }

    public List<Artikel> geefArtikelenBinnenDeDagGeleverd() {
        List<Artikel> artikelen = new ArrayList<>();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryArtikelenGeleverdMaxVolgendeDag);
            while (rs.next()) {
                int artikelId = rs.getInt(1);
                String beschrijving = rs.getString(2);
                Artikel artikel = new Artikel(artikelId, beschrijving);
                artikelen.add(artikel);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return artikelen;
    }

    public LinkedHashMap<String, Integer> geefKlantMetMeesteBestellingen() {
        LinkedHashMap<String, Integer> klantMetBestelling = new LinkedHashMap<>();

        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryKlantMetMeesteBestellingen);
            while (rs.next()) {
                String naam = rs.getString(1);
                String voornaam = rs.getString(2);
                int aantal = rs.getInt(3);
                klantMetBestelling.put(naam + " " + voornaam, aantal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return klantMetBestelling;
    }

    public int geefAantalArtikelenNooitBesteld() {
        return getValue(Configuratie.queryAantalArtikelenNooitBesteld);
    }

    public double geefTotaleKostBestellingenVanOktober() {
        double som = 0;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.querySomBestellingenOktober);
            if (rs.next()) {
                som = rs.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return som;
    }

    public int geefKlantenZonderBestellingenMetSQ() {
        return getValue(Configuratie.queryKlantenZonderBestellingenMetSubQuery);
    }

    public int geefKlantenZonderBestellingenZonderSQ() {
        return getValue(Configuratie.queryKlantenZonderBestellingenZonderSubQuery);
    }

    public LinkedHashMap<String, Integer> geefTop5GemeenteVolgensAantalBestellingen() {
        LinkedHashMap<String, Integer> aantalBestellingenPerGemeente = new LinkedHashMap<>();

        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryTop5GemeentenVolgensAantalBestellingen);
            while (rs.next()) {
                String gemeente = rs.getString(1);
                int aantal = rs.getInt(2);
                aantalBestellingenPerGemeente.put(gemeente, aantal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return aantalBestellingenPerGemeente;
    }

    public int getValue(String query) {
        int aantal = -1;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                aantal = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return aantal;
    }

}

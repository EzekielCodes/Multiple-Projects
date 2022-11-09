package data;

import logica.Bezoeker;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evertjan.jacobs
 */
public class DataLayerJDBC {

    private final String dbUrl = "jdbc:mysql://localhost:3306/";
    private final String login = "root";
    private final String pass = "root";
    private final Connection con;
    //private final String dbName;

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
            conn = DriverManager.getConnection(dbUrl, login, pass);
            stmt = conn.createStatement();
            String sql = Configuratie.databaseCreatie + dbName;
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
        return DriverManager.getConnection(dbUrl + dbName+ "?allowMultiQueries=true", login, pass);
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

    public void dropTabel() {
        execute(Configuratie.tabelVerwijdering);
    }

    public void defineTabel() {
        execute(Configuratie.tabelDefinitie);
    }

    public void changeTabel() {
        execute(Configuratie.dataTypeWijziging);
    }

    public void addData() {
        execute(Configuratie.data);
    }

    public void updateBezoeker() {
        execute(Configuratie.familienaamWijziging);
    }

    public void updateStraat() {
        execute(Configuratie.straatWijziging);
    }

    public void deleteBezoekers() {
        execute(Configuratie.bezoekersVerwijdering);
    }

    public int getSomPostcodes() {
        int som = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.querySomPostcodes);
            if (rs.next()) {
                som = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return som;
    }

    public int getAantalBezoekers() {
        int aantal = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryAantalBezoekers);
            if (rs.next()) {
                aantal = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aantal;
    }

    public int getAantalBezoekersMetPostcode() {
        int aantal = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryAantalBezoekersMetPostcode);
            if (rs.next()) {
                aantal = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aantal;
    }

    public List<Bezoeker> readBezoekers() {
        List<Bezoeker> bezoekers = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryAlleBezoekers);
            while (rs.next()) {
                int bezoekerId = rs.getInt("bezoeker_id");
                String naam = rs.getString("naam");
                String voornaam = rs.getString("voornaam");
                String straat = rs.getString("straat_en_nummer");
                String gemeente = rs.getString("gemeente");
                String postcode = rs.getString("postcode");
                String land = rs.getString("land");
                Bezoeker bezoeker = new Bezoeker(bezoekerId, naam, voornaam, straat, gemeente, postcode, land);
                bezoekers.add(bezoeker);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bezoekers;
    }

    public List<Bezoeker> readBezoekersInfo() {
        List<Bezoeker> bezoekers = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryBeperkteInfoAlleBezoekers);
            while (rs.next()) {
                String naam = rs.getString("naam");
                String voornaam = rs.getString("voornaam");
                String land = rs.getString("land");
                Bezoeker bezoeker = new Bezoeker(naam, voornaam, land);
                bezoekers.add(bezoeker);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bezoekers;
    }

    public LinkedHashMap<String, Integer> readAantalBezoekersPerLand() {
        LinkedHashMap<String, Integer> bezoekerPerLand = new LinkedHashMap<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryAantalBezoekersPerLand);
            while (rs.next()) {
                String naam = rs.getString("land");
                int aantal = rs.getInt("aantal");
                bezoekerPerLand.put(naam, aantal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bezoekerPerLand;
    }

    public String describe() {
        String description = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Configuratie.queryTypePostcode);
            if (rs.next()) {
                description = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return description;
    }

    private void execute(String query) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DataLayerJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package data;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import logica.*;
import logica.ENUM.Kleur;

public class connectie {
    private String dbName = "pandemie";
    private final String login = "pandemie";
    private final String pass = "Azerty123";
    private Connection con;
    private List <Steden> steden;


        public List<Steden> selectSteden() throws SQLException {
            List<Steden> stedenList = null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM steden");
            stedenList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                int x = rs.getInt("x");
                String naam = rs.getString("naam");
                int y = rs.getInt("y");
                int onder = rs.getInt("onderzoekscentrum");
                String kleur = rs.getString("kleur");
                Steden steden = new Steden(id,naam, Kleur.valueOf(kleur),x,y,onder);
                stedenList.add(steden);
            }
            return stedenList;
        }


    public List<Steden> getSteden() {
        return steden;
    }

    public int spellenID(LocalDateTime start) throws SQLException {
        String test = String.valueOf(start).replace("T"," ");
        String control = "2021-05-25 20:24:37";
        //String test = String.valueOf(start).replace("T"," ");
        int x = 0;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select spellen.id from spellen where spellen.start = '" + test + "'");

        while (rs.next()) {
            x = rs.getInt("id");
        }
        return x;
    }

//    public List<stadOne> selectStadOne() throws SQLException {
//        List<stadOne> stadOneList = new ArrayList<>();
//
//        Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT x , y FROM pandemie.steden join  connecties ON connecties.stad1_id = steden.id where connecties.stad1_id = steden.id;");
//        rs.first();
//        while (rs.next()) {
//            int x = rs.getInt("x");
//            int y = rs.getInt("y");
//            stadOne stadone = new stadOne(x,y);
//            stadOneList.add(stadone);
//        }
//
//        return stadOneList;
//    }

    public List<stadOne> selectStadOne() throws SQLException {
        Statement stmt = null;
        List<stadOne> stadOneList = null;
        try {
            stmt = this.con.createStatement();
            //createStudentenDB(stmt);
            ResultSet rs = stmt.executeQuery("SELECT x , y FROM steden  join  connecties ON connecties.stad1_id = steden.id where stad1_id= steden.id order by stad2_id;");
            stadOneList = new ArrayList<>();
            while (rs.next()) {
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                stadOne stad = new stadOne(x, y);
                stadOneList.add(stad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return stadOneList;
    }

    public List<stadTwo> selectStadTwo() throws SQLException {
        List<stadTwo> stadTwoList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT x , y\n" +
                "FROM pandemie.steden\n" +
                "join  connecties ON connecties.stad2_id = steden.id\n" +
                "where connecties.stad2_id = steden.id;");
        stadTwoList = new ArrayList<>();
        while (rs.next()) {
            int x = rs.getInt("x");
            int y = rs.getInt("y");
            stadTwo stadtwo = new stadTwo(x,y);
            stadTwoList.add(stadtwo);
        }
        return stadTwoList;
    }

    public List<Stad> selectStad(String stadNaam) throws SQLException {
        List<Stad> stadList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select x,y from steden where steden.naam = '" + stadNaam + "';");
        stadList = new ArrayList<>();
        while (rs.next()) {
            int x = rs.getInt("x");
            int y = rs.getInt("y");
            Stad stad= new Stad(x,y);
            stadList.add(stad);
        }
        return stadList;
    }

    public ArrayList selectStad(ArrayList stad) throws SQLException {
        stad = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select steden.naam from steden;");

        while (rs.next()) {
            String naam  = rs.getString("naam");

            stad.add(naam);
        }
        return stad;
    }

    public ArrayList selectListConnnected(int id) throws SQLException {
        ArrayList <Integer> connected = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select connecties.stad1_id , connecties.stad2_id from connecties where stad1_id = '" + id + "' or stad2_id = '" + id + "'; ");

        while (rs.next()) {
            int naam1 = rs.getInt("stad1_id");
            int naam2 = rs.getInt("stad2_id");

            connected.add(naam1);
            connected.add(naam2);
        }
        return connected;
    }


    public List<Rollen> selectRollen() throws SQLException {
        List<Rollen> rollenList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM rollen");
        rollenList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            String beschrijving = rs.getString("beschrijving");
            Rollen rollen = new Rollen(id,naam,beschrijving);
            rollenList.add(rollen);
        }
        return rollenList;
    }
    public List<Spellen> selectSpellen() throws SQLException {
        List<Spellen> spellenList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM spellen");
        spellenList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            LocalDateTime start = LocalDateTime.parse(rs.getString("start"));
            LocalDateTime einde = LocalDateTime.parse(rs.getString("einde"));
            byte gewonenn = rs.getByte("gewonnen");
            Spellen spellen = new Spellen(id,start,einde,gewonenn);
            spellenList.add(spellen);
        }
        return spellenList;
    }

    public List<spelers> selectSpelers() throws SQLException {
        List<spelers> spelersList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM spellen");
        spelersList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("spel_id");
            String kleur = rs.getString("kleur");
            int rol_id  = rs.getInt("rol_id");
            String naam = rs.getString("naam");
            spelers speler = new spelers(id,Kleur.valueOf(kleur),naam,rol_id);
            spelersList.add(speler);
        }
        return spelersList;
    }

    public String selectRol(int id , String naam) throws SQLException {
        String rol = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select rollen.naam from rollen join spelers on spelers.rol_id = rollen.id where spelers.naam = '" + naam + "' AND spelers.spel_id = '" + id + "';");

        while (rs.next()) {
             rol = rs.getString("naam");
        }
        return rol;
    }


    public String selectBeschrijving(String rol) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select rollen.beschrijving from rollen where rollen.naam = '" + rol + "';");

        while (rs.next()) {
            rol = rs.getString("beschrijving");
        }
        return rol;
    }



    public int selectId () throws SQLException {
        int id  = 0;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(" select max(spellen.id) from spellen; ");

        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public int selectIdStad (String naam) throws SQLException {
        int id  = 0;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(" select steden.id from steden where steden.naam = '" + naam + "' ");

        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    public String selectNaamStad (int id) throws SQLException {
        String naam  = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select steden.naam from steden where steden.id = '"+ id +"';");

        while (rs.next()) {
            naam = rs.getString("naam");
        }
        return naam;
    }

    public String selectKleur(int id, String naam) throws SQLException {
        String kleur = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select spelers.kleur from spelers where spelers.naam = '" + naam + "' AND spelers.spel_id = '" +  id + "' ;");

        while (rs.next()) {
            kleur = rs.getString("kleur");
        }
        return kleur;
    }

    public ArrayList selectNamen(ArrayList namen , int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select spelers.naam from spelers where spelers.spel_id = '" +  id +"' ;");

        while (rs.next()) {
            String naam  = rs.getString("naam");

            namen.add(naam);
        }
        return namen;
    }


    public List<Connectie> getConnectie() throws SQLException {
        List<Connectie> connectieList = null;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM connecties");
        connectieList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("stad1_id");
            int x = rs.getInt("stad2_id");

            Connectie connectie = new Connectie(id,x);
            connectieList.add(connectie);
        }
        return connectieList;
    }

        public String getDbName() {
            return dbName;
        }

    public connectie(String dbName, boolean alternative){
            this.dbName = dbName;
            if (alternative) {
                makeConnectionAlternative();
            } else {
                makeConnection();
            }
        }

        private void makeConnection() {
            try {
                this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + dbName + "?serverTimezone=UTC&allowMultiQueries=true", login, pass);

            } catch (SQLException ex) {
                Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void makeConnectionAlternative() {
            try {
                Properties connectionProps = new Properties();
                connectionProps.setProperty("pandemie", this.login);
                connectionProps.setProperty("Azerty123", this.pass);
                this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                        + dbName + "?serverTimezone=UTC&allowMultiQueries=true", connectionProps);
            } catch (SQLException ex) {
                Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    public void insertSpeler(int id, Kleur kleur, String rol,String naam) throws SQLException {

            PreparedStatement stmt = null;
            try {
                //stmt = this.con.prepareStatement("INSERT INTO studenten (voornaam) VALUES (?)");
                stmt = this.con.prepareStatement("Insert into spelers (spel_id ,  kleur,rol_id,naam) " +
                        "values (?,?,(select rollen.id from rollen where rollen.naam = ?),?)");
                stmt.setInt(1, id);
                stmt.setString(2,kleur.toString());
                stmt.setString(3, rol);
                stmt.setString(4,naam);
                stmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }

    public void updateOnderzoekcentrum(int aantal, String stadNaam) throws SQLException {
        Statement stmt = null;

        try {

            stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

            int test = stmt.executeUpdate("update steden Set steden.onderzoekscentrum =  '" + aantal + "' where (steden.naam = '" + stadNaam + "' AND steden.id <> 0);");
        } catch (SQLException ex) {
            Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public int getonderzoek(String stadNaam) throws SQLException {
        Statement stmt = null;
        int onderzoek = 0;

        try {
            stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery("select steden.onderzoekscentrum From steden where steden.naam = '" + stadNaam + "' ;");
            //ResultSet rs = stmt.executeQuery("SELECT id,voornaam, familienaam, straat,postcode, gemeente  FROM Studenten");

            while (rs.next()) {
                onderzoek = rs.getInt("onderzoekscentrum");
            }

        } catch (SQLException ex) {
            Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return onderzoek;
    }

    public void insertSpellen(LocalDateTime start) throws SQLException {
        Statement stmt = null;
        try {
            stmt = this.con.createStatement();
            stmt.execute("insert into spellen (spellen.start) VALUES('" + start + "')");
        } catch (SQLException ex) {
            Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertRollen(String naam, String beschrijving) throws SQLException {
        Statement stmt = null;

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet uprs = stmt.executeQuery("INSERT INTO rollen (naam,beschrijving)\n" +
                    "VALUES (\"Containment Specialist\",\" Verwijder een steen in elke stad waar je komt op voorwaarde dat deze stad twee of drie ziektestenen bevat.\");\n" +
                    "\n" +
                    "INSERT INTO rollen (naam,beschrijving)\n" +
                    "VALUES (\"Operations Expert\",\" Bouw een onderzoeksstation in de stad waar je beurt eindigt indien deze stad nog geen onderzoeksstation heeft. Je neemt geen ziektesteen weg. \");\n" +
                    "\n" +
                    "INSERT INTO rollen (naam,beschrijving)\n" +
                    "VALUES (\"Medic\",\" Verwijder alle stenen in de stad waar je eindigt. \");\n" +
                    "\n" +
                    "INSERT INTO rollen (naam,beschrijving)\n" +
                    "VALUES (\"Generalist\",\" Doe vier acties per beurt, dus drie stappen en één ziektesteen verwijderen.\");\n" +
                    "\n" +
                    "INSERT INTO rollen (naam,beschrijving)\n" +
                    "VALUES (\"Quarantine Specialist\",\" Er kunnen geen stenen meer bijkomen in de stad waar je je bevindt. \");");
            uprs.moveToInsertRow();
            uprs.updateString("beschrijving", beschrijving);
            uprs.updateString("naam", naam);
            uprs.insertRow();
            uprs.beforeFirst();

        } catch (SQLException ex) {
            Logger.getLogger(connectie.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    }



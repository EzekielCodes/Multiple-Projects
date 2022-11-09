import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datalaag {
    private String dbName;
    private final String login = "root";
    private final String pass = "Azerty123";
    private Connection con;


    public String getDbName() {
        return dbName;
    }

    public Datalaag(String dbName, boolean alternative){
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
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void makeConnectionAlternative() {
        try {
            Properties connectionProps = new Properties();
            connectionProps.setProperty("user", this.login);
            connectionProps.setProperty("password", this.pass);
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
                    + dbName + "?serverTimezone=UTC&allowMultiQueries=true", connectionProps);
        } catch (SQLException ex) {
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Dvd> getDvdLijst() throws SQLException {
        Statement stmt = null;
        List<Dvd> dvdList = null;
        try {
            stmt = this.con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            //createStudentenDB(stmt);

            ResultSet rs = stmt.executeQuery("SELECT * FROM dvds");
            dvdList = new ArrayList<>();
            //rs.first();
            while (rs.next()) {
                int id = rs.getInt("id");
                String voornaam = rs.getString("voornaam");
//                String familienaam = rs.getString("familienaam");
//                String straat = rs.getString("straat");
//                String gemeente = rs.getString("gemeente");
//                int postcode = rs.getInt("postcode");
                Dvd dvd = new Dvd();
                dvdList.add(dvd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datalaag.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return dvdList;
    }
}

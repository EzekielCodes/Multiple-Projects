package data;

/**
 *
 * @author evertjan.jacobs
 */
public class Configuratie {

    public static String databaseCreatie = "CREATE DATABASE IF NOT EXISTS ";
    public static String tabelVerwijdering = "DROP TABLE IF EXISTS bezoekers;";
    public static String queryAlleBezoekers = "SELECT * FROM bezoekers;";
    public static String queryTypePostcode = "DESCRIBE bezoekers postcode;";

    //Stel de CREATE TABLE instructie op voor bovenstaande bezoekers tabel. Denk na over de kolomtypes die je kiest en de attributen die je zal gebruiken.
    //Zorg ervoor dat het datatype van de kolom postcode een string is. Later zullen we dit wijzigen naar een datatype integer.
    public static String tabelDefinitie = "CREATE table bezoekers(" +
            "bezoeker_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT," +
            "    naam VARCHAR(50) NOT NULL," +
            "    voornaam VARCHAR(50) NOT NULL," +
            "    straat_en_nummer VARCHAR(50) NOT NULL," +
            "    gemeente VARCHAR(50) NOT NULL," +
            "    postcode VARCHAR(5) NOT NULL," +
            "    land CHAR(2) NOT NULL," +
            "    PRIMARY KEY (bezoeker_id)" +
            ");";

    //Voeg alle data toe aan de tabel met INSERT instructies.
    public static String data = "INSERT into bezoekers VALUES" +
            "(null, 'Peters' , 'Jan', 'Pierstraat 5' ,'Aartselaar','2630','BE')," +
            "(null,'Degrootte','Nick','Palmboomstraat 4','Diest','3290','BE')," +
            "(null,'Deridder','Eva','Pelserstraat 17','Maaseik','3680','BE')," +
            "(null, 'Wilms' , 'Frederik','Molendreef 121','Waasmunster','9250','BE')," +
            "(null,'Moons','Anja','Rue des Brasseurs 13','Mons','7000','BE')," +
            "(null,'Van gogh', 'Sara','rue van gogh 12','Paris','75012','FR')," +
            "(null,'Richard','Pierre','Rue de Soleil','Saint-Tropez','83990','FR')," +
            "(null,'Romer','Linda','Ahornstrasse 7','Berlin','12624','DE')," +
            "(null,'Lindt','Aurelie','18 Rue Richmont','Geneve','1202','CH')," +
            "(null,'Borger','Bjorn','Langstrasse 500','Zurich','8005','CH')," +
            "(null,'Herman','Fries','Avenue de Cour 20','Lausanne','1007','CH')," +
            "(null,'Zoetemelk','Joop','Delftlandlaan 19','Amsterdam','1062','NL')," +
            "(null,'De Loenen','Belinda','Kleine Gracht 24','Maastricht','6222','NL')," +
            "(null,'Santos','Carlos','Plaza de Torros 6','Granada','18010','ES')," +
            "(null,'Witteveen','Kees','Hoefkade 9','Den Haag','2526','NL')," +
            "(null,'Contador','Jorge ','Paseo de Sancha 17','Malaga','29016','ES')," +
            "(null,'Castello ','Isabella','Frezzaria 128 San Marco','Venetie','30124','IT')," +
            "(null,'Corce','Paolo','Via del porto 6','Bologna','40122','IT');";

    //Wijzig de familienaam van de bezoeker met bezoeker_id 4 naar Wilmots.
    public static String familienaamWijziging = "UPDATE `bezoekers` SET `naam` = 'Wilmots' WHERE `bezoeker_id` = 4;";

    //Wijzig de straat van Sara Van gogh naar Rue van Gogh 12a.
    public static String straatWijziging = "UPDATE `bezoekers` SET `straat_en_nummer` = 'Rue van Gogh 12a' WHERE `voornaam` = 'sara';";

    //Wijzig het datatype van de postcode naar integer (in dit geval int).
    public static String dataTypeWijziging = "ALTER TABLE bezoekers" +
            "MODIFY COLUMN postcode INT NOT NULL;";

    //Verwijder met een DELETE instructie alle bezoekers uit Duitsland.
    public static String bezoekersVerwijdering = "DELETE FROM bezoekers WHERE 'land' = 'DE';";

    //Geef de naam, voornaam en het land van alle bezoekers in de tabel.
    public static String queryBeperkteInfoAlleBezoekers = "SELECT naam, voornaam, land FROM bezoekers;";

    //Wat is de som van alle postcodes in de tabel bezoekers?
    public static String querySomPostcodes = "SELECT sum(postcode)" +
            "FROM bezoekers;";

    //Geef het aantal bezoekers (dus een getal!) uit België.
    public static String queryAantalBezoekers = "";

    //Geef het aantal bezoekers uit België waarvan de postcode begint met een 3.
    public static String queryAantalBezoekersMetPostcode = "SELECT count(postcode) FROM bezoekers where left(postcode,1) =3 and land = 'BE';";

    //Geef per land het aantal bezoekers. Orden de landen volgens het aantal bezoekers. Neem als alias "aantal" voor het aantal bezoekers. TIP: gebruik hiervoor GROUP BY!
    public static String queryAantalBezoekersPerLand = "SELECT land, COUNT(bezoeker_id) AS aantal FROM bezoekers GROUP BY land ORDER BY COUNT(bezoeker_id) DESC;";
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.data;

import java.sql.SQLException;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author evertjan.jacobs
 */
public class ConfiguratieTest {

    private static DataLayerJDBC dl;
    private static int jaar;

    @BeforeAll
    public static void setup() {
        try {
            String dbName = "postorder";
            System.out.println("Create database " + dbName);
            dl = new DataLayerJDBC(dbName);

            jaar = Year.now().getValue();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguratieTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void tearDown() {
        try {
            dl.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguratieTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of geefBestellingen method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefBestellingen() {
        System.out.println("Q1 - Sorteer de bestellingen (Id, KlantId en Datum) aflopend op maand en oplopend op dag.");
        List<Bestelling> result = dl.geefBestellingen();

        assertEquals(30, result.size());
        assertEquals(result.get(0).getId(), 21);
        assertEquals(result.get(result.size() - 1).getId(), 20);
    }

    /**
     * Test of geefAantalBestellingenVanOktober method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefAantalBestellingenVanOktober() {
        System.out.println("Q2 - Hoeveel bestellingen werden er vorig jaar in oktober geplaatst? ");
        int result = dl.geefAantalBestellingenVanOktober();

        assertEquals(20, result);
    }

    /**
     * Test of geefArtikelenGeleverdInWeekend method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefArtikelenGeleverdInWeekend() {
        System.out.println("Q3 - Welke artikelen (Id en Beschrijving) werden tijdens het weekend geleverd?");
        List<Artikel> result = dl.geefArtikelenGeleverdInWeekend();

        int[] ids = {39, 18, 43, 16};
        for (int id : ids) {
            assertTrue(result.contains(new Artikel(id, "xxx")));
        }

        assertEquals(4, result.size());
    }

    /**
     * Test of geefArtikelenNietGeleverd method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefArtikelenNietGeleverd() {
        System.out.println("Q4 - Welke artikelen (Id en Beschrijving) moeten nog geleverd worden?");
        List<Artikel> result = dl.geefArtikelenNietGeleverd();

        int[] ids = {23, 19, 17, 36, 47, 7, 13};
        for (int id : ids) {
            assertTrue(result.contains(new Artikel(id, "xxx")));
        }

        assertEquals(7, result.size());
    }

    /**
     * Test of geefDatumsBestellingenVanMichel method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefDatumsBestellingenVanMichel() {
        System.out.println("Q5 - Op welke data heeft Michel Hollands bestellingen gedaan?");
        List<Calendar> result = dl.geefDatumsBestellingenVanMichel();

        String[] exp = {"6-10-"+(jaar - 1), "11-10-"+(jaar - 1), "24-10-"+(jaar - 1)};
        boolean ok;
        for (String s1 : exp) {
            ok = false;
            for (Calendar c : result) {
                if (s1.equals(c.get(Calendar.DAY_OF_MONTH) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR))) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                assertFalse(true);
            }
        }

        assertEquals(3, result.size());
    }

    /**
     * Test of geefArtikelenBinnenDeDagGeleverd method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefArtikelenBinnenDeDagGeleverd() {
        System.out.println("Q6 - Welke artikelen (Id en Beschrijving) werden ofwel op dezelfde dag of op de volgende dag geleverd? ");
        List<Artikel> result = dl.geefArtikelenBinnenDeDagGeleverd();

        int[] ids = {13, 16, 17, 22};
        for (int id : ids) {
            assertTrue(result.contains(new Artikel(id, "xxx")));
        }

        assertEquals(4, result.size());
    }

    /**
     * Test of geefKlantMetMeesteBestellingen method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefKlantMetMeesteBestellingen() {
        System.out.println("Q7 - Geef de naam en voornaam van de klant die het meeste aantal bestellingen gedaan heeft. Geef ook het aantal bestellingen dat die klant gedaan heeft. ");
        LinkedHashMap<String, Integer> result = dl.geefKlantMetMeesteBestellingen();

        assertEquals(1, result.keySet().size());
        assertEquals(4, result.get("VAN BELLE WERNER"));
    }

    /**
     * Test of geefAantalArtikelenNooitBesteld method, of class DataLayerJDBC.
     */
    @Test
    public void testGeefAantalArtikelenNooitBesteld() {
        System.out.println("Q8 - Hoeveel artikelen zijn nooit besteld? Maak hiervoor gebruik van subqueries. Gebruik daarnaast ook \"Aantal\" als alias.");
        int result = dl.geefAantalArtikelenNooitBesteld();

        assertEquals(23, result);
    }

    /**
     * Test of geefTotaleKostBestellingenVanOktober method, of class
     * DataLayerJDBC.
     */
    @Test
    public void testGeefTotaleKostBestellingenVanOktober() {
        System.out.println("Q9 - Wat is de totale waarde van de bestellingen die geplaatst zijn in de maand oktober?");
        double result = dl.geefTotaleKostBestellingenVanOktober();

        assertEquals(872.2, result, 0.0);
    }

    /**
     * Test of geefKlantenZonderBestellingenMetSQ method, of class
     * DataLayerJDBC.
     */
    @Test
    public void testGeefKlantenZonderBestellingenMetSQ() {
        System.out.println("Q10a - Hoeveel klanten hebben nog geen bestellingen gedaan? Schrijf met subquery.");
        int result = dl.geefKlantenZonderBestellingenMetSQ();

        assertEquals(31, result);
    }

    /**
     * Test of geefKlantenZonderBestellingenZonderSQ method, of class
     * DataLayerJDBC.
     */
    @Test
    public void testGeefKlantenZonderBestellingenZonderSQ() {
        System.out.println("Q10b - Hoeveel klanten hebben nog geen bestellingen gedaan? Schrijf zonder subquery.");
        int result = dl.geefKlantenZonderBestellingenZonderSQ();

        assertEquals(31, result);
    }

    /**
     * Test of geefTop5GemeenteVolgensAantalBestellingen method, of class
     * DataLayerJDBC.
     */
    @Test
    public void testGeefTop5GemeenteVolgensAantalBestellingen() {
        System.out.println("Q11 - Geef de top-5 van gemeenten berekend volgens aantal bestellingen door klanten uit die gemeente.");

        LinkedHashMap<String, Integer> result = dl.geefTop5GemeenteVolgensAantalBestellingen();
        assertEquals(5, result.keySet().size());
        
       String[] gemeentes = {"Gent", "Wachtebeke", "Lemberge", "Melle", "Zottegem"};
        int[] aantallen = {7, 3, 3, 3, 2};
        for (int i = 0; i < gemeentes.length; i++) {
            assertEquals(aantallen[i], result.get(gemeentes[i].toUpperCase()));
        }   
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import postorder.data.Artikel;
import postorder.data.Bestelling;
import postorder.data.DataLayerJDBC;
import postorder.data.Klant;

/**
 *
 * @author evertjan.jacobs
 */
public class PostorderDemo {

    public static void main(String[] args) throws SQLException {
        DataLayerJDBC dl = new DataLayerJDBC("postorder");
        System.out.println("Sorteer de bestellingen (Id, KlantId en Datum) aflopend op maand en oplopend op dag.");
        List<Bestelling> bestellingen = dl.geefBestellingen();
        for (Bestelling bestelling : bestellingen) {
            System.out.println(bestelling.toString());
        }

        System.out.println("\nHoeveel bestellingen werden er vorig jaar in oktober geplaatst? " + dl.geefAantalBestellingenVanOktober());

        System.out.println("\nWelke artikelen (Id en Beschrijving) werden tijdens het weekend geleverd? ");
        List<Artikel> artikelen = dl.geefArtikelenGeleverdInWeekend();
        for (Artikel artikel : artikelen) {
            System.out.println(artikel.toString());
        }

        System.out.println("\nWelke artikelen (Id en Beschrijving) moeten nog geleverd worden?");
        artikelen = dl.geefArtikelenNietGeleverd();
        for (Artikel artikel : artikelen) {
            System.out.println(artikel.toString());
        }

        System.out.println("\nOp welke data heeft Michel Hollands bestellingen gedaan?");
        List<Calendar> data = dl.geefDatumsBestellingenVanMichel();
        for (Calendar datum : data) {
            System.out.println(datum.get(Calendar.DATE) + "/" + (datum.get(Calendar.MONTH) + 1) + "/" + datum.get(Calendar.YEAR));
        }

        System.out.println("\nWelke artikelen werden ofwel op dezelfde dag of op de volgende dag geleverd?");
        artikelen = dl.geefArtikelenBinnenDeDagGeleverd();
        for (Artikel artikel : artikelen) {
            System.out.println(artikel.toString());
        }

        System.out.println("\nGeef de naam en voornaam van de klant die het meeste aantal bestellingen gedaan heeft. Geef ook het aantal bestellingen dat die klant gedaan heeft. ");
        LinkedHashMap<String, Integer> klantMetMeesteBestellingen = dl.geefKlantMetMeesteBestellingen();
        Map.Entry<String, Integer> entry = klantMetMeesteBestellingen.entrySet().iterator().next();
        System.out.println(entry.getKey() + " " + entry.getValue());

        System.out.println("\nHoeveel artikelen zijn nooit besteld? Maak hiervoor gebruik van subqueries. Gebruik daarnaast ook 'Aantal' als alias. " + dl.geefAantalArtikelenNooitBesteld());
        System.out.println("\nWat is de totale waarde van de bestellingen die geplaatst zijn in de maand oktober? " + dl.geefTotaleKostBestellingenVanOktober());

        System.out.println("\nHoeveel klanten hebben nog geen bestellingen gedaan? Schrijf op 2 manieren, d.w.z. met subquery en zonder subquery.");
        System.out.println(dl.geefKlantenZonderBestellingenMetSQ());
        

        System.out.println("\nGeef de top-5 van gemeenten berekend volgens aantal bestellingen door klanten uit die gemeente. (opgelet er zijn meerdere met 3 bestellingen)");
        LinkedHashMap<String, Integer> gemeentenMetAantalBestellingen = dl.geefTop5GemeenteVolgensAantalBestellingen();
        Iterator<Map.Entry<String, Integer>> iterator = gemeentenMetAantalBestellingen.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            String gemeente = pair.getKey();
            int aantal = pair.getValue();
            System.out.println(gemeente + " " + aantal);
            iterator.remove();
        }
        dl.closeConnection();

    }
}

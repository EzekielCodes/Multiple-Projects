/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder.data;

/**
 *
 * @author evertjan.jacobs
 */
public class Configuratie {

    //Q1. Geef voor elke bestelling: het bestelnummer en de prijs van het duurste artikel die hierbij besteld werd(en).
    public static String queryDuursteArtikelPerBestelling = "select bestellingen.id, max(artikelen.prijs)\n" +
            "from bestellingen\n" +
            "join items on bestellingen.id = items.bestelling_id\n" +
            "join artikelen on items.artikel_id = artikelen.id\n" +
            "group by bestellingen.id;";

    //Q2. Geef het artikelnummer én de beschrijving van alle artikelen waarvan er meer dan 4 eenheden besteld geweest zijn, en dit verspreid over minstens 2 leveringen. Je hoeft geen rekening te houden met bestellingen die nog niet geleverd zijn.
    public static String queryArtikelenMin4BesteldOverMeerdereLeveringen = "select artikelen.id, artikelen.beschrijving\n" +
            "from artikelen\n" +
            "join items on artikelen.id = items.artikel_id\n" +
            "group by artikel_id having sum(items.aantal) > 3 && count(tijdstip) > 1;";

    //Q3. Geef de data waarop geleverd werd bij klant(en) uit GENT (a.d.h.v meerdere geneste subqueries).
    public static String queryDataLeveringBijKlantenUitGent = "select tijdstip \n" +
            "from items \n" +
            "group by items.bestelling_id having items.bestelling_id in (select id from bestellingen where klant_id in (select id from klanten where gemeente = \"GENT\"));";

    //Q4. Wat is de totale factuurprijs voor de levering(en) van bestellingnummer 1?
    public static String queryTotalePrijsBestelling1 = "select sum(artikelen.prijs*items.aantal) \n" +
            "from items\n" +
            "join artikelen on items.artikel_id = artikelen.id\n" +
            "group by items.bestelling_id having items.bestelling_id = 1;";

    //Q5. Geef de ids en de levertijd van de bestellingen die volledig op minder dan 7 dagen tijd zijn geleverd.
    public static String queryLeveringInMinderDan7Dagen = "select bestellingen.id,  (datediff(cast(items.tijdstip as date), bestellingen.datum)) as levertijd\n" +
            " from bestellingen \n" +
            " join items on bestellingen.id = items.bestelling_id\n" +
            " group by items.bestelling_id having bestellingen.id not in (select bestellingen.id from bestellingen join items on bestellingen.id = items.bestelling_id where datediff(cast(items.tijdstip as date), bestellingen.datum) > 6) && items.bestelling_id not in (select items.bestelling_id from items where items.tijdstip is null);";
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postorder;

/**
 *
 * @author evertjan.jacobs
 */
public class Configuratie {

    //Q1. Sorteer de bestellingen (id, klant_id en datum) aflopend op maand en oplopend op dag.
    public static String querySorteerBestellingen = "SELECT * \n" +
            "FROM postorder.bestellingen\n" +
            "order by month(datum) DESC, day(datum) ASC";

    //Q2. Hoeveel bestellingen werden er vorig jaar in oktober geplaatst?
    public static String queryAantalBestellingOktoberVorigJaar = "SELECT count(* )\n" +
            "FROM postorder.bestellingen\n" +
            "where (year(datum)-1)  and month(datum) = 10";

    //Q3. Welke artikelen (id en beschrijving) werden tijdens het weekend geleverd?
    public static String queryArtikelenGeleverdInWeekend = "select id, beschrijving from artikelen where id IN (select artikel_id from items where dayofweek(date(tijdstip))=1 or dayofweek(date(tijdstip))=7);";

    //Q4. Welke artikelen (id en beschrijving) moeten nog geleverd worden?
    public static String queryArtikelenNogNietGeleverd = "select id, beschrijving \n" +
            "from artikelen\n" +
            "where id IN (select artikel_id from items where tijdstip is null);";

    //Q5. welke data heeft Michel Hollands bestellingen gedaan?
    public static String queryDataBestellingenMichelHollands = "select datum\n" +
            "from bestellingen \n" +
            "where klant_id=(select id from klanten where naam='HOLLANDS' and vnaam = 'Michel');";

    //Q6. Welke artikelen (id en beschrijving) werden ofwel op dezelfde dag of op de volgende dag geleverd?
    public static String queryArtikelenGeleverdMaxVolgendeDag = "SELECT artikelen.id, artikelen.beschrijving\n" +
            "from artikelen inner join items ON items.artikel_id = artikelen.id\n" +
            "inner join bestellingen on bestellingen.id = items.bestelling_id\n" +
            "where date(datum) = date(tijdstip) or date(tijdstip) = date(adddate(datum, 1))\n" +
            "group by artikelen.id;";

    //Q7. Geef de naam en voornaam van de klant die het meeste aantal bestellingen gedaan heeft. Geef ook het aantal bestellingen dat die klant gedaan heeft.
    public static String queryKlantMetMeesteBestellingen = "select naam, vnaam, count(*) from bestellingen b JOIN klanten k ON (b.klant_id=k.id) group by klant_id order by count(*) desc limit 1;";

    //Q8. Hoeveel artikelen zijn nooit besteld? Maak hiervoor gebruik van subqueries. Gebruik daarnaast ook "Aantal" als alias.
    public static String queryAantalArtikelenNooitBesteld = "select count(*) as Aantal from items i right JOIN artikelen a ON (i.artikel_id=a.id) where bestelling_id is null;";

    //Q9. Wat is de totale waarde van de bestellingen die geplaatst zijn in de maand oktober?
    public static String querySomBestellingenOktober = "select sum(a.prijs * i.aantal) from items i JOIN bestellingen b ON(i.bestelling_id=b.id) JOIN artikelen a ON(i.artikel_id=a.id) where month(b.datum)=10 order by aantal;";

    //Q10. Hoeveel klanten hebben nog geen bestellingen gedaan? Schrijf op 2 manieren, d.w.z. met subquery en zonder subquery.
    public static String queryKlantenZonderBestellingenZonderSubQuery = "select count(*) from klanten k left JOIN bestellingen b ON (k.id=b.klant_id) where b.klant_id is null;";
    public static String queryKlantenZonderBestellingenMetSubQuery = "select (select count(id) from klanten)-(select count(distinct klant_id) from bestellingen);";

    //Q11. Geef de top-5 van gemeenten berekend volgens aantal bestellingen door klanten uit die gemeente.
    public static String queryTop5GemeentenVolgensAantalBestellingen = "select gemeente, count(*)\n" +
            "from klanten k \n" +
            "JOIN bestellingen b ON (k.id=b.klant_id)\n" +
            "group by gemeente\n" +
            "order by count(*) desc limit 5;";

}

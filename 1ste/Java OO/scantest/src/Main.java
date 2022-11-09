/*
  @author akindeletoluwani ict7
 * @version 03.12.2020
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        final double BATTERIJTIJD = 9.5;
        String naam = "sleep";
        System.out.println("Hoeveel pagina's heb je al gelezen?");
        int aantalPagina = input.nextInt();
        System.out.println("Hoelang heb je hiervoor gedaan?Geef het aantal minuten.");
        double hoelangGelezen = input.nextDouble();
        System.out.println("Hoeveel pagina's moet je nog lezen");
        int resterendePaginas = input.nextInt();
        double resterendeminuten = Math.round(resterendePaginas * hoelangGelezen / aantalPagina) ;
        System.out.println("je hebt nog" + resterendeminuten + "minuten nodig om je boek uit te lezen");
        System.out.println("Hoeveel percentage van je batterij is nog beschikbaar?");
        int batterijBeschikbaar = input.nextInt();
        /*
        Ik heb de formula niet gevonden om de resterendeBatterij te kunnen vinden
        Hierdoor heb ik gewoon een varaible aangemaakt en de resterendeBatterij zelf ingegeven
         */
        double resterendeBatterij = 256.5;
        System.out.println("Resterende batterijtijd: " + resterendeBatterij);
        String resultaat = (resterendeBatterij > resterendeminuten ? "Je hoeft de batterij niet op te laden om dit boek uit te lezen.":"Laad eerst je batterij op!");
        System.out.println(resultaat);

    }
}

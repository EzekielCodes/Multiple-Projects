package com.company;


import java.util.Scanner;

/** dit is de main methode hierin wordt een object van de klasse spelkaarten aangemaakt
 * de soorten kaarten wordt hier ook ingegeven
 * @author akindeletoluwani ict7
 * @version 21.1.2020
 */

public class DemoSpeelKaarten {

    public static void main(String[] args) {
	// write your code here
        String kaarten[] = new String[2];
        Scanner input = new Scanner(System.in);
        char s = 'A';
        for ( int i = 0; i < kaarten.length; i ++){

                System.out.printf("Geeft de  %d kaart in %n", i +1);
                kaarten[i] = input.nextLine().toUpperCase();
        }
        SpeelKaarten test = new SpeelKaarten(kaarten);


        do {
            System.out.println("Van welke soort wil je een trekken? Antwoord met H, K, R, of S");
            String soort = input.next();
            s =soort.charAt(0);
            System.out.println(test.bevatKaartVanSoort(s));
        }
        while (test.bevatKaartVanSoort(s) == false);



        System.out.println(test.geefRandomKaartVanSoort());

    }
}

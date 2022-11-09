package com.company;

import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 26.11.20
 */
public class AfstandOnweer {
    public static void main(String [ ] args ) {
        int geluid =340; //meter
//        int tijdSpanne = 1000;
        System.out.println("Geef een afstand in:");
        Scanner input = new Scanner(System.in);
        int tijdSpanne = input.nextInt();
        int afstand = geluid * tijdSpanne;
        System.out.println("Afstand = " +afstand);
    }
}

package com.company;

import java.util.Scanner;

public class Wedstrijd {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Naam loopwedstrijd");
        String naam = input.next();
        System.out.println("aantal atleten");
        int aantal = input.nextInt();
        System.out.println("Naam atleten");
        String atleten = input.next();
        System.out.println("Tijden");
        String tijd = input.next();

        String atlet[] = new String[aantal];
        double tijdenn[] = new double[aantal];
        Scanner delimeter = new Scanner(atleten).useDelimiter(";");
        Scanner deli = new Scanner(tijd).useDelimiter(";");

        for (int i = 0 ; i < atlet.length; i ++ ){
            atlet[i] = delimeter.next();
            double temp = Double.parseDouble(deli.next());
            tijdenn[i] =temp;
        }
        for (int i = 0 ; i < atlet.length; i ++ ){
            System.out.println(atlet[i]);

            System.out.println(tijdenn[i]);
        }

        LoopWedstrijd test = new LoopWedstrijd(naam,atlet,tijdenn);

        System.out.println(test.geefWinnar());


    }
}

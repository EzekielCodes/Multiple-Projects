package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoLoopWedstrijd {
    public static void main(String[] args) {
        ArrayList atletenn = new ArrayList();
        ArrayList tijdenn = new ArrayList();
        atletenn.add("lucas");
        tijdenn.add(0.2);
        atletenn.add("yan");
        tijdenn.add(0.6);
        atletenn.add("lucas");
        tijdenn.add(0.3);

        LoopWedstrijd test = new LoopWedstrijd("Wedstrijd",atletenn , tijdenn);

        System.out.println(atletenn.size());


        System.out.println("En het goud gaat naar ....: "+ test.geefWinnaaer());
        Scanner input = new Scanner(System.in);
        System.out.println("Wil jij nog een gebuiker aanmaken?");
        int keuze = input.nextInt();

        if (keuze == 1){
            System.out.println("Naam");
            String newNaam = input.next();
            System.out.println("tijd");
            double newTijd = input.nextDouble();

            test.voegExtraPrestatieToe(newNaam,newTijd);

            System.out.println("En het goud gaat naar ....: "+ test.geefWinnaaer());

        }

    }
}

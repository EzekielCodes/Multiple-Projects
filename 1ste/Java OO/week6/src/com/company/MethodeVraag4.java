package com.company;

import java.util.Scanner;

public class MethodeVraag4 {
    public static void main(String[] args) {
        MethodeVraag4 hogerLager = new MethodeVraag4();
        hogerLager.feedback();


    }

    /***
     *
     * @return
     */
    public int vraag() {
        int geraden = 0;
        System.out.println("Raad het getal tussen 0 en 50");
        Scanner input = new Scanner(System.in);
        geraden = input.nextInt();
        return geraden;
    }

    /***
     * Geeft een random getal terug
     * @return een random getal
     */
    public int random() {
        return (int) (Math.random() * 51);

    }

    /**
     *
     */
    public void feedback() {
        int getal = random();
        for (int i = 0; i < 10; i++) {
            int kans = 10 - i;
            int geraden = vraag();
            if (geraden < getal) {
                System.out.println("Raad hoger");
                System.out.println("Je hebt nog " + kans + " kansen");
            } else if (geraden > getal) {
                System.out.println("Raad lager");
                System.out.println("Je hebt nog " + kans + " kansen");
            } else if (geraden == getal) {
                System.out.println("U heeft het te raden getal");
                break;
            } else if (geraden < 0 || geraden > 50) {
                System.out.println("uw zit buiten de range probeer opniew");
            }
        }
    }
}






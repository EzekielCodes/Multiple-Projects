package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel bestaanden wil je ingeven?");
        int aantal = input.nextInt();
        String dim[][] = new String[aantal][2];

        for (int i = 0; i < dim.length; i++) {
            for (int x = 1; x < dim[i].length; x++) {
                System.out.println("Geef de bestaandsnaam");
                String naam = input.next();
                System.out.println("Geed de file inhoud");
                String tekst = input.next();
                dim[i][0] = naam;
                System.out.println(i);
                int check = x + 1;
                System.out.println(check);
                dim[i][1] = tekst;

            }
        }

        for (int i = 0; i < dim.length; i++) {
            for (int x = 0; x < dim[i].length; x++) {
                System.out.print(dim[i][x] + " ");

            }
            System.out.println();
        }
    }
}

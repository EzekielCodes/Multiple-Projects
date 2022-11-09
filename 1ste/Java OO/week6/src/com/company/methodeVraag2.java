package com.company;

import java.util.Scanner;

public class methodeVraag2 {
    public static void main(String[] args) {
        int aantal = aantalAanvragen();
    }
    public static  int aantalAanvragen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel ogen wil je aanmaken");
        int aantal = input.nextInt();
        return aantal;
    }
}

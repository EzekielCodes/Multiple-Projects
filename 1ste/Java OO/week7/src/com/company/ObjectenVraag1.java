package com.company;

import java.util.Scanner;

public class ObjectenVraag1 {
    public static void main(String[] args) {
    Dobbelsteen test = new Dobbelsteen();
    Scanner input = new Scanner(System.in);
    System.out.println("Hoevel ogen wil je werpen?");
    int aantal = input.nextInt();
    int controle = 0;
    while (aantal != controle){
        System.out.println("check" + controle);
        controle = test.gooi();
        test.geefLaatsteWorp(aantal);
    }
    }

}

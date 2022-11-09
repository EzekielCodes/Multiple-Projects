package com.company;

import java.util.Scanner;

public class ObjectenVraag2 {
    public static void main(String[] args) {
        int breedte = 0;
        int lengte = 0 ;
        int x = 0;
        int y = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Breedte?");
        breedte = input.nextInt();
        System.out.println("lengte?");
        lengte = input.nextInt();
        System.out.println("x?");
        x= input.nextInt();
        System.out.println("y?");
        y= input.nextInt();

        RechthoekVraag2 rechthoek = new RechthoekVraag2(x,y,breedte,lengte);
        System.out.println(rechthoek.isVierkant());
        System.out.println(rechthoek.berekenOmtrek());
        System.out.println(rechthoek.berekenOpp());
        System.out.println(rechthoek.isIn(x,y));

    }


}

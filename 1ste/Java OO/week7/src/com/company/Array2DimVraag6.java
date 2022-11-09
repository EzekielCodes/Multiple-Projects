package com.company;

import java.util.Scanner;

public class Array2DimVraag6 {
    public static void main(String[] args) {
        String kaart = "H3";
        System.out.println(kaart.length());

        Scanner input = new Scanner(System.in);
        System.out.println("Hoveel studenten wil je aanmaken?");
        int aantal = input.nextInt();

        String dim[][]=new String [aantal][3];
        String dimm[][]= new String[aantal + 1][3];
        for (int i = 0; i < dim.length; i++) {
            System.out.println("Geef de gegevens in van de student");
            String gegevens = input.next();
            Scanner delimeter = new Scanner(gegevens).useDelimiter(";");
            for (int x = 0; x < dim[i].length; x++) {
                dim[i][x] = delimeter.next();
                //dimm[i][x] = dim[i][x];

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

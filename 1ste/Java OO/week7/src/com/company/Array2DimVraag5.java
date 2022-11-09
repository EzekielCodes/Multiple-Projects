package com.company;

import java.util.Scanner;

public class Array2DimVraag5 {
    public static void main(String[] args) {
        int dim[][];
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel rijen?");
        int rijen = input.nextInt();
        System.out.println("Hoeveel kolommen?");
        int kolommen = input.nextInt();
        dim = new int [rijen][kolommen];
        for (int i = 0; i < rijen; i ++){
            for(int x = 0; x < kolommen; x++){
                dim[i][x] = (int) (Math.random() * 100.0 - 50.0);
            }
        }
    }
}

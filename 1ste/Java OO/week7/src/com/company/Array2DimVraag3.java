package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Array2DimVraag3 {
    public static void main(String[] args) {
        int dim[][];
        int total = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel rijen?");
        int rijen = input.nextInt();
        System.out.println("Hoeveel kolommen?");
        int kolommen = input.nextInt();
        dim = new int [rijen][kolommen];
        int[] resultRijen = new int[rijen];
        int[] resultkolommen = new int[kolommen];
        for (int i = 0; i < rijen; i ++){
            for(int x = 0; x < kolommen; x++){
                dim[i][x] = input.nextInt();
            }
        }
        for (int i = 0; i < rijen; i++) {
            for (int x = 0; x < kolommen; x++) {
                System.out.print(dim[i][x] + " ");

            }
            System.out.println();
        }

        for (int i = 0; i < rijen ; i ++) {
            total = 0;
            for (int x = 0; x < kolommen; x++) {

                System.out.println(dim[i][x] + " ");
                total += dim[i][x];
            }
            resultRijen[i] = total;
        }

        System.out.println(Arrays.toString(resultRijen));

        for (int i = 0; i < kolommen ; i ++) {
            total = 0;
            for (int x = 0; x < rijen; x++) {

                System.out.println(dim[x][i] + " ");
                total += dim[x][i];

            }
            resultkolommen[i] = total;
        }

        System.out.println(Arrays.toString(resultkolommen));


    }
}

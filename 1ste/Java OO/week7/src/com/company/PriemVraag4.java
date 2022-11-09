package com.company;

import java.util.Arrays;

public class PriemVraag4 {
    int num = 29;
    int begin = 0;
    int teller = 0;



    public static boolean isPriem(int num){

        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static  int aantalPriem(int begin,int num){
        boolean flag = false;
        int count = 0;
        int teller = 0;
        for(int i = begin; i <= num; i++) {
             count =0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count = count+1;

                }

            }
            if (count == 2){
                teller ++;
                //System.out.println(i);
        }

    }
        return  teller;
    }

    public static int[] geefPriem(int begin, int num){
        boolean flag = false;
        int count = 0;
        int plaats = 0;
        PriemVraag4 test = new PriemVraag4();

        int array[] = new int[PriemVraag4.aantalPriem(begin,num)];
        for(int i = begin; i <= num; i++) {
            count =0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count = count+1;

                }

            }
            if (count == 2){
                array[plaats] = i;
                plaats++;

                System.out.println(i);
            }

        }
        System.out.println(Arrays.toString(array));
        return  array;
    }
}

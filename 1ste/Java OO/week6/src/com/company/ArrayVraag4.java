package com.company;

public class ArrayVraag4 {
    public static void main(String[] args) {
        int[] getallen;
        getallen  = new int[100];
        int count =0, countPos = 0, countNeg = 0,countO =0;
        for (int i = 0; i < getallen.length; i++){
            getallen[i] = (int)(Math.random() * 100.0 - 50.0);
            if (getallen[i] < 0){
                countNeg ++;
            }else  if (getallen[i] > 0){
                countPos ++;
            }
            else if (getallen[i] == 0){
                countO ++;
            }
        }

        System.out.println(countNeg + "Negatief");
        System.out.println(countPos + "Positief");
        System.out.println(countO + "gelijk is aan null");
    }
}

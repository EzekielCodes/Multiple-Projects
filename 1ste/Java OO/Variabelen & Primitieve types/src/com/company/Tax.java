package com.company;

/**
 * @author akindeletoluwani ict7
 * @version 26.11.20
 */
public class Tax {
    public static void main(String[] args) {
        final int BTW =21;
        double prijs = 105.99;
        double totalePrijs = 0;

        totalePrijs = prijs * BTW/100;
        totalePrijs = prijs + totalePrijs;
        System.out.println(totalePrijs);
    }
}

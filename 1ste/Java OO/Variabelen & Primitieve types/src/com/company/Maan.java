package com.company;

/**
 * @author akindeletoluwani ict7
 * @version 26.11.20
 */
public class Maan {
    public static void main(String[] args) {
        final double versnellingAarde = 9.81;
        final double versnellingMaan = 1.622;
        double gewicthAarde = 500;

        double gewichtMaan = gewicthAarde / versnellingAarde * versnellingMaan;
        System.out.println(gewichtMaan);
    }
}

package com.company;

/**
 * @author akindeletoluwani ict7
 * @version 26.11.20
 */
public class herstellen {
    public static void main(String [ ] args ) {
      final double VALVERSNELLING = 9.81; //symbolische constante
      double hoogte = 10.0; //een hoogte
      double tijd =Math.sqrt ((2*hoogte)/VALVERSNELLING);// bereken valtijd en druk resultaat af
      System.out.println ("De valtijd bedraagt " +tijd );

    }
}

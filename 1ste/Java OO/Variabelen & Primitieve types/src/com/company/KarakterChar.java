package com.company;
/**
 * @author akindeletoluwani ict7
 * @version 26.11.2020
 */
public class KarakterChar {

    public static void main(String[] args) {
	// write your code here
        char at = '@';
        int nummeriek = at;
        char euro = 8364;
        System.out.println("char @ bevat: " + nummeriek);
        System.out.println((char)nummeriek);
        System.out.println( "char Euro bevat" +(char)0x20AC );
        System.out.println("char Euro bevat: " + euro);
        System.out.printf("Deze tekst staat \"tussen dubbele quotes\",\n" +

                "deze ’tussen enkele quotes’\n" +

                "en die \\tussen back slashes\\");

    }
}

package com.company;

import java.util.Scanner;

public class methodeVraag5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("wat is je woord?");
        String woord = input.next();
        String result = MaakZoekertje(woord);
        /*
        methodeVraag5 vraag5 = new methodeVraag5();
        String result = vraag5.MaakZoekertje(woord);
         */
    }

    /**
     *
     * @param woord
     * @return
     */
    public static String MaakZoekertje(String woord){
        String s = "";
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i < woord.length(); i++){
            if (woord.charAt(i) == 'a' || woord.charAt(i) == 'e'  || woord.charAt(i) == 'i'  || woord.charAt(i) == 'o'  || woord.charAt(i) == 'u' ){
                s+="";
            }
            else{
                s += woord.charAt(i);
            }
        }
        return s;
    }
}

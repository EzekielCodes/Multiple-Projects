
/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel voetballertjes worden opgemten");
        int aantal = input.nextInt();

        for (int i = 0; i < aantal; i++) {
            System.out.println("Geef de correcte gegevens van voetballer" + i+1);
            String controle = input.next();
            int comma = controle.indexOf(";", 2);
            int commaa = controle.indexOf(";", 6);
            System.out.println(controle);
            String naam = controle.substring(0, comma);
            String leeftijd = controle.substring(comma + 1, commaa);
            int age =Integer.parseInt(leeftijd);
            String lengte = controle.substring(commaa + 1);
            int height = Integer.parseInt(lengte);
            System.out.println(height);
            System.out.println(age);

            if (age < 5 && height == 99 || height <=110 ){
                System.out.println("De maat voor " + naam + " is : " + 104);
            }
            else if (age >= 5 && height == 99 && height <=110 ) {
                System.out.println("De maat voor " + naam + " is :" + 110);
            }
            else if (age < 7 && height == 111 || height <=122 ){
                System.out.println("De maat voor " + naam + " is :" + 116);
            }
            else if (age >7 && height == 111 || height <=122 ){
                System.out.println("De maat voor " + naam + " is :" + 122);
            }
            else if (age < 9 && height == 123 || height <=134 ){
                System.out.println("De maat voor " + naam + " is :" + 128);

            }
            else if (age >= 9 && height == 123 || height < 134 ){
                System.out.println("De maat voor " + naam + " is :" + 134);
            }
            else if (age < 11 && height == 135 || height <=146 ){
                System.out.println("De maat voor " + naam + " is :" + 140);
            }
            else if (age >=11 && height == 135 || height <=146 ){
                System.out.println("De maat voor " + naam + " is :" + 146);
            }
            else if (age < 13 && height == 147 || height <=158 ){
                System.out.println("De maat voor " + naam + " is :" + 152);
            }
            else if (age >=13 && height == 147 || height <=158 ){
                System.out.println("De maat voor " + naam + " is :" + 158);
            }
            else if (age < 15 && height == 159 || height <=164 ){
                System.out.println("De maat voor " + naam + " is :" + 164);
            }
            else if (age >=15 && age <=18 && height == 159 || height <=164 ){
                System.out.println("De maat voor " + naam + " is :" + 170);
            }
            else {
                System.out.println("Geef de correcte gegevens in");
                controle = input.next();
                comma = controle.indexOf(";", 2);
                commaa = controle.indexOf(";", 6);
                System.out.println(controle);
                naam = controle.substring(0, comma);
                leeftijd = controle.substring(comma + 1, commaa);
                age =Integer.parseInt(leeftijd);
                 lengte = controle.substring(commaa + 1);
                 height = Integer.parseInt(lengte);

            }

        }
    }
}

import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw leeftijd in");
        int leeftijd = input.nextInt();
        if (leeftijd >=0 && leeftijd <=9){
            System.out.println("Gratis");
        }
        else if(leeftijd >= 10 && leeftijd <=20){
            System.out.println("Ticket 14 EURO");
        }
        else if(leeftijd >= 21 && leeftijd <=64){
            System.out.println("Ticket 26 EURO");
        }
        else{
                System.out.println("Ticket 10 EURO");
            }
        }
    }


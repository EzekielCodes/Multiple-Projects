import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag1 {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         System.out.println("Geef een Engelse woord in");
         String woord = input.nextLine().toLowerCase();
         String lidwoord = woord.substring(0,1);
         if (lidwoord.equals("a")|| lidwoord.equals("e") || lidwoord.equals("i")  || lidwoord.equals("o") || lidwoord.equals("u")  ){
             System.out.println(lidwoord);
             System.out.println("Dit is een lidwoord");
         }
         else {
             System.out.println("Dit is geen lidwoord");
             System.out.println(lidwoord);
         }

    }
}

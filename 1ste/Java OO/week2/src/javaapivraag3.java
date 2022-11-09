import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag3 {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw eerste getal in:");
        int eersteGetal = input.nextInt();
        System.out.println("Geef de tweede getal in:");
        int tweedeGetal = input.nextInt();
        int kleinsteGetal = Math.min(eersteGetal,tweedeGetal);
        System.out.println("Het kleinste getal is: " +kleinsteGetal);
    }
}

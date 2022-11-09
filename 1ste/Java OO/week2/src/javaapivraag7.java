import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw voornaam in");
        String voornaam = input.nextLine();
        voornaam = voornaam .substring(0,1).toUpperCase() + voornaam .substring(1).toLowerCase();
        System.out.println(voornaam);
    }
}

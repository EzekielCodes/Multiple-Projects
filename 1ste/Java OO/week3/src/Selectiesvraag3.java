import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een  woord in");
        String woord = input.nextLine();
        int length = woord.length();
        if (length % 2 == 0){
            System.out.println("Dit is een even getal");
            System.out.println(woord.toUpperCase());
        }
        else{
            System.out.println("Dit is een geen getal");
            System.out.println(woord.toLowerCase());
        }
    }
}

import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 16.12.2020
 */
public class Forvraag7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel worden wil je ingegeven ");
        int aantal = input.nextInt();
        int length = 0;
        int som = 0;
        for (int i = 0 ; i <= aantal; i++){
            System.out.println("Geef een woord in");
            String woord = input.nextLine();

            length = woord.length();
             som += length;
        }
            System.out.println("Total length " +som);
    }
}

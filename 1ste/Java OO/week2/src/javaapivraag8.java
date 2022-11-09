import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw bankrekeningnummer in");
        String eerstWord = input.next();
        String tweedeWoord = input.next();
        String derdeWoord = input.nextLine();
        System.out.println("DE IBAN code is: " + tweedeWoord );
        System.out.println("Het rekeningnummer is: " +derdeWoord);
    }
}

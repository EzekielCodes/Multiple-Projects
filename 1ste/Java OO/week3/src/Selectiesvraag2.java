import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een  woord in");
        String woord = input.nextLine();
        String checkwoord = woord.substring(0,1);
        String temp = checkwoord;
        temp = temp.toUpperCase();

        if (checkwoord.equals(temp)){
            System.out.println("Dit is een hoodletter");
            System.out.println(temp);
            System.out.println(checkwoord);
        }
        else{
            System.out.println("Dit is geen hoofdletter");
        }

    }
}

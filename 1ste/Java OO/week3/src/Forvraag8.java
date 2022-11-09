import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 16.12.20
 */
public class Forvraag8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een woorde een");
        String word = input.nextLine();
        String woord = "";
        for (int i = 0 ; i <= word.length(); i++){
           woord = word.substring(0,word.length()-i);

           System.out.println(woord);

        }
        for (int i = word.length() ; i >= 0; i--){
            woord = word.substring(0,word.length()-i);

            System.out.println(woord);

        }

    }
}

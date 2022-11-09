import java.util.Arrays;
import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een zin in:");
        String eerstWord = input.next();
        String tweedeWoord = input.next();
        String derdeWoord = input.nextLine();

        System.out.println(tweedeWoord  +  eerstWord + derdeWoord);
//        String zin = input.nextLine();
//        String[] arrayZin = zin.split(" ");
//        if (arrayZin.length > 1 ){
//            String temp = arrayZin[0];
//            arrayZin[0] =arrayZin[1];
//            arrayZin[1] = temp;
//            System.out.println(Arrays.toString(arrayZin));
//        }
//        else{
//            System.out.println("De zin bevat minider dan 2 worden");
//        }
    }

}

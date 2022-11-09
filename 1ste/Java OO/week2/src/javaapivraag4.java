import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag4 {
    public static void main(String[] args) {
        // write your code here 4 en 5
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een zin de minimum uit 2 woorden bestaan");
        String eerstWord = input.next();
        String tweedeWoord = input.next();
        String derdeWoord = input.nextLine();

        System.out.println(eerstWord + derdeWoord);
    }
}

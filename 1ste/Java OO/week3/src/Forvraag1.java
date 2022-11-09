import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 16.12.20
 */
public class Forvraag1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een getal in:");
        int getal = input.nextInt();
        System.out.println("+-----+");
        for (int i = 0; i < getal;i++){
            System.out.println("\\     /");
        }
        System.out.println("+-----+");
    }
}

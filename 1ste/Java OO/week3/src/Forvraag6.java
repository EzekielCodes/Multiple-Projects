import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 16.12.20
 */
public class Forvraag6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef 7 getallen in ");
        int som = 0;
        for (int i = 0 ; i <=6 ; i++){
            int getal = input.nextInt();
            som += getal;
            int kwadraat = (int) Math.pow(getal,2);
            System.out.println(kwadraat);
        }
        int gemiddelde = som / 7;
        System.out.println(som);
        System.out.println(gemiddelde);
    }
}

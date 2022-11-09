import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public interface Javaapivraag2 {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de tijd in");
        System.out.println("Geef de uur in:");
        Byte uur = input.nextByte();
        /*
        String puntkomma = scanner.nextLine();
        char puntKommaChar = punitkomma.charAt(0)
         */
        System.out.println("Geef de aantal minuten in:");
        Byte minuten = input.nextByte();
        System.out.println("Geef de aantal seconden in:");
        Byte seconden = input.nextByte();
        System.out.printf("het ingegeven uur is: %d u %d min %d sec",uur,minuten,seconden);
    }
}

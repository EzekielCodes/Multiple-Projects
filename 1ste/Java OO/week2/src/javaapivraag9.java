import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 02.12.2020
 */
public class javaapivraag9 {
    public static void main(String[] args) {
        System.out.println("Geef je rekeningnummer in");
        Scanner input = new Scanner(System.in);
        String rekeningNummer = input.nextLine();
        if (rekeningNummer.length() == 19){
            String eersteDeel = rekeningNummer.substring(5,9);
            String tweedeDeel = rekeningNummer.substring(10,14);
            String derdeDeel = rekeningNummer.substring(15,19);

            String rekening = eersteDeel + tweedeDeel + derdeDeel;
            //rekening = "123456789002"
            String first11  = rekening.substring(0,10);//"1234567890"
            String laast = rekening.substring(10);//"02"
            long getal = Long.parseLong(first11);
            int lastGetal = Integer.parseInt(laast);

            String geldigheid = (getal % 97 == lastGetal ? "geldig" : "niet geldig");

            System.out.println("Je rekeningnummer was " + geldigheid);
        }
        else {
            System.out.println("rekeningnummer was geen 19 tekens lang");
        }
    }
}

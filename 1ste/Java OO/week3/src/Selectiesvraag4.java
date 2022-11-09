import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef een  maand in");
        String maand = input.nextLine().toLowerCase();

        switch (maand){
            case "januari":
                System.out.println("Deze maand bevat 31 maanden");
                break;
            case "febuari":
                System.out.println("Zit deze maand in een schrikkeljaar? Antwoord met ja /Nee");
                String keuze = input.nextLine().toLowerCase();
                if (keuze.equals("ja")){
                    System.out.println("Deze maand bevat 29 maanden");
                }else{
                    System.out.println("Deze maand bevat 28 maanden");
                }
                break;
            default:
                System.out.println("Kies een maand tussen januari en december");
        }


    }
}

import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw naam in");
        String naam = input.nextLine();
        System.out.println("Geef uw geboortejaar in?");
        int geboorteJaar = input.nextInt();
        int leeftijd = 2020 - geboorteJaar;

        if (leeftijd == 6 && leeftijd <=8){
            System.out.println(naam +" welkom bij de Premicroben ploeg!" );
        }
        else if(leeftijd == 9 || leeftijd == 10){
            System.out.println(naam +" welkom bij de Microben ploeg!" );
        }
        else if(leeftijd == 11 || leeftijd == 12){
            System.out.println(naam +" welkom bij de Benjamins ploeg!" );
        }
        else if(leeftijd == 13 || leeftijd == 14){
            System.out.println(naam +" welkom bij de Pupillen ploeg!" );
        }
        else if(leeftijd == 15 || leeftijd == 16){
            System.out.println(naam +" welkom bij de Miniemen ploeg!" );
        }
        else if(leeftijd == 17 || leeftijd == 18){
            System.out.println(naam +" welkom bij de Cadettenploeg!" );
        }
        else if(leeftijd == 19 || leeftijd == 20 || leeftijd == 21){
            System.out.println(naam +" welkom bij de Juniores ploeg!" );
        }
        else if(leeftijd > 21){
            System.out.println(naam +" welkom bij de Seniores ploeg!" );
        }
    }
}

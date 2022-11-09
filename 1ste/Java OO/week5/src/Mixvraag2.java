/**
 * @author akindeletoluwani ict7
 * @version 17.12.20
 */
import java.util.Scanner;
public class Mixvraag2 {
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc;

        System.out.println("Enter any month in number (Ex: 1 for January, etc)");
        sc = new Scanner(System.in);
        float month = Integer.parseInt(sc.next());

        if (month / 2 == 0) {
            System.out.println("The month is Even");
        } else {
            System.out.println("The month is Odd");
        }

        // switch statement to return the name of the month
        switch ((int) month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }

        //while loop to calculate time to new year
        int j = 0;
        int i = (int) month;
        while (i != 0) {
            i += 1;
            j++;
            System.out.println("Calculating time to New Year...");
        }

        System.out.println("Total months left for New Year:" + j);
    }
}

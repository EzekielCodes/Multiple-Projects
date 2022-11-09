import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Selectiesvraag9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef de tijd in");
        String tijd = input.nextLine();

        if (tijd.indexOf("AM") != -1){
            String time = tijd.substring(0,tijd.indexOf("AM"));
            System.out.println(time);
        }
        else if(tijd.indexOf("PM") != -1){
            String timeString = tijd.substring(0,tijd.indexOf("PM"));
            int tijdd = Integer.parseInt(timeString);

            if (tijdd < 12){
                tijdd +=12;
            }
            System.out.println((tijdd + "U"));
        }
        else {
            String tijddString = tijd.substring(0,tijd.indexOf("u"));
            int tijddd = Integer.parseInt(tijddString);

            if (tijddd < 12){
                System.out.println(tijddd + " AM");
            }
            else if(tijddd == 12){
                System.out.println(tijddd + " PM");
            }
            else{
                System.out.println(tijddd - 12 + " PM");
            }
        }
    }
}

/**
 * @author akindeletoluwani ict7
 * @version 16.12.2020
 */
public class Forvraag2 {
    public static void main(String[] args) {
        int begin = -20;
        int stop = 50;

        for (int i = -20; i <=50; i+=5){

            int fah = 9/5 * begin + 32;

            System.out.println(begin +" Celcius is gelijk aan " + fah +" fahrenheit");
            begin +=5;
        }
    }
}

import java.util.Scanner;

/**
 * @author akindeletoluwani ict7
 * @version 09.12.2020
 */
public class Slectiesvraag6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Geef uw theorie resultaat in");
        byte theorie = input.nextByte();
        System.out.println("Geef uw practicum resultaat in");
        byte practicum = input.nextByte();
        byte eindCijfer;
        if (practicum < theorie){
            eindCijfer = practicum;
            System.out.println(eindCijfer);
        }
        else{
            eindCijfer = (byte) (practicum + theorie / 2);
            System.out.println(eindCijfer);
        }
    }
}

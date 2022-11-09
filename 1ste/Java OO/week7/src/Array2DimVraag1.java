import java.util.Scanner;

/***
 *
 */

public class Array2DimVraag1 {
    String[][] array;
    public static void main(String[] args) {
        // write your code here
        Array2DimVraag1 dim = new Array2DimVraag1();
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel bestaanden wil je ingeven?");
        final int AANTAL = input.nextInt();
        
        dim.maakAantal(AANTAL);
        dim.drukBestand();

        }

    /***
     *Methoden : maakAantal
     * @param AANTAL
     */
    public  void maakAantal(int AANTAL) {
        array = new String[AANTAL][2];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int x = 1; x < array[i].length; x++) {
                System.out.println("Geef de bestaandsnaam");
                String naam = input.next();
                System.out.println("Geed de file inhoud");
                String tekst = input.next();
                array[i][0] = naam;
                System.out.println(i);
                int check = x + 1;
                System.out.println(check);
                array[i][1] = tekst;

            }
        }
    }

    /***
     * Methoden: drukBestand
     */
    public void drukBestand(){
            for (int i = 0; i < array.length; i++) {
                for (int x = 0; x < array[i].length; x++) {
                    System.out.print(array[i][x] + " ");

                }
                System.out.println();
            }
        }

    }


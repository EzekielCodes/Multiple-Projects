import java.util.Scanner;

public class methodeVraag1 {
    public static void main(String[] args) {
        int arrayGetallen [] = getalInlezen();
        int resulaat = gemiddeldeBereken(arrayGetallen);
        System.out.println(resulaat);
    }

    /***
     *
     * @return array
     */
    public static int[] getalInlezen(){

        Scanner input = new Scanner(System.in);
        System.out.println("Hoevel getallen wilt je ingeven");
        int hoeveelheid = input.nextInt();
        int array[] =new int[hoeveelheid];

        for (int i = 0; i < hoeveelheid ; i++){
            System.out.printf("Geef de %d getal in: %n",i + 1);
            array[i] = input.nextInt();
        }
       return array;


    }

    /***
     *
     * @param arrayGetallen
     * @return resultaat
     */
    public static int gemiddeldeBereken(int arrayGetallen[]){
        int som = 0;
        for (int i = 0; i < arrayGetallen.length; i++){
            som = som + arrayGetallen[i];

        }
        int resultaat = som / arrayGetallen.length;
        return resultaat;
    }
}

import java.util.Scanner;

public class Array2DimVraag2 {
    public static void main(String[] args) {
        int dim[][];
        int transDimm[][];
        Scanner input = new Scanner(System.in);
        System.out.println("Hoeveel rijen?");
        int rijen = input.nextInt();
        System.out.println("Hoeveel kolommen?");
        int kolommen = input.nextInt();
        dim = new int [rijen][kolommen];
        transDimm = new int[kolommen][rijen];
        for (int i = 0; i < rijen; i ++){
            for(int x = 0; x < kolommen; x++){
                dim[i][x] = input.nextInt();
            }
        }

        for (int i = 0; i < rijen; i++) {
            for (int x = 0; x < kolommen; x++) {
                System.out.print(dim[i][x] + " ");

            }
            System.out.println();
        }



        for (int i = 0; i < kolommen; i ++){
            for(int x = 0; x < rijen; x++){
                System.out.print(dim[x][i] + " ");
            }
            System.out.println();
        }
    }
}

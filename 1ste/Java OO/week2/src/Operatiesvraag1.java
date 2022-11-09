/**
 * @author akindeletoluwani ict7
 * @version 03.12.2020
 */
public class Operatiesvraag1 {
    public static void main(String[] args){
        int a = 7;
        int b = 3;
        int c = 6;
        int d = 2;

        int som = a + b +c +d;
        int heelRest = som % 4;
        int gemiddelde = (som-heelRest)/4;
        double gemid = ((double)som)/4;
                        //(som)/4.0
        System.out.println("De waarden van je variabelen zijn ");
        System.out.println("Het gehele gemiddelde is: " + gemiddelde);
        System.out.println("De gehele rest: "+heelRest);
        System.out.println("Het gemiddelede is: " + gemid);
    }
}

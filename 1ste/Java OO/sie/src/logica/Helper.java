package logica;

/**
 * @author Van de Voorde Siebe
 * @Version 28/04/2021
 */

public class Helper {

    public static double afronden(double afTeRondenGetal, int aantalCijfersNaKomma){
        double deler = Math.pow(10, aantalCijfersNaKomma);
        return (double)Math.round(afTeRondenGetal * deler) / deler;
    }
}

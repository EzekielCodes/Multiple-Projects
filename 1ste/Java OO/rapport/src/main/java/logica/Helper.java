package logica;

public class Helper {

    public static double afronden(double afTeRondenGetal, int aantalCijfersNaKomma){
        double deler = Math.pow(10, aantalCijfersNaKomma);
        return (double)Math.round(afTeRondenGetal * deler) / deler;
    }
}
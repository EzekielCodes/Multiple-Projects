package logica;

public class Helper {
    public static double afronden(double getal, int digitsNaKomma){
        double tussenstap = (getal*Math.pow(10,digitsNaKomma));
        double afgerond = Math.round(tussenstap)/(Math.pow(10,digitsNaKomma));
        return afgerond;
    }
}


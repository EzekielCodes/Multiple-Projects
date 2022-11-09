package logica;
public class Helper {

    public static double afronden(double getal, int digitsNaKomma){
        double vermenigvuldiger = 1.0;
        for (int i = 0; i < digitsNaKomma; i++){
            vermenigvuldiger *= 10.0;
        }
        double roudOff = (double)Math.round(getal * vermenigvuldiger) / vermenigvuldiger;
        return roudOff;
    }
}

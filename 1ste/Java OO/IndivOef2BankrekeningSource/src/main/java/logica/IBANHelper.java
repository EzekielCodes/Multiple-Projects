package logica;

import java.math.BigInteger;
import logica.enumeratie.Landcode;

/**
 * IndivOef1a_Bankrekening : HelperIBAN
 *
 * @author kristien.vanassche
 * @version 19/03/2021
 */
public class IBANHelper {
    /**
     * methode waarmee getest kan worden of het een geldig rekeningnummer is of
     * niet. Naast de lengte en de vorm  wordt ook de geldigheid getest a.d.h.v. het controlegetal.
     *
     * @return true bij een geldig rekeningnummer, false bij een ongeldig rekeningnummer
     */
    public static boolean isGeldig(String rekeningnummmer) {
       return false;
    }

//    public static String normaliseer(String rekNr) {
//        if (rekNr.startsWith("IBAN")) rekNr = rekNr.substring(4);
//        return rekNr.replaceAll(" ", "");
//    }
//
//    /**
//     * test controlegetal van vroegere nationaal rekeningnummer
//     * @param nummer het vroegere nationaal rekeningnummer, al dan niet met spaties (xxx-xxxxxxx-xx)
//     * @return true als controlecijfers correct zijn
//     */
//    private static boolean controleerVroegereBelgischeRekeningnummer(String nummer) {
//        long groep, controlegetal;
//        try {
//            nummer = nummer.replace("-", "");
//            if (nummer.length() != 12) return false;
//
//            groep = Long.parseLong(nummer.substring(0, 10));
//            controlegetal = Long.parseLong(nummer.substring(10, 12));
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//        return (groep % 97 == controlegetal);
//    }

//    /**
//     * Deze IBAN controle werkt enkel voor Belgische IBAN nummers.
//     * Voor andere Europese landen voldoet deze methode niet, omdat de rekeningnummers te lang zijn.
//     *
//     * @param nummer
//     * @return true als IBAN ok
//     * test
//     */
//    private boolean controleerIBAN(String nummer) {
//        // test controlegetal van nieuw Belgisch IBAN-nummer (LL + C2 + (xxxxxxxxxx + C1))
//        long groep, controlegetal;
//        try {
//            groep = Long.parseLong(nummer.substring(4, 16) + (10 + nummer.charAt(0) - 'A') + (10 + nummer.charAt(1) - 'A'));
//            groep *= 100;
//            controlegetal = Long.parseLong(nummer.substring(2, 4));
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//        return (controlegetal == (98 - (groep % 97)));
//    }
//
//    /**
//     * Deze IBAN controle werkt voor alle Europese IBAN nummers.
//     *
//     * @param nummer
//     * @return true als IBAN ok
//     */
//    private static boolean controleerIBAN2(String nummer) {
//        // test controlegetal van nieuwe IBAN-nummer (LL + C2 + (xxxxxxxxxxxxxxxxxxx))
//        BigInteger groep;
//        BigInteger controlegetal;
//        try {
//            groep = new BigInteger(convertToNumeric(nummer.substring(4) + nummer.substring(0,2)));
//            groep = groep.multiply(new BigInteger("100"));
//            controlegetal = new BigInteger(nummer.substring(2, 4));
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//
//        if (!controlegetal.equals(new BigInteger("98").subtract(groep.remainder(new BigInteger("97"))))) {
//            return false;
//        }
//        return true; //alles ok!
//    }
//
//    private static String convertToNumeric(String nummer) {
//        String s = "";
//        char c;
//
//        for(int i = 0; i < nummer.length(); i++) {
//            c = nummer.charAt(i);
//            if (c >= 'A' && c <= 'Z') {
//                s += (10 + (c - 'A'));
//            }
//            else {
//                s += c;
//            }
//        }
//        return s;
//    }
//
    private static int getAantalDigitsIBAN(Landcode landcode) {
        switch (landcode) {
            case BE: return 16;
            case NL: return 18;
            case DE: return 22;
            case FR: return 27;
            default: return -1;
        }
    }
}

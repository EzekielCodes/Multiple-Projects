package logica;
import logica.enumeratie.EANControle;
/**
 * https://nl.wikipedia.org/wiki/EAN-codeboek
 * https://www.eancodeboek.nl/eancodeboek/control/index
 * https://callmepower.be/nl/energie/gids/meters/ean-code
 *
 * @author kristien.vanassche
 * @version 29/03/2021
 */
public class EANCodeHelper {
    public static EANControle controleerEANcode(String EANcode) {
        if (EANcode.length() != 18) {
            return EANControle.ONGELDIG_AANTAL_TEKENS;
        }
        if (!EANcode.substring(0,5).equals("54144")) {
            return EANControle.ONGELDIGE_PREFIX;
        }
        if (!EANcode.matches("\\d+")) {
            return EANControle.ONGELDIGE_TEKENREEKS;
        }
        if (!isControlebitJuist(EANcode)) {
            return EANControle.ONGELDIG_CONTROLECIJFER;
        }
        return EANControle.OK;
    }

    private static boolean isControlebitJuist(String code) {
        int[] pincode = converteer(code);

        int somEven = 0;
        int somOneven = 0;
        for (int i = 0; i < code.length()-1; i += 2) somOneven += pincode[i];
        for (int i = 1; i < code.length()-1; i += 2) somEven += pincode[i];
        return pincode[code.length()-1] == (10 - ((somOneven * 3 + somEven) % 10)) % 10;
    }

    private static int[] converteer(String code) {
        int[] rij = new int[code.length()];
        for (int i = 0; i < code.length(); i++) {
            rij[i] = Integer.parseInt("" + code.charAt(i));
        }
        return rij;
    }
}

package logica;

import java.text.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author kristien.vanassche
 * @version 29/03/2021
 */
public class DatumHelper {
    public static LocalDate geefLocalDate(int jaar, int maand, int dag) {
        return LocalDate.of(jaar, maand, dag);
    }

    public static LocalDate geefLocalDate(String datum) {
        if (datum.length() != 10) {
            throw new IllegalArgumentException("DATUM ERROR: ongeldig formaat");
        }
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        try {
            df.parse(datum);
            return LocalDate.of(Integer.parseInt(datum.substring(0,4)),
                    Integer.parseInt(datum.substring(5,7)),
                    Integer.parseInt(datum.substring(8,10)));
        }
        catch(Exception e) {
            throw new IllegalArgumentException("DATUM ERROR: ongeldige datum");
        }
    }

    public static int aantalDagenVerschil(LocalDate datum1, LocalDate datum2) {
        return (int)datum1.until(datum2, ChronoUnit.DAYS);
    }
}

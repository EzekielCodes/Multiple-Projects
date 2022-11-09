package logica;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import logica.enumeratie.EANControle;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PVinstallatie : DigitaleMeterTest
 *
 * @author kristien.vanassche
 * @version 29/03/2021
 */
class DigitaleMeterTest {
    private DigitaleMeter digitaleMeterGas;

    public DigitaleMeterTest() {
        digitaleMeterGas = new DigitaleMeter("2020-09-18", "541448860001203640");
        //digitaleMeterEli = new DigitaleMeter("2020-09-18", "541448860001203589");
    }

    @Test
    public void testGetters() {
        assertEquals("541448860001203640", digitaleMeterGas.getEanCode());
    }

    @Test
    public void constructorNOK() {
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("", "541448860001203640"));
        assertTrue(exc.getMessage().toUpperCase().contains("DATUM"));
        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter(null,  "541448860001203640"));
        assertTrue(exc.getMessage().toUpperCase().contains("DATUM"));

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18", ""));
        assertTrue(exc.getMessage().toUpperCase().replace("_", "").contains("EANCODE"));
        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18",  null));
        assertTrue(exc.getMessage().toUpperCase().replace("_", "").contains("EANCODE"));
    }

    @Test
    public void constructorNOK2() {
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-9-18","541448860001203641"));
        assertEquals("DATUM ERROR: ongeldig formaat", exc.getMessage());

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-35", "541448860001203641"));
        assertEquals("DATUM ERROR: ongeldige datum", exc.getMessage());

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18", "123451234512345123"));
        assertEquals(EANControle.ONGELDIGE_PREFIX.toString(), exc.getMessage());

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18", "541448860001203641"));
        assertEquals(EANControle.ONGELDIG_CONTROLECIJFER.toString(), exc.getMessage());

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18", "54144886"));
        assertEquals(EANControle.ONGELDIG_AANTAL_TEKENS.toString(), exc.getMessage());

        exc = assertThrows(IllegalArgumentException.class, () -> new DigitaleMeter("2020-09-18",  "541448860001203ABC"));
        assertEquals(EANControle.ONGELDIGE_TEKENREEKS.toString(), exc.getMessage());
    }

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.DigitaleMeter");

        Field[] fields = c.getDeclaredFields();
        assertEquals(4, fields.length);
        Stream.of(fields).forEach(f -> {assert ((f.getModifiers() & Modifier.PRIVATE) != 0);});
    }

    @Test
    void getMeterstand() {
        assertEquals(0, digitaleMeterGas.getMeterstand());
    }

    @Test
    void verwerkMeterstandenNok() {
        LocalDate eind2020 = LocalDate.of(2020, 12,31);
        digitaleMeterGas.verwerkMeterstand(eind2020, 123); //kWh

        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> digitaleMeterGas.verwerkMeterstand(eind2020, 124));
        assertTrue(exc.getMessage().contains("DATUM ERROR"));

        LocalDate eerder = LocalDate.of(2020, 12,30);
        exc = assertThrows(IllegalArgumentException.class, () -> digitaleMeterGas.verwerkMeterstand(eerder, 124));
        assertTrue(exc.getMessage().contains("DATUM ERROR"));

        LocalDate later = LocalDate.of(2021, 1,1);
        exc = assertThrows(IllegalArgumentException.class, () -> digitaleMeterGas.verwerkMeterstand(later, 122));
        assertTrue(exc.getMessage().contains("METERSTAND ERROR"));
    }

    @Test
    void verwerkMeterstanden() {
        LocalDate datum = LocalDate.of(2020, 9,20);
        digitaleMeterGas.verwerkMeterstand(datum, 600); //kWh
        assertEquals(300, digitaleMeterGas.geefGemiddeldVerbruikPerDag());

        datum = LocalDate.of(2020, 9,22);
        digitaleMeterGas.verwerkMeterstand(datum, 800); //kWh
        assertEquals(200, digitaleMeterGas.geefGemiddeldVerbruikPerDag());
    }

    @Test
    void verwerkMeterstandenBis() {
        LocalDate eind2020 = LocalDate.of(2020, 12,31);
        int meterstandEind2020 = 2210;
        digitaleMeterGas.verwerkMeterstand(eind2020, meterstandEind2020); //kWh
        int aantalDagen = (int)digitaleMeterGas.getInstallatiedatum().until(eind2020, ChronoUnit.DAYS);
        assertEquals((double)meterstandEind2020/aantalDagen, digitaleMeterGas.geefGemiddeldVerbruikPerDag());

        LocalDate vandaag = LocalDate.of(2021, 4,1);
        int meterstandVandaag = 10318;
        digitaleMeterGas.verwerkMeterstand(vandaag, meterstandVandaag); //kWh
        aantalDagen = (int)digitaleMeterGas.getInstallatiedatum().until(vandaag, ChronoUnit.DAYS);
        assertEquals((double)meterstandVandaag/aantalDagen, digitaleMeterGas.geefGemiddeldVerbruikPerDag());

        digitaleMeterGas.verwerkMeterstand(vandaag.plus(1, ChronoUnit.DAYS), meterstandVandaag); //kWh
        assertEquals((double)meterstandVandaag/(aantalDagen+1), digitaleMeterGas.geefGemiddeldVerbruikPerDag());
    }

    @Test
    public void testToString() {
        digitaleMeterGas.verwerkMeterstand(LocalDate.of(2021,04,01), 10318);
        assertTrue(("" + digitaleMeterGas).contains("2020-09-18"));
        assertTrue(("" + digitaleMeterGas).contains("541448860001203640"));
        assertTrue(("" + digitaleMeterGas).contains("10318"));
    }

    @Test
    public void testEquals() {
        List<DigitaleMeter> lijst = new ArrayList<>();
        DigitaleMeter dm1 = new DigitaleMeter("2020-10-10", "541448860001203640");
        DigitaleMeter dm2 = new DigitaleMeter("2021-11-11", "541448860001203640");
        assertEquals(dm1, dm2);
        lijst.add(dm1);
        assertTrue(lijst.contains(dm2));
    }
}
package logica;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kristien.vanassche
 * @version 19/03/2021
 */
class NetbeheerderTest {
    private Netbeheerder netbeheerder;

    public NetbeheerderTest() {
        netbeheerder = new Netbeheerder("Fluvius");
    }

    @Test
    public void testConstructor() {
        assertNotNull(netbeheerder);
        assertEquals(0, netbeheerder.getMeters().size());
    }

    @Test
    public void testMeters() {
        assertEquals(0, netbeheerder.getMeters().size());
        netbeheerder.voegMeterToe(new DigitaleMeter("2020-09-18", "541448860001203640"));
        assertEquals(1, netbeheerder.getMeters().size());
        assertThrows(IllegalArgumentException.class, () -> netbeheerder.voegMeterToe(new DigitaleMeter("2020-09-19",  "541448860001203640")));
        assertEquals(1, netbeheerder.getMeters().size());
    }

    @Test
    public void testMetersToevoegen() {
        DigitaleMeter rek1 = new DigitaleMeter("2020-10-10",  "541448860001203640");
        DigitaleMeter rek2 = new DigitaleMeter("2020-10-10",  "541448860001203589");
        netbeheerder.voegMeterToe(rek1);
        netbeheerder.voegMeterToe(rek2);
        assertEquals(2, netbeheerder.getMeters().size());
    }

    @Test
    public void testVraagMeterMaxGemiddeldVerbruik() {
        DigitaleMeter m1 = new DigitaleMeter("2020-11-01", "541448860001203640");
        DigitaleMeter m2 = new DigitaleMeter("2020-11-01",  "541448860001203589");
        netbeheerder.voegMeterToe(m1);
        netbeheerder.voegMeterToe(m2);

        DigitaleMeter maxMeter;
        LocalDate datum = DatumHelper.geefLocalDate("2020-12-31");
        m1.verwerkMeterstand(datum, 600);
        maxMeter = netbeheerder.geefMeterMetHoogsteGemiddeldeVerbruik();
        assertEquals(10, m1.geefGemiddeldVerbruikPerDag());
        assertEquals(maxMeter, m1);

        m2.verwerkMeterstand(datum, 1200);
        maxMeter = netbeheerder.geefMeterMetHoogsteGemiddeldeVerbruik();
        assertEquals(20, m2.geefGemiddeldVerbruikPerDag());
        assertEquals(maxMeter, m2);

        m1.verwerkMeterstand(datum.plusMonths(1), 4000);
        maxMeter = netbeheerder.geefMeterMetHoogsteGemiddeldeVerbruik();
        assertEquals(maxMeter, m1);

        m2.verwerkMeterstand(datum.plusMonths(1), 3000);
        maxMeter = netbeheerder.geefMeterMetHoogsteGemiddeldeVerbruik();
        assertEquals(maxMeter, m1);
    }
}
package logica;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

import logica.Autobelasting.Euronorm;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kristien.vanassche
 */
public class AutoTest {
    private Auto[] autos;

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Auto");

        Field[] fields = c.getDeclaredFields();
        assertEquals(8, fields.length);
        Stream.of(fields).forEach(f -> {assert ((f.getModifiers() & Modifier.PRIVATE) != 0);});
    }

    public AutoTest() {
        autos = new Auto[3];
        autos[0] = new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 44, Aandrijving.HYBRIDE);
        autos[1] = new Auto("Toyota", "Corolla", 2019, Euronorm.valueOf("EURO6"), 6, 115, Aandrijving.BENZINE);
        autos[2] = new Auto("Audi", "A4", 2018, Euronorm.EURO6, 0, 44, Aandrijving.HYBRIDE);
    }

    @Test //1pt
    public void testConstructorOk1() {
        System.out.println("constructorOk1");
        Auto a1 = new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 44, Aandrijving.HYBRIDE);
        Auto a2 = new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 0, Aandrijving.ELEKTRISCH);
    }

    @Test //1pt
    public void testConstructorOk2() {
        System.out.println("constructorOk2");
        Auto a1 = new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 44, Aandrijving.DIESEL, false);
        Auto a2 = new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 44, Aandrijving.DIESEL, true);
    }

    @Test //1pt
    public void testConstructorNok() {
        System.out.println("constructorNOK");
        IllegalArgumentException exception;

        exception = assertThrows(IllegalArgumentException.class, () -> new Auto("Toyota", "Yaris", 2020, Euronorm.valueOf("EURO7"), 0, 44, Aandrijving.HYBRIDE));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().toLowerCase().contains("euronorm"));

        exception = assertThrows(IllegalArgumentException.class, () -> new Auto("Toyota", "Yaris", 2020, Euronorm.EURO6, 0, 44, Aandrijving.ELEKTRISCH));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().toLowerCase().contains("co2"));

        exception = assertThrows(IllegalArgumentException.class, () -> new Auto("Toyota", "Yaris", 2020, Euronorm.EURO4, 5, 0, Aandrijving.ELEKTRISCH));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().toLowerCase().contains("pk"));

        exception = assertThrows(IllegalArgumentException.class, () -> new Auto("Toyota", "Yaris", 2020, Euronorm.EURO4, -5, 119, Aandrijving.BENZINE));
        System.out.println(exception.getMessage());
        assertTrue(exception.getMessage().toLowerCase().contains("pk"));
    }

    @Test //1pt
    public void testConstructorNok2() {
        System.out.println("constructorNOK2");
        assertThrows(IllegalArgumentException.class, () -> new Auto("Toyota", "Yaris", 2020,  Euronorm.EURO6, 0, 44, Aandrijving.BENZINE, true));
    }

    @Test //1pt
    public void testBerekenVoorbeeld1() {
        System.out.println("berekenVoorbeeld1");
        Auto clio = new Auto("Renault", "Clio", 2020, Euronorm.EURO6, 5, 117, Aandrijving.BENZINE);
        assertEquals(282.72565, clio.berekenBIV(), 0.00001);
        assertEquals(87.29424, clio.berekenJVB(), 0.00001);
        assertEquals(87.3, Helper.afronden(clio.berekenJVB(),1));
    }

    @Test //1pt
    public void testBerekenVoorbeeld2() {
        System.out.println("berekenVoorbeeld2");
        Auto a1 = new Auto("Renault", "Fluence", 2011, Euronorm.EURO4, 8, 119, Aandrijving.DIESEL, false);
        assertEquals(78.60, a1.berekenBIV(), 0.01);
        assertEquals(303.05, a1.berekenJVB(), 0.01);
        Auto a2 = new Auto("Renault", "Fluence", 2011, Euronorm.EURO4, 8, 119, Aandrijving.DIESEL, true);
        assertTrue(a2.berekenBIV() == a1.berekenBIV());
        assertTrue(a2.berekenJVB() < a1.berekenJVB());
    }

    @Test //1pt
    public void testSetGetRoetfilter() {
        System.out.println("setGetRoetfilter");
        Auto a1 = new Auto("Renault", "Fluence", 2011, Euronorm.EURO4, 8, 119, Aandrijving.DIESEL);
        assertFalse(a1.getRoetfilter());
        a1.setRoetfilter(true);
        assertTrue(a1.getRoetfilter());
        Auto a2 = new Auto("Toyota", "Corolla", 2019, Euronorm.EURO6, 6, 115, Aandrijving.BENZINE);
        assertThrows(IllegalArgumentException.class, () -> a2.setRoetfilter(true));
    }

    @Test //1pt
    public void testBerekenSetRoetfilter2() {
        System.out.println("berekenSetRoetfilter2");
        Auto a1 = new Auto("Renault", "Fluence", 2011, Euronorm.EURO4, 8, 119, Aandrijving.DIESEL);
        double jvb1 = a1.berekenJVB();
        a1.setRoetfilter(true);
        assertTrue(a1.berekenJVB() < jvb1);
    }

    @Test //1pt
    public void testToString() {
        String merk = "Toyota";
        String type = "Yaris";
        int jaar = 2020;
        Auto yarisHybride = new Auto(merk, type, jaar, Euronorm.EURO6, 0, 84, Aandrijving.HYBRIDE);
        assertTrue(yarisHybride.toString().contains(merk + " " + type + " " + jaar));
    }

//    @Test //1pt
//    public void testEquals() {
//        String merk = "Toyota";
//        String type = "Yaris";
//        Auto yarisHybride2020 = new Auto(merk, type, 2020, Helper.EURO6, 0, 84, Aandrijving.Hybride);
//        assertTrue(Arrays.asList(autos).contains(yarisHybride2020));
//        Auto yarisHybride2019 = new Auto(merk, type, 2019, Helper.EURO6, 0, 84, Aandrijving.Hybride);
//        assertFalse(Arrays.asList(autos).contains(yarisHybride2019));
//        Auto yarisBenzine2020 = new Auto(merk, type, 2020, Helper.EURO6, 5, 119, Aandrijving.Benzine);
//        assertTrue(Arrays.asList(autos).contains(yarisBenzine2020));
//    }
}

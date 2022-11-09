package logica;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IndivOef1a_Bankrekening : BankrekeningTest
 *
 * @author kristien.vanassche
 * @version 19/03/2021
 */
class BankrekeningTest {
    private Bankrekening[] rekeningen;

    @Test
    public void testFieldModifier() throws ClassNotFoundException {
        System.out.println("test field modifier");
        Class<?> c = Class.forName("logica.Bankrekening");

        Field[] fields = c.getDeclaredFields();
        assertEquals(3, fields.length);
        Stream.of(fields).forEach(f -> {assert ((f.getModifiers() & Modifier.PRIVATE) != 0);});
    }

    public BankrekeningTest() {
        rekeningen = new Bankrekening[4];
        rekeningen[0] = new Bankrekening("Kristien", "IBAN BE63 6511 5525 8408");
        rekeningen[1] = new Bankrekening("Evert-Jan", "BE75 9796 2085 3151");
        rekeningen[2] = new Bankrekening("Thomas", "BE94290020980414");
        rekeningen[3] = new Bankrekening("Pieterjan", "BE94290020980414", 100);
    }

    @Test
    public void testGetters() {
        assertEquals("Kristien", rekeningen[0].getHouder());
        assertEquals("BE63651155258408", rekeningen[0].getNummer());

        for(int i = 0; i < 3; i++) {
            assertEquals(0, rekeningen[i].getSaldo());
        }
    }

    @Test
    public void testConstructorOk2() {
        assertEquals(100, rekeningen[3].getSaldo());
    }

    @Test
    public void testConstructorNok() {
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", "BE"));
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", "BE12"));
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", "BE12 1234 1234 1234"));
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", "IBAN BE12 1234 1234 1234"));

        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("", "BE94 2900 2098 0414"));
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", ""));

        assertThrows(IllegalArgumentException.class, () -> new Bankrekening(null, "BE94 2900 2098 0414"));
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("XXX", null));
    }

    @Test
    public void testConstructorNok2() {
        assertThrows(IllegalArgumentException.class, () -> new Bankrekening("Kristien", "IBAN BE63 6511 5525 8408", -100));
    }

    @Test
    public void testStorten() {
        assertEquals(0, rekeningen[0].getSaldo());
        for (int i = 1; i <= 5; i++) {
            rekeningen[0].stortBedrag(100);
            assertEquals(i * 100, rekeningen[0].getSaldo());
        }
    }

    @Test
    public void testNegatiefBedragStortenOfAfhalen() {
        assertEquals(0, rekeningen[0].getSaldo());
        assertThrows(IllegalArgumentException.class, () -> rekeningen[0].stortBedrag(-100));
        assertThrows(IllegalArgumentException.class, () -> rekeningen[0].haalBedragAf(-100));
    }

    @Test
    public void testStortenEnAfhalen() {
        assertEquals(100, rekeningen[3].getSaldo());
        for (int i = 1; i <= 5; i++) {
            rekeningen[3].stortBedrag(100);
            assertEquals((i+1) * 100, rekeningen[3].getSaldo());
        }
        for (int i = 1; i <= 10; i++) {
            assertTrue(rekeningen[3].haalBedragAf(50));
        }
        assertFalse(rekeningen[3].haalBedragAf(150));
        assertEquals(100, rekeningen[3].getSaldo());
    }

    @Test
    public void testToString() {
        assertTrue(("" + rekeningen[0]).contains("Kristien"));
        assertTrue(("" + rekeningen[0]).contains("BE63651155258408"));
        assertTrue(("" + rekeningen[0]).contains("" + 0.0));
    }

    @Test
    public void testEquals() {
        List<Bankrekening> lijst = Arrays.asList(rekeningen);
        assertTrue(lijst.contains(new Bankrekening("Kristien", "IBAN BE63 6511 5525 8408")));
        assertTrue(lijst.contains(new Bankrekening("XXXXXXXX", "IBAN BE63 6511 5525 8408")));
        assertTrue(lijst.contains(new Bankrekening("XXXXXXXX", "IBAN BE63651155258408")));
        assertTrue(lijst.contains(new Bankrekening("XXXXXXXX", "BE63651155258408")));
    }
}
package logica;

import logica.enums.Klasgroep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Rapport : StudentTest
 *
 * @author kristien.vanassche
 * @version 30/04/2021
 */
class StudentTest {
    private Student student1, student2;

    public StudentTest() {
        student1 = new Student("r0000001", "An Lemmens", Klasgroep._1ELO1);
        student2 = new Student("r0000002", "Bert Bibber", Klasgroep._1ELO2);
    }

    @Test
    void testConstructorNOK() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null,null, Klasgroep._1ELO1));
        assertThrows(IllegalArgumentException.class, () -> new Student("r1234567","test", null));
        assertThrows(IllegalArgumentException.class, () -> new Student("r1234567","", Klasgroep._1ELO1));
        assertThrows(IllegalArgumentException.class, () -> new Student("123","test", Klasgroep._1ELO1));
        assertThrows(IllegalArgumentException.class, () -> new Student("x1234567","test", Klasgroep._1ELO1));
        assertThrows(IllegalArgumentException.class, () -> new Student("r123x123","test", Klasgroep._1ELO1));
        new Student("r1230123","test", Klasgroep._1ELO1);
    }

    @Test
    void testGetters() {
        assertEquals("An Lemmens", student1.getNaam());
        assertEquals("r0000001", student1.getStudentnummer());
        assertEquals(Klasgroep._1ELO1, student1.getKlasgroep());
    }

    @Test
    void getRapport() {
        assertEquals(0, student1.getRapport().getVakken().length);
        Vak[] vakken = new Vak[]{new Vak("a", 2),
                new Vak("b", 2),
                new Vak("c", 2)};
        student1.setRapport(new Rapport(vakken));
        assertEquals(3, student1.getRapport().getVakken().length);
    }

    @Test
    void testToString() {
        assertTrue(student1.toString().contains("An Lemmens"));
        assertTrue(student1.toString().contains("1ELO1"));
        assertTrue(student1.toString().contains("r0000001"));
    }

    @Test
    public void testEquals() {
        List<Student> lijst = new ArrayList<>();
        Student ander = new Student("r0000001", "ander", Klasgroep._1ELO2);
        assertEquals(student1, ander);
        lijst.add(student1);
        assertTrue(lijst.contains(ander));
    }
}
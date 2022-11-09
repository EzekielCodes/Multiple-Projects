package data;

import logica.enums.Klasgroep;
import logica.Opleiding;
import logica.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RapportenOpleiding : StudentenIOTest
 *
 * @author kristien.vanassche
 * @version 22/05/2021
 */
class StudentenIOReadTest {
    static String bestand = "./src/main/resources/studenten.csv";

    @Test
    void leesLijnen() throws IOException {
        List<String> lijnen = Files.readAllLines(Paths.get(bestand));
        assertEquals(190, lijnen.size());
    }

    @Test
    void leesStudentenOpleiding() throws IOException {
        Opleiding opleiding = new Opleiding("Test");
        List<Student> lijstStudenten = IO.leesStudenten(bestand);
        opleiding.voegStudentenToe(lijstStudenten);
        assertEquals(190, opleiding.getStudenten().size());
    }

    @Test
    void leesStudentenData() throws IOException {
        List<Student> studenten;
        String klasgroep, studNr, naam;
        List<String> lijnen = Files.readAllLines(Paths.get(bestand));
        studenten = IO.leesStudenten(bestand);
        Student s;
        for (int i = 0; i< studenten.size(); i++) {
            s = studenten.get(i);
            klasgroep = s.getKlasgroep().toString();
            studNr = s.getStudentnummer();
            naam = s.getNaam();
            assertTrue((klasgroep.startsWith("1ELO") || klasgroep.startsWith("1ICT")));
            assertTrue(studNr.startsWith("r") && studNr.length() == 8);
            assertEquals(naam, lijnen.get(i).substring(lijnen.get(i).lastIndexOf(";")+1));
        }
    }

    @Test
    void leesStudentenEnSorteer() throws IOException {
        List<Student> lijstStudenten = IO.leesStudenten(bestand);
        String[] studentNr;

        studentNr = lijstStudenten.stream().map(Student::getStudentnummer).toArray(String[]::new);
        for(int i = 0; i < studentNr.length; i++) {
            assertTrue(studentNr[i].equals(lijstStudenten.get(i).getStudentnummer()));
        }

        studentNr = lijstStudenten.stream().map(Student::getStudentnummer).sorted().toArray(String[]::new);
        Collections.sort(lijstStudenten);
        for(int i = 0; i < studentNr.length; i++) {
            assertTrue(studentNr[i].equals(lijstStudenten.get(i).getStudentnummer()));
        }
    }
}
package data;

import be.odisee.ikdoeict.TextFile;
import logica.Opleiding;
import logica.Rapport;
import logica.Student;
import logica.Vak;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * RapportenOpleiding : StudentenIOTest
 *
 * @author kristien.vanassche
 * @version 22/05/2021
 */
class StudentenIOWriteTest {
    @Test
    void schrijfLijnen() throws IOException {
        TextFile.write("temp.txt", "temp");
        assertTrue(TextFile.read("temp.txt").contains("temp"));
        assertTrue(new File("temp.txt").delete());
    }

    @Test
    void schrijfRapportStudent() throws IOException {
        List<Student> studenten = IO.leesStudenten("./src/main/resources/studenten.csv");
        Student student = studenten.get((int)(Math.random()*studenten.size()));
        Rapport rapport = student.getRapport();
        rapport.setVakken(new Vak[] {new Vak("VAK1", 6),
                new Vak("VAK2", 6),
                new Vak("VAK3", 6)});
        Vak[] vakken = rapport.getVakken();
        for(Vak v : vakken) v.setScore(10);
        IO.schrijfStudent(student);
        String bestandsnaam = student.getNaam() + ".txt";
        String res = TextFile.read(bestandsnaam);
        assertTrue(res.contains(student.getNaam()));
        assertTrue(res.contains(student.getStudentnummer()));
        assertTrue(res.contains("50.0%"));
        assertTrue(new File(bestandsnaam).delete());
    }
}
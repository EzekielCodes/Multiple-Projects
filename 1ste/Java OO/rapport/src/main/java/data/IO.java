package data;
import logica.Student;
import logica.Vak;
import logica.enums.Klasgroep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {
//    public static void main(String[] args) throws FileNotFoundException {
//        leesStudenten("./src/main/resources/studenten.csv");
//    }

    public static List<Student> leesStudenten(String path) throws FileNotFoundException {
        List <Student> studentList= new ArrayList<>();
        try (Scanner sc = new Scanner(new File(path))) {
            //Quiz quiz = new Quiz("Biertjes");
            while (sc.hasNextLine()) {
                String[] info = sc.nextLine().split(";");
                if (info.length != 3) {
                    throw new IllegalArgumentException("ongeldige input in file");
                }


                //quiz.voegVraagAntwoordToe(info[0], info[1]);
                Student s = new Student(info[1],info[2], Klasgroep.valueOf(info[0].substring(0,0) + "_" + info[0].substring(0)));
                //Student s = new Student(info[1],info[2], Klasgroep.valueOf(info[0]));
                System.out.println("Q: " + info[0] + "\n=> " + info[1] + "\n=> " + info[2]);
            }
        }
        return studentList;

    }

    public static void schrijfStudent(Student s){
        String output = s.getNaam() + " (" + s.getStudentnummer() + ")" + " - " + s.getKlasgroep() + " - " + s.getRapport();


    }
}

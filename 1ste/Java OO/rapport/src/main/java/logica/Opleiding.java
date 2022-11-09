package logica;
import logica.Student;
import logica.enums.Klasgroep;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opleiding {
    private ArrayList<Student> student;
    private String test;

    public Opleiding(String test){
        student = new ArrayList<>();
        this.test = test;
    }


    public void voegStudentenToe(List<Student> lijstStudenten){
//        Scanner sc = new Scanner(new File(String.valueOf(lijstStudenten)));
//        String[] info = sc.nextLine().split(";");
//        Student s = new Student(info[1],info[2], Klasgroep.valueOf(info[0].substring(0,0) + "_" + info[0].substring(0)));
    }

    public ArrayList<Student> getStudenten() {
        return student;
    }


}

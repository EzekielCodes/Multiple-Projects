package logica;
import logica.enums.Klasgroep;

import java.util.Objects;

public class Student {
    private String studentNr = "";
    private String naam = "";
    private Rapport rapport;
    private Klasgroep klasgroep;

    public Student(String studentNr, String naam, Klasgroep klasgroep){
        method(studentNr);
        this.studentNr = studentNr;
        this.naam = naam;
        this.klasgroep = klasgroep;
    }

    public String getNaam() {
        return naam;
    }

    public String getStudentnummer() {
        return studentNr;
    }

    public Rapport getRapport() {
        return rapport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNr='" + studentNr + '\'' +
                ", naam='" + naam + '\'' +
                ", klasgroep=" + klasgroep +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNr, student.studentNr) && Objects.equals(naam, student.naam) && Objects.equals(rapport, student.rapport) && klasgroep == student.klasgroep;
    }



    public Klasgroep getKlasgroep() {
        return klasgroep;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }

    public String method(String studentNr){
        if (studentNr.length() == 8){
            if(studentNr.substring(0,1).toLowerCase() == "r" && studentNr.substring(1,studentNr.length()).matches(".*\\d.*")){
                return studentNr;
            }
        }
        else {
            throw new IllegalArgumentException("Student nummer is niet 8 characters long");
        }

        return studentNr;
    }


    public int compareTo(Student s){
        return this.studentNr.compareTo(s.studentNr);
    }
}

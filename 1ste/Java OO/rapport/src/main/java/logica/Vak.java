package logica;

import java.util.Objects;

public class Vak {
    private String naam;
    private int stp;
    private int score;
    public static final   int MAX_SCORE= 20;

    public Vak(String naamInput){
        controleerNaam(naamInput);
        this.naam = naamInput;
    }
    public Vak( Vak vak){
        controleerNaam(vak.naam);

    }


    public Vak(String naamInput, int stpInput){
        this(naamInput);
        controleerStp(stpInput);
        this.stp = stpInput;
    }

    public String getNaam() {
        return naam;
    }

    public int getStp() {
        return stp;
    }

    public int getScore() {
        return score;
    }

    public int getMAX_SCORE() {
        return MAX_SCORE;
    }

    public void setScore(int score) {
        controleerScore(score);
        this.score = score;
    }

    public void setStp(int stp) {
        controleerStp(stp);
        this.stp = stp;
    }

    @Override
    public String toString() {
        return this.naam + " (" + stp + "stp)";
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Vak vak = (Vak) o;

        if (this.naam.equals(vak.getNaam())){
            return true;

        }
        return false;
    }
    public void controleerNaam(String naamInput){
        if (naamInput == null || naamInput.equals("")){
            throw new IllegalArgumentException("vaknaam niet geldig");
        }
    }
    public void controleerScore(int scoreInput){
        if (scoreInput > MAX_SCORE || scoreInput < 0){
            throw new IllegalArgumentException("ongeldige score");
        }
    }

    public void controleerStp(int stpInput){
        if (stpInput < 0){
            throw new IllegalArgumentException("ongeldig aantal studiepunten");
        }
    }


}

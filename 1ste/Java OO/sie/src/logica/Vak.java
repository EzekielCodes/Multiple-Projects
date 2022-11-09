package logica;

/**
 * @author Van de Voorde Siebe
 * @Version 28/04/2021
 */

public class Vak {
    public static final int MAX_SCORE = 20;
    private String naam;
    private int stp;
    private int score;

    public Vak(String naam){
        controleerNaam(naam);
        this.naam = naam;
    }

    public Vak(String naam, int stp){
        this(naam);
        controleerStp(stp);
        this.stp = stp;
    }

    public String getNaam() {
        return naam;
    }

    public int getStp() {
        return stp;
    }

    public void setStp(int stp) {
        controleerStp(stp);
        this.stp = stp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        controleerScore(score);
        this.score = score;
    }

    @Override
    public String toString() {
        return naam+" ("+stp+"stp)";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Vak vak = (Vak)obj;
        if (this.naam.equals(vak.naam)){
            return true;
        }
        return false;
    }

    public void controleerScore(int score){
        if (score > MAX_SCORE || score < 0){
            throw new IllegalArgumentException("ongeldige score");
        }
    }

    public void controleerStp(int stp){
        if (stp < 1){
            throw new IllegalArgumentException("ongeldig aantal studiepunten");
        }
    }

    public void controleerNaam(String naam){
        if (naam == null || naam.equals("")){
            throw new IllegalArgumentException("vaknaam ontbreekt");
        }
    }
}

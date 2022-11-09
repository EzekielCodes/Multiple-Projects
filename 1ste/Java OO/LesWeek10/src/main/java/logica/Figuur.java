package logica;
import logica.Enum.Kleur;
import logica.Punt;

import java.util.Objects;

abstract class Figuur{
    private Kleur kleur;
    private Kleur kleurRand;
    private int dikteRand = 0;
    private Punt middelpunt;

    public Figuur(){
        this.kleur = Kleur.WIT;
        this.dikteRand = 1;
        this.kleurRand = Kleur.ZWART;

    }
    public Figuur(Kleur color,Kleur rand, int dikte){
        this.kleur = color;
        this.kleurRand = rand;
        this.dikteRand = dikte;

    }

    public Punt getMiddelpunt() {
        return middelpunt;
    }

    public void setMiddelpunt(Punt middelpunt) {
        this.middelpunt = middelpunt;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public Kleur getKleurRand() {
        return kleurRand;
    }

    public int getDikteRand() {
        return dikteRand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figuur figuur = (Figuur) o;
        return dikteRand == figuur.dikteRand && kleur == figuur.kleur && kleurRand == figuur.kleurRand && Objects.equals(middelpunt, figuur.middelpunt);
    }

    @Override
    public String toString() {
        return "Figuur{" +
                "kleur=" + kleur +
                ", kleurRand=" + kleurRand +
                ", dikteRand=" + dikteRand +
                ", middelpunt=" + middelpunt +
                '}';
    }

    public abstract double berekenOppervlakte();

    public abstract double berekenOmtrek();

    public double berekenAfstand(Punt punten){
        return  middelpunt.berekenAfstand(punten);
    }

    public  double berekenAfstand(Figuur fig){
        return berekenAfstand(fig);
    }
}

package logica;

import logica.Enum.Kleur;
public class Cirkel extends Figuur {
    private double straal = 0;

    public Cirkel(){
        straal = 50;
        this.setMiddelpunt(new Punt(0,0));
    }

    public Cirkel(double straal){
        this.straal = straal;
    }

    public Cirkel(double straal, Kleur kleur , Kleur kleurRand, int dikte ){
        super(kleur,  kleurRand, dikte);
        this.straal = straal;

    }

    public Cirkel(Punt middelpunt, double straal) {
       this.setMiddelpunt(middelpunt);
       this.straal = straal;

    }

    public Cirkel(Punt middelpunt, double straal, Kleur kleur, Kleur kleurRand, int dikte) {
        super(kleur,  kleurRand, dikte);
        this.setMiddelpunt(middelpunt);
        this.straal = straal;
    }

    @Override
    public double berekenOppervlakte() {
        double oppervlakte = Math.pow(this.straal,2) * Math.PI;
        oppervlakte = oppervlakte * 100;
        oppervlakte = Math.round(oppervlakte);
        oppervlakte = oppervlakte / 100;
        return oppervlakte;
    }

    @Override
    public double berekenOmtrek() {
        double omtrek = Math.PI * 2 * this.straal;
        omtrek = omtrek * 100;
        omtrek = Math.round(omtrek);
        omtrek = omtrek / 100;
        return omtrek;
    }

    public double getStraal() {
        return straal;
    }

    @Override
    public String toString() {
        return "Cirkel{" +
                "straal=" + straal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cirkel cirkel = (Cirkel) o;
        return Double.compare(cirkel.straal, straal) == 0;
    }


}

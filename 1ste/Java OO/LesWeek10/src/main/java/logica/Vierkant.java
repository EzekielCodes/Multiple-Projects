package logica;

import logica.Enum.Kleur;

public class Vierkant extends Figuur {
    private double zijde = 0;

    public Vierkant(){
        zijde = 50;
        this.setMiddelpunt(new Punt(0,0));
    }

    public Vierkant(double zijde){
        this.zijde = zijde;
    }

    public Vierkant(Punt punten, double zijde){
        this.setMiddelpunt(punten);
        this.zijde = zijde;
    }

    public Vierkant(double zijde, Kleur kleur, Kleur kleurRand,int dikte){
        super(kleur,kleurRand,dikte);
        this.zijde = zijde;
    }

    public Vierkant(Punt punten,double zijde, Kleur kleur, Kleur kleurRand,int dikte){
        super(kleur,kleurRand,dikte);
        this.setMiddelpunt(punten);
        this.zijde = zijde;
    }

    @Override
    public String toString() {
        return "Vierkant{" +
                "zijde=" + zijde +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vierkant vierkant = (Vierkant) o;
        return Double.compare(vierkant.zijde, zijde) == 0;
    }

    public double getZijde() {
        return zijde;
    }

    @Override
    public double berekenOppervlakte() {
        double side = zijde * zijde;

        return side;
    }

    @Override
    public double berekenOmtrek() {
        return zijde * 4;
    }


}

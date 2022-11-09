package logica;

import logica.enums.Graad;

import java.util.Arrays;

/**
 * @author Van de Voorde Siebe
 * @Version 28/04/2021
 */

public class Rapport {
    private Vak[] vakken;

    public Rapport(Vak[] vakken){
        this.vakken = vakken;
    }

    public Vak[] getVakken() {
        return vakken;
    }

    public double geefGewogenResultaatProcent(){
        double totaalScore = 0.0;
        double totaalTeVerdienen = 0.0;
        for (int i = 0; i < vakken.length; i++){
            totaalScore += vakken[i].getScore() * vakken[i].getStp();
            totaalTeVerdienen += Vak.MAX_SCORE * vakken[i].getStp();
        }
        return  Helper.afronden(((totaalScore / totaalTeVerdienen) * (double)100.0), 2);
    }

    public Graad geefGraad(){
        double resultaatProcent = geefGewogenResultaatProcent();
        if (resultaatProcent < 50){
            return Graad.NIET_GESLAAGD;
        }
        else if (resultaatProcent > 49 && resultaatProcent < 65){
            return Graad.VOLDOENING;
        }
        else if (resultaatProcent > 64 && resultaatProcent < 75){
            return Graad.ONDERSCHEIDING;
        }
        else if (resultaatProcent > 74 && resultaatProcent < 85){
            return Graad.GROTE_ONDERSCHEIDING;
        }
        else{
            return Graad.GROOTSTE_ONDERSCHEIDING;
        }
    }

    private boolean alleVakkenGeslaagd(){
        boolean voorAllesDoor = true;
        for (int i = 0; i < vakken.length; i++){
            if (vakken[i].getScore() < (Vak.MAX_SCORE/2)){
                voorAllesDoor = false;
                break;
            }
        }
        return voorAllesDoor;
    }

    @Override
    public String toString() {
        double resultaatProcent = geefGewogenResultaatProcent();
        Graad graad = geefGraad();
        return resultaatProcent+"% - "+graad;
    }
}

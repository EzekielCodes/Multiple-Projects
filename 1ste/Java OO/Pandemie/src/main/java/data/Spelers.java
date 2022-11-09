package data;

import logica.ENUM.Kleur;

public class Spelers {
    private int id;
    private Kleur kleur;
    private String naam;
    private int rol_id ;

    public Spelers(int id,Kleur kleur,String naam, int rol_id) {
        this.id = id;
        this.rol_id = rol_id;
        this.kleur = kleur;
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public String getNaam() {
        return naam;
    }

    public int getRol_id() {
        return rol_id;
    }
}

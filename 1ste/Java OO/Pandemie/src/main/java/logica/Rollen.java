package logica;

public class Rollen {
    private int id = 0;
    private String naam = "";
    private String beschrijving = "";

    public Rollen(int id, String naam, String beschrijving){
        this.beschrijving = beschrijving;
        this.id = id;
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }
}

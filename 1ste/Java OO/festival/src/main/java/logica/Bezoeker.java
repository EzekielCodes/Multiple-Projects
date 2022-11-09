package logica;

/**
 *
 * @author evertjan.jacobs
 */
public class Bezoeker {

    int bezoekerId;
    String naam;
    String voornaam;
    String straat;
    String gemeente;
    String postcode;
    String land;

    public Bezoeker(int bezoekerId, String naam, String voornaam, String straat, String gemeente, String postcode, String land) {
        this.bezoekerId = bezoekerId;
        this.naam = naam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.gemeente = gemeente;
        this.postcode = postcode;
        this.land = land;
    }

    public Bezoeker(String naam, String voornaam, String land) {
        this.bezoekerId = -1;
        this.naam = naam;
        this.voornaam = voornaam;
        this.land = land;
    }

    public int getBezoekerId() {
        return bezoekerId;
    }

    public void setBezoekerId(int bezoekerId) {
        this.bezoekerId = bezoekerId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

}

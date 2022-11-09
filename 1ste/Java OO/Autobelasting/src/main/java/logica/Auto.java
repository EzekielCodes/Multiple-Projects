package logica;

public class Auto {

    private String merk, model;
    private int bouwjaar, fiscPK;
    private double uitstoot;
    private boolean roetfilter;
    private Autobelasting.Euronorm euronorm;
    private Aandrijving aandrijving;


    public Auto(String merk, String model, int bouwjaar, Autobelasting.Euronorm euronorm, int fiscPK, double uitstoot, Aandrijving aandrijving){
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.euronorm = euronorm;
        if (fiscPK<0){
            throw new IllegalArgumentException("De fiscale PK van een auto kan niet negatief zijn.");
        } else if(aandrijving.equals(Aandrijving.ELEKTRISCH) && fiscPK!=0){
            throw new IllegalArgumentException("De fiscale PK van een elektrische wagen is steeds 0.");
        } else this.fiscPK = fiscPK;
        if (aandrijving.equals(Aandrijving.ELEKTRISCH) && uitstoot!=0){
            throw new IllegalArgumentException("Er is geen CO2-uitstoot voor een elektrische wagen.");
        } else this.uitstoot = uitstoot;
        this.aandrijving = aandrijving;
    }

    public Auto(String merk, String model, int bouwjaar, Autobelasting.Euronorm euronorm, int fiscPK, double uitstoot, Aandrijving aandrijving, boolean roetfilter){
        this.merk = merk;
        this.model = model;
        this.bouwjaar = bouwjaar;
        this.euronorm = euronorm;
        if (fiscPK<0){
            throw new IllegalArgumentException("De fiscale PK van een auto kan niet negatief zijn.");
        } else if(aandrijving.equals(Aandrijving.ELEKTRISCH) && fiscPK!=0){
            throw new IllegalArgumentException("De fiscale PK van een elektrische wagen is steeds 0.");
        } else this.fiscPK = fiscPK;
        if (aandrijving.equals(Aandrijving.ELEKTRISCH) && uitstoot!=0){
            throw new IllegalArgumentException("Er is geen CO2-uitstoot voor een elektrische wagen.");
        } else this.uitstoot = uitstoot;
        this.aandrijving = aandrijving;
        if (!aandrijving.equals(Aandrijving.DIESEL) && roetfilter){
            throw new IllegalArgumentException("Een roetfilter is enkel mogelijk bij dieselauto’s.");
        } else this.roetfilter = roetfilter;
    }

    public double berekenBIV(){
        return Autobelasting.berekenBIV(this.aandrijving, this.euronorm, this.bouwjaar, this.uitstoot);
    }

    public double berekenJVB(){
        return Autobelasting.berekenJVB(this.aandrijving, this.euronorm, this.fiscPK, this.uitstoot, this.roetfilter);
    }

    public void setRoetfilter(boolean roetfilter) {
        if (!this.aandrijving.equals(Aandrijving.DIESEL)){
            throw new IllegalArgumentException("Een roetfilter is enkel mogelijk bij dieselauto’s.");
        } else this.roetfilter = roetfilter;
    }

    public boolean getRoetfilter() {
        return this.roetfilter;
    }

    @Override
    public String toString() {
        return this.merk + " " + this.model + " " + this.bouwjaar + " " + this.aandrijving + "(" + this.euronorm + " - " + this.fiscPK + " - " + this.uitstoot + "g CO2)";
    }
}

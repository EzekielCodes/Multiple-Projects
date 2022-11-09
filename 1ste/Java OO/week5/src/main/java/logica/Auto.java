package  logica;
import logica.Aandrijving;
import logica.Autobelasting.Euronorm;
public class Auto {
    private static String merk;
    private static String model;
    private static int jaarEersteInschr;
    private static Euronorm euronorm;
    private static int fiscPK;
    private static double CO2Uitstoot;
    private static Aandrijving aandrijving;
    private boolean roetfilter = false;

    public Auto(String merk, String model, int jaarEersteInschr, Euronorm euronorm, int fiscPK, int CO2Uitstoot, Aandrijving aandrijving) {
        if (aandrijving == Aandrijving.ELEKTRISCH){
            if (CO2Uitstoot > 0){
                throw new IllegalArgumentException("Elektrische auto's produceren geen CO2");
            }
            if (fiscPK > 0){
                throw new IllegalArgumentException("Elektrische auto's hebben geen fiscale PK");
            }
        }
        if (aandrijving != Aandrijving.ELEKTRISCH && fiscPK < 0){
            throw new IllegalArgumentException("Fiscale PK moet positiek zijn");
        }
        this.merk = merk;
        this.model = model;
        this.jaarEersteInschr = jaarEersteInschr;
        this.euronorm = euronorm;
        this.fiscPK = fiscPK;
        this.CO2Uitstoot = CO2Uitstoot;
        this.aandrijving = aandrijving;
    }

    public Auto(String merk, String model, int jaarEersteInschr, Euronorm euronorm, int fiscPK, int CO2Uitstoot, Aandrijving aandrijving, boolean roetfilter) {
        this(merk, model, jaarEersteInschr, euronorm, fiscPK, CO2Uitstoot, aandrijving);
        setRoetfilter(roetfilter);
    }

    public boolean getRoetfilter() {
        return roetfilter;
    }

    public Euronorm getEuronorm() {
        return this.euronorm;
    }

    public static void setEuronorm(Euronorm euronorm) {
        Auto.euronorm = euronorm;
    }

    public void setRoetfilter(boolean roetfilter) {
        if (roetfilter && (aandrijving != Aandrijving.DIESEL)){
            throw new IllegalArgumentException("Roetfilter enkel mogelijk voor dieselauto's");
        }
        this.roetfilter = roetfilter;
    }

    public double berekenBIV(){
        return Autobelasting.berekenBIV(aandrijving, euronorm, jaarEersteInschr, CO2Uitstoot);
    }

    public double berekenJVB(){
        return Autobelasting.berekenJVB(aandrijving, euronorm, fiscPK, CO2Uitstoot, roetfilter);
    }

    @Override
    public String toString() {
        return merk+" "+model+" "+jaarEersteInschr+" "+aandrijving+" ("+roetfilter+" "+euronorm.toString()+" - "+fiscPK+"PK - "+CO2Uitstoot+"g CO2)";
    }





}

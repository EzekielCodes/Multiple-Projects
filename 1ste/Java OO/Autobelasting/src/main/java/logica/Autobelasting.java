package logica;

/**
 *
 * @author kristien.vanassche
 */
public class Autobelasting {
    private static final int HUIDIG_JAAR = 2020;
    private static final int OPDECIEM_GEMEENTE = 10;

    public enum Euronorm {
        EURO0, EURO1, EURO2, EURO3, EURO4, EURO5, EURO6;

        @Override
        public String toString() {
            String name = this.name();
            return name.substring(0, name.length()-1) + " " + name.charAt(name.length()-1);
        }
    }

    //https://www.autoverzekering-berekenen.be/verkeersbelasting/formule-berekenen-belasting-op-inverkeerstelling.html
    private static final double[][] LUCHTCOMPONENT = {
            //Euronorm, cOther, cDiesel
            {Euronorm.EURO0.ordinal(), 1229.77, 3091.52},
            {Euronorm.EURO1.ordinal(), 549.97, 907.12},
            {Euronorm.EURO2.ordinal(), 164.46, 672.31},
            {Euronorm.EURO3.ordinal(), 103.16, 532.78},
            {Euronorm.EURO4.ordinal(), 24.76, 504.38},
            {Euronorm.EURO5.ordinal(), 22.26, 496.05},
            {Euronorm.EURO6.ordinal(), 22.26, 490.35}
    };

    private static final double[][] LEEFTIJDSCORRECTIE = {
            //Jaar eerste inschrijving, LC-waarde
            {2020, 100},
            {2019, 90},
            {2018, 80},
            {2017, 70},
            {2016, 60},
            {2015, 50},
            {2014, 40},
            {2013, 30},
            {2012, 20},
            {2011, 10} //en lager
    };

    //https://belastingen.vlaanderen.be/VKB_tarieven
    //https://belastingen.vlaanderen.be/JVKB_tarief-vergroende-jaarlijkse-verkeersbelasting-voor-de-personenauto%E2%80%99s-en-aanverwanten-die-bij-de-div
    //https://www.autoverzekering-berekenen.be/verkeersbelasting/BIV-op-basis-van-de-milieukenmerken-van-het-voertuig.html
    private static final double[][] BASISBELASTING_2020 = {
            //fisc PK, basisprijs
            {4, 75.96},
            {5, 95.04},
            {6, 137.40},
            {7, 179.52},
            {8, 222.00},
            {9, 264.36},
            {10, 306.36}
    };

    //wordt ook luchtterm genoemd, zie https://belastingen.vlaanderen.be/JVKB_tarief-vergroende-jaarlijkse-verkeersbelasting-voor-de-personenauto%E2%80%99s-en-aanverwanten-die-bij-de-div
    private static final double[][] LUCHTTERM = {
            //Euronorm, %boniXxx, %maliDiesel
            {Euronorm.EURO0.ordinal(), 30, 50},
            {Euronorm.EURO1.ordinal(), 10, 40},
            {Euronorm.EURO2.ordinal(), 5, 35},
            {Euronorm.EURO3.ordinal(), 0, 30},
            {Euronorm.EURO4.ordinal(), -12.5, 25},
            {Euronorm.EURO5.ordinal(), -15, 17.5},
            {Euronorm.EURO6.ordinal(), -15, 15}
    };

    public static double berekenBIV(Aandrijving aandrijving, Euronorm euronorm, int jaarEersteInschr, double CO2Uitstoot) {
        double f;

        if (aandrijving == Aandrijving.HYBRIDE && CO2Uitstoot <= 50) {
            return 0;
        }
        switch (aandrijving) {
            case ELEKTRISCH:
            case CNG:
                return 0;
            case LPG:
                f = 0.88;
                break;
            default:
                f = 1;
                break;
        }
        double x = (HUIDIG_JAAR - 2012) * 4.5;
        double c = Autobelasting.LUCHTCOMPONENT[euronorm.ordinal()][aandrijving == Aandrijving.DIESEL ? 2 : 1];
        double LC = (jaarEersteInschr <= 2010 ? 10 : Autobelasting.LEEFTIJDSCORRECTIE[2020-jaarEersteInschr][1]) / 100.0;
        return ((Math.pow((CO2Uitstoot * f + x) / 246, 6) * 4500) + c) * LC;
    }

    public static double berekenJVB(Aandrijving aandrijving, Euronorm euronorm, int fiscPK, double CO2Uitstoot, boolean roetfilter) {
        double basis;
        int euronormWaarde = euronorm.ordinal();

        if (aandrijving != Aandrijving.DIESEL && roetfilter) {
            throw new IllegalArgumentException("Enkel dieselauto's kunnen een roetfilter hebben");
        }
        if (roetfilter && euronormWaarde < Euronorm.EURO6.ordinal()) {
            euronormWaarde += 1;
        }

        if (aandrijving == Aandrijving.HYBRIDE && CO2Uitstoot <= 50) {
            return 0;
        }
        switch (aandrijving) {
            case ELEKTRISCH:
            case CNG:
                return 0;
        }

        if (fiscPK <= BASISBELASTING_2020[0][0]) {
            basis = BASISBELASTING_2020[0][1];
        } else {
            basis = BASISBELASTING_2020[fiscPK - (int) Autobelasting.BASISBELASTING_2020[0][0]][1];
        }

        double percentageCO2 = 0.3 * ((CO2Uitstoot > 500 ? 500 : CO2Uitstoot < 24 ? 24 : CO2Uitstoot) - 122);
        double percentageLuchtterm = LUCHTTERM[euronormWaarde][aandrijving == Aandrijving.BENZINE ? 1 : 2];

        double res = basis * (1 + (percentageCO2 + percentageLuchtterm) / 100);
        return res * (1 + OPDECIEM_GEMEENTE / 100.0);
    }
}
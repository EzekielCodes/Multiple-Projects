package logica;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class DigitaleMeter {
    private LocalDate installatiedatum;
    private String eanCode;
    private int meterStand = 0;
    private LocalDate laatsteUpdate;


    public DigitaleMeter(String input,String time){
        String test = time.substring(0,5);
        String controle = "54144";

        System.out.println(time.length());
        System.out.println(test.length());
        try {
            this.installatiedatum = DatumHelper.geefLocalDate(input);


        }
        catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
        try{
            if(time.isEmpty()){
                throw  new IllegalArgumentException("Staat leeg");
            }
            else if(time.length() != 18){
                throw  new IllegalArgumentException("EANCODE niet lang genoeg");
            }




           if(!(controle.equals(test))){
                throw  new IllegalArgumentException("MOet met 54144 beginnen");
            }

            this.eanCode = time;
            this.meterStand = 0;
            this.laatsteUpdate = installatiedatum;


        }
        catch (Exception  e){
                System.out.println(e.getMessage());
        }




    }

    public LocalDate getInstallatiedatum() {
        return installatiedatum;
    }

    public void setInstallatiedatum(LocalDate installatiedatum) {
        this.installatiedatum = installatiedatum;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public int getMeterStand() {
        return meterStand;
    }

    public void setMeterStand(int meterStand) {
        this.meterStand = meterStand;
    }

    public LocalDate getLaatsteUpdate() {
        return laatsteUpdate;
    }

    public void setLaatsteUpdate(LocalDate laatsteUpdate) {
        this.laatsteUpdate = laatsteUpdate;
    }


    public void verwerkMeterstand(LocalDate eind2020, int i) {
        if (this.meterStand == 0){
            System.out.println(this.meterStand);

                this.meterStand = i;
                int compareValue = laatsteUpdate.compareTo(eind2020);
                if(compareValue < 0 || compareValue == 0){
                    this.laatsteUpdate = eind2020;
                    System.out.println(this.laatsteUpdate);
                }
                else {
                    throw new IllegalArgumentException("");
                }


        }
        else {
            if (this.meterStand <= i){
                this.meterStand = i;
                int compareValue = laatsteUpdate.compareTo(eind2020);
                if(compareValue < 0 || compareValue == 0){
                    this.laatsteUpdate = eind2020;
                }
                else {
                    throw new IllegalArgumentException("");
                }
            }
            else {
                throw new IllegalArgumentException("Meterstand moet gelijk of groter zijn dan laast gegevens");
            }
        }

    }


    public double geefGemiddeldVerbruikPerDag() {
        int compareValue = installatiedatum.compareTo(laatsteUpdate);

        if(compareValue < 0 || compareValue == 0){

                    int aantalDagen = DatumHelper.aantalDagenVerschil(installatiedatum,laatsteUpdate);
                    return (double) meterStand/aantalDagen;


        }
        else{
            throw  new IllegalArgumentException("");
        }
    }



    @Override
    public String toString() {
        return "installatiedatum=" + installatiedatum +
               " eanCode=" + eanCode + "Meterstand" + meterStand;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        DigitaleMeter that = (DigitaleMeter) o;
        if (this.eanCode.equals(that.getEanCode())){
            return true;
        }
        return false;
    }




    public int getMeterstand() {
        return meterStand;
    }
}

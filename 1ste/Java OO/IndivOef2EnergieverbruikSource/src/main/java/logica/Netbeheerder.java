package logica;

import java.util.ArrayList;

public class Netbeheerder {
    private String naam;
    private ArrayList<DigitaleMeter> meterLijst = new ArrayList<>();


    public Netbeheerder(String inputNaam){
        this.naam = inputNaam;
    }

    public ArrayList<DigitaleMeter> getMeters() {
        return meterLijst;
    }

    public void voegMeterToe(DigitaleMeter s) {

        for (int i = 0; i <meterLijst.size();i++){
            if (meterLijst.get(i).getEanCode().equals(s.getEanCode())){
                throw new IllegalArgumentException("Bestaat al");
            }
        }

        meterLijst.add(s);



    }

    public DigitaleMeter  geefMeterMetHoogsteGemiddeldeVerbruik() {
        DigitaleMeter s = meterLijst.get(0);
        for (int i = 0; i <meterLijst.size();i++){
            if (meterLijst.get(i).geefGemiddeldVerbruikPerDag() > s.geefGemiddeldVerbruikPerDag()){
                s = meterLijst.get(i);
            }
        }

        return s;

    }
}

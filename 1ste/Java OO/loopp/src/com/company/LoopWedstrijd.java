package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class LoopWedstrijd {
    String naam = "";
    ArrayList atleten = new ArrayList();
    ArrayList tijden = new ArrayList();

    public LoopWedstrijd(String naam , ArrayList atleten , ArrayList tijden){
        this.atleten = atleten;
        this.tijden = tijden;
        this.naam = naam;
    }

    public  String geefWinnaaer(){
       double temp = 0;
       ArrayList kopie = new ArrayList(tijden);
       Collections.sort(kopie);


        temp = (double) kopie.get(0);
        System.out.println(temp);
        int index = 0;

        for(int y = 0; y < tijden.size(); y++){
            double gettiy = (double) tijden.get(y);
        if(temp == gettiy){
        index = y ;
        }
        }
        String naamm = (String) atleten.get(index);
        return naamm;
    }

    public void voegExtraPrestatieToe(String atleetNaam, double tijd){
        tijden.add(tijd);
        atleten.add(atleetNaam);

    }
}

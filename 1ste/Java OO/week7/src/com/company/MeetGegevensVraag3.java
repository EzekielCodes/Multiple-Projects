package com.company;

import java.util.Arrays;

public class MeetGegevensVraag3 {
    int array [] = new int[20];

    public MeetGegevensVraag3 (int array[]){

    }

    public boolean zijnAlleElementenOnderlingVerschillend(int array[]){
        Arrays.sort(array);
        boolean state = false;
        for (int i = 0; i < array.length; i ++){
            if (array[i] == array [i + 1]){
                     state = true;
                   break;
            }
        }
        return  state;
    }
    public int  bepaalKleinstePositiefVerschil(int array[]){
        Arrays.sort(array);
        return array[0];
    }
}

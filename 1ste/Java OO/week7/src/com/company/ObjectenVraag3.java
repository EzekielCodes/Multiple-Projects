package com.company;

public class ObjectenVraag3 {
    public static void main(String[] args) {
        int array []= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        MeetGegevensVraag3 test = new MeetGegevensVraag3(array);

        System.out.println(test.bepaalKleinstePositiefVerschil(array));
        System.out.println(test.zijnAlleElementenOnderlingVerschillend(array));

    }
}

package com.company;

/**
 * dit is de klas spelkaarten
 * waarin alles om een spelkaart te maken staat
 */
public class SpeelKaarten {
    final int AANTALKAARTEN = 26;
    String stapelEen[][] = new String [AANTALKAARTEN][2];
    char randomChar ;
    String arraySoorten[];

    /**
     * Hier wordt de 2 dimensionaal array automatische gevuld met waarden
     * @param arraySooreten de arraysorten is de type kaarten
     */
    public SpeelKaarten( String arraySooreten[]){

        for (int i = 0; i < 13; i ++){
            for(int x = 0; x < stapelEen[i].length; x ++){
                    stapelEen[i][0] = arraySooreten[0];
                    int random = (int) ((Math.random()* 14 -1 ) + 1);
                    if (random == 1 || random == 2 || random == 3 || random == 4 || random == 5 || random == 6 ||  random == 7 || random == 8 || random == 9 ){
                        stapelEen[i][1] = String.valueOf(random);
                    }
                    else if (random == 10){
                        stapelEen[i][1] = "T";

                    }
                    else if (random == 11){
                        stapelEen[i][1] = "B";

                    }
                    else if (random == 12){
                        stapelEen[i][1] = "D";

                    }
                    else if (random == 13){
                        stapelEen[i][1] = "H";

                    }
                    else if (random == 14){
                        stapelEen[i][1] = "A";

                    }
            }

        }
        for (int i = 12; i < stapelEen.length; i ++){
            for(int x = 0; x < stapelEen[i].length; x ++){
                stapelEen[i][0] = arraySooreten[1];
                int random = (int) ((Math.random()* 15 -2 ) + 1);
                if (random == 1 || random == 2 || random == 3 || random == 4 || random == 5 || random == 6 ||  random == 7 || random == 8 || random == 9 ){
                    stapelEen[i][1] = String.valueOf(random);
                }
                else if (random == 10){
                    stapelEen[i][1] = "T";

                }
                else if (random == 11){
                    stapelEen[i][1] = "B";

                }
                else if (random == 12){
                    stapelEen[i][1] = "D";

                }
                else if (random == 13){
                    stapelEen[i][1] = "H";

                }
                else if (random == 14){
                    stapelEen[i][1] = "A";

                }

            }
        }

        for (int i = 0; i < stapelEen.length; i ++){
            for(int x = 0; x < stapelEen[i].length; x ++){
                System.out.print(stapelEen[i][x] + " ");
            }
            System.out.println(" ");
        }

    }

    /**
     * Hier wordt gekeken als char soort in de kolom soortKaarten bestaat
     *
     * @param soort een char sort wordt ingegeven door de gebruiker
     * @return de state (als bestaat of niet)wordt terug geven.
     */
    public boolean bevatKaartVanSoort(char soort){
        boolean state = false;

        for (int i = 0; i < stapelEen.length; i ++){
            for ( int x = 0; x <1;x++){
                if (stapelEen[i][x].charAt(0) == soort ){
                        state =true;
                        this.randomChar = soort;
                }
            }
        }

        if (!state){
            System.out.println("Dit is geen geldige soort. Gelieve een geldige soort op te geven");
        }
        return state;
    }

    /**
     * Hier wordt de random kaart weergeven met de waarde en soort
     * @return randomKaart //de kaart en waarde wordt terug gegeven
     */
    public String geefRandomKaartVanSoort(){
        String randomKaart = "";
        int controleCount = 0;
        System.out.println(randomChar);
        for (int i = 0; i < stapelEen.length; i ++){
            for ( int x = 0; x <1;x++){
                if (stapelEen[i][x].charAt(0) == randomChar){
                    randomKaart = "De kaart die je trok was: "+ stapelEen[i][x] + stapelEen[i][1];

                    controleCount++;
                }
            }
        }
        if (controleCount == 0){
            randomKaart = " ";
        }
        return randomKaart;
    }


}


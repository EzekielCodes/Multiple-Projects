package com.company;

public class LoopWedstrijd {

        String naam;
        String atleten[];
        double tijden[];

        public LoopWedstrijd(String naam,String atleten[],double tijden[]){
            this.atleten = atleten;
            this.tijden = tijden;
            this.naam = naam;
        }

        public String geefWinnar(){
            int position = 0;
            int lengte = tijden.length;
            double[] temp = new double[lengte];
            for (int x = 0;x < tijden.length; x ++){
                temp[x] = tijden[x];
            }

            for (int i = 0; i < temp.length; i++) {
                for (int j = i + 1; j < temp.length; j++) {
                    double tmp = 0;
                    if (temp[i] > temp[j]) {
                        tmp = temp[i];
                        temp[i] = temp[j];
                        temp[j] = tmp;
                    }
                }
            }



            for (int i = 0 ; i < temp.length; i ++){

                if (tijden[i] ==  temp[0]){
                    position = i;
                    break;
                }
            }

            System.out.println(atleten[position]);

            return atleten[position];

        }



}

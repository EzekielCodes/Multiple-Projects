package com.company;

public class Dobbelsteen {
    final int minimum = 3;
    final int maximum = 10;
    int worp = 0;
    int counter = 0;


    public Dobbelsteen(int minimum,int maximum){

    }
    public Dobbelsteen(){

    }

    public int gooi(){
        worp=(int)(Math.random() * (maximum-minimum + 1)) + minimum;
        counter++;
        return  worp;
    }
    public void geefLaatsteWorp(int getal){
        System.out.println(getal);
        if (worp == getal ){
            System.out.println("In "+ counter+ " pogingen werd een "+getal+" gedobbeld");
            System.out.println("Nieuwe worp = " + worp);
        }
        else {
            System.out.println("Nieuwe worp = " + worp);
        }
    }



}

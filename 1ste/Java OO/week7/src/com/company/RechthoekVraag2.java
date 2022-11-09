package com.company;

public class RechthoekVraag2 {
    int x = 0;
    int y = 0;
    int breedte = 0;
    int lengte = 0;

    /**
     *
     * @param x
     * @param y
     * @param breedte
     * @param lengte
     */
    public RechthoekVraag2(int x,int y,int breedte ,int lengte){
            this.x = x;
            this.y = y;
            this.breedte = breedte;
            this.lengte = lengte;
    }

    /**
     *
     * @return state
     */
    public boolean isVierkant (){
        boolean state = false;
        if (this.breedte == this.lengte){
            state = true;
        }
        else{
            state =false;
        }
        return  state;
    }

    /**
     *
     * @return omtrek
     */
    public int berekenOmtrek(){
        return 2 *(this.lengte + this.breedte);
    }

    /**
     *
     * @return oppervlakte
     */
    public int berekenOpp(){
        return this.lengte * this.breedte;
    }

    /**
     * Geef aan of een coordinaat binnen de rechthoek ligt
     * @param x
     * @param y
     * @return
     */
    public boolean isIn (int x , int y){
        if ((x >= this.x && x <= x + this.breedte) && (y >= this.y && y <= this.lengte)){
            return  true;
        }
        else{
            return  false;
        }

    }

}

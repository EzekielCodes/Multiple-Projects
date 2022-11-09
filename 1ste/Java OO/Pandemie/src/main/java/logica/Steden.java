package logica;
import logica.ENUM.Kleur;

public class Steden {
    private int id = 0;
    private String name = "";
    private Kleur color;
    private int x = 0;
    private int y = 0;
    private int onderzoekCentrum = 0;
    private  int ziekteStenen = 0;

    public Steden(){

    }
    public Steden(int id,String naam,Kleur color,int x, int y, int onderzoekCentrum){
        this.id = id;
        this.name = naam;
        this.color = color;
        this.x = x;
        this.y = y;
        this.onderzoekCentrum = onderzoekCentrum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public Kleur getColor() {
        return color;
    }

    public int getY() {
        return y;
    }

    public int getOnderzoekCentrum() {
        return onderzoekCentrum;
    }

    public void setOnderzoekCentrum(int onderzoekCentrum) {
        this.onderzoekCentrum = onderzoekCentrum;
    }

    public int getZiekteStenen() {
        return ziekteStenen;
    }

    public void setZiekteStenen(int ziekteStenen) {
        if(ziekteStenen == 0){
            System.out.println("zero");
            this.ziekteStenen = 0;
        }
       else  if(ziekteStenen == -1){
            System.out.println("came here");
            this.ziekteStenen = this.ziekteStenen - 1;
        }
       else if (ziekteStenen == 3){
           this.ziekteStenen = 3;

        }
       else{
            this.ziekteStenen = this.ziekteStenen + 1;
        }

    }
}

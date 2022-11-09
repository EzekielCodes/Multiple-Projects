package logica;

public class Punt {
    private int x = 0;
    private int y = 0;

    public Punt(int xx , int yy){
        this.x = xx;
        this.y = yy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double berekenAfstand(Punt punten) {
        double xx = punten.x - this.x;
        double yy =punten.y - this.y;
         double afstand = Math.hypot(xx,yy);
         return  afstand;
    }

    @Override
    public String toString() {
        return "Punt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punt punt = (Punt) o;
        return x == punt.x && y == punt.y;
    }


}

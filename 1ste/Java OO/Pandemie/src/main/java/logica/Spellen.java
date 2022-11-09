package logica;

import java.time.LocalDateTime;

public class Spellen {
    private int id = 0;
    private LocalDateTime start;
    private LocalDateTime einde;
    private byte gewonnen = 0;

    public Spellen(int id, LocalDateTime start, LocalDateTime einde, byte gewonnen){
        this.einde = einde;
        this.id = id;
        this.gewonnen = gewonnen;
        this.start = start;

    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEinde() {
        return einde;
    }

    public byte getGewonnen() {
        return gewonnen;
    }
}

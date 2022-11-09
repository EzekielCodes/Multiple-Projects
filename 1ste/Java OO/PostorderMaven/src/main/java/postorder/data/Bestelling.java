package postorder.data;

import java.util.Calendar;


/**
 *
 * @author evertjan.jacobs
 */
public class Bestelling {
    private int id;
    private int klantId;
    private Calendar datum;

    public Bestelling(int id, int klantId, Calendar datum) {
        this.id = id;
        this.klantId = klantId;
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Bestelling{" + "id=" + id + ", klantId=" + klantId + ", datum=" + datum.get(Calendar.DATE)+"/"+ (datum.get(Calendar.MONTH) + 1) +"/" +datum.get(Calendar.YEAR)+ '}';
    }

    public int getId() {
        return id;
    }

    public int getKlantId() {
        return klantId;
    }

    public Calendar getDatum() {
        return datum;
    }

    
    
    
    
}

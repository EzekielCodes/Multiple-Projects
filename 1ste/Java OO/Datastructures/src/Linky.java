import java.util.Iterator;
import java.util.LinkedList;

public class Linky {
    public static void main(String[] args) {
        LinkedList linky = new LinkedList();

        linky.add("Rob");
        linky.add("Akex");
        linky.add("Jose");

        //linky.getFirst();
        //linky.clear();
        //linky.remove();

        //linky.get(1);
        //linky.isEmpty();

        Iterator it = linky.iterator();

        while (it.hasNext()){
            if (it.next() == "Rob"){
                System.out.println("Found");
            }
        }

    }
}

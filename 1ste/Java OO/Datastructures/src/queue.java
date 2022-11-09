import java.util.LinkedList;
import java.util.Queue;

public class queue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<String>();

        q.add("Jackson");
        q.add("Tariq");
        q.add("Susan");


        q.poll();//removes next person on line
        q.peek(); // look but don't remove
    }
}

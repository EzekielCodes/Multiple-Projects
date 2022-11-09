import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class set {
    public static void main(String[] args) {
        //set = Interface
        Set setter = new HashSet<>();

        setter.add(4);
        setter.add(4);
        setter.add(5);

        Set treeSet = new TreeSet();
        treeSet.add(4);
        treeSet.add(3);

        System.out.println(setter);
        /*
        Hashset
         //no duplicates
        //not order
         */


        /*
        treeset
        //no duplicates
        //smallest elements first. ascending
        treeSet.contains(10);
        treeSet.remove(2);
        treeSet.clear();
         */

    }
}

import java.util.Stack;

public class stack {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.add("Cal of duty");
        s.add("Guiter Hero");
        s.add("Super monkey");


        s.pop();// pop out first element
        s.peek();//peak but don't delete
        s.contains("call of duty");
        s.set(1,"sleep");

    }
}

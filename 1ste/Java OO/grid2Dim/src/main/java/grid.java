import javax.swing.*;
import java.awt.*;

public class grid extends JPanel {
    private static final int PREF_W = 750;
    private static final int PREF_H = 550;
    private static final int GRID_ROWS = 5;
    private static final int GRID_COLS = 5;
    private JPanel panelMain;

    public grid() {
        JPanel gridPanel = new JPanel(new GridLayout(GRID_ROWS, GRID_COLS));
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                JButton button = new JButton(Character.toString(col));
            }
        }

        setLayout(new GridBagLayout()); // to center component added
        add(gridPanel);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("DemoDependencyInjectie");
        frame.setContentPane(new grid().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

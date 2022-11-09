package presentatie;

import logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WPSUNIEK extends JFrame {
    private JTextArea outputArea;
    private JTextField inputGebruiker;
    private JButton button;
    private JPanel jpanelMain;
    private ArrayList<WPS> list ;// = new ArrayList<WPS>();

    public WPSUNIEK(String title) {
        super(title);
        this.setDefaultCloseOperation(3);
        this.setContentPane(this.jpanelMain);
        this.pack();
        this.setSize(new Dimension(300,300));
        this.list = new ArrayList<>();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String input = inputGebruiker.getText();
                    WPS gemaakt = new WPS(input);

                    for (int i = 0; i < list.size();i++){
                        String controle = list.get(i);

                    }

                }
                catch (Exception ee){

                }




            }
        });
    }
    public static void main(String[] args) {
        JFrame myFrame = new WPSUNIEK("CODE UNIEK");
        myFrame.setVisible(true);
    }
}

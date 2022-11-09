package presentatie;

import logica.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WPSVALIDATOR extends  JFrame{
    private JTextField inputGebruiker;
    private JPanel jpanelMain;
    private JLabel labelError;

    public WPSVALIDATOR(String title) {
        super(title);
        this.setDefaultCloseOperation(3);
        this.setContentPane(this.jpanelMain);
        this.pack();
        this.setSize(new Dimension(300,300));


        inputGebruiker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
                try {
                    String input = inputGebruiker.getText();
                    new WPS(input);
                    labelError.setForeground(Color.GREEN);
                    labelError.setText("OK");

                }
                catch (Exception ee){
                    labelError.setForeground(Color.RED);
                    labelError.setText(ee.getMessage());

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new WPSVALIDATOR("CODE VALIDATOR");
        myFrame.setVisible(true);
    }
}

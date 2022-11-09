package presentatie;

import logica.WPS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Van de Voorde Siebe
 * @Version 24/03/2021
 */

public class WPSValidatorGUI {

    private JPanel panelMain;
    private JLabel labelError;
    private JTextField textFieldValidator;

    public WPSValidatorGUI(){
        textFieldValidator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
                try {
                    String pincode = textFieldValidator.getText();
                    new WPS(pincode);
                    labelError.setForeground(Color.GREEN);
                    labelError.setText("OK");
                }
                catch (Exception err){
                    labelError.setForeground(Color.RED);
                    labelError.setText(err.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Wifi pincode validator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new WPSValidatorGUI().panelMain);
        myFrame.setSize(400, 200);
        myFrame.setVisible(true);
    }
}

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

public class WPSGeneratorGUI {
    private JButton buttonGenereerWPS;
    private JLabel LabelWPS;
    private JPanel panelMain;

    public WPSGeneratorGUI(){
        buttonGenereerWPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WPS wps = new WPS();
                LabelWPS.setText(wps.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Wifi pincode generator");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new WPSGeneratorGUI().panelMain);
        myFrame.setSize(400, 200);
        myFrame.setVisible(true);
    }
}

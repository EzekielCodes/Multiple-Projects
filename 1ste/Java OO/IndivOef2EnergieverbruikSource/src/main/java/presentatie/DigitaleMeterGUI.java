package presentatie;

import logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Collections;

/**
 * PVinstallatie : DigitaleMeter
 *
 * @author kristien.vanassche
 * @version 30/03/2021
 */
public class DigitaleMeterGUI {
    private JPanel panelMain;
    private JTextField textFieldInstallatiedatum;
    private JTextField textfieldUpdatedatum;
    private JTextField textFieldMeterstand;
    private JTextField textFieldEANcode;
    private JButton buttonInstalleerMeter;
    private JLabel labelGemiddeldVerbruikPerDag;
    private JLabel labelError;
    private JButton buttonUpdateMeterstand;
    DigitaleMeter test;

    public DigitaleMeterGUI() {
        buttonInstalleerMeter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String date =textFieldInstallatiedatum.getText();
                    String code = textFieldEANcode.getText();

                    test = new DigitaleMeter(date,code);

                    test.setLaatsteUpdate(LocalDate.parse(date));
                    labelError.setText(test.toString() +  " "+ test.getLaatsteUpdate());
                }
                catch (Exception ee){
                    labelError.setForeground(Color.RED);
                    labelError.setText(ee.getMessage());


                }



            }
        });
        buttonUpdateMeterstand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String update = textfieldUpdatedatum.getText();
                int meterstand = Integer.parseInt(textFieldMeterstand.getText());



                test.verwerkMeterstand(LocalDate.parse(update),meterstand);
                test.setLaatsteUpdate(LocalDate.parse(update));


                labelGemiddeldVerbruikPerDag.setText(String.valueOf(test.geefGemiddeldVerbruikPerDag()));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digitale Meter");
        frame.setContentPane(new DigitaleMeterGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setVisible(true);
    }

}

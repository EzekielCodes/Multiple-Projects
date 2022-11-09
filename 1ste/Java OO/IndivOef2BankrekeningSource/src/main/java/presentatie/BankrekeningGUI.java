package presentatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.Bankrekening;

/**
 * IndivOef1a_Bankrekening : BankrekeningGUI
 *
 * @author kristien.vanassche
 * @version 13/03/2021
 */
public class BankrekeningGUI {
    private JTextField naamHouder;
    private JTextField rekeningNummer;
    private JLabel labelSaldo;
    private JButton buttonOpenRekening;
    private JTextField outputBedrag;
    private JButton buttonStort;
    private JButton buttonHaalAf;
    private JLabel labelError;
    private JPanel panelMain;
    private JLabel rekeningHouder;
    private Bankrekening s;


    public BankrekeningGUI() {
        buttonOpenRekening.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String naam = naamHouder.getText();
                    String rekeningNumber = rekeningNummer.getText();
                     s = new Bankrekening(naam,rekeningNumber);
                    labelError.setForeground(Color.GREEN);
                     labelSaldo.setText(String.valueOf(s.getSaldo()));
                }
                catch (Exception ee){
                    labelError.setForeground(Color.RED);
                    labelError.setText(ee.getMessage());

                }



            }
        });
        buttonStort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double bedrag = Double.parseDouble(outputBedrag.getText());
                    s.stortBedrag(bedrag);

                    labelError.setForeground(Color.GREEN);
                    labelError.setText(String.valueOf(s.getSaldo()));
                    labelSaldo.setText(String.valueOf(s.getSaldo()));

                }
                catch (Exception ee){
                    labelError.setForeground(Color.RED);
                    labelError.setText(ee.getMessage());
                }


            }
        });
        buttonHaalAf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double bedrag = Double.parseDouble(outputBedrag.getText());
                    s.haalBedragAf(bedrag);

                    labelError.setForeground(Color.GREEN);
                    labelError.setText(String.valueOf(s.getSaldo()));
                    labelSaldo.setText(String.valueOf(s.getSaldo()));

                }
                catch (Exception ee){
                    labelError.setForeground(Color.RED);
                    labelError.setText(ee.getMessage());
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Bankrekening");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new BankrekeningGUI().panelMain);
        myFrame.setSize(new Dimension(600, 300));
        myFrame.setVisible(true);
    }
}

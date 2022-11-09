package presentatie;

import logica.Aandrijving;
import logica.Auto;
import logica.Autobelasting;
import logica.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
    private JPanel mainPanel;
    private JTextField merk;
    private JTextField model;
    private JTextField inschrijving;
    private JTextField euronorm;
    private JTextField fiscalePK;
    private JTextField uitstootCO2;
    private JTextField aandrijving;
    private JLabel merkLabel;
    private JLabel modelLabel;
    private JLabel inschrijvingLabel;
    private JLabel euronormLabel;
    private JLabel fiscalePKLabel;
    private JLabel uitstootCO2Label;
    private JLabel aandrijvingLabel;
    private JPanel spacer;
    private JCheckBox roetfilter;
    private JButton bereken;
    private JLabel labelBIV;
    private JLabel labelJVB;
    private JLabel bedragBIV;
    private JLabel bedragJVB;
    private JLabel errors;
    private JComboBox<String> euronormComboBox;

    public Gui(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        setSize(new Dimension(500,600));
        euronormComboBox.addItem("EURO0");
        euronormComboBox.addItem("EURO1");
        euronormComboBox.addItem("EURO2");
        euronormComboBox.addItem("EURO3");
        euronormComboBox.addItem("EURO4");
        euronormComboBox.addItem("EURO5");
        euronormComboBox.addItem("EURO6");
        bereken.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Auto auto = new Auto(getMerk().getText(), getModel().getText(), Integer.parseInt(getInschrijving().getText()), toEuronorm((String) euronormComboBox.getSelectedItem()), Integer.parseInt(getFiscalePK().getText()), Integer.parseInt(getUitstootCO2().getText()), toAandrijving(getAandrijving().getText()), getRoetfilter().isSelected());
                    bedragBIV.setText("€"+Double.toString(Helper.afronden(auto.berekenBIV(),2)));
                    bedragJVB.setText("€"+Double.toString(Helper.afronden(auto.berekenJVB(),2)));
                    errors.setText("");
                }catch(IllegalArgumentException exception){
                    errors.setText("ERROR: "+exception.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new Gui("Verkeersbelasting: BIV & JVB");
        myFrame.setVisible(true);
    }

    public JTextField getMerk() {
        return merk;
    }

    public JTextField getModel() {
        return model;
    }

    public JTextField getInschrijving() {
        return inschrijving;
    }

    public JComboBox<String> getEuronorm() {
        return euronormComboBox;
    }

    public JTextField getFiscalePK() {
        return fiscalePK;
    }

    public JTextField getUitstootCO2() {
        return uitstootCO2;
    }

    public JTextField getAandrijving() {
        return aandrijving;
    }

    public JCheckBox getRoetfilter() {
        return roetfilter;
    }

    public Autobelasting.Euronorm toEuronorm(String euronorm){
        if (euronorm.equals("EURO0")){
            return Autobelasting.Euronorm.EURO0;
        } else if (euronorm.equals("EURO1")){
            return Autobelasting.Euronorm.EURO1;
        } else if (euronorm.equals("EURO2")){
            return Autobelasting.Euronorm.EURO2;
        } else if (euronorm.equals("EURO3")){
            return Autobelasting.Euronorm.EURO3;
        }  else if (euronorm.equals("EURO4")){
            return Autobelasting.Euronorm.EURO4;
        } else if (euronorm.equals("EURO5")){
            return Autobelasting.Euronorm.EURO5;
        }  else if (euronorm.equals("EURO6")){
            return Autobelasting.Euronorm.EURO6;
        } else {
            throw new IllegalArgumentException("Geen geldige euronorm.");
        }
    }

    //BENZINE, DIESEL, LPG, CNG, HYBRIDE, ELEKTRISCH

    public Aandrijving toAandrijving(String aandrijving){
        if (aandrijving.toUpperCase().equals("BENZINE")){
            return Aandrijving.BENZINE;
        } else if (aandrijving.toUpperCase().equals("DIESEL")){
            return Aandrijving.DIESEL;
        } else if (aandrijving.toUpperCase().equals("LPG")){
            return Aandrijving.LPG;
        } else if (aandrijving.toUpperCase().equals("CNG")){
            return Aandrijving.CNG;
        }  else if (aandrijving.toUpperCase().equals("HYBRIDE")){
            return Aandrijving.HYBRIDE;
        } else if (aandrijving.toUpperCase().equals("ELEKTRISCH")){
            return Aandrijving.ELEKTRISCH;
        } else {
            throw new IllegalArgumentException("Geen geldige aandrijving.");
        }
    }
}

package logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.Autobelasting.Euronorm;

public class AutoGui extends JFrame {
    private JPanel panelMain;
    private JTextField merkField;
    private JTextField modelField;
    private JTextField inschrijvingJaar;
    private JTextField fiscaleField;
    private JTextField uitstootFiled;
    private JComboBox aandrijvingField;
    private JComboBox euroField;
    private JButton berekenButton;
    private JTextArea outputAreaOne;
    private JCheckBox roetChecker;
    private JLabel labelMerk;
    private JLabel labelModel;
    private JLabel labelJaar;
    private JLabel labelEuro;
    private JLabel labelPK;
    private JLabel labeluitstoot;
    private JLabel labelAandrijving;
    private JTextArea outputAreaTwo;

    public AutoGui(String title){
        super(title);

        this.setDefaultCloseOperation(3);
        this.setContentPane(this.panelMain);
        this.pack();
        this.setSize(new Dimension(500, 600));
        this.euroField.addItem("EURO0");
        this.euroField.addItem("EURO1");
        this.euroField.addItem("EURO2");
        this.euroField.addItem("EURO3");
        this.euroField.addItem("EURO4");
        this.euroField.addItem("EURO5");
        this.euroField.addItem("EURO6");
        this.aandrijvingField.addItem("BENZINE");
        this.aandrijvingField.addItem("DIESEL");
        this.aandrijvingField.addItem("LPG");
        this.aandrijvingField.addItem("CNG");
        this.aandrijvingField.addItem("HYBRIDE");
        this.aandrijvingField.addItem("ELEKTRISCH");

        this.berekenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Auto autoNew = new Auto(AutoGui.this.getMerk().getText(), AutoGui.this.getModel().getText(),Integer.parseInt(AutoGui.this.getInschrijving().getText()),AutoGui.this.toEuronorm((String)AutoGui.this.euroField.getSelectedItem()), Integer.parseInt(AutoGui.this.getFiscalePK().getText()),Integer.parseInt(AutoGui.this.getUitstootCO2().getText()),AutoGui.this.toAandrijving((String)AutoGui.this.aandrijvingField.getSelectedItem()),AutoGui.this.getRoetfilter().isSelected());

                  double waarde = Helper.afronden(autoNew.berekenBIV(),2);
                  double waardeJVB = Helper.afronden(autoNew.berekenJVB(),2);
                  outputAreaOne.setText("Belasting op inverkeerstelling: "+" " + String.valueOf(waarde));
                  outputAreaTwo.setText("Jaarlijkse verkeersbelasting "+" " +String.valueOf(waardeJVB));
                }
                catch (IllegalArgumentException x){
                    AutoGui.this.outputAreaOne.setText(x.getMessage());


                }
            }
        });
    }

    public static void main(String[] args){
        JFrame myFrame = new AutoGui("Autobelasting");
        myFrame.setVisible(true);
    }

    public  JTextField getMerk(){
        return this.merkField;
    }

    public JTextField getModel() {
        return this.modelField;
    }

    public JTextField getInschrijving() {
        return this.inschrijvingJaar;
    }

    public JTextField getFiscalePK() {
        return this.fiscaleField;
    }

    public JTextField getUitstootCO2() {
        return this.uitstootFiled;
    }

    public JComboBox<String> getEuronorm() {
        return this.euroField;
    }

    public JComboBox<String> getAandrijving() {
        return this.aandrijvingField;
    }

    public JCheckBox getRoetfilter() {
        return this.roetChecker;
    }

    public Euronorm toEuronorm(String euronorm) {
        if (euronorm.equals("EURO0")) {
            return Euronorm.EURO0;
        } else if (euronorm.equals("EURO1")) {
            return Euronorm.EURO1;
        } else if (euronorm.equals("EURO2")) {
            return Euronorm.EURO2;
        } else if (euronorm.equals("EURO3")) {
            return Euronorm.EURO3;
        } else if (euronorm.equals("EURO4")) {
            return Euronorm.EURO4;
        } else if (euronorm.equals("EURO5")) {
            return Euronorm.EURO5;
        } else if (euronorm.equals("EURO6")) {
            return Euronorm.EURO6;
        } else {
            throw new IllegalArgumentException("Geen geldige euronorm.");
        }
    }

    public Aandrijving toAandrijving(String aandrijving) {
        if (aandrijving.toUpperCase().equals("BENZINE")) {
            return Aandrijving.BENZINE;
        } else if (aandrijving.toUpperCase().equals("DIESEL")) {
            return Aandrijving.DIESEL;
        } else if (aandrijving.toUpperCase().equals("LPG")) {
            return Aandrijving.LPG;
        } else if (aandrijving.toUpperCase().equals("CNG")) {
            return Aandrijving.CNG;
        } else if (aandrijving.toUpperCase().equals("HYBRIDE")) {
            return Aandrijving.HYBRIDE;
        } else if (aandrijving.toUpperCase().equals("ELEKTRISCH")) {
            return Aandrijving.ELEKTRISCH;
        } else {
            throw new IllegalArgumentException("Geen geldige aandrijving.");
        }
    }
}

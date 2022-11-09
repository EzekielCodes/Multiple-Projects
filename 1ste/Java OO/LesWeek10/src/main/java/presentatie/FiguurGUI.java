package presentatie;

import com.sun.tools.javac.Main;
import logica.Cirkel;
import logica.Vierkant;
import javax.swing.*;
import logica.Enum.Kleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiguurGUI {
    private JTextArea inputX;
    private JTextArea inputY;
    private JTextArea inputGrotte;
    private JComboBox kleurFiguur;
    private JComboBox kleurRand;
    private JSpinner dikteRand;
    private JRadioButton kiesCirkel;
    private JTextArea outputGegevens;
    private JButton verwerk;
    private JRadioButton kiesVierkant;
    private JPanel diagram;
    private JPanel panelMain;


    public FiguurGUI(){

        kleurFiguur.setModel(new DefaultComboBoxModel(Kleur.values()));


        kleurRand.setModel(new DefaultComboBoxModel(Kleur.values()));

        //ButtonGroup buttonGroup = new ButtonGroup();
        //buttonGroup.add(kiesCirkel);
        //buttonGroup.add(kiesVierkant);

        kiesCirkel.setSelected(true);
        kiesVierkant.setSelected(false);



        verwerk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double omtrek = 0;
                double oppervlakte = 0;
                int straal = 0;
                int dikte = 0;
                int xCordinaat = 0;
                int yCordinaat = 0;
                String kleurfig = kleurFiguur.getSelectedItem().toString();
                String kleurrand = kleurRand.getSelectedItem().toString();
                if(kiesCirkel.isSelected()){
                    System.out.println("Cirel");
                    double grotte = Double.parseDouble((inputGrotte.getText()));
                    xCordinaat =  Integer.parseInt(inputX.getText());
                    yCordinaat = Integer.parseInt(inputY.getText());
                     dikte = (int) dikteRand.getValue();
                    straal = (int) (grotte / 2);
                    Cirkel cirkel = new Cirkel(straal,Kleur.valueOf(kleurfig),Kleur.valueOf(kleurrand),dikte);
                    omtrek = cirkel.berekenOmtrek();
                    oppervlakte = cirkel.berekenOppervlakte();
                }
                else if (kiesVierkant.isSelected()){
                    System.out.println("vierkant");
                }
                outputGegevens.setText("Cirkel = "+ kleurfig + " rand=  " + kleurrand + " " + dikte +"cm "+ " Omtrek= " + omtrek + "cm2 "+ " Oppervlakte= " + oppervlakte + "cm2 "  + " Straal= "+  straal + "cm "+" middelpunt = (" + xCordinaat + " , " + yCordinaat + ")");

            }
        });
        kiesCirkel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kiesVierkant.setSelected(false);
            }
        });
        kiesVierkant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kiesCirkel.setSelected(false);
            }
        });
    }


    public static void main(String[] args){
        JFrame myFrame = new JFrame();
        myFrame.setTitle("RapportGui");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new FiguurGUI().panelMain);
        myFrame.setSize(800,800);
        myFrame.setVisible(true);

    }
}

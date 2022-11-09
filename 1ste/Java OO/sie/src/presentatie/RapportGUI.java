package presentatie;

import logica.Rapport;
import logica.Vak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Van de Voorde Siebe
 * @Version 28/04/2021
 */

public class RapportGUI {
    private JPanel panelMain;
    private JTextField textFieldVak1;
    private JTextField textFieldVak2;
    private JTextField textFieldVak3;
    private JTextField textFieldVak4;
    private JTextField textFieldVak5;
    private JTextField textFieldVak6;
    private JLabel labelVak1;
    private JLabel labelVak2;
    private JLabel labelVak3;
    private JLabel labelVak4;
    private JLabel labelVak5;
    private JLabel labelVak6;
    private JLabel maxScore;
    private JLabel resultaat;
    private JLabel labelResultaat;
    private JPanel panelVakken;

    private Rapport rapport;

    public RapportGUI(){
        maxScore.setText("Maxs score: "+ Vak.MAX_SCORE);

        Vak[] vakken = {
                new Vak("Elektronische Netwerken", 6),
                new Vak("Programming Fundamentals", 6),
                new Vak("InfraStructure Fundamentals", 6),
                //new Vak("OO", 12),
                //new Vak("Hackaton", 6),
                //new Vak("Web", 6)
        };

        rapport = new Rapport(vakken);
        setLabelInfo(vakken);
        setZichtbaarheidComponenten(vakken);
        panelVakken.setBackground(Color.white);

        textFieldVak1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwerkInput();
            }
        });
        textFieldVak2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwerkInput();
            }
        });
        textFieldVak3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwerkInput();
            }
        });
        textFieldVak5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwerkInput();
            }
        });
        textFieldVak6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwerkInput();
            }
        });
    }

    private void setLabelInfo(Vak[] vakken){
        if (vakken.length >= 1){
            labelVak1.setText(vakken[1 ].toString());
        }
        if (vakken.length >= 2){
            labelVak2.setText(vakken[1].toString());
        }
        if (vakken.length >= 3){
            labelVak3.setText(vakken[2].toString());
        }
        if (vakken.length >= 4){
            labelVak4.setText(vakken[3].toString());
        }
        if (vakken.length >= 5){
            labelVak5.setText(vakken[4].toString());
        }
        if (vakken.length >= 6){
            labelVak6.setText(vakken[5].toString());
        }
    }

    private void setZichtbaarheidComponenten(Vak[] vakken){
        if (vakken.length < 6) {
            labelVak6.setVisible(false);
            textFieldVak6.setVisible(false);
        }
        if (vakken.length < 5){
            labelVak5.setVisible(false);
            textFieldVak5.setVisible(false);
        }
        if (vakken.length < 4){
            labelVak4.setVisible(false);
            textFieldVak4.setVisible(false);
        }
        if (vakken.length < 3){
            labelVak3.setVisible(false);
            textFieldVak3.setVisible(false);
        }
        if (vakken.length < 2){
            labelVak2.setVisible(false);
            textFieldVak2.setVisible(false);
        }
        if (vakken.length < 1){
            labelVak1.setVisible(false);
            textFieldVak1.setVisible(false);
        }
    }

    private void verwerkInput(){
        try{
            Vak[] vakken = rapport.getVakken();
            if (textFieldVak1.isVisible()) verwerkInput(vakken[0], textFieldVak1);
            if (textFieldVak2.isVisible()) verwerkInput(vakken[1], textFieldVak2);
            if (textFieldVak3.isVisible()) verwerkInput(vakken[2], textFieldVak3);
            if (textFieldVak4.isVisible()) verwerkInput(vakken[3], textFieldVak4);
            if (textFieldVak5.isVisible()) verwerkInput(vakken[4], textFieldVak5);
            if (textFieldVak6.isVisible()) verwerkInput(vakken[5], textFieldVak6);
            labelResultaat.setForeground(Color.black);
            labelResultaat.setText(this.rapport.toString());
        }
        catch (Exception e){
            labelResultaat.setForeground(Color.red);
            labelResultaat.setText(e.getMessage());
        }
    }

    private void verwerkInput(Vak vak, javax.swing.JTextField textField) {
        try {
            int score = Integer.parseInt(textField.getText());
            vak.setScore(score);
            textField.setBackground(score >= Vak.MAX_SCORE/2 ? Color.green : Color.orange);
        }
        catch (Exception e){
            textField.setBackground(Color.red);
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("RapportGUI");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new RapportGUI().panelMain);
        myFrame.setSize(800, 800);
        myFrame.setVisible(true);
    }
}

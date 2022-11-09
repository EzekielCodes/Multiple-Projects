package presentatie;

import logica.Rapport;
import logica.Vak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RapportGui {
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

    public RapportGui(){
       maxScore.setText("Max Score: "+ Vak.MAX_SCORE);

        Vak[] vakken = {
                new Vak("Elektronische Netwerken", 6),
                new Vak("Programming Fundamentals", 12),
                new Vak("InfraStructure Fundamentals", 6),
                //new Vak("OO", 12),
                //new Vak("Hackaton", 6),
                //new Vak("Web", 6)
        };

        rapport = new Rapport(vakken);// hier wordt rapport gemaakt met de vakken die in de array staat
        checkHoeveelVak(vakken);
        visibile(vakken);
        panelVakken.setBackground(Color.white);

        textFieldVak1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwekExecute();
            }
        });
        textFieldVak2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwekExecute();
            }
        });
        textFieldVak3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwekExecute();
            }
        });
        textFieldVak5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwekExecute();
            }
        });
        textFieldVak6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verwekExecute();
            }
        });


    }

    private void checkHoeveelVak(Vak [] vakkenInput){
        if (vakkenInput.length >= 1){
            labelVak1.setText(vakkenInput[0].toString());

        }
        if (vakkenInput.length >= 2){
            labelVak2.setText(vakkenInput[1].toString());

        }
        if (vakkenInput.length >= 3){
            labelVak3.setText(vakkenInput[2].toString());

        }
        if (vakkenInput.length >= 4){
            labelVak4.setText(vakkenInput[3].toString());

        }
        if (vakkenInput.length >= 5){
            labelVak5.setText(vakkenInput[4].toString());

        }
        if (vakkenInput.length >= 6){
            labelVak6.setText(vakkenInput[5].toString());

        }


    }
    private void visibile(Vak[] vakken){
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

    private void verwekExecute(){
        try{
            Vak[] vakken = rapport.getVakken();
            if (textFieldVak1.isVisible()){
                mainexcecute(vakken[0], textFieldVak1);
            }
            if (textFieldVak2.isVisible()) mainexcecute(vakken[1], textFieldVak2);
            if (textFieldVak3.isVisible()) mainexcecute(vakken[2], textFieldVak3);
            if (textFieldVak4.isVisible()) mainexcecute(vakken[3], textFieldVak4);
            if (textFieldVak5.isVisible()) mainexcecute(vakken[4], textFieldVak5);
            if (textFieldVak6.isVisible()) mainexcecute(vakken[5], textFieldVak6);
            labelResultaat.setForeground(Color.black);
            labelResultaat.setText(this.rapport.toString());
        }
        catch (Exception e){
            labelResultaat.setForeground(Color.red);
            labelResultaat.setText(e.getMessage());
        }
    }

    private void mainexcecute(Vak vak, javax.swing.JTextField textField) {
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

    public static void main(String[] args){
        JFrame myFrame = new JFrame();
        myFrame.setTitle("RapportGui");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new RapportGui().panelMain);
        myFrame.setSize(800,800);
        myFrame.setVisible(true);

    }



}

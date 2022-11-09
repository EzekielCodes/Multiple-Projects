package presentatie;
import data.connectie;
import presentatie.PandemieGui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import logica.*;
import logica.ENUM.*;

public class checkList extends JFrame  {
    private PandemieGui pand;
    private JButton annulerenButton;
    private JButton startSpelButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JRadioButton radioButton9;
    private JRadioButton radioButton10;
    private JRadioButton radioButton11;
    private JRadioButton radioButton12;
    private JRadioButton radioButton13;
    private JRadioButton radioButton14;
    private JRadioButton radioButton15;
    private JRadioButton radioButton16;
    private JRadioButton radioButton17;
    private JRadioButton radioButton18;
    private JRadioButton radioButton19;
    private JRadioButton radioButton20;
    private JTextArea geefUwNaamInTextArea;
    private JLabel operation;
    private JLabel Quarantie;
    private JLabel Generalist;
    private JLabel containment;
    private JLabel medic;
    private JPanel check;
    static  JFrame frame;
    String operationRol = "";
    String kleurOperation = "BRUIN";

    String kleurQuarantine = "";
    String naam = "";

    String kleurGeneralist = "";

    String kleurContainment = "";


    String kleurMedic = "";


    String namen[];

    public static void main(String[] args) {
        frame = new JFrame("checkList");
        frame.setContentPane(new checkList().check);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new checkList().check);
        frame.pack();
        frame.setVisible(true);
    }

    public checkList(){

        JRadioButton[][] buttons = {
                {radioButton17, radioButton18, radioButton19,radioButton20},
                {radioButton13,radioButton14, radioButton15, radioButton16},
                {radioButton9, radioButton10, radioButton11,radioButton12},
                {radioButton5,radioButton6,radioButton7,radioButton8},
                {radioButton1,radioButton2,radioButton3,radioButton4},
        };
        for (int i = 0; i < buttons.length; i++){
            for (int x = 0; x < buttons[i].length;x++){
                buttons[i][x].setSelected(false);
            }
        }

        JRadioButton [] b20 = {radioButton17,radioButton18,radioButton19,radioButton16,radioButton12,radioButton8,radioButton4};
        JRadioButton [] b16 = {radioButton15,radioButton14,radioButton13,radioButton20,radioButton12,radioButton8,radioButton4};
        JRadioButton [] b12 = {radioButton11,radioButton10,radioButton9,radioButton20,radioButton16,radioButton8,radioButton4};
        JRadioButton [] b8 = {radioButton7,radioButton6,radioButton5,radioButton20,radioButton12,radioButton16,radioButton4};
        JRadioButton [] b4 = {radioButton2,radioButton1,radioButton3,radioButton8,radioButton12,radioButton16,radioButton20};


        JRadioButton [] b17 = {radioButton13,radioButton1,radioButton9,radioButton5,radioButton18,radioButton19,radioButton20};
        JRadioButton [] b13 = {radioButton17 ,radioButton1,radioButton9,radioButton5,radioButton14,radioButton15,radioButton16};
        JRadioButton [] b9 = {radioButton17,radioButton1,radioButton13,radioButton5,radioButton10,radioButton11,radioButton12};
        JRadioButton [] b5 = {radioButton17,radioButton1,radioButton13,radioButton9,radioButton6,radioButton7,radioButton8};
        JRadioButton [] b1 = {radioButton17,radioButton13,radioButton9,radioButton5,radioButton2,radioButton3,radioButton4};

        JRadioButton [] b18 = {radioButton17,radioButton19,radioButton20,radioButton14,radioButton10,radioButton6,radioButton2};
        JRadioButton [] b14 = {radioButton13,radioButton15,radioButton16,radioButton10,radioButton6,radioButton18,radioButton2};
        JRadioButton [] b10 = {radioButton9,radioButton11,radioButton12,radioButton14,radioButton6,radioButton18,radioButton2};
        JRadioButton [] b6 = {radioButton5,radioButton10,radioButton14,radioButton18,radioButton7,radioButton8,radioButton2};
        JRadioButton [] b2 = {radioButton3,radioButton1,radioButton4,radioButton6,radioButton10,radioButton14,radioButton18};

        JRadioButton [] b19 = {radioButton18,radioButton17,radioButton20,radioButton15,radioButton11,radioButton7,radioButton3};
        JRadioButton [] b15 = {radioButton14,radioButton13,radioButton16,radioButton19,radioButton11,radioButton7,radioButton3};
        JRadioButton [] b11 = {radioButton10,radioButton9,radioButton12,radioButton19,radioButton15,radioButton7,radioButton3};
        JRadioButton [] b7 = {radioButton6,radioButton5,radioButton8,radioButton19,radioButton11,radioButton19,radioButton3};
        JRadioButton [] b3 = {radioButton2,radioButton1,radioButton4,radioButton7,radioButton11,radioButton19,radioButton15};


        radioButton17.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hallo");
                kleurOperation = "BRUIN";
                for (int v = 0; v <b17.length; v++){
                    System.out.println("Select 17");
                    b17[v].setSelected(false);
                }


            }

        });
        radioButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kleurQuarantine = "BRUIN";
                for (int v = 0; v < b13.length; v++){
                    System.out.println("Select 13");
                    b13[v].setSelected(false);
                }
                //radioButton13.setSelected(false);
            }
        });
        radioButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurGeneralist = "BRUIN";
                for (int v = 0; v < b9.length; v++){
                    System.out.println("Select 13");
                    b9[v].setSelected(false);
                }
            }
        });
        radioButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurContainment = "BRUIN";
                for (JRadioButton jRadioButton : b5) {
                    System.out.println("Select 13");
                    jRadioButton.setSelected(false);
                }
            }
        });
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurMedic = "BRUIN";
                for (int v = 0; v < b1.length; v++){
                    System.out.println("Select 13");
                    b1[v].setSelected(false);
                }
            }
        });
        radioButton18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurOperation = "WIT";
                for (int v = 0; v < b18.length; v++){
                    System.out.println("Select 13");
                    b18[v].setSelected(false);
                }
            }
        });
        radioButton19.addActionListener(e -> {
            kleurOperation = "BLAUW";
            for (JRadioButton jRadioButton : b19) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton20.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                kleurOperation = "GEEL";
                for (JRadioButton jRadioButton : b20) {
                    System.out.println("Select 13");
                    jRadioButton.setSelected(false);
                }
            }
        });
        radioButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurContainment = "WIT";
                for (JRadioButton jRadioButton : b6) {
                    System.out.println("Select 6");
                    jRadioButton.setSelected(false);
                }
            }
        });

        radioButton14.addActionListener(e -> {
             kleurQuarantine = "WIT";
            for (JRadioButton jRadioButton : b14) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton10.addActionListener(e -> {
            kleurGeneralist = "WIT";
            for (JRadioButton jRadioButton : b10) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton2.addActionListener(e -> {
            kleurMedic = "WIT";
            for (JRadioButton jRadioButton : b2) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kleurQuarantine = "BLAUW";
                for (JRadioButton jRadioButton : b15) {
                    System.out.println("Select 13");
                    jRadioButton.setSelected(false);
                }
            }
        });
        radioButton11.addActionListener(e -> {
            for (JRadioButton jRadioButton : b11) {
                kleurGeneralist = "BLAUW";
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton7.addActionListener(e -> {
            for (JRadioButton jRadioButton : b7) {
                kleurContainment = "BLAUW";
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton3.addActionListener(e -> {
            kleurMedic = "BLAUW";
            for (JRadioButton jRadioButton : b3) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton16.addActionListener(e -> {
             kleurQuarantine = "GEEL";
            for (int v = 0; v < b16.length; v++){
                System.out.println("Select 13");
                b16[v].setSelected(false);
            }
        });
        radioButton12.addActionListener(e -> {
            kleurGeneralist = "GEEL";
            for (JRadioButton jRadioButton : b12) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton8.addActionListener(e -> {
            kleurContainment = "GEEL";
            for (JRadioButton jRadioButton : b8) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        radioButton4.addActionListener(e -> {
            kleurMedic = "GEEL";
            for (JRadioButton jRadioButton : b4) {
                System.out.println("Select 13");
                jRadioButton.setSelected(false);
            }
        });
        startSpelButton.addActionListener(e -> {


            String list = geefUwNaamInTextArea.getText();

            namen = list.split(";");
            if  (namen.length < 2){
                //JOptionPane;
            }
            else {
                int id = 0;
                connectie dataLayer = new connectie("pandemie", false);
                LocalDateTime start = LocalDateTime.now().withNano(0);
                try {
                    dataLayer.insertSpellen(start);


                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                try {
                    id = dataLayer.spellenID(start);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                int count = 0;

                    for (int x = 0; x < buttons[0].length; x++) {
                        if (buttons[0][x].isSelected()) {
                            naam = namen[count];
                            count++;

                            try {
                                dataLayer.insertSpeler(id, Kleur.valueOf(kleurOperation),"Operations Expert",naam);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                }


                    for (int x = 0; x < buttons[1].length; x++) {
                        if (buttons[1][x].isSelected()) {
                            naam = namen[count];
                            count++;
                            try {
                                dataLayer.insertSpeler(id, Kleur.valueOf(kleurQuarantine),"Quarantine Specialist",naam);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                }


                    for (int x = 0; x < buttons[2].length; x++) {
                        if (buttons[2][x].isSelected()) {
                            naam = namen[count];
                            count++;
                            try {
                                dataLayer.insertSpeler(id, Kleur.valueOf(kleurGeneralist),"Generalist",naam);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }

                    }



                    for (int x = 0; x < buttons[3].length; x++) {
                        if (buttons[3][x].isSelected()) {
                            naam = namen[count];
                            count++;
                            try {
                                dataLayer.insertSpeler(id, Kleur.valueOf(kleurContainment),"Containment Specialist",naam);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }

                }


                    for (int x = 0; x < buttons[4].length; x++) {
                        if (buttons[4][x].isSelected()) {
                            naam = namen[count];
                            count++;
                            try {
                                dataLayer.insertSpeler(id, Kleur.valueOf(kleurMedic),"Medic",naam);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }

                    }

            }
            pand = new PandemieGui();
            pand.main(null);
            checkList.frame.dispose();
        });
        annulerenButton.addActionListener(e ->
                frame.dispose())

        ;
    }




}


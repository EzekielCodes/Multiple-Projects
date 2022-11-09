package presentatie;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import data.connectie;
import logica.Steden;

/**
 * Dit is een Gui voor het spel Pandemie, een opdracht voor het vak Object Orientation & Database Concepts - 2020-2021
 * @author naam student
 */
public class PandemieGui {
    private checkList check;
    Random randum = new Random();
    private TekenPanel tekenPanelForm;
    private JPanel tekenPanel;
    private JPanel mainPanel;
    private JTextArea logTextArea;
    private JPanel sidePanel;
    private JProgressBar progressUitbraak;
    private JProgressBar progressActies;
    private JProgressBar progressGetrokken;
    private JButton buttonStapel;
    private JButton buttonTrek;
    private JButton mover;
    private JLabel uitbraakLabel;
    private JLabel player;
    private JLabel rol;
    private JComboBox listSteden;
    private JLabel infectieStabel;
    private JLabel getrokkenInfectie;
    private JTextArea rolBeschrijving;
    private JLabel colorRol;
    private JLabel kaart;
    static JFrame frame;
    ArrayList<String> stad = new ArrayList();
    ArrayList<Integer> teller = new ArrayList();
    ArrayList<Integer> shuffle = new ArrayList();
    connectie dataLayer = new connectie("pandemie", false);
    int count = 0;
    int switc = 0;
    int move = 0;
    int id = 0;
    int counter = 0;
    String naam = "";
    static  String rolPlayers = " ";
    static  String beschrijving = "";
    int tel = 0;
    static int chec = 0;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> listConnected = new ArrayList<>();
    int crosschecker = 0;
    int naamChecker = 0;
    ArrayList<String> cityControle = new ArrayList<>();
    static  ArrayList<String> listControle = new ArrayList<>();
    Boolean state = false;
    int infectie = 25;
    String select = "";
     int con = 0;
    List<Steden> stedenList;
    int stadID = 0;
    static String kleur = "";
    static int aantal = 0;
    int n = 0;
    int h = 0;
    int score = 0;





    private void createUIComponents() throws SQLException {
        tekenPanelForm=new TekenPanel();
        tekenPanel=tekenPanelForm.getTekenPanel();

    }
    public PandemieGui(){
        score = tekenPanelForm.getScore();
        if (score == 7){
            progressUitbraak.setValue(7);
            progressUitbraak.setString(7 + " /7");
            JOptionPane.showMessageDialog(null,"Verloren --uitbraak","LOST",JOptionPane.INFORMATION_MESSAGE);
        }

        HashMap<String, Color> map = new  HashMap<String, Color>();
        map.put("BLAUW", Color.RED);
        map.put("GROEN", Color.GREEN);
        map.put("GEEL", Color.YELLOW);
        map.put("ZWART", Color.BLACK);
        map.put("BRUIN", new Color(102,51,0));
        map.put("WIT", Color.white);
        map.put("ROOS", Color.pink);

        progressUitbraak.setMinimum(0);
        progressUitbraak.setMaximum(7);
        buttonTrek.setText("Trek " + " \n" +  " InfectieKaart");
        buttonTrek.setBackground(Color.green);
        buttonTrek.setBorder(new LineBorder(Color.BLACK));

        buttonStapel.setBackground(Color.green);
        buttonTrek.setBorder(new LineBorder(Color.BLACK));
        progressUitbraak.setVisible(true);
        progressUitbraak.setStringPainted(true);
        progressActies.setStringPainted(true);
        progressGetrokken.setStringPainted(true);
        try {
            id = dataLayer.selectId();
            stedenList = dataLayer.selectSteden();
            dataLayer.selectNamen(names,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        naam = names.get(naamChecker);
        if (chec == 0){
            System.out.println("Once");
            for(int f = 0; f < names.size() ; f++){
                listControle.add("Brussel");
            }
        }
        chec ++;
        tekenPanel.repaint();

        /**
         * Dit button wordt gebruikt om een infectieKaart te nemen
         */
        buttonTrek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter == 3){
                    naamChecker++;
                    tel = 3;

                    if (naamChecker >= names.size()){
                        naamChecker = 0;
                    }
                    move = 0;
                    count = 0;
                    naam = names.get(naamChecker);
                    progressGetrokken.setString(move + " /3");
                    progressGetrokken.setValue(move);
                    progressGetrokken.setValue(move);
                    progressActies.setString(3 + "/3");
                    progressActies.setValue(3);
                    counter = 0;
                }
                try {
                    rolPlayers = dataLayer.selectRol(id,naam);
                    beschrijving = dataLayer.selectBeschrijving(rolPlayers);
                    kleur = dataLayer.selectKleur(id,naam);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                player.setText("speler aan zet: " + naam);
                rol.setText(rolPlayers);
                colorRol.setOpaque(true);
                rolBeschrijving.setFont(new Font("serif", Font.PLAIN, 20));
                colorRol.setBackground(map.get(kleur));

                colorRol.setForeground(map.get(kleur));
                rolBeschrijving.setText(beschrijving);



                try {
                    stad = dataLayer.selectStad(stad);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (switc == 1) {
                    score = tekenPanelForm.getScore();
                    progressUitbraak.setString(score + "/7");

                    progressUitbraak.setValue(score);
                    tel = 3;
                    infectie --;
                    if (move == teller.size() - 1){
                        switc = 0;
                    }
                    try {
                        stadID = dataLayer.selectIdStad(stad.get(teller.get(move)));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    tekenPanelForm.stedenList.get(stadID - 1).setZiekteStenen(1);

                    tekenPanel.repaint();
                    infectieStabel.setText( infectie +  "/25");
                    getrokkenInfectie.setText(25 - infectie + "/25");
                    buttonStapel.setText(stad.get(teller.get(move)));
                    logTextArea.append(" \n" +  naam + " heeft een infectiekaart getrokken = " + stad.get(teller.get(move)) +" \n");
                    move ++;
                    progressGetrokken.setString(move + " /3");
                    progressGetrokken.setValue(move);


                } else {
                    score = tekenPanelForm.getScore();
                    progressUitbraak.setString(score + "/7");

                    progressUitbraak.setValue(score);
                    aantal = 0;
                    tel = 3;
                    infectie--;
                    if (crosschecker < 3) {
                        crosschecker++;
                    }

                    count = count + 1;
                    int index = (int) (Math.random() * stad.size());
                    teller.add(index);
                    progressActies.setValue(3);
                    progressActies.setString(3 + " /3");
                    progressGetrokken.setString(count + " /3");
                    progressGetrokken.setValue(count);

                    try {
                        stadID = dataLayer.selectIdStad(stad.get(index));
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    tekenPanelForm.stedenList.get(stadID - 1).setZiekteStenen(1);
                    tekenPanel.repaint();

                    buttonStapel.setText(stad.get(index));
                    infectieStabel.setText(infectie + "/25");
                    getrokkenInfectie.setText(25 - infectie + "/25");
                    logTextArea.append("\n" + naam + "  heeft een infectiekaart getrokken =  " + stad.get(index) + " \n");
                }

               counter ++;
            }
        });

        /**
         * Een button om de stapel te schudding
         */
        buttonStapel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crosschecker = 3;
                infectieStabel.setText("25/25");
                getrokkenInfectie.setText( 0 + "/25");
                infectie = 25;
                counter = 0;
                switc = 1;
                progressGetrokken.setString(0 + " /3");
                progressActies.setString(0 + " /3");
                progressGetrokken.setValue(0);
                progressActies.setValue(0);
                buttonStapel.setText("stapel leeg");
            }
        });

        /**
         * Dit is een button die de speler verplaast wanner dat hij/zij een stad selecteert
         */
        mover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                select = (String) listSteden.getSelectedItem();
                listControle.set(naamChecker,select);
                logTextArea.append(" \n" + naam +  " moved to " + select + " \n");
                state = true;
                cityControle.clear();
                listConnected.clear();
                listSteden.removeAllItems();
                tel --;


                if (tel == 1){

                    progressActies.setValue(0);
                    progressActies.setString(0 + "/3");
                    progressGetrokken.setValue(0);
                    progressGetrokken.setString(0 + "/3");
                }else{
                    progressActies.setValue(tel);
                    progressActies.setString(tel + "/3");
                }

                tekenPanel.repaint();
                naam = names.get(naamChecker);
                n ++;


                    if (n == 2){
                        n = 0;

                        if (h == names.size() -1){
                            h = 0;
                            n = 0;
                        }
                        else{
                            h++;
                        }
                        naam = names.get(h);
                        player.setText("speler aan zet: " + naam);
                    }
                    System.out.println("Here size");



                System.out.println(h + " naamchecker");
                System.out.println(n + " n");
                System.out.println(names.size() + " array size");



                aantal++;

            }
        });

        /**
         * Hier mee kijk ik naar welke stad die geseleecteerd is in de jcombobox
         */
        listSteden.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listSteden.setSelectedItem(null);
                super.mouseClicked(e);
                listSteden.showPopup();
                if (listSteden.getSelectedIndex() < -1){
                    count --;
                }

                if (crosschecker == 3) {
                    String name = listControle.get(naamChecker);
                    int d = 0;
                    int city = 0;
                    try {
                        city = c(naamChecker);
                        listConnected = dataLayer.selectListConnnected(city);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    for (int x = 0; x < listConnected.size(); x++) {
                        String names = "";
                        try {
                            names = dataLayer.selectNaamStad(listConnected.get(x));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        name.toLowerCase();
                        names.toLowerCase();
                        if (cityControle.contains(names) || names.equals(name)) {

                        } else {
                            cityControle.add(names);
                        }

                    }
                    for (int s = 0; s < cityControle.size(); s++) {
                        listSteden.addItem(cityControle.get(s));
                    }

                    if (count > 4){
                        crosschecker = 0;
                    }
                }

            }
        });
    }

    /**
     *
     * @param n
     * @return
     * @throws SQLException
     */
    public int c(int n) throws SQLException {
        String nm = listControle.get(n);
        int id = dataLayer.selectIdStad(nm);
        return id;
    }

    /**
     * Hier mee kan ik vanaf tekenpanel de arraylist oproepen
     * @return
     */
    public ArrayList<String> getListcontrole(){
        return listControle;
    }

    /**
     * Hiermee kan ik vanaf tekenpanel het kleur van hudige speler aanvragen
     * @return
     */
    public String getKleur(){
        return kleur;
    }

    /**
     *
     * Een getter om de count vanaf tekenpanel op te vragen
     * @return
     */
    public int getCount(){
        return aantal;
    }

    /**
     * Hiermee kan ik vanaf tekenPanel de rol van de hudige speler aanvragen
     * @return
     */
    public String getRol(){
        return rolPlayers;
    }

    /**
     *
     * @param aan
     * Een setter om de count van de tekenPanle te kunnen aanpassen
     */
    public void setCount(int aan){
        aantal = aan;
    }

    public String getNaam(){
        return naam;
    }








    public static void main(String[] args) {
         frame = new JFrame("Pandemie - <naam Akindele>");
        if(frame.getTitle().contains("student"))
            JOptionPane.showMessageDialog(frame,"Voeg in de titel van het frame je eigen naam toe \nom deze melding te vermijden.","Titel nog niet aangepast",JOptionPane.WARNING_MESSAGE);
        frame.setContentPane(new PandemieGui().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

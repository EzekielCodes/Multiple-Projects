package presentatie;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import data.connectie;
import logica.Connectie;
import logica.Steden;
import logica.*;


/**
 * In deze klasse zal het tekenwerk gebeuren.
 * Deze klasse bevat het grafisch paneel in de linker helft van de toepassing.
 * @author naam student
 */
public class TekenPanel {

    private Image achtergrond;
    private Image pion;
    private JPanel tekenPanel;
    private JLabel coordinatenLabel;
    int id = 0;
    String naam = " ";
    int counter = 0;
    int IDconnect = 0;
    static int score = 0;


    List<Steden> stedenList;
    List<stadOne> stadOneList;
    List<stadTwo> stadTwoList;
    List<Connectie> connectieList;
    List<spelers> spelersList;
    List<Stad> listConnnected;
    ArrayList<Integer> connect = new ArrayList();



    public JPanel getTekenPanel() {
        return tekenPanel;
    }

    public Image getAchtergrond() {
        if (achtergrond == null) {
            try {
                achtergrond = ImageIO.read(PandemieGui.class.getResource("/europe.png"));
            } catch (IOException e) {
                e.printStackTrace();
                achtergrond = null;
            }
        }
        return achtergrond;
    }


    connectie dataLayer = new connectie("pandemie", false);
    {
        try {
            stedenList = dataLayer.selectSteden();
            connectieList = dataLayer.getConnectie();
            stadOneList = dataLayer.selectStadOne();
            stadTwoList = dataLayer.selectStadTwo();
            //spelersList = dataLayer.selectSpelers();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public void createUIComponents() {



        tekenPanel=new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                PandemieGui p = new PandemieGui();

                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // achtergrond tekenen
                g2.drawImage(getAchtergrond(), 0, 0, null);
                ((Graphics2D) g).setStroke(new BasicStroke(3));




                    g.setColor(Color.WHITE);

//                for (int x = 0; x < stadOneList.size(); x ++){
//                    stadOnexx.add(stadOneList.get(x).getX());
//                    stadOneyy.add(stadOneList.get(x).getY());
//
//                }


                    for (int n = 0; n < stadOneList.size(); n ++){
                        g.drawLine(stadOneList.get(n).getX(),stadOneList.get(n).getY(),stadTwoList.get(n).getX(),stadTwoList.get(n).getY());

                    }




                int i = 0;
                int mover  = 10;
                int ziekte = 5;
                int position = 0;
                HashMap<String, Color> map = new  HashMap<String, Color>();
                map.put("BLAUW", Color.RED);
                map.put("GROEN", Color.GREEN);
                map.put("GEEL", Color.YELLOW);
                map.put("ZWART", Color.BLACK);
                map.put("ZWART", Color.BLACK);
                map.put("BRUIN", new Color(102,51,0));
                map.put("WIT", Color.white);
                map.put("ROOS", Color.pink);

                for (Steden s : stedenList) {

                    String color = String.valueOf(s.getColor());
                    g.setColor(Color.WHITE);
                    g.drawString(s.getName(), s.getX() + 10, s.getY() + 10);
                    g.setColor(map.get(color));
                    g.fillOval(s.getX() - 10, s.getY() - 10, 20, 20);
                    if (s.getOnderzoekCentrum() > 0) {
                        g.setColor(Color.GREEN);
                        mover = 0;

                        for (int x = 0; x < s.getOnderzoekCentrum(); x++) {

                            g.fillRect(s.getX() - 20 + mover, s.getY(), 8, 8);
                            mover = mover + 10;
                        }


                    }



                     if (s.getZiekteStenen() > 3){
                         score = score + 1;
                        System.out.println("BIGGER");
                        int count = 10;
                        try {
                           connect =  dataLayer.selectListConnnected(s.getId());
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        connect = (ArrayList<Integer>) connect.stream().distinct().collect(Collectors.toList());
                         System.out.println(" array" +connect.toString());

                        for (int c = 0; c < connect.size();c++){
                            String names = "";
                            try {
                                names = dataLayer.selectNaamStad(connect.get(c));
                               // dataLayer.selectStad(names);
                                IDconnect = dataLayer.selectIdStad(names);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            IDconnect = IDconnect - 1;
                            System.out.println("names " + names);
                            if (stedenList.get(IDconnect).getZiekteStenen() < 3){

                                stedenList.get(IDconnect).setZiekteStenen(1);
                                System.out.println("names " + names);
                                System.out.println("ziekte "+ stedenList.get(IDconnect).getZiekteStenen() );
                            }
                            else{
                                stedenList.get(IDconnect).setZiekteStenen(3);
                                System.out.println("problem" + stedenList.get(IDconnect).getZiekteStenen());
                            }
                        }
                        repaint();
                   }
                    else if (s.getZiekteStenen() < 4 ){
                        ziekte = 10;
                        for (int h = 0; h < s.getZiekteStenen(); h++) {

                            String kle = String.valueOf(s.getColor());
                            g.setColor(map.get(kle));
                            System.out.println(s.getZiekteStenen());
                            g.fillRect(s.getX() + ziekte , s.getY() + 10, 10, 10);
                            ziekte = ziekte + 15;
                        }
                         repaint();
                    }


                    }



                try {
                    id = dataLayer.selectId();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


                ArrayList<String> names = new ArrayList<>();
                ArrayList<String> list = new ArrayList<>(p.listControle);
                List<Stad> stadList = new ArrayList<>();
                System.out.println("incoming");
                p.getListcontrole();
                System.out.println(p.getListcontrole());

                System.out.println( "color"+p.getKleur());

                for (int x =0 ; x < list.size(); x++){
                    int id = 0;
                    g.setColor(map.get(p.getKleur()));
                    String city = list.get(x);
                    {
                        try {
                            stadList = dataLayer.selectStad(city);
                            id = dataLayer.selectIdStad(city);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    counter++;
                    ///System.out.println("city " + city);
                   /// System.out.println("ID" + id);
                    id = id -1;
                    System.out.println( "index " + stedenList.get(id).getName());

                    int xAS = stadList.get(0).getX();
                    int yAS = stadList.get(0).getY();
                    if (p.getRol().toLowerCase().equals("containment specialist")) {
                        System.out.println("contain  me and oyu" + stedenList.get(id).getZiekteStenen());
                        if (stedenList.get(id).getZiekteStenen() == 2 || stedenList.get(id).getZiekteStenen() == 3) {
                            System.out.println("waiting for you");
                            stedenList.get(id).setZiekteStenen(-1);
                            g.drawRect(xAS, yAS, 20, 20);
                        }
                    }

                    if (p.getCount() == 2){
                        String naam = p.getNaam();
                        p.setCount(0);
                        System.out.println("higher than 3");

                        if(p.getRol().toLowerCase().equals("operations expert")){
                            System.out.println("contains " + stedenList.get(id).getOnderzoekCentrum());
                                if(stedenList.get(id).getOnderzoekCentrum() <= 0){
                                    stedenList.get(id).setOnderzoekCentrum(1);
                                    g.fillRect(stedenList.get(id).getX() + 10 , stedenList.get(id).getY() + 10, 8, 8);
                                    g.drawRect(xAS,yAS,20,20);
                                    g.drawString(naam,xAS,yAS);
                                    System.out.println("me and you");
                                }
                                else {
                                    g.drawRect(xAS,yAS,20,20);
                                    g.drawString(naam,xAS,yAS);
                                }
                            }
                            else if(p.getRol().toLowerCase().equals("medic")){
                            stedenList.get(id).setZiekteStenen(0);
                                g.drawRect(xAS,yAS,20,20);
                                g.drawString(naam,xAS,yAS);

                            }
                            else if(p.getRol().toLowerCase().equals("Generalist")){
                                g.drawRect(xAS,yAS,20,20);
                                g.drawString(naam,xAS,yAS);

                            }
                            else if (p.getRol().toLowerCase().equals("containment specialist")){
                                System.out.println("contain  me and oyu" + stedenList.get(id).getZiekteStenen());
                                if (stedenList.get(id).getZiekteStenen() == 2 ||  stedenList.get(id).getZiekteStenen() == 3){
                                    System.out.println("waiting for you");
                                    stedenList.get(id).setZiekteStenen(-1);
                                    g.drawRect(xAS,yAS,20,20);
                                    g.drawString(naam,xAS,yAS);
                                }
                                else {
                                    g.drawRect(xAS,yAS,20,20);
                                    g.drawString(naam,xAS,yAS);
                                }

                            }
                            else if (p.getRol().toLowerCase().equals("Quarantine specialist")){
                            g.drawRect(xAS,yAS,20,20);
                            g.drawString(naam,xAS,yAS);

                        }

                    }
                    else{
                        g.drawRect(xAS,yAS,20,20);
                    }

                }

                // andere zaken tekenen
            }
        };
        tekenPanel.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                coordinatenLabel.setText(e.getX()+"," + e.getY());
            }
        });
        tekenPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }
    public int getScore(){
        return score;
    }
}

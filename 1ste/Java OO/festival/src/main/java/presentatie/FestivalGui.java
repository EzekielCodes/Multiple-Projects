package presentatie;

import data.DataLayerJDBC;
import logica.Bezoeker;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FestivalGui {

    private JPanel contentPane;
    private JTable tableBezoekers;
    private JButton updateNaamButton;
    private JButton updateAdresButton;
    private JButton verwijderBezoekersButton;
    private JButton toonBezoekersButton;
    private JButton toonAantalButton;
    private JButton toonSomButton;
    private JButton toonAantalPerLandButton;
    private JTextField textFieldAantal;
    private JTextField textFieldSom;
    private JTextField textFieldAantalBis;
    private JButton toonAantalBisButton;

    protected DataLayerJDBC dl;

    public FestivalGui() {
        initComponents();

        try {
            dl = new DataLayerJDBC("festival");
            dl.dropTabel();
            dl.defineTabel();
            dl.addData();

            createHeaderBezoekers();
            List<Bezoeker> bezoekers = dl.readBezoekers();
            createTable(bezoekers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private void initComponents() {
        updateNaamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dl.updateBezoeker();
                List<Bezoeker> bezoekers = dl.readBezoekers();
                createTable(bezoekers);
            }
        });
        updateAdresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dl.updateStraat();
                List<Bezoeker> bezoekers = dl.readBezoekers();
                createTable(bezoekers);
            }
        });
        verwijderBezoekersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dl.deleteBezoekers();
                List<Bezoeker> bezoekers = dl.readBezoekers();
                createTable(bezoekers);
            }
        });
        toonBezoekersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Bezoeker> bezoekers = dl.readBezoekersInfo();;
                createTable(bezoekers);
            }
        });
        toonAantalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aantalBezoekers = dl.getAantalBezoekers();
                textFieldAantal.setText(Integer.toString(aantalBezoekers));
            }
        });
        toonAantalBisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aantalBezoekers = dl.getAantalBezoekersMetPostcode();
                textFieldAantalBis.setText(Integer.toString(aantalBezoekers));
            }
        });
        toonSomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int som = dl.getSomPostcodes();
                textFieldSom.setText(Integer.toString(som));
            }
        });
        toonAantalPerLandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableBezoekers.getModel();

                String[] header = {"land", "aantal"};
                model.setColumnCount(0);
                for (String naamKolom : header) {
                    model.addColumn(naamKolom);
                }

                LinkedHashMap<String, Integer> aantalBezoekersPerLand = dl.readAantalBezoekersPerLand();
                model.setRowCount(0);

                Iterator<Map.Entry<String, Integer>> iterator = aantalBezoekersPerLand.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Integer> pair = iterator.next();
                    String land = pair.getKey();
                    int aantal = pair.getValue().intValue();
                    String[] row = {land, Integer.toString(aantal)};
                    model.addRow(row);
                    iterator.remove();
                }
            }
        });
    }

    private void createHeaderBezoekers() {
        DefaultTableModel model = (DefaultTableModel) tableBezoekers.getModel();
        model.setColumnCount(0);

        String[] header = {"bezoeker_id", "naam", "voornaam", "straat_en_nummer", "gemeente", "postcode", "land"};

        for (String naamKolom : header) {
            model.addColumn(naamKolom);
        }
    }

    private void createTable(List<Bezoeker> bezoekers) {
        createHeaderBezoekers();
        DefaultTableModel model = (DefaultTableModel) tableBezoekers.getModel();
        model.setRowCount(0);

        for (Bezoeker bezoeker : bezoekers) {
            String[] bezoekersInfo = {bezoeker.getBezoekerId() != -1 ? Integer.toString(bezoeker.getBezoekerId()) : "", bezoeker.getNaam(), bezoeker.getVoornaam(), bezoeker.getStraat(), bezoeker.getGemeente(), bezoeker.getPostcode(), bezoeker.getLand()};
            model.addRow(bezoekersInfo);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FestivalGui");
        frame.setContentPane(new FestivalGui().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

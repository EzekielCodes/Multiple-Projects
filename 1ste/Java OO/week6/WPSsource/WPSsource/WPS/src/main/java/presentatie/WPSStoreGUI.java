package presentatie;

import logica.WPS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Van de Voorde Siebe
 * @Version 24/03/2021
 */

public class WPSStoreGUI {
    private JPanel panelMain;
    private JButton buttonStore;
    private JTextField textFieldStore;
    private JLabel labelList;
    private JLabel labelError;
    private ArrayList<WPS> lijst = new ArrayList<>();
    boolean check;
    String stringbuilder;

    public WPSStoreGUI(){

        buttonStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelError.setText("");
                try {
                    stringbuilder = "<html>";
                    String pincode = textFieldStore.getText();
                    WPS wps = new WPS(pincode);
                    check = false;
                    for (int i = 0; i < lijst.size(); i++){
                        if (lijst.get(i).equals(wps)){
                            check = true;
                        }
                    }
                    if (!check){
                        lijst.add(wps);
                        labelError.setText("nieuw gegenereerde code "+wps+" toegevoegd");
                    }
                    else {
                        throw new IllegalArgumentException("niet toegevoegd, reeds in lijst");
                    }
                    for (int i = 0; i < lijst.size(); i++){
                        stringbuilder += lijst.get(i).toString();
                        stringbuilder += "<br/>";
                    }
                    stringbuilder += "</html>";
                    labelList.setText(stringbuilder);
                }
                catch (Exception err){
                    labelError.setText(err.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("WPSStoreGUI");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(new WPSStoreGUI().panelMain);
        myFrame.setSize(400, 800);
        myFrame.setVisible(true);
    }
}

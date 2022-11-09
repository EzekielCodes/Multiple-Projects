package presentatie;

import logica.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WPSGENERATE extends  JFrame{
    private JButton generateButton;
    private JTextField outputArea;
    private JPanel jpanelmain;

    public WPSGENERATE(String title) {
        super(title);
        this.setDefaultCloseOperation(3);
        this.setContentPane(this.jpanelmain);
        this.pack();
        this.setSize(new Dimension(300,300));
        this.generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WPS newWps = new WPS();
                outputArea.setText(newWps.toString());
            }
        });
    }
    public static void main(String[] args) {
        JFrame myFrame = new WPSGENERATE("CODE GENERATOR");
        myFrame.setVisible(true);
    }
}

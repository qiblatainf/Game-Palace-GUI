/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class WinnerPanel extends JFrame {
    public WinnerPanel(){
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
       // pane.add(panel, BorderLayout.CENTER);
        pane.add(panel1, BorderLayout.CENTER);

        this.setSize(900, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      public static void main(String[] args) throws IOException {

        WinnerPanel m = new WinnerPanel();
        m.setVisible(true);

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

/**
 *
 * @author hp
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class panel extends JFrame{
     public panel(){
    JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        add(panel);
        panel.setLayout(null);
        setTitle(" ");
        setBackground(Color.BLACK);
        
        
         add(panel, BorderLayout.CENTER);
        this.setSize(340, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     }
     
     public static void main(String[] args) throws IOException {
        // TODO code application logic here

        panel m = new panel();
        m.setVisible(true);

    }
}

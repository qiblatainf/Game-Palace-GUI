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

public class AnagramIntro extends JFrame implements ActionListener {

    //declaring variables
    private JLabel labels;
    private JButton sixLetter, nineLetter, fourLetter,  EXIT,Back, leaderboard;

    public AnagramIntro() {


        //creating a new JPanel, setting color and setting title
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));
        add(panel);
        panel.setLayout(null);
        setTitle("Game Palace");
        
        ////////////////////LABELS\\\\\\\\\\\\\\\\\\\\\\\\\\
        //initalizing Labels
        labels = new JLabel("ANAGRAM");

        //Locaion and size setting of labels
        labels.setBounds(65, 1, 500, 100);

        //Setting Font Type,Colour,Size
        Font f = new Font("Vrinda", Font.BOLD, 24);
        labels.setFont(f);
        labels.setForeground(new Color(255, 153, 51));   

        //Adding Labels to panel
        panel.add(labels);

        ///////////////////  BUTTONS \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //Initalizing Buttons
        fourLetter = new JButton("Four Letter");        
        sixLetter = new JButton("Six Letter");
        nineLetter = new JButton("Nine Letter");
        Back = new JButton("Back");
        EXIT = new JButton("Exit");
        leaderboard = new JButton("LeaderBoard");
        
        //////////Setting bounds BG and FG color for buttons\\\\\\\\\\\
        fourLetter.setBounds(50, 80, 150, 30);        
        sixLetter.setBounds(50, 120, 150, 30);
        nineLetter.setBounds(50, 160, 150, 30);
        Back.setBounds(50, 240, 150, 30);
        leaderboard.setBounds(50, 280, 150, 30);
        EXIT.setBounds(50, 320, 150, 30);
        

        fourLetter.setBackground(new Color(0, 153, 76));       
        sixLetter.setBackground(new Color(204, 0, 102));
        nineLetter.setBackground(Color.YELLOW);
        Back.setBackground(Color.RED);
        EXIT.setBackground(Color.RED);
        leaderboard.setBackground(Color.RED);

        fourLetter.setForeground(Color.BLACK);       
        sixLetter.setForeground(Color.BLACK);
        nineLetter.setForeground(Color.BLACK);
        Back.setForeground(Color.BLACK);
        EXIT.setForeground(Color.BLACK);
        leaderboard.setForeground(Color.BLACK);
        

        fourLetter.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 76)));      
        sixLetter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        nineLetter.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        Back.setBorder(BorderFactory.createLineBorder(Color.RED));
        EXIT.setBorder(BorderFactory.createLineBorder(Color.RED));
        leaderboard.setBorder(BorderFactory.createLineBorder(Color.RED));

        nineLetter.setFont(new Font("Consolas", Font.BOLD, 20));
        sixLetter.setFont(new Font("Consolas", Font.BOLD, 20));      
        fourLetter.setFont(new Font("Consolas", Font.BOLD, 20));
        Back.setFont(new Font("Consolas", Font.BOLD, 20));
        EXIT.setFont(new Font("Consolas", Font.BOLD, 20));
        leaderboard.setFont(new Font("Consolas", Font.PLAIN, 20));

        //Adding actionlistener to buttons to make sure they're functional
        nineLetter.addActionListener(this);
        sixLetter.addActionListener(this);
        fourLetter.addActionListener(this);     
        Back.addActionListener(this);
        EXIT.addActionListener(this);
        leaderboard.addActionListener(this);

        //Grouping Radio Buttons
        panel.add(sixLetter);
        panel.add(nineLetter);     
        panel.add(fourLetter);
        panel.add(Back);
        panel.add(EXIT);
        panel.add(leaderboard);

        add(panel, BorderLayout.CENTER);
        this.setSize(280, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

       
        //move to new  JFrame if specific button pressed
        
        if (ae.getSource() == fourLetter) {

            try {
              this.toBack();
                Anagram4 b = new Anagram4();
                b.setVisible(true);
                b.toFront();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (ae.getSource() == sixLetter) {

            try {
                this.toBack();
                Anagram6 b = new Anagram6();
                b.setVisible(true);
                b.toFront();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (ae.getSource() == nineLetter) {

            try {
               this.toBack();
                Anagram9 b = new Anagram9();
                b.setVisible(true);
                b.toFront();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (ae.getSource() == EXIT) {
            this.setVisible(false);

        }
        
        if (ae.getSource() == leaderboard){
             try {
                this.setVisible(false);
                Leaderboard L = new Leaderboard();
                L.setVisible(true);
                L.toFront();
                
            } catch (FileNotFoundException ex) {
                System.out.print("Exception");
            } catch (Exception ex) {
                Logger.getLogger(Anagram4.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
        
        
        if (ae.getSource() == Back) {
            this.toBack();
            this.setVisible(false);

            try {
                new DSPROJECT().setVisible(true);
                //new OOPProject().setState(java.awt.Frame.NORMAL);
            } catch (IOException ex) {
                Logger.getLogger(AnagramIntro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        AnagramIntro m = new AnagramIntro();
        m.setVisible(true);

    }
}

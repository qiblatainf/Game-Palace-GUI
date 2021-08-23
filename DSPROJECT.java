/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.io.*;

public class DSPROJECT extends JFrame implements ActionListener {

//    PriorityQueue Q;
    //declaring variables
    private JLabel labels, name;

    private JButton Anagram, SAL, three, WAR, six, EXIT, four;
    private JTextField playername;

    public DSPROJECT() throws FileNotFoundException, IOException {

        //creating a new JPanel, setting color and setting title
        JPanel panel = new JPanel();
        panel.setBackground(new Color(160, 82, 45));
        add(panel);
        panel.setLayout(null);
        setTitle("Game Palace");
        setBackground(Color.BLACK);

        //player name
        Font p = new Font("Ink Free", Font.BOLD, 15);
        Font f = new Font("Ink Free", Font.BOLD, 35);
        Font j = new Font("Ink Free", Font.BOLD, 18);

        name = new JLabel("NAME: ");
        name.setFont(p);
        name.setBounds(80, 70, 130, 30);
        name.setForeground(Color.BLACK);

        labels = new JLabel("GAME PALACE");
        labels.setBounds(40, 1, 500, 100);
        labels.setFont(f);
        labels.setForeground(Color.BLACK);

        playername = new JTextField();
        playername.setBounds(80, 100, 150, 30);
        playername.setBackground(new Color(160, 82, 45));
        playername.setForeground(Color.BLACK);
        playername.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        playername.setFont(p);

        //Adding Labels to panel
        panel.add(labels);
        panel.add(playername);
        panel.add(name);

        //Initalizing Buttons
        SAL = new JButton("SNAKES AND LADDER");
        Anagram = new JButton("ANAGRAM");
        EXIT = new JButton("Exit");
        WAR = new JButton("WAR");

/////////////////Setting bounds BG and FG color for buttons\\\\\\\\\\\\\\\\\\\\\\\\
        Anagram.setBounds(80, 160, 150, 30);
        SAL.setBounds(80, 240, 150, 30);
        WAR.setBounds(80, 200, 150, 30);
        EXIT.setBounds(80, 320, 150, 30);

        Anagram.setBackground(new Color(30, 144, 255));
        SAL.setBackground(new Color(0, 128, 0));
        WAR.setBackground(new Color(102, 0, 102));
        EXIT.setBackground(Color.RED);

        Anagram.setForeground(Color.BLACK);
        SAL.setForeground(Color.BLACK);
        WAR.setForeground(Color.BLACK);
        EXIT.setForeground(Color.BLACK);

        SAL.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
        Anagram.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        WAR.setBorder(BorderFactory.createLineBorder(new Color(102, 0, 102)));
        EXIT.setBorder(BorderFactory.createLineBorder(Color.RED));

        SAL.setFont(new Font("Ink Free", Font.BOLD, 12));
        Anagram.setFont(new Font("Ink Free", Font.BOLD, 20));
        WAR.setFont(new Font("Ink Free", Font.BOLD, 20));
        EXIT.setFont(new Font("Ink Free", Font.BOLD, 20));

        //Adding actionlistener to buttons to make sure they're functional
        SAL.addActionListener(this);
        Anagram.addActionListener(this);
        WAR.addActionListener(this);
        EXIT.addActionListener(this);

        //Grouping Radio Buttons
        panel.add(Anagram);
        panel.add(SAL);
        panel.add(WAR);
        panel.add(EXIT);

        add(panel, BorderLayout.CENTER);
        this.setSize(340, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {

        //move to Snake and Ladder
        if (ae.getSource() == SAL) {
            this.setVisible(false);
            GraphSL g = new GraphSL();

            g.setVisible(true);
            g.toFront();
        }

        if (ae.getSource() == WAR) {
            this.setVisible(false);
            WAR w = new WAR();

            w.setVisible(true);
            w.toFront();
        }
        //move to Anagram
        if (ae.getSource() == Anagram) {

            try {
                File file = new File("players.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

                bw.write(playername.getText());
                bw.newLine();
                bw.close();
                // repaint();

                this.setVisible(false);
                AnagramIntro b = new AnagramIntro();
                b.setVisible(true);
                b.toFront();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ae.getSource() == EXIT) {
            this.setVisible(false);
            File file = new File("players.txt");

        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        DSPROJECT m = new DSPROJECT();
        m.setVisible(true);

    }
}

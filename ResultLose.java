/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class ResultLose extends JFrame implements ActionListener {

    private JLabel result, complete, lose;
    private JButton Back, Exit;
    private final ImageIcon Icon, Iconp;

    public ResultLose(int n) {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));

        Icon = new ImageIcon("lose.PNG");
        Iconp = new ImageIcon("point.PNG");

        lose = new JLabel("", Icon, JLabel.CENTER);
        complete = new JLabel("TRY AGAIN", JLabel.CENTER);
        result = new JLabel("<html><span class=<font size='6'> x </font></span>" + n, Iconp, JLabel.CENTER);

        lose.setLocation(60, 70);
        lose.setSize(200, 200);

        result.setLocation(0, 280);
        result.setSize(340, 60);
        result.setForeground(Color.BLACK);
        result.setBackground(new Color(0, 153, 76));
        Font r = new Font("Calbiri (Body)", Font.BOLD, 34);
        result.setFont(r);
        result.setOpaque(true);

        complete.setLocation(0, 0);
        complete.setSize(330, 60);
        complete.setForeground(Color.BLACK);
        complete.setBackground(new Color(0, 153, 76));
        Font a = new Font("Calbiri (Body)", Font.BOLD, 24);
        complete.setFont(a);
        complete.setOpaque(true);

        add(lose);
        add(result);
        add(complete);

        Exit = new JButton("EXIT");
        Back = new JButton("BACK");

        Exit.setBounds(190, 400, 90, 30);
        Back.setBounds(30, 400, 90, 30);

        Font s = new Font("Calbiri (Body)", Font.BOLD, 18);
        Exit.setFont(s);
        Back.setFont(s);

        Exit.setBackground(Color.RED);
        Back.setBackground(Color.RED);
        Exit.setForeground(Color.BLACK);
        Back.setForeground(Color.BLACK);
        Exit.setBorder(BorderFactory.createLineBorder(Color.RED));
        Back.setBorder(BorderFactory.createLineBorder(Color.RED));

        Back.addActionListener(this);
        Exit.addActionListener(this);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Back);
        bg.add(Exit);

        add(Back);
        add(Exit);

        add(panel, BorderLayout.CENTER);
        this.setSize(340, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        ResultLose obj = new ResultLose(9);
    }

    public void actionPerformed(ActionEvent ae) {
        //////Condition to exit Frame\\\\\\\
        if (ae.getSource() == Exit) {
            this.setVisible(false);

        }
       
        if (ae.getSource() == Back) {
            this.toBack();
            this.setVisible(false);

            new AnagramIntro().toFront();
            

        }
    }
}

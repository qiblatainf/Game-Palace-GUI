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
import java.io.File;
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
public class Result extends JFrame implements ActionListener {

    private JLabel Star1, Star2, Star3, result, complete;
    private JButton Back, Exit;
    private final ImageIcon Icon, Iconp;

    public Result(int n) {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 51));

        Icon = new ImageIcon("star.PNG");
        Iconp = new ImageIcon("point.PNG");
        Star1 = new JLabel("", Icon, JLabel.CENTER);
        Star2 = new JLabel("", Icon, JLabel.CENTER);
        Star3 = new JLabel("", Icon, JLabel.CENTER);
        complete = new JLabel("LEVEL COMPLETE", JLabel.CENTER);
        result = new JLabel("<html><span class=<font size='6'> x </font></span>" + n, Iconp, JLabel.CENTER);

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

        Star1.setLocation(45, 140);
        Star1.setSize(110, 110);
        Star2.setLocation(155, 140);
        Star2.setSize(110, 110);
        Star3.setLocation(95, 80);
        Star3.setSize(110, 110);

        add(Star1);
        add(Star2);
        add(Star3);
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

        Result obj = new Result(9);
    }

    @Override
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

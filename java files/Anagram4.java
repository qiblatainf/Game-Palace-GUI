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

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Anagram4 extends JFrame implements ActionListener {

   // static PriorityQueue Q = new PriorityQueue();
    JLabel title, level, one, two, three, four, counts, Points;
    JButton letter1, letter2, letter3, letter4, clear, next, back, leaderboard;
    String L1, L2, L3, L4, temp, S, st;
    String[] rws;
    LinkedList list, olist, clist;
    String[] arr = new String[1128];
    Random r = new Random();
    String rword;
    int RandomWord;
    int nwords, points = 0;
    int counter;
    boolean flag;
    char oneT;
    private final ImageIcon Icon, icon, IconB, Iconp;
    char[] rw;

    public Anagram4() throws FileNotFoundException, IOException {
                   
        
///////////Creating a new dictionary of four letters words\\\\\\\\\\\\\\\\\\\\\\\
        File file = new File("fourletters.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((st = br.readLine()) != null) {
            arr[nwords] = st;
            nwords++;

        }

        RandomWord = r.nextInt(arr.length);
        rword = arr[RandomWord];//// store the word in string

///////////////// Code to shufflethe Random word\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        rw = rword.toCharArray();
        list = new LinkedList<>();
        olist = new LinkedList<>();
        clist = new LinkedList<>();

        //ordered linked list
        for (int i = 0; i < rw.length; i++) {
            olist.add(rw[i]);
            System.out.print(rw[i]);
        }
        System.out.println();

        for (int i = 0; i < rw.length; i++) {
            list.add(rw[i]);
        }

        Collections.shuffle(list);// use to shuffle
        for (int i = 0; i < rw.length; i++) {
            if (list.get(i) == olist.get(i)) {
                Collections.shuffle(list);
            }
        }

        for (int i = 0; i < rw.length; i++) { // copy the shuffled chars back to the array
            rw[i] = (char) list.get(i);
        }
        rws = new String[4];
        for (int i = 0; i < rws.length; i++) { // copy the shuffled chars back to the array
            rws[i] = Character.toString(rw[i]);
        }

/////////////////////////////////Creating Panel\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        JPanel panel = new JPanel();
        setTitle("Anagram");
        setBackground(Color.BLACK);

        ///////Setting Title and background for Anagram Frame\\\\\\\\\\\
        setTitle("Anagram");
        setBackground(Color.BLACK);

        /////////Add Random Word and shuffled to panel using JLabel\\\\\\\\\\\
        title = new JLabel("ANAGRAM");
        level = new JLabel("4 Letters", JLabel.CENTER);
        one = new JLabel(" ", JLabel.CENTER);
        two = new JLabel(" ", JLabel.CENTER);
        three = new JLabel(" ", JLabel.CENTER);
        four = new JLabel(" ", JLabel.CENTER);
        counts = new JLabel("0/10", JLabel.CENTER);

        ////////////Setting location and size of labels\\\\\\\\\\\\\\       
        title.setLocation(90, 20);
        title.setSize(180, 60);
        title.setForeground(new Color(255, 128, 0));
        title.setBackground(Color.DARK_GRAY);
        title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        title.setOpaque(true);

        level.setLocation(90, 60);
        level.setSize(100, 60);
        level.setForeground(Color.BLACK);
        level.setBackground(Color.DARK_GRAY);
        level.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        level.setOpaque(true);

        one.setLocation(50, 180);
        one.setSize(50, 50);
        one.setForeground(Color.BLACK);
        one.setBackground(new Color(255, 128, 0));
        one.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        one.setOpaque(true);

        two.setLocation(110, 180);
        two.setSize(50, 50);
        two.setForeground(Color.BLACK);
        two.setBackground(Color.RED);
        two.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        two.setOpaque(true);

        three.setLocation(170, 180);
        three.setSize(50, 50);
        three.setForeground(Color.BLACK);
        three.setBackground(Color.YELLOW);
        three.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        three.setOpaque(true);

        four.setLocation(230, 180);
        four.setSize(50, 50);
        four.setForeground(Color.BLACK);
        four.setBackground(new Color(102, 0, 102));
        four.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        four.setOpaque(true);

        counts.setLocation(190, 65);
        counts.setSize(50, 50);
        counts.setForeground(Color.BLACK);
        counts.setFont(new Font("Kristen ITC", Font.PLAIN, 20));

        Iconp = new ImageIcon("point.PNG");
        Points = new JLabel("0", Iconp, JLabel.CENTER);
        Points.setLocation(280, 25);
        Points.setSize(100, 50);
        Points.setForeground(Color.BLACK);
        Points.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        add(Points);
        ////////////Adding labels to panel\\\\\\\\\\\\\\\\\\\
        add(counts);

        add(title);
        add(level);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);

        ////////////////////////////JButtons\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        letter1 = new JButton(rws[0]);
        letter1.setLocation(50, 120);
        letter1.setSize(50, 50);
        letter1.setFont(new Font("Kristen ITC", Font.PLAIN, 20));

        letter2 = new JButton(rws[1]);
        letter2.setLocation(110, 120);
        letter2.setSize(50, 50);
        letter2.setFont(new Font("Kristen ITC", Font.PLAIN, 20));

        letter3 = new JButton(rws[2]);
        letter3.setLocation(170, 120);
        letter3.setSize(50, 50);
        letter3.setFont(new Font("Kristen ITC", Font.PLAIN, 20));

        letter4 = new JButton(rws[3]);
        letter4.setLocation(230, 120);
        letter4.setSize(50, 50);
        letter4.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        

        Icon = new ImageIcon("logo.PNG");

        clear = new JButton("", Icon);
        clear.setLocation(290, 120);
        clear.setSize(60, 60);
        clear.setBackground(Color.DARK_GRAY);
        clear.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        icon = new ImageIcon("next.PNG");
        next = new JButton("", icon);

        next.setLocation(300, 180);
        next.setSize(50, 50);
        next.setBackground(Color.DARK_GRAY);
        next.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        IconB = new ImageIcon("back.PNG");

        back = new JButton("", IconB);
        back.setLocation(20, 15);
        back.setSize(50, 50);
        back.setBackground(Color.DARK_GRAY);
        back.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        letter1.setForeground(Color.BLACK);
        letter2.setForeground(Color.BLACK);
        letter3.setForeground(Color.BLACK);
        letter4.setForeground(Color.BLACK);

        letter1.setBackground(new Color(30,144,255));
        letter2.setBackground(new Color(30,144,255));
        letter3.setBackground(new Color(30,144,255));
        letter4.setBackground(new Color(30,144,255));

        letter1.setBorder(BorderFactory.createLineBorder(new Color(30,144,255)));
        letter2.setBorder(BorderFactory.createLineBorder(new Color(30,144,255)));
        letter3.setBorder(BorderFactory.createLineBorder(new Color(30,144,255)));
        letter4.setBorder(BorderFactory.createLineBorder(new Color(30,144,255)));

        ///////////////////// Adding JButtons to panels\\\\\\\\\\\\\\\\\\\\\\
        panel.add(letter1);
        panel.add(letter2);
        panel.add(letter3);
        panel.add(letter4);
        panel.add(clear);
        panel.add(next);
        panel.add(back);
        

        ////////////////Adding Ationlistener to JButtons\\\\\\\\\\\\\\\\\\\\\\
        letter1.addActionListener(this);
        letter2.addActionListener(this);
        letter3.addActionListener(this);
        letter4.addActionListener(this);
        clear.addActionListener(this);
        next.addActionListener(this);
        back.addActionListener(this);

        ////////////Formating of panel(bg colour,size,borders)\\\\\\\\\\\\\\
        panel.setBackground(Color.darkGray);
        this.setSize(400, 300);
        add(panel);
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == letter1) {
            if (one.getText().equals(" ")) {
                one.setText(letter1.getText());
            } else if (two.getText().equals(" ")) {
                two.setText(letter1.getText());
            } else if (three.getText().equals(" ")) {
                three.setText(letter1.getText());
            } else if (four.getText().equals(" ")) {
                four.setText(letter1.getText());
            }
            letter1.setVisible(false);

        }

        if (e.getSource() == letter2) {
            if (one.getText().equals(" ")) {
                one.setText(letter2.getText());
            } else if (two.getText().equals(" ")) {
                two.setText(letter2.getText());
            } else if (three.getText().equals(" ")) {
                three.setText(letter2.getText());
            } else if (four.getText().equals(" ")) {
                four.setText(letter2.getText());
            }

            letter2.setVisible(false);

        }

        if (e.getSource() == letter3) {

            if (one.getText().equals(" ")) {
                one.setText(letter3.getText());
            } else if (two.getText().equals(" ")) {
                two.setText(letter3.getText());
            } else if (three.getText().equals(" ")) {
                three.setText(letter3.getText());
            } else if (four.getText().equals(" ")) {
                four.setText(letter3.getText());
            }

            letter3.setVisible(false);

        }

        if (e.getSource() == letter4) {

            if (one.getText().equals(" ")) {
                one.setText(letter4.getText());
            } else if (two.getText().equals(" ")) {
                two.setText(letter4.getText());
            } else if (three.getText().equals(" ")) {
                three.setText(letter4.getText());
            } else if (four.getText().equals(" ")) {
                four.setText(letter4.getText());
            }

            letter4.setVisible(false);

        }

        if (e.getSource() == next) {

            clist.clear();
            clist.add(one.getText().charAt(0));
            clist.add(two.getText().charAt(0));
            clist.add(three.getText().charAt(0));
            clist.add(four.getText().charAt(0));

            flag = false;

            for (int i = 0; i < 4; i++) {

                if (clist.get(i) == olist.get(i)) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag == false) {
                    break;
                }

            }

            if (flag == false) {
                counter++;
                counts.setText(String.valueOf(counter) + "/" + "10");

                one.setText(null);
                two.setText(null);
                three.setText(null);
                four.setText(null);

                one.setText(" ");
                two.setText(" ");
                three.setText(" ");
                four.setText(" ");

                RandomWord = r.nextInt(arr.length);
                rword = arr[RandomWord];//// store the word in string
                System.out.println(rword);
                rw = rword.toCharArray();
                for (int i = 0; i < rw.length; i++) {
                    list.set(i, rw[i]);
                }

                for (int i = 0; i < rw.length; i++) {
                    olist.set(i, rw[i]);
                }

                Collections.shuffle(list);  // use to shuffle
                for (int i = 0; i < rw.length; i++) {
                    if (list.get(i) == olist.get(i)) {
                        Collections.shuffle(list);
                    }
                }

                for (int i = 0; i < rw.length; i++) { // copy the shuffled chars back to the array
                    rw[i] = (char) list.get(i);
                }

                rws = new String[4];

                for (int i = 0; i < rws.length; i++) { // copy the shuffled chars back to the array
                    rws[i] = Character.toString(rw[i]);

                }

                letter1.setText(rws[0]);
                letter2.setText(rws[1]);
                letter3.setText(rws[2]);
                letter4.setText(rws[3]);

                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);

                if (counter == 10) {
                    if (points < 50) {
                        this.setVisible(false);
                        ResultLose b = new ResultLose(points);

                    } else {
                        this.setVisible(false);
                        Result b = new Result(points);
                    }

                }

            } else {
                counter++;
                counts.setText(String.valueOf(counter) + "/" + "10");
                points = points + 5;
                Points.setText(String.valueOf(points));

                one.setText(null);
                two.setText(null);
                three.setText(null);
                four.setText(null);

                one.setText(" ");
                two.setText(" ");
                three.setText(" ");
                four.setText(" ");

                RandomWord = r.nextInt(arr.length);
                rword = arr[RandomWord];//// store the word in string
                System.out.println(rword);
                rw = rword.toCharArray();
                for (int i = 0; i < rw.length; i++) {
                    list.set(i, rw[i]);
                }

                for (int i = 0; i < rw.length; i++) {
                    olist.set(i, rw[i]);
                }

                Collections.shuffle(list);  // use to shuffle
                for (int i = 0; i < rw.length; i++) {
                    if (list.get(i) == olist.get(i)) {
                        Collections.shuffle(list);
                    }
                }

                for (int i = 0; i < rw.length; i++) { // copy the shuffled chars back to the array
                    rw[i] = (char) list.get(i);
                }

                rws = new String[4];

                for (int i = 0; i < rws.length; i++) { // copy the shuffled chars back to the array
                    rws[i] = Character.toString(rw[i]);

                }

                letter1.setText(rws[0]);
                letter2.setText(rws[1]);
                letter3.setText(rws[2]);
                letter4.setText(rws[3]);

                letter1.setVisible(true);
                letter2.setVisible(true);
                letter3.setVisible(true);
                letter4.setVisible(true);

                if (counter == 10) {
                    if (points == 50) {
                        this.setVisible(false);
                         Result b = new Result(points);
                        
                    } else {
                        this.setVisible(false);
                        ResultLose b = new ResultLose(points);
                    }

                }
              
              
            }

                      if (counter == 10){
              
                        try {
                           
                            BufferedWriter bw = new BufferedWriter(new FileWriter("players.txt", true));
                            bw.write("" + points);
                            bw.newLine();
                            bw.close();
                            
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

               }
        }

        if (e.getSource() == clear) {

            letter1.setVisible(true);
            letter2.setVisible(true);
            letter3.setVisible(true);
            letter4.setVisible(true);

            one.setText(null);
            two.setText(null);
            three.setText(null);
            four.setText(null);

            one.setVisible(true);
            two.setVisible(true);
            three.setVisible(true);
            four.setVisible(true);

            one.setText(" ");
            two.setText(" ");
            three.setText(" ");
            four.setText(" ");

        }

        if (e.getSource() == back) {

            this.toBack();       
            this.setVisible(false);

        }
        
        

    }

    public static void main(String[] args) throws IOException {

        Anagram4 m = new Anagram4();
        m.setVisible(true);

    }

}

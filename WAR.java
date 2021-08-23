/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class WAR extends JFrame implements ActionListener {

    Player p1, p2;
    Stack<String> p1Pile, p2Pile;
    boolean flag;
    String p1Value, p2Value;
    int value;
    JButton p1Card, ExitB, BackB;
    JLabel AICard, p1playcard, AIplaycard, P1WAR, AIWAR, AICount, P1Count;
    String winner = "";
    private final ImageIcon Icon, Icon2, Icon3, Icon4, Icon5, Icon6, Icon7, Icon8, Icon9, Icon10, IconJ, IconQ, IconK, IconA, IconWAR,
            Icon22, Icon32, Icon42, Icon52, Icon62, Icon72, Icon82, Icon92, Icon102, IconJ2, IconQ2, IconK2, IconA2;
    String[] deck;

    public WAR() {
        flag = false;
        p1Pile = new Stack<String>();
        p2Pile = new Stack<String>();
        p1 = new Player();
        p2 = new Player();

        String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
        };

        int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // initialize deck
        int n = SUITS.length * VALUES.length;
        String[] deck = new String[n];
        for (int i = 0; i < VALUES.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
                if (VALUES[i] == 1) {
                    deck[SUITS.length * i + j] = "Aces" + " of " + SUITS[j];
                } else if (VALUES[i] == 11) {
                    deck[SUITS.length * i + j] = "Jack" + " of " + SUITS[j];
                } else if (VALUES[i] == 12) {
                    deck[SUITS.length * i + j] = "Queen" + " of " + SUITS[j];
                } else if (VALUES[i] == 13) {
                    deck[SUITS.length * i + j] = "King" + " of " + SUITS[j];
                } else {
                    deck[SUITS.length * i + j] = VALUES[i] + " of " + SUITS[j];
                }
            }
        }

        // shuffle
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            String temp = deck[r];
            deck[r] = deck[i];
            deck[i] = temp;
        }

        // add in player stack
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                p1.getCard(deck[i]);
            } else {
                p2.getCard(deck[i]);
            }
        }

        System.out.println("Player 1 " + p1.cardCount());
        System.out.println("Player 1 " + p1.getstack());
        System.out.println("Player 2 " + p2.cardCount());
        System.out.println("Player 2 " + p2.getstack());

        JPanel panel = new JPanel();
        ///////Setting Title and background for Anagram Frame\\\\\\\\\\\
        setTitle("WAR");
        setBackground(Color.BLACK);

        Icon = new ImageIcon("card.PNG");
        IconWAR = new ImageIcon("3cards.PNG");
        IconA = new ImageIcon("AC.PNG");
        Icon2 = new ImageIcon("2D.PNG");
        Icon3 = new ImageIcon("3S.PNG");
        Icon4 = new ImageIcon("4H.PNG");
        Icon5 = new ImageIcon("5C.PNG");
        Icon6 = new ImageIcon("6D.PNG");
        Icon7 = new ImageIcon("7S.PNG");
        Icon8 = new ImageIcon("8H.PNG");
        Icon9 = new ImageIcon("9C.PNG");
        Icon10 = new ImageIcon("10D.PNG");
        IconJ = new ImageIcon("JS.PNG");
        IconQ = new ImageIcon("QH.PNG");
        IconK = new ImageIcon("KC.PNG");
        
        IconA2 = new ImageIcon("AH.PNG");
        Icon22 = new ImageIcon("2S.PNG");
        Icon32 = new ImageIcon("3D.PNG");
        Icon42 = new ImageIcon("4C.PNG");
        Icon52 = new ImageIcon("5H.PNG");
        Icon62 = new ImageIcon("6S.PNG");
        Icon72 = new ImageIcon("7D.PNG");
        Icon82 = new ImageIcon("8C.PNG");
        Icon92 = new ImageIcon("9H.PNG");
        Icon102 = new ImageIcon("10S.PNG");
        IconJ2 = new ImageIcon("JD.PNG");
        IconQ2 = new ImageIcon("QC.PNG");
        IconK2 = new ImageIcon("KH.PNG");
        
        //creating exit button to close frame
        ExitB = new JButton("EXIT");
        ExitB.setBounds(260, 510, 70, 30);
        ExitB.setBackground(Color.GRAY);
        ExitB.addActionListener(this);
        add(ExitB);

        //creating button to go back
        BackB = new JButton("BACK");
        BackB.setBounds(340, 510, 70, 30);
        BackB.setBackground(Color.GRAY);
        BackB.addActionListener(this);
        add(BackB);
        
        p1Card = new JButton();
        p1Card.setLocation(40, 300);
        p1Card.setSize(145, 200);
        p1Card.setIcon(Icon);
        

        AICard = new JLabel("");
        AICard.setLocation(220, 50);
        AICard.setSize(170, 200);
        AICard.setIcon(Icon);

        p1playcard = new JLabel();
        p1playcard.setLocation(250, 300);
        p1playcard.setSize(170, 200);
        p1playcard.setIcon(null);

        AIplaycard = new JLabel();
        AIplaycard.setLocation(50, 50);
        AIplaycard.setSize(170, 200);
        AIplaycard.setIcon(null);

        AICount = new JLabel("AI Card Count " + "26");
        AICount.setLocation(300, 0);
        AICount.setSize(200, 70);
        AICount.setForeground(Color.yellow);

        P1Count = new JLabel("Player Card Count " + "26");
        P1Count.setLocation(50, 500);
        P1Count.setSize(200, 40);
        P1Count.setForeground(Color.yellow);

        P1WAR = new JLabel();
        P1WAR.setLocation(240, 300);
        P1WAR.setSize(170, 200);
        P1WAR.setIcon(null);

        AIWAR = new JLabel();
        AIWAR.setLocation(50, 50);
        AIWAR.setSize(170, 200);
        AIWAR.setIcon(null);

        p1Card.addActionListener(this);

        panel.add(AICard);
        panel.add(P1WAR);
        panel.add(AIWAR);
        panel.add(AIplaycard);
        panel.add(p1playcard);
        panel.add(AICount);
        panel.add(P1Count);
        panel.add(p1Card);

        panel.setBackground(Color.darkGray);
        this.setSize(450, 600);
        add(panel);
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        JOptionPane.showMessageDialog(this, "WELCOME TO THE GAME, WAR! CAN YOU BEAT THE COMPUTER?", "", JOptionPane.PLAIN_MESSAGE );
        
    }

    private int getValue(String s) {

        if (s.substring(0, 2).equals("10")) {
            value = 10;
        } else if (s.substring(0, 4).equals("Aces")) {
            value = 14;
        } else if (s.substring(0, 4).equals("Jack")) {
            value = 11;
        } else if (s.substring(0, 5).equals("Queen")) {
            value = 12;
        } else if (s.substring(0, 4).equals("King")) {
            value = 13;
        } else {
            String j = s.substring(0, 1);
            value = Integer.parseInt(j);
        }

        return value;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == p1Card) {

            if (!p1.isEmpty() && p1.cardCount() < 52) {
                p1Pile.push(p1.playCard());

            } else {
                winner = "p2";// player 1 has no more cards
                JOptionPane.showMessageDialog(this, "AI WINS!",
                        "", JOptionPane.PLAIN_MESSAGE);

            }

            if (!p2.isEmpty()) {
                p2Pile.push(p2.playCard());

            } else {
                winner = "p1";// player 2 has no more cards
                JOptionPane.showMessageDialog(this, "YOU WIN!",
                        "", JOptionPane.PLAIN_MESSAGE);

            }

            /////////Getting the cards put on the table\\\\\\\
            p1Value = p1Pile.get(p1Pile.size() - 1);
            p2Value = p2Pile.get(p2Pile.size() - 1);

            System.out.println("p1 Value " + p1Value);
            System.out.println("p2 Value " + p2Value);

            int x = getValue(p1Value);// get the value of card
            int y = getValue(p2Value);// get the value of card

            ////////////For Player 1\\\\\\\\\\\\\\\\\\\\\   
            if (x == 14) {
                p1playcard.setIcon(IconA);
            } else if (x == 2) {
                p1playcard.setIcon(Icon2);
            } else if (x == 3) {
                p1playcard.setIcon(Icon3);
            } else if (x == 4) {
                p1playcard.setIcon(Icon4);
            } else if (x == 5) {
                p1playcard.setIcon(Icon5);
            } else if (x == 6) {
                p1playcard.setIcon(Icon6);
            } else if (x == 7) {
                p1playcard.setIcon(Icon7);
            } else if (x == 8) {
                p1playcard.setIcon(Icon8);
            } else if (x == 9) {
                p1playcard.setIcon(Icon9);
            } else if (x == 10) {
                p1playcard.setIcon(Icon10);
            } else if (x == 11) {
                p1playcard.setIcon(IconJ);
            } else if (x == 12) {
                p1playcard.setIcon(IconQ);
            } else if (x == 13) {
                p1playcard.setIcon(IconK);
            }

            ////////////For AI\\\\\\\\\\\\\\\\\\\\\\\\\
            if (y == 14) {
                AIplaycard.setIcon(IconA2);
            } else if (y == 2) {
                AIplaycard.setIcon(Icon22);
            } else if (y == 3) {
                AIplaycard.setIcon(Icon32);
            } else if (y == 4) {
                AIplaycard.setIcon(Icon42);
            } else if (y == 5) {
                AIplaycard.setIcon(Icon52);
            } else if (y == 6) {
                AIplaycard.setIcon(Icon62);
            } else if (y == 7) {
                AIplaycard.setIcon(Icon72);
            } else if (y == 8) {
                AIplaycard.setIcon(Icon82);
            } else if (y == 9) {
                AIplaycard.setIcon(Icon92);
            } else if (y == 10) {
                AIplaycard.setIcon(Icon102);
            } else if (y == 11) {
                AIplaycard.setIcon(IconJ2);
            } else if (y == 12) {
                AIplaycard.setIcon(IconQ2);
            } else if (y == 13) {
                AIplaycard.setIcon(IconK2);
            }

            AIWAR.setIcon(null);
            P1WAR.setIcon(null);

            ///////Comparing the cards value\\\\\\
            if (x > y) {
                winner = "p1";
            } else if (x < y) {
                winner = "p2";
            } else {
                winner = "none";
            }

            if (winner.equals("p1"))// move all cards on table to Player 1
            {
                System.out.println("Player 1 wins");
                while (!p1Pile.isEmpty()) {
                    p1.insertatstart(p1Pile.pop());
                }
                while (!p2Pile.isEmpty()) {
                    p1.insertatstart(p2Pile.pop());
                }

                System.out.println("Updated deck of p1: " + p1.getstack());
                System.out.println("Updated deck of p2: " + p2.getstack());
                P1Count.setText("Player Card Count " + p1.cardCount());
                AICount.setText("AI Card Count " + p2.cardCount());
                System.out.println("Deck of p1 size : " + p1.cardCount());
                System.out.println("Deck of p2 size : " + p2.cardCount());
            }

            if (winner.equals("p2"))// move all cards on table to Player 2
            {
                System.out.println("Player 2 wins");
                while (!p1Pile.isEmpty()) {
                    p2.insertatstart(p1Pile.pop()); // to insert at bottom of stack
                }
                while (!p2Pile.isEmpty()) {
                    p2.insertatstart(p2Pile.pop());
                }

                System.out.println("Updated deck of p1: " + p1.getstack());
                System.out.println("Updated deck of p2: " + p2.getstack());
                P1Count.setText("Player Card Count " + p1.cardCount());
                AICount.setText("AI Card Count " + p2.cardCount());
                System.out.println("Deck of p1 size : " + p1.cardCount());
                System.out.println("Deck of p2 size : " + p2.cardCount());

            }

            if (winner.equals("none")) {

                System.out.println("WAR!");
                JOptionPane.showMessageDialog(this, "WAR!\n Play Card Again",
                        "", JOptionPane.PLAIN_MESSAGE);
               
                int count = 0;

                P1WAR.setIcon(IconWAR);
                AIWAR.setIcon(IconWAR);

                // getting 4 more cards
                while (!p1.isEmpty() && count < 3) {
                    String a = p1.playCard();
                    p1Pile.push(a);

                    System.out.println(a);

                    count++;
                }
                count = 0;
                while (!p2.isEmpty() && count < 3) {
                    String a = p2.playCard();
                    p2Pile.push(a);

                    System.out.println(a);
                    count++;
                }

            }
        }
        if (ae.getSource() == ExitB) {
            System.exit(0);
        }

        if (ae.getSource() == BackB) {
            
            this.setVisible(false);

            try {
                DSPROJECT d = new DSPROJECT();
                d.setVisible(true);
            d.toFront();
             
                            
            } catch (IOException ex) {
                Logger.getLogger(WAR.class.getName()).log(Level.SEVERE, null, ex);
            }
                        

        }
    }

    public static void main(String[] args) {
        WAR game = new WAR();
    }
}
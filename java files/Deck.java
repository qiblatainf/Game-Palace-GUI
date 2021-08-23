/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.awt.Color;
import java.awt.Font;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Deck extends JFrame{

    Player p1, p2;
    Stack<String> p1Pile, p2Pile;
    boolean flag;
    String p1Value, p2Value;
    int value;
    JButton p1Card,p2Card;

    public Deck() {
 
        
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

        // print shuffled deck
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

        beginGame();

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

    private void beginGame() {
        String winner = "";
        while (true)// to continue till it breaks somewhere 
        {
            if (!flag)
            {
                if (!p1.isEmpty() && p1.cardCount() < 52) {
                    p1Pile.push(p1.playCard());

                } else {
                    winner = "p2";// player 1 has no more cards
                    break;
                }

                if (!p2.isEmpty()) {
                    p2Pile.push(p2.playCard());

                } else {
                    winner = "p1";// player 2 has no more cards
                    break;
                }
            }
            flag = false;//to makesure players put down cards in next round
            
            /////////Getting the cards put on the table\\\\\\\
            p1Value = p1Pile.get(p1Pile.size() - 1);
            p2Value = p2Pile.get(p2Pile.size() - 1);

            System.out.println("p1 Value " + p1Value);
            System.out.println("p2 Value " + p2Value);

            int x = getValue(p1Value);// get the value of card
            int y = getValue(p2Value);// get the value of card

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
                System.out.println("Deck of p1 size : " + p1.cardCount());
                System.out.println("Deck of p2 size : " + p2.cardCount());

            }

            if (winner.equals("none")) {
                System.out.println(p1Value);
                System.out.println(p2Value);                
                System.out.println("WAR!");
                
                flag = true;
                int count = 0;

                // getting 4 more cards
                while (!p1.isEmpty() && count < 4) {
                    String a = p1.playCard();
                    p1Pile.push(a);
                    System.out.println(a);

                    count++;
                }
                count = 0;
                while (!p2.isEmpty() && count < 4) {
                    String a = p2.playCard();
                    p2Pile.push(a);
                    System.out.println(a);
                    count++;
                }
            }

        }

        System.out.println("The winner is " + winner + ".");
        System.out.println("P1 has " + p1.cardCount() + " cards. P2 has " + p2.cardCount() + " cards");
    }

    public static void main(String[] args) {

        Deck obj = new Deck();

    }

}

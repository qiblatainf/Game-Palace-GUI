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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class GraphSL extends JFrame implements ActionListener {

    public static int v = 5;
    public static int[][] matrix;
    public static int row = 5, col = 5;
    public static Node node[][];
    public static boolean flag = false;
    public int dice, start, start2, dest, dest2, x, box, num = 25, m, n, count = 1, previ, prevj, prevj2, previ2, prevdest = 1, prevdest2 = 1;
    public static String value;
    JButton[][] cell = new JButton[5][5];
    JButton Player1, Player2, ExitB, BackB;
    JLabel Snake, Snake2, Ladder, Ladder2, diceP1, diceP2, title, P1, P2;
    private final ImageIcon Icon, IconG, IconL, IconL2, IconS2, IconG2, Stack, Iconsl, dice1, dice2, dice3, dice4, dice5, dice6;

    public GraphSL() {

        Icon = new ImageIcon("snake1.PNG");
        IconG = new ImageIcon("goti1.PNG");
        IconG2 = new ImageIcon("goti2.PNG");
        IconL = new ImageIcon("ladder1.PNG");
        IconL2 = new ImageIcon("ladder2.PNG");
        IconS2 = new ImageIcon("snake2.PNG");
        Stack = new ImageIcon("double.PNG");
        Iconsl = new ImageIcon("SL.PNG");
        dice1 = new ImageIcon("dice1.PNG");
        dice2 = new ImageIcon("dice2.PNG");
        dice3 = new ImageIcon("dice3.PNG");
        dice4 = new ImageIcon("dice4.PNG");
        dice5 = new ImageIcon("dice5.PNG");
        dice6 = new ImageIcon("dice6.PNG");
        Snake = new JLabel("", Icon, JLabel.CENTER);
        Snake.setLocation(430, 40);
        Snake.setSize(300, 600);

        //creating exit button to close frame
        ExitB = new JButton("EXIT");
        ExitB.setBounds(700, 550, 70, 30);
        ExitB.setBackground(new Color(154, 205, 50));
        ExitB.addActionListener(this);
        add(ExitB);

        //creating button to go back
        BackB = new JButton("BACK");
        BackB.setBounds(780, 550, 70, 30);
        BackB.setBackground(new Color(154, 205, 50));
        BackB.addActionListener(this);
        add(BackB);

        title = new JLabel("", Iconsl, JLabel.CENTER);
        title.setLocation(650, 10);
        title.setSize(200, 110);
        add(title);

        Snake2 = new JLabel("", IconS2, JLabel.CENTER);
        Snake2.setLocation(30, 6);
        Snake2.setSize(600, 600);

        Ladder = new JLabel("", IconL, JLabel.CENTER);
        Ladder.setLocation(10, 35);
        Ladder.setSize(100, 300);

        Ladder2 = new JLabel("", IconL2, JLabel.CENTER);
        Ladder2.setLocation(140, 280);
        Ladder2.setSize(300, 300);

        P1 = new JLabel("Player 1");
        P1.setForeground(Color.RED);
        P1.setFont(new Font("Ink Free", Font.BOLD, 18));
        P1.setLocation(780, 180);
        P1.setSize(100, 300);

        P2 = new JLabel("Player 2");
        P2.setForeground(new Color(75, 0, 130));
        P2.setFont(new Font("Ink Free", Font.BOLD, 18));
        P2.setLocation(780, 90);
        P2.setSize(300, 300);

        add(P1);
        add(P2);

        this.node = new Node[row][col];
        matrix = new int[v * v][v * v];
        cell = new JButton[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                node[i][j] = new Node();
                cell[i][j] = new JButton();
                cell[i][j].setBackground(new Color(138, 43, 226));
                cell[i][j].setForeground(new Color(255, 255, 0));
                cell[i][j].setBorder(BorderFactory.createLineBorder(Color.CYAN));
                cell[i][j].setFont(new Font("Sans Serif", Font.BOLD, 24));
                cell[i][j].setOpaque(false);

            }
        }

        cell[4][0].setIcon(Stack);
        for (int i = 0; i < row; i++) {
            if (i == 0 || i % 2 == 0) {
                for (int j = 0; j < col; j++) {
                    if (i == 4) {
                        cell[i][j].setText(String.valueOf(j + 1));
                    }
                    if (i == 2) {
                        cell[i][j].setText(String.valueOf(j + 11));
                    }
                    if (i == 0) {
                        cell[i][j].setText(String.valueOf(j + 21));
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (i % 2 != 0) {
                for (int j = col - 1; j >= 0; j--) {
                    if (i == 3) {

                        cell[i][j].setText(String.valueOf(10 - j));

                    }
                    if (i == 1) {
                        cell[i][j].setText(String.valueOf(20 - j));
                    }

                }
            }
        }

        start = 1;
        start2 = 1;

        setTitle("Snake & Ladders");
        setBackground(Color.BLACK);

        JPanel panel = new JPanel(new GridLayout(5, 5));
        panel.setOpaque(false);
        add(Ladder);
        add(Ladder2);
        add(Snake);
        add(Snake2);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                panel.add(cell[i][j]);
            }
        }

        JPanel panel1 = new JPanel();
        //panel1.setBackground(new Color(188, 143, 143));
        panel1.setBackground(Color.BLACK);

        Player1 = new JButton();
        Player1.setIcon(dice1);
        Player1.setForeground(Color.YELLOW);
        Player1.setLocation(680, 300);
        Player1.setSize(80, 70);
        Player1.setBackground(Color.BLACK);
        Player1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(Player1);
        Player1.addActionListener(this);

        Player2 = new JButton();
        Player2.setIcon(dice1);
        Player2.setForeground(Color.YELLOW);
        Player2.setLocation(680, 200);
        Player2.setSize(80, 80);
        Player2.setBackground(Color.BLACK);
        Player2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(Player2);
        Player2.addActionListener(this);

        panel.setSize(650, 650);
        panel1.setSize(400, 400);

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(panel, BorderLayout.CENTER);
        pane.add(panel1, BorderLayout.CENTER);

        this.setSize(900, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane.showMessageDialog(this, "WELCOME TO SNAKE AND LADDERS! \nGame begins with PLAYER 1", "", JOptionPane.PLAIN_MESSAGE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ExitB) {
            System.exit(0);
        }

        if (e.getSource() == BackB) {

            this.setVisible(false);

            try {
                DSPROJECT d = new DSPROJECT();
                d.setVisible(true);
                d.toFront();

            } catch (IOException ex) {
                Logger.getLogger(WAR.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

/////////////////////////////// PLAYER 1 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if (e.getSource() == Player1) {
            if (count == 1) {
                cell[4][0].setIcon(IconG2);
            } else {
                cell[4][0].setIcon(null);
            }

            if (count % 2 != 0) {

                dice = (int) (Math.random() * (6) + 1);
                System.out.println("dice: " + dice);
                if (dice == 1) {
                    Player1.setIcon(dice1);
                } else if (dice == 3) {
                    Player1.setIcon(dice3);
                } else if (dice == 4) {
                    Player1.setIcon(dice4);
                } else if (dice == 2) {
                    Player1.setIcon(dice2);
                } else if (dice == 5) {
                    Player1.setIcon(dice5);
                }

                dest = dice + start;
                start = dest;

                ////////////////////// CONDITION FOR DICE = 6 \\\\\\\\\\\\\\\\\\\\\\\
                if (dice == 6) {
                    Player1.setIcon(dice6);

                    if (dest >= 1 && dest <= 5) {
                        x = 4;
                        if (dest == 4) {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][dest - 1].next)][gety(node[x][dest - 1].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][dest - 1].next)][gety(node[x][dest - 1].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][dest - 1].next);
                            prevj = gety(node[x][dest - 1].next);
                            start = dest + 8;

                        } else {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][dest - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][dest - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = dest - 1;
                        }

                    } else if (dest >= 6 && dest <= 10) {
                        x = 3;
                        if (prevdest == dest2) {
                            cell[previ][prevj].setIcon(IconG2);
                        } else {
                            cell[previ][prevj].setIcon(null);
                        }
                        cell[x][10 - dest].setIcon(IconG);
                        if (dest == prevdest2) {
                            cell[x][10 - dest].setIcon(Stack);
                        }
                        previ = x;
                        prevj = 10 - dest;

                    } else if (dest >= 11 && dest <= 15) {
                        x = 2;
                        if (dest == 11) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][dest - 11].next)][gety(node[x][dest - 11].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][dest - 11].next)][gety(node[x][dest - 11].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][dest - 11].next);
                            prevj = gety(node[x][dest - 11].next);
                            start = dest + 10;
                        } else {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][dest - 10 - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][dest - 10 - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = dest - 10 - 1;

                        }
                    } else if (dest >= 16 && dest <= 20) {
                        x = 1;

                        if (dest == 16) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][20 - dest].next)][gety(node[x][20 - dest].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][20 - dest].next)][gety(node[x][20 - dest].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][20 - dest].next);
                            prevj = gety(node[x][20 - dest].next);
                            start = dest - 10;
                        } else {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][20 - dest].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][20 - dest].setIcon(Stack);
                            }
                            previ = x;
                            prevj = 20 - dest;
                        }
                    } else if (dest >= 21 && dest <= 25) {
                        x = 0;
                        if (dest == 24) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][(dest - 20) - 1].next)][gety(node[x][(dest - 20) - 1].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][(dest - 20) - 1].next)][gety(node[x][(dest - 20) - 1].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][(dest - 20) - 1].next);
                            prevj = gety(node[x][(dest - 20) - 1].next);
                            start = dest - 22;
                        } else if (dest == 25) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][(dest - 20) - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][(dest - 20) - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = (dest - 20) - 1;
                            JOptionPane.showMessageDialog(this, "GAME OVER \n Player 1 Wins",
                                    "", JOptionPane.PLAIN_MESSAGE);
                            
                        } else {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][(dest - 20) - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][(dest - 20) - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = (dest - 20) - 1;
                        }

                    }

                    if (dest > 25) {

                        start = dest - dice;
                        dest = dest - dice;

                    }
                    if (dest == 4) {
                        dest = 12;
                    }
                    if (dest == 11) {
                        dest = 21;
                    }

                    JOptionPane.showMessageDialog(this, "Player 1: Roll Dice one more time",
                            "", JOptionPane.PLAIN_MESSAGE);

                    prevdest = dest;
                } /////////////////CONDITION FOR DICE FROM 1 to 5 \\\\\\\\\\\\\\\\\
                else {
                    if (dest >= 1 && dest <= 5) {
                        x = 4;
                        if (dest == 4) {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][dest - 1].next)][gety(node[x][dest - 1].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][dest - 1].next)][gety(node[x][dest - 1].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][dest - 1].next);
                            prevj = gety(node[x][dest - 1].next);
                            start = dest + 8;
                        } else {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][dest - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][dest - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = dest - 1;
                        }

                    } else if (dest >= 6 && dest <= 10) {
                        x = 3;
                        if (prevdest == dest2) {
                            cell[previ][prevj].setIcon(IconG2);
                        } else {
                            cell[previ][prevj].setIcon(null);
                        }
                        cell[x][10 - dest].setIcon(IconG);
                        if (dest == prevdest2) {
                            cell[x][10 - dest].setIcon(Stack);
                        }
                        previ = x;
                        prevj = 10 - dest;

                    } else if (dest >= 11 && dest <= 15) {
                        x = 2;
                        if (dest == 11) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][dest - 11].next)][gety(node[x][dest - 11].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][dest - 11].next)][gety(node[x][dest - 11].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][dest - 11].next);
                            prevj = gety(node[x][dest - 11].next);
                            start = dest + 10;
                        } else {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][dest - 10 - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][dest - 10 - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = dest - 10 - 1;

                        }
                    } else if (dest >= 16 && dest <= 20) {
                        x = 1;

                        if (dest == 16) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][20 - dest].next)][gety(node[x][20 - dest].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][20 - dest].next)][gety(node[x][20 - dest].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][20 - dest].next);
                            prevj = gety(node[x][20 - dest].next);
                            start = dest - 10;
                        } else {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][20 - dest].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][20 - dest].setIcon(Stack);
                            }
                            previ = x;
                            prevj = 20 - dest;
                        }
                    } else if (dest >= 21 && dest <= 25) {
                        x = 0;
                        if (dest == 24) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[getx(node[x][(dest - 20) - 1].next)][gety(node[x][(dest - 20) - 1].next)].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[getx(node[x][(dest - 20) - 1].next)][gety(node[x][(dest - 20) - 1].next)].setIcon(Stack);
                            }
                            previ = getx(node[x][(dest - 20) - 1].next);
                            prevj = gety(node[x][(dest - 20) - 1].next);
                            start = dest - 22;
                        } else if (dest == 25) {

                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][(dest - 20) - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][(dest - 20) - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = (dest - 20) - 1;
                            JOptionPane.showMessageDialog(this, "     GAME OVER! \n      Player 1 Wins",
                                    "", JOptionPane.PLAIN_MESSAGE);
                            
                        } else {
                            if (prevdest == dest2) {
                                cell[previ][prevj].setIcon(IconG2);
                            } else {
                                cell[previ][prevj].setIcon(null);
                            }
                            cell[x][(dest - 20) - 1].setIcon(IconG);
                            if (dest == prevdest2) {
                                cell[x][(dest - 20) - 1].setIcon(Stack);
                            }
                            previ = x;
                            prevj = (dest - 20) - 1;
                        }

                    }

                    if (dest > 25) {

                        JOptionPane.showMessageDialog(this, "Player 1: Roll your Dice Again in next turn",
                                "", JOptionPane.PLAIN_MESSAGE);
                        start = dest - dice;
                        dest = dest - dice;

                    }
                    if (dest == 4) {
                        dest = 12;
                    }
                    if (dest == 11) {
                        dest = 21;
                    }
                    count++;
                }
                prevdest = dest;
                System.out.println("dest: " + start);
            } /////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////
            else {

                JOptionPane.showMessageDialog(this, "Player2's Turn",
                        "", JOptionPane.PLAIN_MESSAGE);

            }

        }

        ////////////////////////////////// PLAYER 2 \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        if (e.getSource() == Player2) {
            cell[4][0].setIcon(null);
            if (count % 2 == 0) {

                dice = (int) (Math.random() * (6) + 1);
                System.out.println("dice2: " + dice);
                if (dice == 1) {
                    Player2.setIcon(dice1);
                } else if (dice == 3) {
                    Player2.setIcon(dice3);
                } else if (dice == 4) {
                    Player2.setIcon(dice4);
                } else if (dice == 2) {
                    Player2.setIcon(dice2);
                } else if (dice == 5) {
                    Player2.setIcon(dice5);
                }

                dest2 = dice + start2;
                start2 = dest2;

                if (dice == 6) {
                    Player2.setIcon(dice6);

                    if (dest2 >= 1 && dest2 <= 5) {
                        x = 4;
                        if (dest2 == 4) {
                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][dest2 - 1].next)][gety(node[x][dest2 - 1].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][dest2 - 1].next)][gety(node[x][dest2 - 1].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][dest2 - 1].next);
                            prevj2 = gety(node[x][dest2 - 1].next);
                            start2 = dest2 + 8;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][dest2 - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][dest2 - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = dest2 - 1;
                        }

                    } else if (dest2 >= 6 && dest2 <= 10) {
                        x = 3;

                        if (prevdest2 == dest) {
                            cell[previ2][prevj2].setIcon(IconG);
                        } else {
                            cell[previ2][prevj2].setIcon(null);
                        }
                        cell[x][10 - dest2].setIcon(IconG2);
                        if (dest == dest2) {
                            cell[x][10 - dest2].setIcon(Stack);
                        }
                        previ2 = x;
                        prevj2 = 10 - dest2;
                    } else if (dest2 >= 11 && dest2 <= 15) {
                        x = 2;
                        if (dest2 == 11) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][dest2 - 11].next)][gety(node[x][dest2 - 11].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][dest2 - 11].next)][gety(node[x][dest2 - 11].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][dest2 - 11].next);
                            prevj2 = gety(node[x][dest2 - 11].next);
                            start2 = dest2 + 10;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][dest2 - 10 - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][dest2 - 10 - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = dest2 - 10 - 1;
                        }
                    } else if (dest2 >= 16 && dest2 <= 20) {
                        x = 1;

                        if (dest2 == 16) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][20 - dest2].next)][gety(node[x][20 - dest2].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][20 - dest2].next)][gety(node[x][20 - dest2].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][20 - dest2].next);
                            prevj2 = gety(node[x][20 - dest2].next);
                            start2 = dest2 - 10;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][20 - dest2].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][20 - dest2].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = 20 - dest2;
                        }

                    } else if (dest2 >= 21 && dest2 <= 25) {
                        x = 0;
                        if (dest2 == 24) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][(dest2 - 20) - 1].next)][gety(node[x][(dest2 - 20) - 1].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][(dest2 - 20) - 1].next)][gety(node[x][(dest2 - 20) - 1].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][(dest2 - 20) - 1].next);
                            prevj2 = gety(node[x][(dest2 - 20) - 1].next);
                            start2 = dest2 - 22;
                        } else if (dest2 == 25) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][(dest2 - 20) - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][(dest2 - 20) - 1].setIcon(Stack);
                            }
                            JOptionPane.showMessageDialog(this, "       GAME OVER! \n      Player 2 Wins",
                                    "", JOptionPane.PLAIN_MESSAGE);
                            
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][(dest2 - 20) - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][(dest2 - 20) - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = (dest2 - 20) - 1;
                        }
                    }
                    if (dest2 > 25) {
                        start2 = dest2 - dice;
                        dest2 = dest2 - dice;

                    }

                    if (dest2 == 4) {
                        dest2 = 12;
                    }
                    if (dest2 == 11) {
                        dest2 = 21;
                    }

                    JOptionPane.showMessageDialog(this, "Player 2: Roll Dice one more time",
                            "", JOptionPane.PLAIN_MESSAGE);
                    prevdest2 = dest2;

                } //////////////////////////////////////////////////////////////
                else {
                    if (dest2 >= 1 && dest2 <= 5) {
                        x = 4;
                        if (dest2 == 4) {
                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][dest2 - 1].next)][gety(node[x][dest2 - 1].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][dest2 - 1].next)][gety(node[x][dest2 - 1].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][dest2 - 1].next);
                            prevj2 = gety(node[x][dest2 - 1].next);
                            start2 = dest2 + 8;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][dest2 - 1].setIcon(IconG2);

                            if (dest == dest2) {
                                cell[x][dest2 - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = dest2 - 1;
                        }

                    } else if (dest2 >= 6 && dest2 <= 10) {
                        x = 3;

                        if (prevdest2 == dest) {
                            cell[previ2][prevj2].setIcon(IconG);
                        } else {
                            cell[previ2][prevj2].setIcon(null);
                        }
                        cell[x][10 - dest2].setIcon(IconG2);
                        if (dest == dest2) {
                            cell[x][10 - dest2].setIcon(Stack);
                        }
                        previ2 = x;
                        prevj2 = 10 - dest2;
                    } else if (dest2 >= 11 && dest2 <= 15) {
                        x = 2;
                        if (dest2 == 11) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][dest2 - 11].next)][gety(node[x][dest2 - 11].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][dest2 - 11].next)][gety(node[x][dest2 - 11].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][dest2 - 11].next);
                            prevj2 = gety(node[x][dest2 - 11].next);
                            start2 = dest2 + 10;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][dest2 - 10 - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][dest2 - 10 - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = dest2 - 10 - 1;
                        }
                    } else if (dest2 >= 16 && dest2 <= 20) {
                        x = 1;

                        if (dest2 == 16) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][20 - dest2].next)][gety(node[x][20 - dest2].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][20 - dest2].next)][gety(node[x][20 - dest2].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][20 - dest2].next);
                            prevj2 = gety(node[x][20 - dest2].next);
                            start2 = dest2 - 10;
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][20 - dest2].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][20 - dest2].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = 20 - dest2;
                        }

                    } else if (dest2 >= 21 && dest2 <= 25) {
                        x = 0;
                        if (dest2 == 24) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[getx(node[x][(dest2 - 20) - 1].next)][gety(node[x][(dest2 - 20) - 1].next)].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[getx(node[x][(dest2 - 20) - 1].next)][gety(node[x][(dest2 - 20) - 1].next)].setIcon(Stack);
                            }
                            previ2 = getx(node[x][(dest2 - 20) - 1].next);
                            prevj2 = gety(node[x][(dest2 - 20) - 1].next);
                            start2 = dest2 - 22;
                        } else if (dest2 == 25) {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }
                            cell[x][(dest2 - 20) - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][(dest2 - 20) - 1].setIcon(Stack);
                            }
                            JOptionPane.showMessageDialog(this, "GAME OVER! \n Player 2 Wins",
                                    "", JOptionPane.PLAIN_MESSAGE);
                            
                        } else {

                            if (prevdest2 == dest) {
                                cell[previ2][prevj2].setIcon(IconG);
                            } else {
                                cell[previ2][prevj2].setIcon(null);
                            }

                            cell[x][(dest2 - 20) - 1].setIcon(IconG2);
                            if (dest == dest2) {
                                cell[x][(dest2 - 20) - 1].setIcon(Stack);
                            }
                            previ2 = x;
                            prevj2 = (dest2 - 20) - 1;
                        }
                    }
                    if (dest2 > 25) {

                        JOptionPane.showMessageDialog(this, "Roll your Dice Again in next turn Player 2",
                                "", JOptionPane.PLAIN_MESSAGE);
                        start2 = dest2 - dice;
                        dest2 = dest2 - dice;

                    }
                    if (dest2 == 4) {
                        dest2 = 12;
                    }
                    if (dest2 == 11) {
                        dest2 = 21;
                    }
                    count++;
                }
                prevdest2 = dest2;
                System.out.println("dest2: " + start2);
            } ////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////
            else {
                JOptionPane.showMessageDialog(this, "Player1's Turn",
                        "", JOptionPane.PLAIN_MESSAGE);

            }

        }

    }

    public void printNode(int i, int j) {
        System.out.println(node[i][j]);
    }

    public void addladder(int ifrom, int jfrom, int ito, int jto) {

        node[ifrom][jfrom].next = node[ito][jto];
        flag = true;
    }

    public void addSnake(int ifrom, int jfrom, int ito, int jto) {

        node[ifrom][jfrom].next = node[ito][jto];
        flag = true;
    }

    public Node getNode(int i, int j) {
        return this.node[i][j];

    }

    public int getx(Node node) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (this.node[i][j] == node) {
                    return i;
                }
            }

        }
        return -1;
    }

    public int gety(Node node) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (this.node[i][j] == node) {
                    return j;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {

        GraphSL g = new GraphSL();
        //creating ladder from 4 to 12   
        g.addladder(4, 3, 2, 1);
        //creating ladder from 11 to 21 
        g.addladder(2, 0, 0, 0);

        //s- 16 to 6, 24 to 2
        //creating snake from 16 to 6
        g.addSnake(1, 4, 3, 4);

        //creating snake from 24 to 2
        g.addSnake(0, 3, 4, 1);
        //  System.out.println(dice);
        g.setVisible(true);

    }

}

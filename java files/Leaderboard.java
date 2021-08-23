/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

class Node2 {

    int data;
    int p;
    Node2 next;

    Node2() { // no argument constructor
        data = 0;
        next = null;
        p = 0;
    }

    Node2(int V, int P) { // one argument constructor
        data = V;
        next = null;
        p = P;
    }

    Node2(int V) { // one argument constructor
        data = V;
        next = null;

    }

}

public final class Leaderboard extends JFrame implements ActionListener {

    Node2 Head = null;
    public static int count = 0, f, s, t;
    public static int score = 0;
    public static int arr[];
    public static String fname, sname, tname;
    public static String namearr[];
    public static JScrollPane scrollPane;
    public static JPanel panel;
    public static JTable table;
    public static JButton ExitB, BackB;
    private static JLabel labels;

    Leaderboard() throws FileNotFoundException, IOException, Exception {

        File file = new File("players.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        BufferedReader br3 = new BufferedReader(new FileReader(file));

        //total number of lines
        while (br.readLine() != null) {
            count++;
        }

        if (count % 2 != 0) {
            count = count - 1;
        }

        //read only the integer values i.e. the score
        for (int i = 0; i <= (count + 2) / 2; i = i + 2) {
            br2.readLine();
            insert(Integer.valueOf(br2.readLine()));
        }

        //create a new array using elements of the queue
        arr = new int[count];
        namearr = new String[count];
        for (int i = 0; i < count; i = i + 2) {
            namearr[i] = br3.readLine();
            arr[i] = Integer.valueOf(br3.readLine());

        }
        //sort you array
        bubbleSort(arr);

        //top three positions
        f = arr[count - 1];
        s = arr[count - 2];
        t = arr[count - 3];

        fname = namearr[count - 1];
        sname = namearr[count - 2];
        tname = namearr[count - 3];

        //empty your queue
        Empty();

        //create a new queue        
        CreatePriorityQueue(f, 1);
        CreatePriorityQueue(s, 2);
        CreatePriorityQueue(t, 3);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        setTitle("Anagram - Leaderboard");
        setBackground(Color.WHITE);

        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Leader Board", TitledBorder.CENTER, TitledBorder.TOP));

        ExitB = new JButton("EXIT");
        ExitB.setBounds(150, 100, 70, 30);
        ExitB.setBackground(Color.BLACK);
        ExitB.setForeground(Color.WHITE);
        ExitB.addActionListener(this);
        add(ExitB);

        //creating button to go back
        BackB = new JButton("BACK");
        BackB.setBounds(240, 100, 70, 30);
        BackB.setBackground(Color.BLACK);
        BackB.setForeground(Color.WHITE);
        BackB.addActionListener(this);
        add(BackB);

        Object[][] data = {
            {"1", namearr[count - 1], dequeue()},
            {"2", namearr[count - 2], dequeue()},
            {"3", namearr[count - 3], dequeue()}};
        String[] header = {"Position", "Player's Name", "Score"};
        table = new JTable(data, header);
        panel.add(table);

        add(panel);
        this.setSize(480, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public int dequeue() throws Exception {
        Node2 Temp = Head;
        if (Head == null) {
            throw new Exception();
        } else {
            Head = Head.next;
        }
        return Temp.data;
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j];
                    String tempname = namearr[j];
                    arr[j] = arr[j + 1];
                    namearr[j] = namearr[j + 1];
                    arr[j + 1] = temp;
                    namearr[j + 1] = tempname;
                }
            }
        }

    }

    public void insert(int data) {
        Node2 N = new Node2(data);
        Node2 Temp = null;
        if (Head == null) {
            Head = N;
        } else {
            Temp = Head;
            while (Temp.next != null) {
                Temp = Temp.next;
            }
            Temp.next = N;
        }
    }

    public void CreatePriorityQueue(int data, int p) {
        Node2 NewNode = new Node2(data, p);

        Node2 current;

        if (Head == null) {
            Head = NewNode;     // if list is empty  
        } else if (Head.p > NewNode.p) { //need to place before the first node
            NewNode.next = Head;
            Head = NewNode;
        } else if (Head.p == NewNode.p) {
            //insert new node after head!
            NewNode.next = Head.next;
            Head.next = NewNode;

        } else {
            current = Head;
            // locate the node after which the new node is to be inserted   
            while (current.next != null && (current.next.p <= NewNode.p)) {
                if (current.next.p == NewNode.p) {
                    current = current.next;// Now this is the node we wanna insert the newnode after.
                    NewNode.next = current.next;
                    current.next = NewNode;

                    break;
                }
                current = current.next;
            }

            NewNode.next = current.next;
            current.next = NewNode;

        }

    }

    public void Empty() {
        Head = null;
    }

    public void DisplayPriorityQueue() {
        Node2 Temp = Head;
        while (Temp != null) {
            Temp = Temp.next;
        }
    }

    public void actionPerformed(ActionEvent ae) {

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

    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        Leaderboard L = new Leaderboard();
        L.DisplayPriorityQueue();

    }

}

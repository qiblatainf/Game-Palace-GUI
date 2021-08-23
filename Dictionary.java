/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dictionary {

    public static void main(String[] args) throws IOException {

////////////////////Reading from the Original Dictionary\\\\\\\\\\\\\\\\\\\\\\\
        File file = new File("Dictionary.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

///////////Creating a new dictionary of six letters words\\\\\\\\\\\\\\\\\\\\\\\
        File Bfile = new File("sixletters.txt");// creating a new file
        FileWriter writer = new FileWriter(Bfile);
        BufferedWriter bw = new BufferedWriter(writer);

        File B2file = new File("fourletters.txt");// creating a new file
        FileWriter writer2 = new FileWriter(B2file);
        BufferedWriter bw2 = new BufferedWriter(writer2);
        
        File B3file = new File("nineletters.txt");// creating a new file
        FileWriter writer3 = new FileWriter(B3file);
        BufferedWriter bw3 = new BufferedWriter(writer3);

        int nwords = 0;
        int nwords4 = 0;
        int nwords9 = 0;
        String st;
        while ((st = br.readLine()) != null)// reading lines till no more lines left
        {
            if (st.length() == 6)//// extracting six letter words
            {
                bw.write(st); //// writing words in the new file
                bw.newLine();
                nwords++; // counting the number of six letter words
            }

            if (st.length() == 4)//// extracting four letter words
            {
                bw2.write(st); //// writing words in the new file
                bw2.newLine();
                nwords4++; // counting the number of nine letter words
            }
            
            if (st.length() == 9)//// extracting nine letter words
            {
                bw3.write(st); //// writing words in the new file
                bw3.newLine();
                nwords9++; // counting the number of nine letter words
            }

        }

        bw.close();
        bw2.close();
        bw3.close();

        System.out.println(nwords);
        System.out.println(nwords4);
        System.out.println(nwords9);

    }

}

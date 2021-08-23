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

    import java.util.ArrayList;
public class Node {

     ArrayList<Node> neighbour;
     Node next;
     
      public Node(){
              //  isVisited = false;
              //  isWall = false;
                this.neighbour = new ArrayList<Node>();
        }     
    
}



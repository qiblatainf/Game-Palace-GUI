/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsproject;

import java.util.Stack;

/**
 *
 * @author hp
 */
public class Player {
    Stack<String> STACK1;
    Stack<String> STACK2= new Stack<String>();
    
    public Player(){
        STACK1 = new Stack<String>();
    }
    
    public void getCard(String aCard){
        STACK1.push(aCard);
    }
    
    public void insertatstart(String aCard){
        while (!STACK1.isEmpty()){
            STACK2.push(STACK1.pop());
        }
        
        STACK1.push(aCard);
        
         while (!STACK2.isEmpty()){
            STACK1.push(STACK2.pop());
        }
        
    }
    
    public String playCard(){
        return STACK1.pop();
    }    
    
    public int cardCount(){
        return STACK1.size();
    }
    
    public boolean isEmpty(){
        if (STACK1.size()>0)
        return false;
        
        else 
            return true;
    }
    
    public Stack getstack(){
        return STACK1;
    }
}

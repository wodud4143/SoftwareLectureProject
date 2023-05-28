/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MementoPattern;

/**
 *
 * @author Lee
 */
public class Originator {
    String state1;
    int state2;
    
    public Memento createMemento(){
        return new Memento(state1,state2);
    }
    
    public void restoreMemento (Memento memento){
        this.state1 = memento.getState1();
        this.state2 = memento.getState2();
    }

    public String getState1() {
        return state1;
    }
    
    public int getState2() {
        return state2;
    }

    public void setState(String state1,int state2) {
        this.state1 = state1;
        this.state2 = state2;
    }

    
    
}

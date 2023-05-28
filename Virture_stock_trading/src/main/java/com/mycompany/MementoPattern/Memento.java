/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MementoPattern;

/**
 *
 * @author Lee
 */
public class Memento {
    private String state1;
    private int state2;
    
    public Memento(String state1 ,int state2){
        this.state1 = state1;
        this.state2 = state2;
    }

    public String getState1() {
        return state1;
    }
    
    public int getState2() {
        return state2;
    }
}

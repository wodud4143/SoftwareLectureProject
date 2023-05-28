/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MementoPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Lee
 */
public class CareTaker {
    private Stack<Memento> mementoList = new Stack<>();
    
    public void push(Memento state){
        mementoList.push(state);
    }
    
    public Memento pop(){
        return mementoList.pop();
    }
}

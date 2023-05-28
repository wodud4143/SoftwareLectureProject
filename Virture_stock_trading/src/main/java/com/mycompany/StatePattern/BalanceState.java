/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StatePattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;

/**
 *
 * @author user
 */
public interface BalanceState {
    public void buy(Stock stock, User user);

}

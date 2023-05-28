/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StatePattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;
import javax.swing.JOptionPane;
import static com.mycompany.layout.StockChart.power;

/**
 *
 * @author user
 */
public class NeedBalance implements BalanceState{
    
    @Override
    public void buy(Stock stock, User user){
        power = false;
        System.out.println("잔액이 부족하여 주식을 구매할 수 없습니다.");
        JOptionPane.showMessageDialog(null, "잔액이 부족하여 주식을 구매할 수 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StatePattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Manager {
    
    public void checkState(Stock stock, User user){
        System.out.println(stock.getPrice());
        BalanceManager manager = new BalanceManager();
        
        String WithdrawalMoney = JOptionPane.showInputDialog(null, "매수 개수를 입력해주세요 ");
        Double WithdrawalMoney_D = Double.valueOf(WithdrawalMoney);
        int Stock_Quantity = (int) Math.round(WithdrawalMoney_D);
        stock.setQuantity(Stock_Quantity);
        
        //User user = User.getInstance(); //유저 정보 가져오기
        if (user.getBalance() >= stock.getPrice()*stock.getQuantity()) {//유저의 잔액이 금액보다 많이 있으면
            manager.setCurrent(stock ,  new FullBalance(), user);
            
            

        } else {
            manager.setCurrent(stock, new NeedBalance(), user);
        }

    }
}

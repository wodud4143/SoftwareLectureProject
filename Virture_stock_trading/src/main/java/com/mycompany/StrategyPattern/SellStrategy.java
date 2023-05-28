/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StrategyPattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author ijaeyeong
 */
public class SellStrategy implements TradeStrategy {

    double balance;

    @Override
    public void executeTrade(Stock stock, User user) {
        if (user.getStocks()==null) {
            JOptionPane.showMessageDialog(null, "판매 할 주식이 없습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int index = 0;
            boolean isStock = false;

            JSONObject jsonObject = new JSONObject();
            for (Object obj : user.getStocks()) {
                jsonObject = (JSONObject) obj;
                
                if(jsonObject.containsKey("StockName") && jsonObject.get("StockName").equals(stock.getName())) {
                    isStock = true;
                    break;
                }
                index++;
            }
            
            // 해당 주식이 있는지 검색
            if (isStock) {
                // 보유 주식량이 판매 주식량 보다 많거나 같을 때  
                if (Integer.parseInt(jsonObject.get("StockQuantity").toString()) >= stock.getQuantity()) {
                    //보유 주식량과 판매량이 같을 때  
                    if (Integer.parseInt(jsonObject.get("StockQuantity").toString()) == stock.getQuantity()) {

                        user.removeStock(index);

                        System.out.println(user.getStocks());
                        balance = user.getBalance() + (stock.getPrice() * stock.getQuantity());
                        user.setBalance(balance);
                    } //보유 주식량이 더 많을 때 
                    else {
                        jsonObject.replace("StockQuantity", Integer.parseInt(jsonObject.get("StockQuantity").toString()) - stock.getQuantity());
                        System.out.println(user.getStocks());
                        balance = user.getBalance() + (stock.getPrice() * stock.getQuantity());
                        user.setBalance(balance);
                    }
                    JOptionPane.showMessageDialog(null, "주식이 판매 되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                } // 판매 할 주식량이 보유 주식량 보다 많을 때 
                else {
                    JOptionPane.showMessageDialog(null, "보유 수량이 적습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                }
            } //해당 주식을 보유하고 있지 않을 때  
            else {
                JOptionPane.showMessageDialog(null, "해당 주식을 보유하고 있지 않습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
}

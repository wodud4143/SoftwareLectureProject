/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StrategyPattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author ijaeyeong
 */
public class BuyStrategy implements TradeStrategy {

    double balance;
    JSONObject stocks = new JSONObject();

    @Override
    public void executeTrade(Stock stock, User user) {

        // 처음 주식을 살 때  
        if (user.getStocks() == null) {
            JSONArray newStock = new JSONArray();
            stocks.put("StockName", stock.getName());
            stocks.put("StockPrice", stock.getPrice());
            stocks.put("StockQuantity", stock.getQuantity());
            newStock.add(stocks);
            
            

            user.putStock(newStock);
        } // Stocks가 존재 할 때
        else {
            JSONObject jsonObject = new JSONObject();
            boolean isStock = false;

            for (Object obj : user.getStocks()) {
                jsonObject = (JSONObject) obj;
                if (jsonObject.containsKey("StockName") && jsonObject.get("StockName").equals(stock.getName())) {
                    isStock = true;
                    break;
                }
            }
            // 해당 주식을 보유하고 있을 때 
            if (isStock) {
                System.out.println("해당 주식 보유 중일때");
                //주식 평단가 계산  
                double price = (Double.parseDouble(jsonObject.get("StockPrice").toString()) + stock.getPrice()) / 2;
                //수량 수정
                jsonObject.replace("StockQuantity", Integer.parseInt(jsonObject.get("StockQuantity").toString()) + stock.getQuantity());
                //단가 수정
                jsonObject.replace("StockPrice", price);
            } //해당 주식을 보유하고 있지 않을 때  
            else {
                System.out.println("해당 주식 보유하고 있지 않을 때");
                System.out.println(stock.getName());
                System.out.println(stock.getPrice());
                System.out.println(stock.getQuantity());
                stocks.put("StockName", stock.getName());
                stocks.put("StockPrice", stock.getPrice());
                stocks.put("StockQuantity", stock.getQuantity());

                user.setStocks(stocks);

            }

        }
        
        
        System.out.println(stocks);
        System.out.println(user.getStocks());
        user.setBalance(user.getBalance() - (stock.getPrice()*stock.getQuantity()));
        
    }
}

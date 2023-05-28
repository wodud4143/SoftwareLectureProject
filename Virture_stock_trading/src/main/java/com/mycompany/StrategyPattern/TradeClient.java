/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StrategyPattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;

/**
 *
 * @author ijaeyeong
 */
public class TradeClient {
    
    private TradeStrategy tradeStrategy;

    public void setTradeStrategy(TradeStrategy tradeStrategy) {
        this.tradeStrategy = tradeStrategy;
    }

    public void executeTrade(Stock stock, User user) {
        tradeStrategy.executeTrade(stock, user);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.SingletonPattern;

import java.util.ArrayList;

/**
 *
 * @author ijaeyeong
 */
public class User {
    private static User instance = null;
    private String name;
    private String id;
    private String password;
    private double balance; // 보유자산
    private ArrayList<String> stocks;
    private double profit; // 수익률
    private double totalStockValue; // 총 주식가격 합산

    private User() {

    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    // Getters and setters for all attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<String> stocks) {
        this.stocks = stocks;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTotalStockValue() {
        return totalStockValue;
    }

    public void setTotalStockValue(double totalStockValue) {
        this.totalStockValue = totalStockValue;
    }
}

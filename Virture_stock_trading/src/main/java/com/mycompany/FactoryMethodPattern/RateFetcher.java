/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.FactoryMethodPattern;

/**
 *
 * @author 정원
 */
public class RateFetcher implements Runnable{
    private Rate rate;
    
    public RateFetcher(Rate rate) {
        this.rate = rate;
    }
    
    @Override
    public void run() {
        try {
            String exchangeRate = rate.getRate();
            System.out.println("현재 환율 = " + exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.StatePattern;

import com.mycompany.SingletonPattern.Stock;
import com.mycompany.SingletonPattern.User;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static com.mycompany.layout.StockChart.power;

/**
 *
 * @author user
 */
public class FullBalance implements BalanceState {

    double balance;

    @Override
    public void buy(Stock stock, User user) {
        power = true;
        System.out.println("full.");
        JOptionPane.showMessageDialog(null, "주식 구매가 완료 되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(user.getStocks());
        System.out.println(user.getBalance());
        System.out.println(stock.getPrice());
    }

}

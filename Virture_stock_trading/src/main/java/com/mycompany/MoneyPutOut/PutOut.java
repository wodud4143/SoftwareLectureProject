/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MoneyPutOut;

import java.io.FileReader;
import com.mycompany.MvcPattern.SignUp;
import com.mycompany.MvcPattern.SignUpController;
import com.mycompany.layout.stock_search;
import java.io.FileReader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author user
 */
public class PutOut {
     private JSONArray readJsonFile() {
        JSONParser parser = new JSONParser();
        JSONArray json = null;
        try {
            FileReader reader = new FileReader("users.json");
            json = (JSONArray) parser.parse(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    
}

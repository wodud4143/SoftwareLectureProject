/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dataUpdate;

import com.mycompany.SingletonPattern.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataUpdate {

    User user = User.getInstance();

    public DataUpdate() {
        String targetId = user.getId();
        String targetPassword = user.getPassword();

        
        

        try {
            // JSON 파일 읽기
            FileReader fileReader = new FileReader("users.json");
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            fileReader.close();

            // JSON 데이터 수정
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                String id = (String) jsonObject.get("id");
                String password = (String) jsonObject.get("password");

                if (id.equals(targetId) && password.equals(targetPassword)) {
                    // 일치하는 id와 password를 가진 객체의 balance 수정
                    jsonObject.put("balance", user.getBalance());
                    jsonObject.put("Stocks",user.getStocks());
                    jsonObject.put("WishStocks", user.getWishStocks());
                    break; // 해당 객체를 찾았으므로 반복문 종료
                }
            }

            // 수정된 JSON 데이터 파일에 덮어쓰기
            FileWriter fileWriter = new FileWriter("users.json");
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();

            System.out.println("balance 수정 완료.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

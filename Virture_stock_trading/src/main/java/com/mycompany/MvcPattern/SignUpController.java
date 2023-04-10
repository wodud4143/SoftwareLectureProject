/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 테스트123123*/
package com.mycompany.MvcPattern;

/**
 *
 * @author ijaeyeong
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;
import com.mycompany.SingletonPattern.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SignUpController {
    private SignUp view;
    private Gson gson;

    public SignUpController(SignUp view) {
        this.view = view;
        this.gson = new Gson();

        this.view.getSubmitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = view.getUsernameField().getText();
        String userId = view.getUserIdField().getText();
        String password = new String(view.getPasswordField().getPassword());

        User user = User.getInstance();
        user.setPassword(password);
        user.setName(username);
        user.setId(userId);
        saveUserToFile(user);
    }

    private void saveUserToFile(User user) {
        if(SignUp.doubleCheck > 0){
            try {
            JSONArray users;

            // 파일에서 기존 데이터 읽어오기
            File file = new File("users.json");
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                users = (JSONArray) parser.parse(new FileReader(file));
            } else {
                users = new JSONArray();
            }

            // 새로운 유저 데이터 추가
            JSONObject userData = new JSONObject();
            userData.put("id", user.getId());
            userData.put("username", user.getName());
            userData.put("password", user.getPassword());
            users.add(userData);

            // 파일에 데이터 쓰기
            Files.write(Paths.get("users.json"), (users.toJSONString() + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
            catch (IOException | ParseException ex) {
            ex.printStackTrace();
            }
        }
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Clllllick nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserEdit;

import com.mycompany.SingletonPattern.User;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ijaeyeong
 */
public class UserEdit {

    UserEdit() {
        try {
            User user = User.getInstance();
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
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }

}

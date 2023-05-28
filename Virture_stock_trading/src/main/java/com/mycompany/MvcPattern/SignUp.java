/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.MvcPattern;

import com.mycompany.MvcPattern.SignUpController;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yunch
 */
public class SignUp extends javax.swing.JFrame {
    public static int doubleCheck = 0;
    /**
     * Creates new form NewJFrameNewid
     */
    public SignUp() {
        
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        get_id = new javax.swing.JTextField();
        idcheck = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        get_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        password_state = new javax.swing.JLabel();
        get_repassword = new javax.swing.JPasswordField();
        get_password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel1.setText("회원가입");

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel2.setText("아이디");

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel3.setText("비밀번호");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel4.setText("비밀번호 확인");

        get_id.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        get_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_idActionPerformed(evt);
            }
        });

        idcheck.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        idcheck.setText("중복확인");
        idcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcheckActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        registerButton.setText("가입완료하기");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        get_username.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel5.setText("이름");

        get_repassword.setMinimumSize(new java.awt.Dimension(64, 28));
        get_repassword.setPreferredSize(new java.awt.Dimension(64, 28));
        get_repassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                get_repasswordKeyReleased(evt);
            }
        });

        get_password.setMinimumSize(new java.awt.Dimension(64, 28));
        get_password.setPreferredSize(new java.awt.Dimension(64, 28));
        get_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(registerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(get_repassword, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(get_password, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(get_username, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(get_id, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)))
                .addComponent(idcheck)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(password_state, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(get_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(get_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idcheck)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(get_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(get_repassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(password_state)
                .addGap(55, 55, 55)
                .addComponent(registerButton)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcheckActionPerformed
        try {
            JSONArray users;
            File file = new File("users.json");
            // 파일에서 데이터 읽어오기
            /*JSONParser parser = new JSONParser();
            JSONArray users = (JSONArray) parser.parse(new FileReader("users.json"));
            boolean duplicate = false;*/
            boolean duplicate = false;
            if (file.exists()) {
                JSONParser parser = new JSONParser();
                users = (JSONArray) parser.parse(new FileReader(file));

                for (Object user : users) {
                    JSONObject obj = (JSONObject) user;
                    if (obj.get("id").equals(get_id.getText())) {
                        // 중복된 아이디가 있음
                        duplicate = true;
                        break;
                    }
                }

            }

            if (duplicate) {
                JOptionPane.showMessageDialog(this, "중복된 아이디입니다.", "알림", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
                doubleCheck++;
            }
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_idcheckActionPerformed

    private void get_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_get_idActionPerformed

    private void get_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_get_passwordActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
         if (doubleCheck > 0) {
            JOptionPane.showMessageDialog(this, "회원가입 성공!", "알림", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "아이디 중복확인을 해주세요", "알림", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void get_repasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_get_repasswordKeyReleased
        String password = new String(get_password.getPassword());
                String get_repassword = new String(SignUp.this.get_repassword.getPassword());
                if (password.equals(get_repassword)) {
                    password_state.setText("비밀번호가 일치합니다.");
                    password_state.setForeground(Color.BLUE);
                } else {
                    password_state.setText("비밀번호가 일치하지 않습니다.");
                    password_state.setForeground(Color.RED);
                }
    }//GEN-LAST:event_get_repasswordKeyReleased

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SignUp view =  new SignUp();
                SignUpController controller= new SignUpController(view);
                view.setVisible(true);
            }
        });
    }
    
        public static void dearmain(){
        
    }
        
         public JTextField getUserIdField() {
        return get_id;
    }

    public JPasswordField getPasswordField() {
        return get_password;
    }

    public JTextField getUsernameField() {
        return get_username;
    }

    public JButton getSubmitButton() {
        return registerButton;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField get_id;
    private javax.swing.JPasswordField get_password;
    private javax.swing.JPasswordField get_repassword;
    private javax.swing.JTextField get_username;
    private javax.swing.JButton idcheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel password_state;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
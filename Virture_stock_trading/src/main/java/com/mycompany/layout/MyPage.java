/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.layout;

import com.mycompany.MementoPattern.CareTaker;
import com.mycompany.MementoPattern.Originator;
import com.mycompany.SingletonPattern.User;
import com.mycompany.multiThread.MultiThread;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;

/**
 *
 * @author yunch
 */
public class MyPage extends javax.swing.JFrame {

    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();
    User user = User.getInstance();
    List<MultiThread> mThread = new ArrayList<MultiThread>();

    /**
     * Creates new form mypage
     */
    public MyPage() {
        initComponents();

        if (user.getStocks() != null) {
            for (int i = 0; i < user.getStocks().size(); i++) {
                JSONObject jsonObject = (JSONObject) user.getStocks().get(i);
                String name = jsonObject.get("StockName").toString();

                MultiThread th = new MultiThread(name, i);
                mThread.add(th);

                mThread.get(i).start();
            }
        }

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
        get_id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Deposit = new javax.swing.JButton();
        Withdrawal = new javax.swing.JButton();
        get_money = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        removeButt = new javax.swing.JButton();
        restoreButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("굴림", 0, 36)); // NOI18N
        jLabel1.setText("내 정보");

        get_id.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        get_id.setText(user.getId());

        jLabel3.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel3.setText("보유자금:");

        Deposit.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        Deposit.setText("입금하기");
        Deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositActionPerformed(evt);
            }
        });

        Withdrawal.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        Withdrawal.setText("출금하기");
        Withdrawal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WithdrawalActionPerformed(evt);
            }
        });

        get_money.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        get_money.setText(user.getBalance()+"원");

        jLabel7.setFont(new java.awt.Font("굴림", 0, 24)); // NOI18N
        jLabel7.setText("아이디:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("보유주식");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("주식이름");
        model.addColumn("평단가");
        model.addColumn("개수");
        model.addColumn("현재가격");
        model.addColumn("수익률");
        if(user.getStocks() != null){
            for (int i = 0; i < user.getStocks().size(); i++) {
                JSONObject jsonObject = (JSONObject)user.getStocks().get(i);
                String name = jsonObject.get("StockName").toString();
                double price = (double)jsonObject.get("StockPrice");
                int quantity = Integer.parseInt(jsonObject.get("StockQuantity").toString());
                model.addRow(new Object[]{name, price, quantity});
            }
        }
        stockList.setModel(model);
        jScrollPane1.setViewportView(stockList);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        DefaultListModel<String> model2 = new DefaultListModel<>();

        if(user.getWishStocks() != null){
            for (int i = 0; i < user.getWishStocks().size(); i++) {
                JSONObject jsonObject = (JSONObject)user.getWishStocks().get(i);
                String name = jsonObject.get("Name").toString();
                model2.addElement(name);
            }
        }
        jList1.setModel(model2);
        jScrollPane2.setViewportView(jList1);

        jLabel4.setText("관심 목록");

        removeButt.setText("삭제");
        removeButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtActionPerformed(evt);
            }
        });

        restoreButt.setText("되돌리기");
        restoreButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(386, 386, 386)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Deposit)
                        .addGap(18, 18, 18)
                        .addComponent(Withdrawal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(get_id, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(get_money, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(restoreButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(get_id, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(get_money, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Deposit, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(Withdrawal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeButt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(restoreButt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void WithdrawalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WithdrawalActionPerformed
        // TODO add your handling code here:
        String WithdrawalMoney = JOptionPane.showInputDialog(this, "출금하실 금액을 입력해주세요");
        double WithdrawalMoney_D = Double.parseDouble(WithdrawalMoney);
        if (user.getBalance() < WithdrawalMoney_D) {
            JOptionPane.showMessageDialog(this, "잔액이 부족합니다", "알림", JOptionPane.INFORMATION_MESSAGE);
        } else {
            user.setBalance(user.getBalance() - WithdrawalMoney_D);
            get_money.setText(user.getBalance() + "원");
        }


    }//GEN-LAST:event_WithdrawalActionPerformed

    private void DepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositActionPerformed
        // TODO add your handling code here:
        String DepositMoney = JOptionPane.showInputDialog(this, "입금하실 금액을 입력해주세요");
        double DepositMoney_D = Double.parseDouble(DepositMoney);
        user.setBalance(user.getBalance() + DepositMoney_D);
        get_money.setText(user.getBalance() + "원");

    }//GEN-LAST:event_DepositActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println(user.getStocks());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        for (int i = 0; i < mThread.size(); i++) {
            mThread.get(i).stop();
        }
    }//GEN-LAST:event_formWindowClosed

    private void removeButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtActionPerformed

        originator.setState(jList1.getSelectedValue(), jList1.getSelectedIndex());
        careTaker.push(originator.createMemento());
        System.out.println("Current State: " + originator.getState1() + originator.getState2());
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        model.removeElementAt(jList1.getSelectedIndex());
        user.getWishStocks().remove(originator.getState2());
        System.out.println(user.getWishStocks());
    }//GEN-LAST:event_removeButtActionPerformed

    private void restoreButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreButtActionPerformed

        
        originator.restoreMemento(careTaker.pop());
        System.out.println("복구된  이름: " + originator.getState1() +  "복구된 인덱스: " + originator.getState2());
        DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
        model.add(originator.getState2(), originator.getState1());
        JSONObject obj = new JSONObject();
        obj.put("Name",originator.getState1());
        user.getWishStocks().add(originator.getState2(), obj);
        System.out.println(user.getWishStocks());
    }//GEN-LAST:event_restoreButtActionPerformed

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
            java.util.logging.Logger.getLogger(MyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deposit;
    private javax.swing.JButton Withdrawal;
    private javax.swing.JLabel get_id;
    private javax.swing.JLabel get_money;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeButt;
    private javax.swing.JButton restoreButt;
    public static javax.swing.JTable stockList;
    // End of variables declaration//GEN-END:variables
}
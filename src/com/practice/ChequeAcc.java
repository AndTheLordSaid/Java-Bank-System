/*
 * Created by JFormDesigner on Sun Nov 29 16:14:06 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 */
public class ChequeAcc {
    private JDBC datba;
    JFrame adFrame;
    Connection con;
    PreparedStatement pst;
    ResultSet rset;
    Statement stmt;

    public ChequeAcc() {
        initComponents();
        con=JDBC.dbConnect();
        adFrame = new JFrame();
        adFrame.setTitle("Client: Open Cheque Account");
        adFrame.add(chqAcc);//name of panel
        adFrame.pack();
        adFrame.setSize(579, 657);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccPicker accPicker = new AccPicker(datba);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen atmAuthen = new ATMAuthen(datba);
    }

    private void searchingBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill the ID Field!","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try{
                String id = IDField.getText();
                String sql="select Balance from chequeingaccount where CheID='"+ id + "'";
                stmt=con.prepareStatement(sql);
                rset=stmt.executeQuery(sql);
                if (rset.next()){
                    Double currentBal = rset.getDouble("Balance");
                    CurentBalanField.setText(String.valueOf(currentBal));
                }
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Your Chequeing Account Was Not Found","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DepoBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && DeposAmountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill The ID Field And The Deposit Amount Field!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String balance = CurentBalanField.getText();
            String amount = DeposAmountField.getText();
            try{
                Double sumA = Double.parseDouble(amount) + Double.parseDouble(balance);
                String sumB = String.valueOf(sumA);
                DepoTotalField.setText(sumB);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit Failed: Please Enter Numbers Only!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DepoAcceptBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && CurentBalanField.getText().isEmpty() && DeposAmountField.getText().isEmpty() && DepoTotalField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill In the Spaces!","Alert!",JOptionPane.WARNING_MESSAGE);
        }else {
            String id = IDField.getText();
            String deposTotal = DepoTotalField.getText();
            try {
                String sql = "update chequeingaccount set balance='" + deposTotal + "'where customers_ID='" + id + "'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deposit SuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);
                CurentBalanField.setText("");
                DeposAmountField.setText("");
                DepoTotalField.setText("");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit UnSuccessFul: Enter Numbers! ", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void WithdBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && WithdrawAmountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill The ID Field And The Withdraw Amount Field!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String balance = CurentBalanField.getText();
            String amount = WithdrawAmountField.getText();
            try {
                Double a = Double.parseDouble(amount);
                Double b = Double.parseDouble(balance);
                Double sumA;
                String sumB;

                if (a <= b) {
                    sumA = b - a;
                    sumB = String.valueOf(sumA);
                    WithdrawTotalField.setText(sumB);
                } else if (a > b) {
                    JOptionPane.showMessageDialog(null, "Withdraw Failed: Cannot Withdraw More Than Your Current Balance", "Alert!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit Failed: Please Enter Numbers Only!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void WithdAcceptBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && CurentBalanField.getText().isEmpty() && WithdrawAmountField.getText().isEmpty() && WithdrawTotalField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Fill In the Spaces!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String id = IDField.getText();
            String withdrawTotal = WithdrawTotalField.getText();
            try {
                String sql = "update chequeingaccount set balance='" + withdrawTotal + "'where customers_ID='" + id + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Withdraw SuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);
                CurentBalanField.setText("");
                WithdrawAmountField.setText("");
                WithdrawTotalField.setText("");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Withdraw UnSuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);

            }

        }
    }

    private void clearAllBTNActionPerformed(ActionEvent e) {
        IDField.setText("");
        CurentBalanField.setText("");
        DeposAmountField.setText("");
        DepoTotalField.setText("");
        WithdrawAmountField.setText("");
        WithdrawTotalField.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        chqAcc = new JPanel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label5 = new JLabel();
        label1 = new JLabel();
        label3 = new JLabel();
        IDField = new JTextField();
        label6 = new JLabel();
        CurentBalanField = new JTextField();
        label4 = new JLabel();
        DeposAmountField = new JTextField();
        label7 = new JLabel();
        WithdrawAmountField = new JTextField();
        label8 = new JLabel();
        DepoTotalField = new JTextField();
        label9 = new JLabel();
        WithdrawTotalField = new JTextField();
        backBTN = new JButton();
        logoutBTN = new JButton();
        searchingBTN = new JButton();
        DepoBTN = new JButton();
        DepoAcceptBTN = new JButton();
        WithdBTN = new JButton();
        WithdAcceptBTN = new JButton();
        clearAllBTN = new JButton();

        //======== chqAcc ========
        {
            chqAcc.setBackground(Color.white);
            chqAcc.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder ( 0
            , 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM
            , new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,
            chqAcc. getBorder () ) ); chqAcc. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("CHEQUEING ACCOUNT");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                //---- label5 ----
                label5.setText("Please Enter Your Ac/n Then Search, Before Deposits & Withdrawls");
                label5.setForeground(Color.white);
                label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(43, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addGap(24, 24, 24))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(164, 164, 164))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label5)
                            .addContainerGap(11, Short.MAX_VALUE))
                );
            }

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //---- label3 ----
            label3.setText("Enter Account Number");
            label3.setForeground(new Color(102, 102, 102));
            label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- IDField ----
            IDField.setBackground(new Color(153, 153, 153));
            IDField.setForeground(Color.white);

            //---- label6 ----
            label6.setText("Current Balance");
            label6.setForeground(new Color(102, 102, 102));
            label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- CurentBalanField ----
            CurentBalanField.setBackground(new Color(153, 153, 153));
            CurentBalanField.setForeground(Color.black);
            CurentBalanField.setEditable(false);

            //---- label4 ----
            label4.setText("Enter Amount You Want To Deposit");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- DeposAmountField ----
            DeposAmountField.setForeground(Color.white);
            DeposAmountField.setBackground(new Color(153, 153, 153));

            //---- label7 ----
            label7.setText("Enter The Amount You Want To Withdraw");
            label7.setForeground(new Color(102, 102, 102));
            label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- WithdrawAmountField ----
            WithdrawAmountField.setForeground(Color.white);
            WithdrawAmountField.setBackground(new Color(153, 153, 153));

            //---- label8 ----
            label8.setText("Balance After Deposit");
            label8.setForeground(new Color(102, 102, 102));
            label8.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- DepoTotalField ----
            DepoTotalField.setForeground(Color.black);
            DepoTotalField.setBackground(new Color(153, 153, 153));
            DepoTotalField.setEditable(false);

            //---- label9 ----
            label9.setText("Balance After Withdrawl");
            label9.setForeground(new Color(102, 102, 102));
            label9.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- WithdrawTotalField ----
            WithdrawTotalField.setForeground(Color.black);
            WithdrawTotalField.setBackground(new Color(153, 153, 153));
            WithdrawTotalField.setEditable(false);

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.setForeground(Color.white);
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            //---- searchingBTN ----
            searchingBTN.setText("SEARCH");
            searchingBTN.setForeground(Color.white);
            searchingBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            searchingBTN.setBackground(new Color(153, 153, 153));
            searchingBTN.addActionListener(e -> searchingBTNActionPerformed(e));

            //---- DepoBTN ----
            DepoBTN.setText("ACCEPT");
            DepoBTN.setForeground(Color.white);
            DepoBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DepoBTN.setBackground(new Color(153, 153, 153));
            DepoBTN.addActionListener(e -> DepoBTNActionPerformed(e));

            //---- DepoAcceptBTN ----
            DepoAcceptBTN.setText("CONFIRM");
            DepoAcceptBTN.setForeground(Color.white);
            DepoAcceptBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DepoAcceptBTN.setBackground(new Color(153, 153, 153));
            DepoAcceptBTN.addActionListener(e -> DepoAcceptBTNActionPerformed(e));

            //---- WithdBTN ----
            WithdBTN.setText("ACCEPT");
            WithdBTN.setForeground(Color.white);
            WithdBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            WithdBTN.setBackground(new Color(153, 153, 153));
            WithdBTN.addActionListener(e -> WithdBTNActionPerformed(e));

            //---- WithdAcceptBTN ----
            WithdAcceptBTN.setText("CONFIRM");
            WithdAcceptBTN.setForeground(Color.white);
            WithdAcceptBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            WithdAcceptBTN.setBackground(new Color(153, 153, 153));
            WithdAcceptBTN.addActionListener(e -> WithdAcceptBTNActionPerformed(e));

            //---- clearAllBTN ----
            clearAllBTN.setText("CLEAR");
            clearAllBTN.setBackground(new Color(153, 153, 153));
            clearAllBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            clearAllBTN.setForeground(Color.white);
            clearAllBTN.addActionListener(e -> clearAllBTNActionPerformed(e));

            GroupLayout chqAccLayout = new GroupLayout(chqAcc);
            chqAcc.setLayout(chqAccLayout);
            chqAccLayout.setHorizontalGroup(
                chqAccLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, chqAccLayout.createSequentialGroup()
                        .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, chqAccLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addGroup(chqAccLayout.createParallelGroup()
                                    .addGroup(chqAccLayout.createSequentialGroup()
                                        .addGroup(chqAccLayout.createParallelGroup()
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addGroup(chqAccLayout.createParallelGroup()
                                                    .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(label3))
                                                .addGap(48, 48, 48)
                                                .addGroup(chqAccLayout.createParallelGroup()
                                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(chqAccLayout.createSequentialGroup()
                                                        .addComponent(CurentBalanField, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(searchingBTN))))
                                            .addComponent(label4)
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addComponent(DeposAmountField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepoBTN))
                                            .addComponent(label8)
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DepoAcceptBTN))
                                            .addComponent(label7))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(chqAccLayout.createSequentialGroup()
                                        .addGroup(chqAccLayout.createParallelGroup()
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addComponent(WithdrawAmountField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WithdBTN))
                                            .addComponent(label9)
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addComponent(WithdrawTotalField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(WithdAcceptBTN)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                        .addGroup(chqAccLayout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, chqAccLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(clearAllBTN, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(backBTN, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(chqAccLayout.createSequentialGroup()
                                                .addComponent(logoutBTN)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(26, 26, 26))))
                            .addGroup(GroupLayout.Alignment.LEADING, chqAccLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 94, Short.MAX_VALUE))
                            .addGroup(chqAccLayout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGap(26, 26, 26))
            );
            chqAccLayout.setVerticalGroup(
                chqAccLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, chqAccLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(label3))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(CurentBalanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchingBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(DeposAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepoBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepoAcceptBTN))
                        .addGroup(chqAccLayout.createParallelGroup()
                            .addGroup(chqAccLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(WithdrawAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WithdBTN))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(chqAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(WithdrawTotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WithdAcceptBTN)))
                            .addGroup(chqAccLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(clearAllBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN)))
                        .addContainerGap(48, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel chqAcc;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label5;
    private JLabel label1;
    private JLabel label3;
    private JTextField IDField;
    private JLabel label6;
    private JTextField CurentBalanField;
    private JLabel label4;
    private JTextField DeposAmountField;
    private JLabel label7;
    private JTextField WithdrawAmountField;
    private JLabel label8;
    private JTextField DepoTotalField;
    private JLabel label9;
    private JTextField WithdrawTotalField;
    private JButton backBTN;
    private JButton logoutBTN;
    private JButton searchingBTN;
    private JButton DepoBTN;
    private JButton DepoAcceptBTN;
    private JButton WithdBTN;
    private JButton WithdAcceptBTN;
    private JButton clearAllBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

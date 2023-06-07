/*
 * Created by JFormDesigner on Sun Nov 29 16:14:24 CAT 2020
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
public class InterstAcc {
    private JDBC datba;
    JFrame adFrame;
    Connection con;
    PreparedStatement pst;
    ResultSet rset;
    Statement stmt;
    public InterstAcc() {
        initComponents();
        con=JDBC.dbConnect();
        adFrame = new JFrame();
        adFrame.setTitle("Client: Open Interest Account Menu");
        adFrame.add(IntresAcc);//name of panel
        adFrame.pack();
        adFrame.setSize(569, 667);
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

    private void SearchBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill the ID Field!","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try{
                String id = IDField.getText();
                String sql="select Balance from interestbearingaccount where IntID='"+ id + "'";
                stmt=con.prepareStatement(sql);
                rset=stmt.executeQuery(sql);
                if (rset.next()){
                    Double currentBal = rset.getDouble("Balance");
                    CurentBalanField.setText(String.valueOf(currentBal));
                }
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Your Savings Account Was Not Found","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DepoBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && DeposAmountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The ID Field And Deposit Amount Field!","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                String balance = CurentBalanField.getText();
                String amount = DeposAmountField.getText();
                Double sumA = Double.parseDouble(amount) + Double.parseDouble(balance);
                String sumB = String.valueOf(sumA);
                DepoTotalField.setText(sumB);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit Failed: Please Enter Numbers Only!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DepoConfirmBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && CurentBalanField.getText().isEmpty() && DeposAmountField.getText().isEmpty() && DepoTotalField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill In the Spaces!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                if (CurentBalanField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Search For Your Account First!","Alert",JOptionPane.WARNING_MESSAGE);
                }
                String id = IDField.getText();
                String deposTotal = DepoTotalField.getText();
                String sql = "update interestbearingaccount set balance='" + deposTotal + "'where customers_ID='" + id + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deposit SuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);
                CurentBalanField.setText("");
                DeposAmountField.setText("");
                DepoTotalField.setText("");
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit UnSuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void WithdrawBTNActionPerformed(ActionEvent e) {
            if (IDField.getText().isEmpty() && WithdrawAmountField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Fill The ID Field And Withdraw Amount Field!","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    String balance = CurentBalanField.getText();
                    String amount = WithdrawAmountField.getText();
                    Double a = Double.parseDouble(amount);
                    Double b = Double.parseDouble(balance);
                    Double sumA;
                    String sumB;

                    if (a <= b) {
                        sumA = b - a;
                        sumB = String.valueOf(sumA);
                        WithdrawTotalField.setText(sumB);
                    }
                    else if (a > b) {
                        JOptionPane.showMessageDialog(null, "Withdraw Failed: Cannot Withdraw More Than Your Current Balance", "Alert!", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Deposit Failed: Please Enter Numbers Only!", "Alert!", JOptionPane.WARNING_MESSAGE);
                }
            }
    }

    private void WithdrawConfirBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && CurentBalanField.getText().isEmpty() && WithdrawAmountField.getText().isEmpty() && WithdrawTotalField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Fill In the Spaces!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String id = IDField.getText();
            String withdrawTotal = WithdrawTotalField.getText();
            try {
                String sql = "update interestbearingaccount set balance='" + withdrawTotal + "'where customers_ID='" + id + "'";

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

    private void ClearBTNActionPerformed(ActionEvent e) {
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
        IntresAcc = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        IDField = new JTextField();
        label6 = new JLabel();
        CurentBalanField = new JTextField();
        label4 = new JLabel();
        DeposAmountField = new JTextField();
        label8 = new JLabel();
        DepoTotalField = new JTextField();
        label7 = new JLabel();
        WithdrawAmountField = new JTextField();
        label9 = new JLabel();
        WithdrawTotalField = new JTextField();
        backBTN = new JButton();
        logoutBTN = new JButton();
        SearchBTN = new JButton();
        DepoBTN = new JButton();
        DepoConfirmBTN = new JButton();
        WithdrawBTN = new JButton();
        WithdrawConfirBTN = new JButton();
        ClearBTN = new JButton();

        //======== IntresAcc ========
        {
            IntresAcc.setBackground(Color.white);
            IntresAcc.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            IntresAcc. getBorder( )) ); IntresAcc. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("INTEREST ACCOUNT");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                //---- label5 ----
                label5.setText("Please Enter Your Ac/N Then Search, Before Deposits & Withdrawls");
                label5.setForeground(Color.white);
                label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(label5))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(label2)))
                            .addContainerGap(49, Short.MAX_VALUE))
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
            CurentBalanField.setForeground(Color.black);
            CurentBalanField.setEditable(false);
            CurentBalanField.setBackground(new Color(153, 153, 153));

            //---- label4 ----
            label4.setText("Enter Amount You Want To Deposit");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- DeposAmountField ----
            DeposAmountField.setForeground(Color.white);
            DeposAmountField.setBackground(new Color(153, 153, 153));

            //---- label8 ----
            label8.setText("Balance After Deposit");
            label8.setForeground(new Color(102, 102, 102));
            label8.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- DepoTotalField ----
            DepoTotalField.setForeground(Color.black);
            DepoTotalField.setBackground(new Color(153, 153, 153));
            DepoTotalField.setEditable(false);

            //---- label7 ----
            label7.setText("Enter The Amount You Want To Withdraw");
            label7.setForeground(new Color(102, 102, 102));
            label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- WithdrawAmountField ----
            WithdrawAmountField.setForeground(Color.white);
            WithdrawAmountField.setBackground(new Color(153, 153, 153));

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

            //---- SearchBTN ----
            SearchBTN.setText("SEARCH");
            SearchBTN.setBackground(new Color(153, 153, 153));
            SearchBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            SearchBTN.setForeground(Color.white);
            SearchBTN.addActionListener(e -> SearchBTNActionPerformed(e));

            //---- DepoBTN ----
            DepoBTN.setText("ACCEPT");
            DepoBTN.setBackground(new Color(153, 153, 153));
            DepoBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DepoBTN.setForeground(Color.white);
            DepoBTN.addActionListener(e -> DepoBTNActionPerformed(e));

            //---- DepoConfirmBTN ----
            DepoConfirmBTN.setText("CONFIRM");
            DepoConfirmBTN.setBackground(new Color(153, 153, 153));
            DepoConfirmBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DepoConfirmBTN.setForeground(Color.white);
            DepoConfirmBTN.addActionListener(e -> DepoConfirmBTNActionPerformed(e));

            //---- WithdrawBTN ----
            WithdrawBTN.setText("ACCEPT");
            WithdrawBTN.setBackground(new Color(153, 153, 153));
            WithdrawBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            WithdrawBTN.setForeground(Color.white);
            WithdrawBTN.addActionListener(e -> WithdrawBTNActionPerformed(e));

            //---- WithdrawConfirBTN ----
            WithdrawConfirBTN.setText("CONFIRM");
            WithdrawConfirBTN.setForeground(Color.white);
            WithdrawConfirBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 13));
            WithdrawConfirBTN.setBackground(new Color(153, 153, 153));
            WithdrawConfirBTN.addActionListener(e -> WithdrawConfirBTNActionPerformed(e));

            //---- ClearBTN ----
            ClearBTN.setText("CLEAR");
            ClearBTN.setBackground(new Color(153, 153, 153));
            ClearBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            ClearBTN.setForeground(Color.white);
            ClearBTN.addActionListener(e -> ClearBTNActionPerformed(e));

            GroupLayout IntresAccLayout = new GroupLayout(IntresAcc);
            IntresAcc.setLayout(IntresAccLayout);
            IntresAccLayout.setHorizontalGroup(
                IntresAccLayout.createParallelGroup()
                    .addGroup(IntresAccLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, IntresAccLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(IntresAccLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, IntresAccLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(GroupLayout.Alignment.TRAILING, IntresAccLayout.createSequentialGroup()
                                .addGroup(IntresAccLayout.createParallelGroup()
                                    .addGroup(IntresAccLayout.createSequentialGroup()
                                        .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DepoConfirmBTN))
                                    .addGroup(IntresAccLayout.createSequentialGroup()
                                        .addComponent(WithdrawAmountField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(WithdrawBTN))
                                    .addComponent(label7)
                                    .addComponent(label9)
                                    .addGroup(IntresAccLayout.createSequentialGroup()
                                        .addComponent(WithdrawTotalField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(WithdrawConfirBTN))
                                    .addGroup(IntresAccLayout.createSequentialGroup()
                                        .addGroup(IntresAccLayout.createParallelGroup()
                                            .addComponent(label3)
                                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)
                                        .addGroup(IntresAccLayout.createParallelGroup()
                                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(IntresAccLayout.createSequentialGroup()
                                                .addComponent(CurentBalanField, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SearchBTN))))
                                    .addComponent(label4)
                                    .addGroup(IntresAccLayout.createSequentialGroup()
                                        .addGroup(IntresAccLayout.createParallelGroup()
                                            .addComponent(DeposAmountField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label8))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DepoBTN)))
                                .addGap(1, 1, 1)
                                .addGroup(IntresAccLayout.createParallelGroup()
                                    .addComponent(ClearBTN, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(logoutBTN))
                                .addGap(32, 32, 32))))
            );
            IntresAccLayout.setVerticalGroup(
                IntresAccLayout.createParallelGroup()
                    .addGroup(IntresAccLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(CurentBalanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(DeposAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepoBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DepoConfirmBTN))
                        .addGap(18, 18, 18)
                        .addComponent(label7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(WithdrawAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(WithdrawBTN)
                            .addComponent(ClearBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(IntresAccLayout.createParallelGroup()
                            .addGroup(IntresAccLayout.createSequentialGroup()
                                .addComponent(label9)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(IntresAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(WithdrawTotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WithdrawConfirBTN)))
                            .addGroup(IntresAccLayout.createSequentialGroup()
                                .addComponent(backBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN)))
                        .addContainerGap(28, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel IntresAcc;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label5;
    private JLabel label3;
    private JTextField IDField;
    private JLabel label6;
    private JTextField CurentBalanField;
    private JLabel label4;
    private JTextField DeposAmountField;
    private JLabel label8;
    private JTextField DepoTotalField;
    private JLabel label7;
    private JTextField WithdrawAmountField;
    private JLabel label9;
    private JTextField WithdrawTotalField;
    private JButton backBTN;
    private JButton logoutBTN;
    private JButton SearchBTN;
    private JButton DepoBTN;
    private JButton DepoConfirmBTN;
    private JButton WithdrawBTN;
    private JButton WithdrawConfirBTN;
    private JButton ClearBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

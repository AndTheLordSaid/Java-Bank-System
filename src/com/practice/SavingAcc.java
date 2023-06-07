/*
 * Created by JFormDesigner on Sun Nov 29 16:13:44 CAT 2020
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
public class SavingAcc{
    JDBC datba;
    JFrame adFrame;
    Connection con;
    PreparedStatement pst;
    ResultSet rset;
    Statement stmt;

    public SavingAcc() {
        initComponents();
        con=JDBC.dbConnect();
        adFrame = new JFrame();
        adFrame.setTitle("Client: Savings Account");
        adFrame.add(saAcc);//name of panel
        adFrame.pack();
        adFrame.setSize(679, 557);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void SearchBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The ID Field!","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try{
                String id = IDField.getText();
                String sql="select Balance from savingsaccount where SavID='"+ id + "'";
                stmt=con.prepareStatement(sql);
                rset=stmt.executeQuery(sql);
                if (rset.next()){
                    Double currentBal = rset.getDouble("Balance");
                    CurentBalField.setText(String.valueOf(currentBal));
                }
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Your Savings Account Was Not Found","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DeposBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && AmountField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The ID Field & Amount Field!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                Double balance = Double.valueOf(CurentBalField.getText());
                String amount = AmountField.getText();
                Double sumA = Double.parseDouble(amount) + balance;
                String sumB = String.valueOf(sumA);
                DepoTotalField.setText(sumB);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit Failed: Please Enter Numbers Only!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DeposConfirBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && CurentBalField.getText().isEmpty() && AmountField.getText().isEmpty() && DepoTotalField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill In the Spaces!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                String id = IDField.getText();
                String deposTotal = DepoTotalField.getText();
                String sql = "update savingsaccount set balance='" + deposTotal + "'where customers_ID='" + id + "'";

                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deposit SuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);
                IDField.setText("");
                CurentBalField.setText("");
                AmountField.setText("");
                DepoTotalField.setText("");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Deposit UnSuccessFul", "Alert!", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen atmAuthen = new ATMAuthen(datba);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccPicker accPicker = new AccPicker(datba);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        saAcc = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label5 = new JLabel();
        IDField = new JTextField();
        label3 = new JLabel();
        logoutBTN = new JButton();
        backBTN = new JButton();
        AmountField = new JTextField();
        label4 = new JLabel();
        label6 = new JLabel();
        DepoTotalField = new JTextField();
        label7 = new JLabel();
        SearchBTN = new JButton();
        DeposBTN = new JButton();
        DeposConfirBTN = new JButton();
        CurentBalField = new JTextField();

        //======== saAcc ========
        {
            saAcc.setBackground(Color.white);
            saAcc.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),saAcc. getBorder
            ()));saAcc. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException
            ();}});

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("SAVINGS ACCOUNT");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                //---- label5 ----
                label5.setText("Please Enter Your Ac/n Then Search, Before Deposits");
                label5.setForeground(Color.white);
                label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(72, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addGap(61, 61, 61))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(129, 129, 129))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label5)
                            .addGap(11, 11, 11))
                );
            }

            //---- IDField ----
            IDField.setBackground(new Color(153, 153, 153));
            IDField.setForeground(Color.white);

            //---- label3 ----
            label3.setText("Enter Account Number");
            label3.setForeground(new Color(102, 102, 102));
            label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.setForeground(Color.white);
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- AmountField ----
            AmountField.setForeground(Color.white);
            AmountField.setBackground(new Color(153, 153, 153));

            //---- label4 ----
            label4.setText("Enter Amount You Want To Deposit");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label6 ----
            label6.setText("Current Balance");
            label6.setForeground(new Color(102, 102, 102));
            label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- DepoTotalField ----
            DepoTotalField.setForeground(Color.black);
            DepoTotalField.setBackground(new Color(153, 153, 153));
            DepoTotalField.setEditable(false);

            //---- label7 ----
            label7.setText("Balance After Deposit");
            label7.setForeground(new Color(102, 102, 102));
            label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- SearchBTN ----
            SearchBTN.setText("SEARCH");
            SearchBTN.setBackground(new Color(153, 153, 153));
            SearchBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            SearchBTN.setForeground(Color.white);
            SearchBTN.addActionListener(e -> SearchBTNActionPerformed(e));

            //---- DeposBTN ----
            DeposBTN.setText("ACCEPT");
            DeposBTN.setBackground(new Color(153, 153, 153));
            DeposBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DeposBTN.setForeground(Color.white);
            DeposBTN.addActionListener(e -> DeposBTNActionPerformed(e));

            //---- DeposConfirBTN ----
            DeposConfirBTN.setText("CONFIRM");
            DeposConfirBTN.setBackground(new Color(153, 153, 153));
            DeposConfirBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DeposConfirBTN.setForeground(Color.white);
            DeposConfirBTN.addActionListener(e -> DeposConfirBTNActionPerformed(e));

            //---- CurentBalField ----
            CurentBalField.setEditable(false);
            CurentBalField.setForeground(Color.black);
            CurentBalField.setBackground(new Color(153, 153, 153));

            GroupLayout saAccLayout = new GroupLayout(saAcc);
            saAcc.setLayout(saAccLayout);
            saAccLayout.setHorizontalGroup(
                saAccLayout.createParallelGroup()
                    .addGroup(saAccLayout.createSequentialGroup()
                        .addGroup(saAccLayout.createParallelGroup()
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(saAccLayout.createParallelGroup()
                                    .addComponent(label4)
                                    .addGroup(saAccLayout.createSequentialGroup()
                                        .addComponent(AmountField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DeposBTN))
                                    .addGroup(saAccLayout.createSequentialGroup()
                                        .addGroup(saAccLayout.createParallelGroup()
                                            .addComponent(label7)
                                            .addGroup(saAccLayout.createSequentialGroup()
                                                .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(DeposConfirBTN)))
                                        .addGap(132, 132, 132)
                                        .addGroup(saAccLayout.createParallelGroup()
                                            .addComponent(logoutBTN)
                                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label3)
                                    .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, saAccLayout.createSequentialGroup()
                        .addGroup(saAccLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addGroup(saAccLayout.createParallelGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CurentBalField))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchBTN)))
                        .addGap(143, 143, 143))
            );
            saAccLayout.setVerticalGroup(
                saAccLayout.createParallelGroup()
                    .addGroup(saAccLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(saAccLayout.createParallelGroup()
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label6))
                            .addGroup(saAccLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label3)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(saAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchBTN)
                            .addComponent(CurentBalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(saAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(AmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(DeposBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(saAccLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(DepoTotalField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN)
                            .addComponent(DeposConfirBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutBTN)
                        .addGap(17, 17, 17))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel saAcc;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label5;
    private JTextField IDField;
    private JLabel label3;
    private JButton logoutBTN;
    private JButton backBTN;
    private JTextField AmountField;
    private JLabel label4;
    private JLabel label6;
    private JTextField DepoTotalField;
    private JLabel label7;
    private JButton SearchBTN;
    private JButton DeposBTN;
    private JButton DeposConfirBTN;
    private JTextField CurentBalField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

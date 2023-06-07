/*
 * Created by JFormDesigner on Mon Nov 30 12:48:12 CAT 2020
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
public class AccountOpen {
    private JDBC datba;
    JFrame adFrame;
    
    public AccountOpen(JDBC datba) {
        initComponents();
        this.datba= datba;
        adFrame=new JFrame();
        adFrame.setTitle("Open Account Menu");
        adFrame.add(AccOpener);
        adFrame.pack();
        adFrame.setSize(816, 717);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void ChDepoBTNActionPerformed(ActionEvent e) {
        if (ChAccNoField.getText().isEmpty() && ChIDField.getText().isEmpty() && ChAccTypeField.getText().isEmpty() && ChDeposField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Cheque Account Fields","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int accNoStr = Integer.parseInt(ChAccNoField.getText());
                int idStr = Integer.parseInt(ChIDField.getText());
                String acctypeStr = ChAccTypeField.getText();
                double balanceStr = Integer.parseInt(ChDeposField.getText());
                int i = datba.addCheque(accNoStr, idStr, acctypeStr, balanceStr);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Cheque Account Successfully Created", "Alert", JOptionPane.WARNING_MESSAGE);
                    ChAccNoField.setText("");
                    ChIDField.setText("");
                    ChAccTypeField.setText("");
                    ChDeposField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Cheque Account Not Created!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error: Try Again Enter The Correct Information!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void SaDepoBTNActionPerformed(ActionEvent e) {
        if (SaAccNoField.getText().isEmpty() && SaIDField.getText().isEmpty() && SaAccTypeField.getText().isEmpty() && SaDeposField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Savings Account Fields","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int accNoStr = Integer.parseInt(SaAccNoField.getText());
                int idStr = Integer.parseInt(SaIDField.getText());
                String acctypeStr = SaAccTypeField.getText();
                double balanceStr = Integer.parseInt(SaDeposField.getText());
                int i = datba.addSavings(accNoStr, idStr, acctypeStr, balanceStr);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Savings Account Successfully Created", "Alert", JOptionPane.WARNING_MESSAGE);
                    SaAccNoField.setText("");
                    SaIDField.setText("");
                    SaAccTypeField.setText("");
                    SaDeposField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Savings Account Not Created!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error: Try Again Enter The Correct Information!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void InDepoBTNActionPerformed(ActionEvent e) {
        double balanceStr = Double.parseDouble(InDeposField.getText());
        if (InAccNoField.getText().isEmpty() && InIDField.getText().isEmpty() && InAccTypeField.getText().isEmpty() && InDeposField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Interest Account Fields","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else if (balanceStr<500){
            JOptionPane.showMessageDialog(null,"Sorry We Only Accept Deposits More Than P500","Alert!",JOptionPane.WARNING_MESSAGE);
            InAccNoField.setText("");
            InIDField.setText("");
            InAccTypeField.setText("");
            InDeposField.setText("");
        }
        else if (balanceStr>500){
            int accNoStr = Integer.parseInt(InAccNoField.getText());
            int idStr = Integer.parseInt(InIDField.getText());
            String acctypeStr = InAccTypeField.getText();
            double balanceStr2 = Double.parseDouble(InDeposField.getText());
            try {
                int i = datba.addInterestBearing(accNoStr, idStr, acctypeStr, balanceStr2);
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Interest Account Successfully Created", "Alert", JOptionPane.WARNING_MESSAGE);
                    InAccNoField.setText("");
                    InIDField.setText("");
                    InAccTypeField.setText("");
                    InDeposField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Interest Account Not Created!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error: Try Again Enter The Correct Information!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void depositBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccPicker accPicker = new AccPicker(datba);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen test = new ATMAuthen(datba);
    }

    private void cheClearBTNActionPerformed(ActionEvent e) {
        ChAccNoField.setText("");
        ChIDField.setText("");
        ChAccTypeField.setText("");
        ChDeposField.setText("");
    }

    private void saClearBTNActionPerformed(ActionEvent e) {
        SaAccNoField.setText("");
        SaIDField.setText("");
        SaAccTypeField.setText("");
        SaDeposField.setText("");    
    }

    private void inClearBTNActionPerformed(ActionEvent e) {
        InAccNoField.setText("");
        InIDField.setText("");
        InAccTypeField.setText("");
        InDeposField.setText("");
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        AccOpener = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label7 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        panel4 = new JPanel();
        label8 = new JLabel();
        panel5 = new JPanel();
        label9 = new JLabel();
        label3 = new JLabel();
        ChAccNoField = new JTextField();
        label4 = new JLabel();
        ChIDField = new JTextField();
        ChDepoBTN = new JButton();
        label5 = new JLabel();
        ChAccTypeField = new JTextField();
        label10 = new JLabel();
        ChDeposField = new JTextField();
        label11 = new JLabel();
        SaAccNoField = new JTextField();
        label12 = new JLabel();
        SaIDField = new JTextField();
        label13 = new JLabel();
        SaAccTypeField = new JTextField();
        label14 = new JLabel();
        SaDeposField = new JTextField();
        SaDepoBTN = new JButton();
        label15 = new JLabel();
        InAccNoField = new JTextField();
        label16 = new JLabel();
        InIDField = new JTextField();
        label17 = new JLabel();
        InAccTypeField = new JTextField();
        label18 = new JLabel();
        InDeposField = new JTextField();
        InDepoBTN = new JButton();
        backBTN = new JButton();
        logoutBTN = new JButton();
        cheClearBTN = new JButton();
        saClearBTN = new JButton();
        inClearBTN = new JButton();

        //======== AccOpener ========
        {
            AccOpener.setBackground(Color.white);
            AccOpener.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
            0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
            . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
            red ) ,AccOpener. getBorder () ) ); AccOpener. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
            beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label7 ----
                label7.setText("Open A Chequeing Account");
                label7.setForeground(Color.white);
                label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(22, Short.MAX_VALUE)
                            .addComponent(label7)
                            .addGap(19, 19, 19))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(19, Short.MAX_VALUE)
                            .addComponent(label7)
                            .addGap(14, 14, 14))
                );
            }

            //======== panel2 ========
            {
                panel2.setBackground(new Color(153, 153, 153));

                //---- label6 ----
                label6.setText("Pick An Account You Want To Open");
                label6.setForeground(Color.white);
                label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(label6)
                            .addContainerGap(38, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(label6)
                            .addContainerGap(28, Short.MAX_VALUE))
                );
            }

            //======== panel4 ========
            {
                panel4.setBackground(new Color(153, 153, 153));

                //---- label8 ----
                label8.setText("Open A Savings Account");
                label8.setForeground(Color.white);
                label8.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addContainerGap(32, Short.MAX_VALUE)
                            .addComponent(label8)
                            .addGap(23, 23, 23))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label8)
                            .addContainerGap(17, Short.MAX_VALUE))
                );
            }

            //======== panel5 ========
            {
                panel5.setBackground(new Color(153, 153, 153));

                //---- label9 ----
                label9.setText("Open An Interest Account");
                label9.setForeground(Color.white);
                label9.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addContainerGap(20, Short.MAX_VALUE)
                            .addComponent(label9)
                            .addGap(16, 16, 16))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addContainerGap(19, Short.MAX_VALUE)
                            .addComponent(label9)
                            .addGap(14, 14, 14))
                );
            }

            //---- label3 ----
            label3.setText("Enter Account Number");
            label3.setForeground(new Color(102, 102, 102));
            label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ChAccNoField ----
            ChAccNoField.setForeground(Color.white);
            ChAccNoField.setBackground(new Color(153, 153, 153));

            //---- label4 ----
            label4.setText("Enter Your ID");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ChIDField ----
            ChIDField.setForeground(Color.white);
            ChIDField.setBackground(new Color(153, 153, 153));

            //---- ChDepoBTN ----
            ChDepoBTN.setText("Accept");
            ChDepoBTN.setBackground(new Color(153, 153, 153));
            ChDepoBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            ChDepoBTN.setForeground(Color.white);
            ChDepoBTN.addActionListener(e -> {
			depositBTNActionPerformed(e);
			depositBTNActionPerformed(e);
			ChDepoBTNActionPerformed(e);
		});

            //---- label5 ----
            label5.setText("Enter Account Type");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ChAccTypeField ----
            ChAccTypeField.setForeground(Color.white);
            ChAccTypeField.setBackground(new Color(153, 153, 153));

            //---- label10 ----
            label10.setText("Initial Deposit");
            label10.setForeground(new Color(102, 102, 102));
            label10.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ChDeposField ----
            ChDeposField.setForeground(Color.white);
            ChDeposField.setBackground(new Color(153, 153, 153));

            //---- label11 ----
            label11.setText("Enter Account Number");
            label11.setForeground(new Color(102, 102, 102));
            label11.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- SaAccNoField ----
            SaAccNoField.setForeground(Color.white);
            SaAccNoField.setBackground(new Color(153, 153, 153));

            //---- label12 ----
            label12.setText("Enter Your ID");
            label12.setForeground(new Color(102, 102, 102));
            label12.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- SaIDField ----
            SaIDField.setForeground(Color.white);
            SaIDField.setBackground(new Color(153, 153, 153));

            //---- label13 ----
            label13.setText("Enter Account Type");
            label13.setForeground(new Color(102, 102, 102));
            label13.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- SaAccTypeField ----
            SaAccTypeField.setForeground(Color.white);
            SaAccTypeField.setBackground(new Color(153, 153, 153));

            //---- label14 ----
            label14.setText("Initial Deposit");
            label14.setForeground(new Color(102, 102, 102));
            label14.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- SaDeposField ----
            SaDeposField.setForeground(Color.white);
            SaDeposField.setBackground(new Color(153, 153, 153));

            //---- SaDepoBTN ----
            SaDepoBTN.setText("Accept");
            SaDepoBTN.setBackground(new Color(153, 153, 153));
            SaDepoBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            SaDepoBTN.setForeground(Color.white);
            SaDepoBTN.addActionListener(e -> {
			depositBTNActionPerformed(e);
			depositBTNActionPerformed(e);
			SaDepoBTNActionPerformed(e);
		});

            //---- label15 ----
            label15.setText("Enter Account Number");
            label15.setForeground(new Color(102, 102, 102));
            label15.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- InAccNoField ----
            InAccNoField.setForeground(Color.white);
            InAccNoField.setBackground(new Color(153, 153, 153));

            //---- label16 ----
            label16.setText("Enter Your ID");
            label16.setForeground(new Color(102, 102, 102));
            label16.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- InIDField ----
            InIDField.setForeground(Color.white);
            InIDField.setBackground(new Color(153, 153, 153));

            //---- label17 ----
            label17.setText("Enter Account Type");
            label17.setForeground(new Color(102, 102, 102));
            label17.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- InAccTypeField ----
            InAccTypeField.setForeground(Color.white);
            InAccTypeField.setBackground(new Color(153, 153, 153));

            //---- label18 ----
            label18.setText("Initial Deposit");
            label18.setForeground(new Color(102, 102, 102));
            label18.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- InDeposField ----
            InDeposField.setForeground(Color.white);
            InDeposField.setBackground(new Color(153, 153, 153));

            //---- InDepoBTN ----
            InDepoBTN.setText("Accept");
            InDepoBTN.setBackground(new Color(153, 153, 153));
            InDepoBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            InDepoBTN.setForeground(Color.white);
            InDepoBTN.addActionListener(e -> {
			depositBTNActionPerformed(e);
			depositBTNActionPerformed(e);
			InDepoBTNActionPerformed(e);
		});

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

            //---- cheClearBTN ----
            cheClearBTN.setText("CLEAR");
            cheClearBTN.setBackground(new Color(153, 153, 153));
            cheClearBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            cheClearBTN.setForeground(Color.white);
            cheClearBTN.addActionListener(e -> cheClearBTNActionPerformed(e));

            //---- saClearBTN ----
            saClearBTN.setText("CLEAR");
            saClearBTN.setBackground(new Color(153, 153, 153));
            saClearBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            saClearBTN.setForeground(Color.white);
            saClearBTN.addActionListener(e -> saClearBTNActionPerformed(e));

            //---- inClearBTN ----
            inClearBTN.setText("CLEAR");
            inClearBTN.setBackground(new Color(153, 153, 153));
            inClearBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            inClearBTN.setForeground(Color.white);
            inClearBTN.addActionListener(e -> inClearBTNActionPerformed(e));

            GroupLayout AccOpenerLayout = new GroupLayout(AccOpener);
            AccOpener.setLayout(AccOpenerLayout);
            AccOpenerLayout.setHorizontalGroup(
                AccOpenerLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, AccOpenerLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addGroup(AccOpenerLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(AccOpenerLayout.createSequentialGroup()
                                .addGroup(AccOpenerLayout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(label10)
                                    .addComponent(ChAccTypeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5)
                                    .addComponent(ChAccNoField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4)
                                    .addComponent(ChIDField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ChDeposField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AccOpenerLayout.createSequentialGroup()
                                        .addComponent(cheClearBTN)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ChDepoBTN)))
                                .addGap(92, 92, 92)
                                .addGroup(AccOpenerLayout.createParallelGroup()
                                    .addGroup(AccOpenerLayout.createSequentialGroup()
                                        .addComponent(saClearBTN)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SaDepoBTN))
                                    .addComponent(SaAccNoField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label11)
                                    .addComponent(label12)
                                    .addComponent(SaIDField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13)
                                    .addComponent(SaAccTypeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label14)
                                    .addComponent(SaDeposField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(label15)
                            .addComponent(InAccNoField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label16)
                            .addComponent(InIDField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label17)
                            .addComponent(InAccTypeField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label18)
                            .addComponent(InDeposField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(AccOpenerLayout.createSequentialGroup()
                                .addComponent(inClearBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InDepoBTN)))
                        .addGap(33, 33, 33))
                    .addGroup(GroupLayout.Alignment.TRAILING, AccOpenerLayout.createSequentialGroup()
                        .addContainerGap(287, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBTN))
                        .addGap(139, 139, 139))
                    .addGroup(AccOpenerLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(209, Short.MAX_VALUE))
            );
            AccOpenerLayout.setVerticalGroup(
                AccOpenerLayout.createParallelGroup()
                    .addGroup(AccOpenerLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(AccOpenerLayout.createSequentialGroup()
                                .addComponent(backBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN)))
                        .addGap(35, 35, 35)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(label3)
                            .addGroup(AccOpenerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label15)
                                .addComponent(label11)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(ChAccNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(InAccNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaAccNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(label4)
                            .addGroup(AccOpenerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label16)
                                .addComponent(label12)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(ChIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(InIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(label17)
                            .addComponent(label13))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(ChAccTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(InAccTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaAccTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(label10)
                            .addComponent(label18)
                            .addComponent(label14))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addComponent(ChDeposField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(InDeposField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SaDeposField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccOpenerLayout.createParallelGroup()
                            .addGroup(AccOpenerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cheClearBTN)
                                .addComponent(ChDepoBTN))
                            .addGroup(AccOpenerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(InDepoBTN)
                                .addComponent(inClearBTN))
                            .addGroup(AccOpenerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saClearBTN)
                                .addComponent(SaDepoBTN)))
                        .addContainerGap(24, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel AccOpener;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label7;
    private JPanel panel2;
    private JLabel label6;
    private JPanel panel4;
    private JLabel label8;
    private JPanel panel5;
    private JLabel label9;
    private JLabel label3;
    private JTextField ChAccNoField;
    private JLabel label4;
    private JTextField ChIDField;
    private JButton ChDepoBTN;
    private JLabel label5;
    private JTextField ChAccTypeField;
    private JLabel label10;
    private JTextField ChDeposField;
    private JLabel label11;
    private JTextField SaAccNoField;
    private JLabel label12;
    private JTextField SaIDField;
    private JLabel label13;
    private JTextField SaAccTypeField;
    private JLabel label14;
    private JTextField SaDeposField;
    private JButton SaDepoBTN;
    private JLabel label15;
    private JTextField InAccNoField;
    private JLabel label16;
    private JTextField InIDField;
    private JLabel label17;
    private JTextField InAccTypeField;
    private JLabel label18;
    private JTextField InDeposField;
    private JButton InDepoBTN;
    private JButton backBTN;
    private JButton logoutBTN;
    private JButton cheClearBTN;
    private JButton saClearBTN;
    private JButton inClearBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Mon Nov 16 06:09:15 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.*;

/**
 * @author uCSE19-064
 */
public class DeleteClient {
    private JDBC datba;
    JFrame adFrame;
    public DeleteClient(JDBC datba) {
        initComponents();
        this.datba=datba;
        // Create frame with
        adFrame = new JFrame();
        adFrame.setTitle("Delete Client");
        adFrame.add(delCli);
        adFrame.pack();
        adFrame.setSize(692, 502);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void deleteBTNActionPerformed(ActionEvent e) {
        if (FnameField.getText().isEmpty() && LnameField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else
        try {
            String FnameStr = FnameField.getText();
            String LnameStr = LnameField.getText();
            int i = datba.deleteCustomer(FnameStr,LnameStr);
            if (i>0){
              JOptionPane.showMessageDialog(null, "Client Successfully Deleted","Alert!",JOptionPane.WARNING_MESSAGE);
              FnameField.setText("");
              LnameField.setText("");
            }else {
                JOptionPane.showMessageDialog(null, "Error: Client Not Deleted","Alert!",JOptionPane.WARNING_MESSAGE);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        BackEnd backEnd = new BackEnd(datba);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn authenAdmin = new SignIn(datba);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        delCli = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        toptextpanel = new JPanel();
        label6 = new JLabel();
        label5 = new JLabel();
        LnameField = new JTextField();
        FnameField = new JTextField();
        deleteBTN = new JButton();
        backBTN = new JButton();
        logoutBTN = new JButton();

        //======== delCli ========
        {
            delCli.setBackground(Color.white);
            delCli.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder
            (0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax.swing.border
            .TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),delCli. getBorder()));delCli. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void
            propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException()
            ;}});

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //---- label3 ----
            label3.setText("ADMIN (Delete Client) ");
            label3.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));
            label3.setForeground(Color.black);

            //---- label4 ----
            label4.setText("First Name: ");
            label4.setForeground(new Color(102, 102, 102));
            label4.setBackground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //======== toptextpanel ========
            {
                toptextpanel.setBackground(new Color(153, 153, 153));
                toptextpanel.setForeground(Color.white);

                //---- label6 ----
                label6.setText("Enter The First Name And Last Name Of The Client, To Delete Them");
                label6.setForeground(Color.white);
                label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout toptextpanelLayout = new GroupLayout(toptextpanel);
                toptextpanel.setLayout(toptextpanelLayout);
                toptextpanelLayout.setHorizontalGroup(
                    toptextpanelLayout.createParallelGroup()
                        .addGroup(toptextpanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label6)
                            .addContainerGap(16, Short.MAX_VALUE))
                );
                toptextpanelLayout.setVerticalGroup(
                    toptextpanelLayout.createParallelGroup()
                        .addGroup(toptextpanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label6)
                            .addContainerGap(15, Short.MAX_VALUE))
                );
            }

            //---- label5 ----
            label5.setText("Last Name; ");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- LnameField ----
            LnameField.setBackground(new Color(204, 204, 204));
            LnameField.setForeground(Color.white);

            //---- FnameField ----
            FnameField.setBackground(new Color(204, 204, 204));
            FnameField.setForeground(Color.white);

            //---- deleteBTN ----
            deleteBTN.setText("DELETE");
            deleteBTN.setForeground(Color.white);
            deleteBTN.setBackground(new Color(153, 153, 153));
            deleteBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            deleteBTN.addActionListener(e -> deleteBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.setForeground(Color.white);
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            GroupLayout delCliLayout = new GroupLayout(delCli);
            delCli.setLayout(delCliLayout);
            delCliLayout.setHorizontalGroup(
                delCliLayout.createParallelGroup()
                    .addGroup(delCliLayout.createSequentialGroup()
                        .addGroup(delCliLayout.createParallelGroup()
                            .addGroup(delCliLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN))
                            .addGroup(delCliLayout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addGroup(delCliLayout.createParallelGroup()
                                    .addGroup(delCliLayout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FnameField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(delCliLayout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LnameField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, delCliLayout.createSequentialGroup()
                        .addGap(0, 157, Short.MAX_VALUE)
                        .addGroup(delCliLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, delCliLayout.createSequentialGroup()
                                .addGroup(delCliLayout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(toptextpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(144, 144, 144))
                            .addGroup(GroupLayout.Alignment.TRAILING, delCliLayout.createSequentialGroup()
                                .addGroup(delCliLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(deleteBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(backBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(154, 154, 154))))
            );
            delCliLayout.setVerticalGroup(
                delCliLayout.createParallelGroup()
                    .addGroup(delCliLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(delCliLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(toptextpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(delCliLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(FnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(delCliLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(LnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(deleteBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBTN)
                        .addContainerGap())
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel delCli;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JPanel toptextpanel;
    private JLabel label6;
    private JLabel label5;
    private JTextField LnameField;
    private JTextField FnameField;
    private JButton deleteBTN;
    private JButton backBTN;
    private JButton logoutBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
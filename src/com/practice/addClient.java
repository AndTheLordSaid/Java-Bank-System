/*
 * Created by JFormDesigner on Mon Nov 16 05:31:30 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.*;

/**
 * @author CSE19-064
 */
public class addClient {
    private JDBC datba;
    JFrame adFrame;
    

    public addClient(JDBC datba) {
        initComponents();
        this.datba=datba;
        // Create frame with title Signin
        adFrame = new JFrame();
        adFrame.setTitle("Administrative Tasks// Add Client menu");
        adFrame.add(addClient);
        adFrame.pack();
        adFrame.setSize(649, 586);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn authenAdmin = new SignIn(datba);
    }

    private void addBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && FnameField.getText().isEmpty() && LnameField.getText().isEmpty() && GenderField.getText().isEmpty() && GenderField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill In The Fields!","Alert",JOptionPane.WARNING_MESSAGE);
        }
        else
        try{
            int IDStr = Integer.parseInt(IDField.getText());
            String  FnameStr = FnameField.getText();
            String  LnameStr = LnameField.getText();
            String  GenderStr = GenderField.getText();
            String  AddressStr = AdressField.getText();

            int i=datba.addCustomer(IDStr,FnameStr,LnameStr,GenderStr,AddressStr);
            if (i>0){
                JOptionPane.showMessageDialog(null,"Client Successfully Added","Alert",JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Error: Client Not Added","Alert",JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,"Task Failed!","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        BackEnd backEnd = new BackEnd(datba);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        addClient = new JPanel();
        admin = new JLabel();
        logo = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        IDField = new JTextField();
        FnameField = new JTextField();
        LnameField = new JTextField();
        GenderField = new JTextField();
        AdressField = new JTextField();
        label6 = new JLabel();
        addBTN = new JButton();
        logoutBTN = new JButton();
        backBTN = new JButton();

        //======== addClient ========
        {
            addClient.setBackground(Color.white);
            addClient.setForeground(Color.black);
            addClient.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,addClient. getBorder( )) ); addClient. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- admin ----
            admin.setText("ADMIN (Add Client) ");
            admin.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));
            admin.setForeground(Color.black);

            //---- logo ----
            logo.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label1 ----
                label1.setText("Please Add Client Details To Their Respective Fields");
                label1.setForeground(Color.white);
                label1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(58, 58, 58)
                            .addComponent(label1)
                            .addContainerGap(42, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(20, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(16, 16, 16))
                );
            }

            //---- label2 ----
            label2.setText("First Name");
            label2.setBackground(new Color(153, 153, 153));
            label2.setForeground(new Color(102, 102, 102));
            label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label3 ----
            label3.setText("Last Name");
            label3.setBackground(new Color(153, 153, 153));
            label3.setForeground(new Color(102, 102, 102));
            label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label4 ----
            label4.setText("Gender");
            label4.setForeground(new Color(102, 102, 102));

            //---- label5 ----
            label5.setText("Client ID Number");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- IDField ----
            IDField.setForeground(Color.white);
            IDField.setBackground(new Color(153, 153, 153));

            //---- FnameField ----
            FnameField.setForeground(Color.white);
            FnameField.setBackground(new Color(153, 153, 153));

            //---- LnameField ----
            LnameField.setForeground(Color.white);
            LnameField.setBackground(new Color(153, 153, 153));

            //---- GenderField ----
            GenderField.setBackground(new Color(153, 153, 153));
            GenderField.setForeground(Color.white);

            //---- AdressField ----
            AdressField.setBackground(new Color(153, 153, 153));
            AdressField.setForeground(Color.white);

            //---- label6 ----
            label6.setText("Address");
            label6.setBackground(new Color(102, 102, 102));
            label6.setForeground(new Color(102, 102, 102));

            //---- addBTN ----
            addBTN.setText("ADD ");
            addBTN.setForeground(Color.white);
            addBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            addBTN.setBackground(new Color(153, 153, 153));
            addBTN.addActionListener(e -> addBTNActionPerformed(e));

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setForeground(Color.white);
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout addClientLayout = new GroupLayout(addClient);
            addClient.setLayout(addClientLayout);
            addClientLayout.setHorizontalGroup(
                addClientLayout.createParallelGroup()
                    .addGroup(addClientLayout.createSequentialGroup()
                        .addGroup(addClientLayout.createParallelGroup()
                            .addGroup(addClientLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN))
                            .addGroup(addClientLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addGroup(addClientLayout.createParallelGroup()
                                    .addGroup(addClientLayout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(18, 18, 18)
                                        .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(admin)
                                    .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(addClientLayout.createSequentialGroup()
                                            .addGroup(addClientLayout.createParallelGroup()
                                                .addComponent(label2)
                                                .addComponent(label3)
                                                .addComponent(label4)
                                                .addComponent(label6))
                                            .addGap(49, 49, 49)
                                            .addGroup(addClientLayout.createParallelGroup()
                                                .addGroup(addClientLayout.createSequentialGroup()
                                                    .addComponent(AdressField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(backBTN))
                                                .addGroup(addClientLayout.createSequentialGroup()
                                                    .addGroup(addClientLayout.createParallelGroup()
                                                        .addComponent(LnameField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(FnameField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(addClientLayout.createSequentialGroup()
                                                    .addComponent(GenderField, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(addBTN))))
                                        .addComponent(panel1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(22, Short.MAX_VALUE))
            );
            addClientLayout.setVerticalGroup(
                addClientLayout.createParallelGroup()
                    .addGroup(addClientLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(logo, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(FnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(LnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(GenderField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(addClientLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(AdressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(backBTN))
                        .addContainerGap(16, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel addClient;
    private JLabel admin;
    private JLabel logo;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField IDField;
    private JTextField FnameField;
    private JTextField LnameField;
    private JTextField GenderField;
    private JTextField AdressField;
    private JLabel label6;
    private JButton addBTN;
    private JButton logoutBTN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
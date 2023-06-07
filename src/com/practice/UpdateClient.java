/*
 * Created by JFormDesigner on Mon Nov 16 06:09:37 CAT 2020
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
public class UpdateClient {
    private JDBC datba;
    Connection con;
    PreparedStatement pst;
    JFrame adFrame;
    public UpdateClient(JDBC datba) {
        initComponents();
        this.datba=datba;
        con=JDBC.dbConnect();
        // Create frame
        adFrame = new JFrame();
        adFrame.setTitle("Administrative Tasks// Update Client menu");
        adFrame.add(UpdCLi2);
        adFrame.pack();
        adFrame.setSize(649, 597);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AuthenAdmin authenAdmin = new AuthenAdmin(datba);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        BackEnd backEnd = new BackEnd(datba);
    }

    private void updateActionPerformed(ActionEvent e) {
        if (clieID.getText().isEmpty() && fNameField.getText().isEmpty() && lNameFiedl.getText().isEmpty() && genField.getText().isEmpty() && adField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int IDStr = Integer.parseInt(clieID.getText());
                String FnameStr = fNameField.getText();
                String LnameStr = lNameFiedl.getText();
                String GenderStr = genField.getText();
                String AddressStr = adField.getText();

                String sql = "UPDATE customers set ID='"+IDStr+"',Fname='"+FnameStr+"',Lname='"+LnameStr+"',Gender='"+GenderStr+"',Address='"+AddressStr+"'where ID='"+IDStr+"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Client Details Successfully Updated", "Alert!", JOptionPane.WARNING_MESSAGE);
                clieID.setText("");
                fNameField.setText("");
                lNameFiedl.setText("");
                genField.setText("");
                adField.setText("");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error: Client Details Not Updated", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        UpdCLi2 = new JPanel();
        admin2 = new JLabel();
        label5 = new JLabel();
        clieID = new JTextField();
        label6 = new JLabel();
        fNameField = new JTextField();
        lNameFiedl = new JTextField();
        genField = new JTextField();
        adField = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        logoutBTN = new JButton();
        backBTN = new JButton();
        update = new JButton();

        //======== UpdCLi2 ========
        {
            UpdCLi2.setBackground(Color.white);
            UpdCLi2.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,UpdCLi2. getBorder( )) ); UpdCLi2. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- admin2 ----
            admin2.setText("ADMIN (Update Client)  ");
            admin2.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));
            admin2.setForeground(Color.black);

            //---- label5 ----
            label5.setText("Client ID: ");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- clieID ----
            clieID.setBackground(new Color(153, 153, 153));
            clieID.setForeground(Color.white);

            //---- label6 ----
            label6.setText("First Name: ");
            label6.setForeground(new Color(102, 102, 102));
            label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- fNameField ----
            fNameField.setBackground(new Color(153, 153, 153));
            fNameField.setForeground(Color.white);

            //---- lNameFiedl ----
            lNameFiedl.setBackground(new Color(153, 153, 153));
            lNameFiedl.setForeground(Color.white);

            //---- genField ----
            genField.setBackground(new Color(153, 153, 153));
            genField.setForeground(Color.white);

            //---- adField ----
            adField.setBackground(new Color(153, 153, 153));
            adField.setForeground(Color.white);

            //---- label7 ----
            label7.setText("Last Name: ");
            label7.setForeground(new Color(102, 102, 102));
            label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label8 ----
            label8.setText("Gender: ");
            label8.setForeground(new Color(102, 102, 102));
            label8.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label9 ----
            label9.setText("Address: ");
            label9.setForeground(new Color(102, 102, 102));

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("Enter And Update Client Details");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(94, 94, 94)
                            .addComponent(label2)
                            .addContainerGap(93, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(46, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(38, 38, 38))
                );
            }

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.setForeground(Color.white);
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setForeground(Color.white);
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- update ----
            update.setText("UPDATE");
            update.setForeground(Color.white);
            update.setBackground(new Color(153, 153, 153));
            update.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            update.addActionListener(e -> updateActionPerformed(e));

            GroupLayout UpdCLi2Layout = new GroupLayout(UpdCLi2);
            UpdCLi2.setLayout(UpdCLi2Layout);
            UpdCLi2Layout.setHorizontalGroup(
                UpdCLi2Layout.createParallelGroup()
                    .addGroup(UpdCLi2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutBTN)
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(UpdCLi2Layout.createSequentialGroup()
                        .addContainerGap(109, Short.MAX_VALUE)
                        .addGroup(UpdCLi2Layout.createParallelGroup()
                            .addComponent(admin2)
                            .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(GroupLayout.Alignment.LEADING, UpdCLi2Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(UpdCLi2Layout.createSequentialGroup()
                                    .addGroup(UpdCLi2Layout.createParallelGroup()
                                        .addComponent(label8)
                                        .addGroup(UpdCLi2Layout.createSequentialGroup()
                                            .addGroup(UpdCLi2Layout.createParallelGroup()
                                                .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(UpdCLi2Layout.createSequentialGroup()
                                                        .addComponent(label5)
                                                        .addGap(18, 18, 18))
                                                    .addGroup(UpdCLi2Layout.createSequentialGroup()
                                                        .addComponent(label9)
                                                        .addGap(23, 23, 23)))
                                                .addGroup(UpdCLi2Layout.createSequentialGroup()
                                                    .addGroup(UpdCLi2Layout.createParallelGroup()
                                                        .addComponent(label7)
                                                        .addComponent(label6, GroupLayout.Alignment.TRAILING))
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(UpdCLi2Layout.createParallelGroup()
                                                .addComponent(genField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(adField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fNameField, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(clieID, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lNameFiedl, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(backBTN, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(update, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                    .addGap(2, 2, 2))))
                        .addContainerGap(168, Short.MAX_VALUE))
            );
            UpdCLi2Layout.setVerticalGroup(
                UpdCLi2Layout.createParallelGroup()
                    .addGroup(UpdCLi2Layout.createSequentialGroup()
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin2)
                        .addGap(12, 12, 12)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(clieID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(fNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6))
                        .addGap(5, 5, 5)
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lNameFiedl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(genField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8)
                            .addComponent(update))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(UpdCLi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(adField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label9)
                            .addComponent(backBTN))
                        .addGap(23, 23, 23))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel UpdCLi2;
    private JLabel admin2;
    private JLabel label5;
    private JTextField clieID;
    private JLabel label6;
    private JTextField fNameField;
    private JTextField lNameFiedl;
    private JTextField genField;
    private JTextField adField;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JButton logoutBTN;
    private JButton backBTN;
    private JButton update;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
/*
 * Created by JFormDesigner on Fri Nov 27 16:40:54 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import java.sql.*;

/**
 * @author CSE19-064
 */
public class ATMAuthen  extends JFrame{
    private JDBC datba;
    private JFrame adFrame;

    public ATMAuthen(JDBC datba){
        initComponents();
        this.datba = datba;
        adFrame = new JFrame();
        adFrame.setTitle("Customer Sign In");
        // Add panel to frame
        adFrame.add(ATMAuthen);//name of panel
        adFrame.pack();
        adFrame.setSize(704, 466);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn signIn = new SignIn(datba);
    }

    private void LoginBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && PINField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill In The Fields!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int IDstr = Integer.parseInt(IDField.getText());
                int PINstr = Integer.parseInt(PINField.getText());
                if (datba.clientLogin(IDstr, PINstr)) {
                    adFrame.dispose();
                    AccPicker accPicker = new AccPicker(datba);
                    JOptionPane.showMessageDialog(null, "Login Successful!", "Alert!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter The Correct ID/PIN!", "Alert!", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Login Failed!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void createpinBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        CreatePin createPin = new CreatePin(datba);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ATMAuthen = new JPanel();
        label1 = new JLabel();
        IDField = new JTextField();
        backBTN = new JButton();
        LoginBTN = new JButton();
        PINField = new JPasswordField();
        label4 = new JLabel();
        label5 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        createpinBTN = new JButton();

        //======== ATMAuthen ========
        {
            ATMAuthen.setBackground(Color.white);
            ATMAuthen.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,ATMAuthen. getBorder( )) ); ATMAuthen. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //---- IDField ----
            IDField.setBackground(new Color(153, 153, 153));
            IDField.setForeground(Color.white);

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- LoginBTN ----
            LoginBTN.setText("LOGIN");
            LoginBTN.setBackground(new Color(153, 153, 153));
            LoginBTN.setForeground(Color.white);
            LoginBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            LoginBTN.addActionListener(e -> LoginBTNActionPerformed(e));

            //---- PINField ----
            PINField.setBackground(new Color(153, 153, 153));
            PINField.setForeground(Color.white);

            //---- label4 ----
            label4.setText("ID");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label5 ----
            label5.setText("PIN");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("Please Enter Your ID & PIN.");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                //---- label3 ----
                label3.setText("Create A New PIN If  Don't Have One Already");
                label3.setForeground(Color.white);
                label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(138, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(147, 147, 147))
                                .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addGap(103, 103, 103))))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label3)
                            .addContainerGap(16, Short.MAX_VALUE))
                );
            }

            //---- createpinBTN ----
            createpinBTN.setText("CREATE PIN");
            createpinBTN.setForeground(Color.white);
            createpinBTN.setBackground(new Color(153, 153, 153));
            createpinBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            createpinBTN.addActionListener(e -> createpinBTNActionPerformed(e));

            GroupLayout ATMAuthenLayout = new GroupLayout(ATMAuthen);
            ATMAuthen.setLayout(ATMAuthenLayout);
            ATMAuthenLayout.setHorizontalGroup(
                ATMAuthenLayout.createParallelGroup()
                    .addGroup(ATMAuthenLayout.createSequentialGroup()
                        .addGroup(ATMAuthenLayout.createParallelGroup()
                            .addGroup(ATMAuthenLayout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addGroup(ATMAuthenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4)
                                    .addComponent(label5))
                                .addGap(27, 27, 27)
                                .addGroup(ATMAuthenLayout.createParallelGroup()
                                    .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ATMAuthenLayout.createSequentialGroup()
                                        .addComponent(PINField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ATMAuthenLayout.createParallelGroup()
                                            .addComponent(createpinBTN)
                                            .addComponent(LoginBTN)))))
                            .addGroup(ATMAuthenLayout.createSequentialGroup()
                                .addGap(223, 223, 223)
                                .addComponent(backBTN))
                            .addGroup(ATMAuthenLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(ATMAuthenLayout.createParallelGroup()
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(81, Short.MAX_VALUE))
            );
            ATMAuthenLayout.setVerticalGroup(
                ATMAuthenLayout.createParallelGroup()
                    .addGroup(ATMAuthenLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ATMAuthenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ATMAuthenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(PINField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(LoginBTN))
                        .addGap(18, 18, 18)
                        .addGroup(ATMAuthenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN)
                            .addComponent(createpinBTN))
                        .addGap(36, 36, 36))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel ATMAuthen;
    private JLabel label1;
    private JTextField IDField;
    private JButton backBTN;
    private JButton LoginBTN;
    private JPasswordField PINField;
    private JLabel label4;
    private JLabel label5;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JButton createpinBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
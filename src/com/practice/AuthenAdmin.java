/*
 * Created by JFormDesigner on Fri Nov 27 15:10:00 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 */
public class AuthenAdmin {
    private JDBC datba;
    private JFrame adFrame;


    public AuthenAdmin(JDBC data) {
        initComponents();
        this.datba=data;
        adFrame = new JFrame();
        adFrame.setTitle("Admin Sign In");
        // Add panel to frame
        adFrame.add(AuthenAdmin);//name of panel
        adFrame.pack();
        adFrame.setSize(724, 452);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);

    }

    private void LogInBTNActionPerformed(ActionEvent e){
        if (AdminUsernameTField.getText().isEmpty() && AdminPasswordField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill In The Fields!", "Alert!", JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                String usernameSTr = AdminUsernameTField.getText();
                String passwordSTr = AdminPasswordField.getText();
                if (datba.adminlogin(usernameSTr, passwordSTr)) {
                    adFrame.dispose();
                    BackEnd backEnd = new BackEnd(datba);
                    JOptionPane.showMessageDialog(null, "Login SuccessFul!", "Alert!", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please Input The Correct Username/Password!", "Alert!", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Login Failed!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void BackBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn signIn = new SignIn(datba);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        AuthenAdmin = new JPanel();
        LogInBTN = new JButton();
        BackBTN = new JButton();
        AdminUsernameTField = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        AdminPasswordField = new JPasswordField();
        label6 = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();

        //======== AuthenAdmin ========
        {
            AuthenAdmin.setBackground(Color.white);
            AuthenAdmin.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,AuthenAdmin. getBorder () ) )
            ; AuthenAdmin. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;

            //---- LogInBTN ----
            LogInBTN.setText("LOGIN");
            LogInBTN.setForeground(Color.white);
            LogInBTN.setBackground(new Color(153, 153, 153));
            LogInBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            LogInBTN.addActionListener(e -> LogInBTNActionPerformed(e));

            //---- BackBTN ----
            BackBTN.setText("BACK");
            BackBTN.setForeground(Color.white);
            BackBTN.setBackground(new Color(153, 153, 153));
            BackBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            BackBTN.addActionListener(e -> BackBTNActionPerformed(e));

            //---- AdminUsernameTField ----
            AdminUsernameTField.setBackground(new Color(153, 153, 153));
            AdminUsernameTField.setForeground(Color.white);

            //---- label4 ----
            label4.setText("Username");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label5 ----
            label5.setText("Password");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- AdminPasswordField ----
            AdminPasswordField.setBackground(new Color(153, 153, 153));
            AdminPasswordField.setForeground(Color.white);

            //---- label6 ----
            label6.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label1 ----
                label1.setText("Please Enter Your Sign-In Details");
                label1.setForeground(Color.white);
                label1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(label1)
                            .addContainerGap(165, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(label1)
                            .addContainerGap(43, Short.MAX_VALUE))
                );
            }

            GroupLayout AuthenAdminLayout = new GroupLayout(AuthenAdmin);
            AuthenAdmin.setLayout(AuthenAdminLayout);
            AuthenAdminLayout.setHorizontalGroup(
                AuthenAdminLayout.createParallelGroup()
                    .addGroup(AuthenAdminLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addGroup(AuthenAdminLayout.createParallelGroup()
                            .addGroup(AuthenAdminLayout.createSequentialGroup()
                                .addComponent(label5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdminPasswordField, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGroup(AuthenAdminLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdminUsernameTField, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 331, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, AuthenAdminLayout.createSequentialGroup()
                        .addContainerGap(195, Short.MAX_VALUE)
                        .addComponent(BackBTN)
                        .addGap(188, 188, 188)
                        .addComponent(LogInBTN)
                        .addGap(171, 171, 171))
                    .addGroup(AuthenAdminLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(AuthenAdminLayout.createParallelGroup()
                            .addGroup(AuthenAdminLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label6, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(126, Short.MAX_VALUE))
            );
            AuthenAdminLayout.setVerticalGroup(
                AuthenAdminLayout.createParallelGroup()
                    .addGroup(AuthenAdminLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AuthenAdminLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(AdminUsernameTField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AuthenAdminLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(AdminPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AuthenAdminLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BackBTN)
                            .addComponent(LogInBTN))
                        .addContainerGap(35, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel AuthenAdmin;
    private JButton LogInBTN;
    private JButton BackBTN;
    private JTextField AdminUsernameTField;
    private JLabel label4;
    private JLabel label5;
    private JPasswordField AdminPasswordField;
    private JLabel label6;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
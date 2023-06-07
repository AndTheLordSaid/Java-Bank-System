/*
 * Created by JFormDesigner on Mon Nov 16 07:46:15 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 */
/*************************************************************/
/*************************************************************/
/*************************************************************/
/**********************SIGNIN GUI*****************************/
/*************************************************************/
/*************************************************************/
/*************************************************************/
public class SignIn extends JFrame{
    private JDBC datba;
    private JFrame adFrame;

    public SignIn(JDBC datba) {
        initComponents();
        this.datba=datba;
        // Create frame with title Signin
        adFrame = new JFrame();
        adFrame.setTitle("Sign In");
        adFrame.add(SignIn);
        adFrame.pack();
        adFrame.setSize(763, 502);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);

    }
    //Opens AutenAdmin
    private void adsignActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AuthenAdmin login = new AuthenAdmin(datba);
    }
    //Opens AuthenAtm
    private void atmpinActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen atmAuthen = new ATMAuthen(datba);
    }
    //Method called by AuthenAdmin to go back to SignIn Screen
    //      OR
    //Method called by AuthenAtm to go back to SignIn Screen
    /*************************************************************/
    /*************************************************************/
    /*************************************************************/
    /*****************JFORM DESIGNER JUNK*************************/
    /*************************************************************/
    /*************************************************************/
    /*************************************************************/
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        SignIn = new JPanel();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        atmpin = new JButton();
        adsign = new JButton();
        panel1 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();

        //======== SignIn ========
        {
            SignIn.setBackground(Color.white);
            SignIn.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
            javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
            . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
            .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
            . Color. red) ,SignIn. getBorder( )) ); SignIn. addPropertyChangeListener (new java. beans.
            PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
            equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //---- label4 ----
            label4.setText("ATM");
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 28));
            label4.setForeground(new Color(102, 102, 102));

            //---- label5 ----
            label5.setText("ADMIN");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 28));

            //---- atmpin ----
            atmpin.setText("USE ATM");
            atmpin.setForeground(Color.white);
            atmpin.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            atmpin.setBackground(new Color(153, 153, 153));
            atmpin.addActionListener(e -> atmpinActionPerformed(e));

            //---- adsign ----
            adsign.setText(" ADMIN SIGN IN");
            adsign.setForeground(Color.white);
            adsign.setBackground(new Color(153, 153, 153));
            adsign.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            adsign.addActionListener(e -> adsignActionPerformed(e));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label6 ----
                label6.setForeground(Color.white);
                label6.setHorizontalAlignment(SwingConstants.CENTER);
                label6.setText("WELCOME TO ODYSSEY BANK! THANKS FOR USING OUR SERVICES");
                label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                //---- label7 ----
                label7.setText("Please Pick An Option");
                label7.setForeground(Color.white);
                label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(69, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addGap(55, 55, 55))
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(label7)
                            .addContainerGap(186, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap(24, Short.MAX_VALUE)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label7)
                            .addGap(18, 18, 18))
                );
            }

            GroupLayout SignInLayout = new GroupLayout(SignIn);
            SignIn.setLayout(SignInLayout);
            SignInLayout.setHorizontalGroup(
                SignInLayout.createParallelGroup()
                    .addGroup(SignInLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(SignInLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(SignInLayout.createSequentialGroup()
                                .addComponent(atmpin, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(adsign, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, SignInLayout.createSequentialGroup()
                        .addGap(0, 132, Short.MAX_VALUE)
                        .addGroup(SignInLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(SignInLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5))
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(135, 135, 135))
            );
            SignInLayout.setVerticalGroup(
                SignInLayout.createParallelGroup()
                    .addGroup(SignInLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(SignInLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SignInLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(atmpin, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addComponent(adsign, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel SignIn;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JButton atmpin;
    private JButton adsign;
    private JPanel panel1;
    private JLabel label6;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
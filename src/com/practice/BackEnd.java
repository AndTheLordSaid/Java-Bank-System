/*
 * Created by JFormDesigner on Mon Nov 16 04:30:56 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE-19-064
 */
public class BackEnd extends JFrame{
    private JDBC datba;
    JFrame adFrame;
    public BackEnd(JDBC datba) {
        initComponents();
        this.datba=datba;
        // Create frame
        adFrame = new JFrame();
        adFrame.setTitle("Administrative Tasks");
        adFrame.add(backEnd);
        adFrame.pack();
        adFrame.setSize(684, 492);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void addBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        addClient addClient = new addClient(datba);
    }

    private void logOutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn signIn = new SignIn(datba);
    }

    private void viewBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ViewClient viewClient = new ViewClient(datba);
    }

    private void updateBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        UpdateClient updateClient = new UpdateClient(datba);
    }

    private void deleteBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        DeleteClient deleteClient = new DeleteClient(datba);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        backEnd = new JPanel();
        admin = new JLabel();
        logo = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();
        logOutBTN = new JButton();
        addBTN = new JButton();
        viewBTN = new JButton();
        updateBTN = new JButton();
        deleteBTN = new JButton();

        //======== backEnd ========
        {
            backEnd.setBackground(Color.white);
            backEnd.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,backEnd. getBorder( )) ); backEnd. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );

            //---- admin ----
            admin.setText("ADMIN (Main Menu) ");
            admin.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));
            admin.setForeground(Color.black);

            //---- logo ----
            logo.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label1 ----
                label1.setText("Please Pick An Option");
                label1.setForeground(Color.white);
                label1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(label1)
                            .addContainerGap(127, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label1)
                            .addContainerGap(20, Short.MAX_VALUE))
                );
            }

            //---- logOutBTN ----
            logOutBTN.setText("LOGOUT");
            logOutBTN.setForeground(Color.white);
            logOutBTN.setBackground(new Color(153, 153, 153));
            logOutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logOutBTN.addActionListener(e -> logOutBTNActionPerformed(e));

            //---- addBTN ----
            addBTN.setText("ADD CLIENT");
            addBTN.setForeground(Color.white);
            addBTN.setBackground(new Color(153, 153, 153));
            addBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            addBTN.addActionListener(e -> addBTNActionPerformed(e));

            //---- viewBTN ----
            viewBTN.setText("VIEW CLIENTS");
            viewBTN.setForeground(Color.white);
            viewBTN.setBackground(new Color(153, 153, 153));
            viewBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            viewBTN.addActionListener(e -> viewBTNActionPerformed(e));

            //---- updateBTN ----
            updateBTN.setText("UPDATE CLIENT DETAILS");
            updateBTN.setForeground(Color.white);
            updateBTN.setBackground(new Color(153, 153, 153));
            updateBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            updateBTN.addActionListener(e -> updateBTNActionPerformed(e));

            //---- deleteBTN ----
            deleteBTN.setText("DELETE CLIENT");
            deleteBTN.setForeground(Color.white);
            deleteBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            deleteBTN.setBackground(new Color(153, 153, 153));
            deleteBTN.addActionListener(e -> deleteBTNActionPerformed(e));

            GroupLayout backEndLayout = new GroupLayout(backEnd);
            backEnd.setLayout(backEndLayout);
            backEndLayout.setHorizontalGroup(
                backEndLayout.createParallelGroup()
                    .addGroup(backEndLayout.createSequentialGroup()
                        .addGroup(backEndLayout.createParallelGroup()
                            .addGroup(backEndLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addGroup(backEndLayout.createParallelGroup()
                                    .addComponent(admin)
                                    .addGroup(backEndLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addBTN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(updateBTN, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewBTN, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteBTN, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backEndLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(logOutBTN)))
                        .addContainerGap(56, Short.MAX_VALUE))
            );
            backEndLayout.setVerticalGroup(
                backEndLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, backEndLayout.createSequentialGroup()
                        .addGroup(backEndLayout.createParallelGroup()
                            .addComponent(logo, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                            .addGroup(backEndLayout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(logOutBTN)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(admin)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewBTN)
                        .addGap(12, 12, 12)
                        .addComponent(updateBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBTN)
                        .addContainerGap(36, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel backEnd;
    private JLabel admin;
    private JLabel logo;
    private JPanel panel1;
    private JLabel label1;
    private JButton logOutBTN;
    private JButton addBTN;
    private JButton viewBTN;
    private JButton updateBTN;
    private JButton deleteBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
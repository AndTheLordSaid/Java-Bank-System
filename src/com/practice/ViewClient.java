/*
 * Created by JFormDesigner on Mon Nov 16 06:08:30 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;

/**
 * @author CSE19-064
 */
public class ViewClient {
    JDBC datba;
    JFrame adFrame;
    public ViewClient(JDBC datba) {
        initComponents();
        this.datba=datba;
        // Create frame
        adFrame = new JFrame();
        adFrame.setTitle("Administrative Tasks// View Client menu");
        adFrame.add(viewCli);
        adFrame.pack();
        adFrame.setSize(634, 602);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void viewBTNActionPerformed(ActionEvent e) {
        /*******Add Clients to be viewed in JTable*******/
        try {
            ArrayList<Customer>list = datba.listCustomers();
            DefaultTableModel listModel = (DefaultTableModel)displayTable.getModel();
            Object[] row= new Object[5];
            for (int i=0; i<list.size();i++){
             row[0]=list.get(i).getID();
             row[1]=list.get(i).getFname();
             row[2]=list.get(i).getLname();
             row[3]=list.get(i).getGender();
             row[4]=list.get(i).getAddress();

             listModel.addRow(row);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SignIn authenAdmin = new SignIn(datba);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        BackEnd backEnd = new BackEnd(datba);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        viewCli = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        displayTable = new JTable();
        panel1 = new JPanel();
        label2 = new JLabel();
        logoutBTN = new JButton();
        viewBTN = new JButton();
        backBTN = new JButton();

        //======== viewCli ========
        {
            viewCli.setBackground(Color.white);
            viewCli.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border
            .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax
            . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,
            12 ) ,java . awt. Color .red ) ,viewCli. getBorder () ) ); viewCli. addPropertyChangeListener( new java. beans
            .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e.
            getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setForeground(Color.white);
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //---- label3 ----
            label3.setText("ADMIN (View Clients) ");
            label3.setForeground(Color.black);
            label3.setFont(new Font("Mongolian Baiti", Font.ITALIC, 15));

            //======== scrollPane1 ========
            {

                //---- displayTable ----
                displayTable.setForeground(Color.white);
                displayTable.setBackground(new Color(153, 153, 153));
                displayTable.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
                displayTable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "ID Number", "First Name", "Last Name", "Gender", "Address"
                    }
                ));
                scrollPane1.setViewportView(displayTable);
            }

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("CLick View To Display All Current Clients");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(label2)
                            .addContainerGap(67, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(29, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(20, 20, 20))
                );
            }

            //---- logoutBTN ----
            logoutBTN.setText("LOGOUT");
            logoutBTN.setBackground(new Color(153, 153, 153));
            logoutBTN.setForeground(Color.white);
            logoutBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            logoutBTN.addActionListener(e -> logoutBTNActionPerformed(e));

            //---- viewBTN ----
            viewBTN.setText("VIEW");
            viewBTN.setBackground(new Color(153, 153, 153));
            viewBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            viewBTN.setForeground(Color.white);
            viewBTN.addActionListener(e -> viewBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setForeground(Color.white);
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            GroupLayout viewCliLayout = new GroupLayout(viewCli);
            viewCli.setLayout(viewCliLayout);
            viewCliLayout.setHorizontalGroup(
                viewCliLayout.createParallelGroup()
                    .addGroup(viewCliLayout.createSequentialGroup()
                        .addGroup(viewCliLayout.createParallelGroup()
                            .addGroup(viewCliLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(viewCliLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(viewCliLayout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addGap(217, 217, 217)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutBTN))
                            .addGroup(viewCliLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(viewCliLayout.createParallelGroup()
                                    .addComponent(viewBTN)
                                    .addComponent(backBTN)))
                            .addGroup(viewCliLayout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(47, Short.MAX_VALUE))
            );
            viewCliLayout.setVerticalGroup(
                viewCliLayout.createParallelGroup()
                    .addGroup(viewCliLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(viewCliLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(logoutBTN)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(viewCliLayout.createParallelGroup()
                            .addGroup(viewCliLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewCliLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(viewBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(backBTN)))
                        .addContainerGap(34, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel viewCli;
    private JLabel label1;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable displayTable;
    private JPanel panel1;
    private JLabel label2;
    private JButton logoutBTN;
    private JButton viewBTN;
    private JButton backBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
/*
 * Created by JFormDesigner on Wed Dec 02 07:03:02 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 */
public class CloseAcc {
    private JDBC datba;
    JFrame adFrame;
    Connection con;
    PreparedStatement pst;
    
    public CloseAcc(JDBC datba) {
        initComponents();
        this.datba=datba;
        adFrame = new JFrame();
        con=JDBC.dbConnect();
        adFrame.setTitle("Close Account Menu");
        adFrame.add(AccClose);
        adFrame.pack();
        adFrame.setSize(764, 628);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccPicker accPicker = new AccPicker(datba);
    }

    private void logoutBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen test = new ATMAuthen(datba);
    }

    private void deleteBTNActionPerformed(ActionEvent e) {
        if (ownerIDField.getText().isEmpty() && AccNoField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int ownerIdStr= Integer.parseInt(ownerIDField.getText());
                int accNoStr = Integer.parseInt(AccNoField.getText());

                String sql = "delete from chequeingaccount where CheID='"+accNoStr+"'and customers_ID='"+ownerIdStr+"'";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Cheque Account Successfully Deleted", "Alert!", JOptionPane.WARNING_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Account Not Found!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }


    private void DeleteSavAccBTNActionPerformed(ActionEvent e) {
        if (ownIDSavField.getText().isEmpty() && SavingAcNumField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int idStr = Integer.parseInt(ownIDSavField.getText());
                int accNoStr = Integer.parseInt(SavingAcNumField.getText());

                String sql = "delete from savingsaccount where SavID='"+accNoStr+"'and customers_ID='"+idStr+"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Savings Account Successfully Deleted", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Enter The Correct Information!","Alert!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void DeleteIntAccBTNActionPerformed(ActionEvent e) {
        if (ownIntField.getText().isEmpty() && IntAcNumField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int idStr = Integer.parseInt(ownIntField.getText());
                int accNoStr = Integer.parseInt(IntAcNumField.getText());
                
                String sql = "Delete from interestbearingaccount where IntID='"+accNoStr+"'and customers_ID='"+idStr+"'";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Interest Account Successfully Deleted", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception exception){
                JOptionPane.showMessageDialog(null,"Enter The Correct Information!","Alert!",JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void depositBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void ChDepoBTNActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        AccClose = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label6 = new JLabel();
        label3 = new JLabel();
        AccNoField = new JTextField();
        deleteBTN = new JButton();
        backBTN = new JButton();
        logoutBTN = new JButton();
        label4 = new JLabel();
        ownerIDField = new JTextField();
        panel3 = new JPanel();
        label7 = new JLabel();
        panel4 = new JPanel();
        label8 = new JLabel();
        panel5 = new JPanel();
        label9 = new JLabel();
        label5 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        ownIDSavField = new JTextField();
        SavingAcNumField = new JTextField();
        ownIntField = new JTextField();
        IntAcNumField = new JTextField();
        DeleteSavAccBTN = new JButton();
        DeleteIntAccBTN = new JButton();

        //======== AccClose ========
        {
            AccClose.setBackground(Color.white);
            AccClose.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
            . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing
            . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
            Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
            ) ,AccClose. getBorder( )) ); AccClose. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
            public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName (
            ) )) throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel2 ========
            {
                panel2.setBackground(new Color(153, 153, 153));

                //---- label6 ----
                label6.setText("Enter The Account Number Of The Account To Be Closed");
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

            //---- label3 ----
            label3.setText("Enter Account Number");
            label3.setForeground(new Color(102, 102, 102));
            label3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- AccNoField ----
            AccNoField.setForeground(Color.white);
            AccNoField.setBackground(new Color(153, 153, 153));

            //---- deleteBTN ----
            deleteBTN.setText("DELETE");
            deleteBTN.setBackground(new Color(153, 153, 153));
            deleteBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            deleteBTN.setForeground(Color.white);
            deleteBTN.addActionListener(e -> {
			depositBTNActionPerformed(e);
			depositBTNActionPerformed(e);
			ChDepoBTNActionPerformed(e);
			deleteBTNActionPerformed(e);
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

            //---- label4 ----
            label4.setText("Enter Your ID");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ownerIDField ----
            ownerIDField.setBackground(new Color(153, 153, 153));
            ownerIDField.setForeground(Color.white);

            //======== panel3 ========
            {
                panel3.setBackground(new Color(153, 153, 153));

                //---- label7 ----
                label7.setText("Close A Cheque Account");
                label7.setForeground(Color.white);
                label7.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(label7)
                            .addContainerGap(31, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label7)
                            .addGap(14, 14, 14))
                );
            }

            //======== panel4 ========
            {
                panel4.setBackground(new Color(153, 153, 153));

                //---- label8 ----
                label8.setText("Close A Savings Account");
                label8.setForeground(Color.white);
                label8.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(label8)
                            .addContainerGap(31, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label8)
                            .addGap(14, 14, 14))
                );
            }

            //======== panel5 ========
            {
                panel5.setBackground(new Color(153, 153, 153));

                //---- label9 ----
                label9.setText("Close An Interest  Account");
                label9.setForeground(Color.white);
                label9.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(panel5Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(label9)
                            .addContainerGap(31, Short.MAX_VALUE))
                );
                panel5Layout.setVerticalGroup(
                    panel5Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label9)
                            .addGap(14, 14, 14))
                );
            }

            //---- label5 ----
            label5.setText("Enter Your ID");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label10 ----
            label10.setText("Enter Account Number");
            label10.setForeground(new Color(102, 102, 102));
            label10.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label11 ----
            label11.setText("Enter Account Number");
            label11.setForeground(new Color(102, 102, 102));
            label11.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label12 ----
            label12.setText("Enter Your ID");
            label12.setForeground(new Color(102, 102, 102));
            label12.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- ownIDSavField ----
            ownIDSavField.setBackground(new Color(153, 153, 153));
            ownIDSavField.setForeground(Color.white);

            //---- SavingAcNumField ----
            SavingAcNumField.setBackground(new Color(153, 153, 153));
            SavingAcNumField.setForeground(Color.white);

            //---- ownIntField ----
            ownIntField.setBackground(new Color(153, 153, 153));
            ownIntField.setForeground(Color.white);

            //---- IntAcNumField ----
            IntAcNumField.setForeground(Color.white);
            IntAcNumField.setBackground(new Color(153, 153, 153));

            //---- DeleteSavAccBTN ----
            DeleteSavAccBTN.setText("DELETE");
            DeleteSavAccBTN.setBackground(new Color(153, 153, 153));
            DeleteSavAccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DeleteSavAccBTN.setForeground(Color.white);
            DeleteSavAccBTN.addActionListener(e -> DeleteSavAccBTNActionPerformed(e));

            //---- DeleteIntAccBTN ----
            DeleteIntAccBTN.setText("DELETE");
            DeleteIntAccBTN.setForeground(Color.white);
            DeleteIntAccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            DeleteIntAccBTN.setBackground(new Color(153, 153, 153));
            DeleteIntAccBTN.addActionListener(e -> DeleteIntAccBTNActionPerformed(e));

            GroupLayout AccCloseLayout = new GroupLayout(AccClose);
            AccClose.setLayout(AccCloseLayout);
            AccCloseLayout.setHorizontalGroup(
                AccCloseLayout.createParallelGroup()
                    .addGroup(AccCloseLayout.createSequentialGroup()
                        .addGroup(AccCloseLayout.createParallelGroup()
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AccCloseLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(AccCloseLayout.createParallelGroup()
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4)
                            .addComponent(label3)
                            .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(AccNoField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(ownerIDField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(deleteBTN)))
                        .addGap(30, 30, 30)
                        .addGroup(AccCloseLayout.createParallelGroup()
                            .addComponent(label5)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label10)
                            .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(SavingAcNumField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addComponent(ownIDSavField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(DeleteSavAccBTN)))
                        .addGap(29, 29, 29)
                        .addGroup(AccCloseLayout.createParallelGroup()
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(DeleteIntAccBTN)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addGroup(AccCloseLayout.createParallelGroup()
                                    .addComponent(logoutBTN)
                                    .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(AccCloseLayout.createSequentialGroup()
                                .addGroup(AccCloseLayout.createParallelGroup()
                                    .addComponent(label11)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label12)
                                    .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(IntAcNumField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                        .addComponent(ownIntField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                                .addGap(0, 86, Short.MAX_VALUE))))
            );
            AccCloseLayout.setVerticalGroup(
                AccCloseLayout.createParallelGroup()
                    .addGroup(AccCloseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(panel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label12)
                            .addComponent(label5)
                            .addComponent(label4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AccCloseLayout.createParallelGroup()
                            .addComponent(ownerIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(ownIDSavField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(ownIntField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(label10)
                            .addComponent(label11))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(AccNoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(SavingAcNumField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(IntAcNumField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AccCloseLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN)
                            .addComponent(deleteBTN)
                            .addComponent(DeleteSavAccBTN)
                            .addComponent(DeleteIntAccBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoutBTN)
                        .addContainerGap())
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel AccClose;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label6;
    private JLabel label3;
    private JTextField AccNoField;
    private JButton deleteBTN;
    private JButton backBTN;
    private JButton logoutBTN;
    private JLabel label4;
    private JTextField ownerIDField;
    private JPanel panel3;
    private JLabel label7;
    private JPanel panel4;
    private JLabel label8;
    private JPanel panel5;
    private JLabel label9;
    private JLabel label5;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JTextField ownIDSavField;
    private JTextField SavingAcNumField;
    private JTextField ownIntField;
    private JTextField IntAcNumField;
    private JButton DeleteSavAccBTN;
    private JButton DeleteIntAccBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

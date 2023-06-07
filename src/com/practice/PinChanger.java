/*
 * Created by JFormDesigner on Wed Dec 02 09:06:50 CAT 2020
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
public class PinChanger {
    private JDBC datba;
    Connection con;
    PreparedStatement pst;
    JFrame adFrame;

    public PinChanger(JDBC datba) {
        initComponents();
        this.datba=datba;
        con=JDBC.dbConnect();
        adFrame = new JFrame();
        adFrame.setTitle("Client Change PIN");
        adFrame.add(ChangePin);
        adFrame.pack();
        adFrame.setSize(629, 483);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccPicker accPicker = new AccPicker(datba);
    }

    private void pinChangeBTNActionPerformed(ActionEvent e) {
        if (IDField.getText().isEmpty() && pinField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Fill The Fields!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
        else {
            try {
                int idStr = Integer.parseInt(IDField.getText());
                int pinStr = Integer.parseInt(pinField.getText());

                String sql = "UPDATE customerpin set ID='"+idStr+"',PIN='"+pinStr+"'where ID='"+idStr+"'";
                pst = con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Pin Changed", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
            catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Enter The Correct Information!", "Alert!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        ChangePin = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        backBTN = new JButton();
        label4 = new JLabel();
        IDField = new JTextField();
        label5 = new JLabel();
        pinField = new JPasswordField();
        pinChangeBTN = new JButton();

        //======== ChangePin ========
        {
            ChangePin.setBackground(Color.white);
            ChangePin.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
            EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing
            . border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ),
            java. awt. Color. red) ,ChangePin. getBorder( )) ); ChangePin. addPropertyChangeListener (new java. beans. PropertyChangeListener( )
            { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () ))
            throw new RuntimeException( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("Enter Your ID and New PIN");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(55, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(48, 48, 48))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label2)
                            .addContainerGap(19, Short.MAX_VALUE))
                );
            }

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setForeground(Color.white);
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- label4 ----
            label4.setText("Enter Your ID");
            label4.setForeground(new Color(102, 102, 102));
            label4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- IDField ----
            IDField.setForeground(Color.white);
            IDField.setBackground(new Color(153, 153, 153));

            //---- label5 ----
            label5.setText("Enter Your New PIN");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- pinField ----
            pinField.setBackground(new Color(153, 153, 153));
            pinField.setForeground(Color.white);

            //---- pinChangeBTN ----
            pinChangeBTN.setText("CHANGE PIN");
            pinChangeBTN.setBackground(new Color(153, 153, 153));
            pinChangeBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            pinChangeBTN.setForeground(Color.white);
            pinChangeBTN.addActionListener(e -> pinChangeBTNActionPerformed(e));

            GroupLayout ChangePinLayout = new GroupLayout(ChangePin);
            ChangePin.setLayout(ChangePinLayout);
            ChangePinLayout.setHorizontalGroup(
                ChangePinLayout.createParallelGroup()
                    .addGroup(ChangePinLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(104, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, ChangePinLayout.createSequentialGroup()
                        .addContainerGap(185, Short.MAX_VALUE)
                        .addGroup(ChangePinLayout.createParallelGroup()
                            .addGroup(ChangePinLayout.createSequentialGroup()
                                .addGroup(ChangePinLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, ChangePinLayout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(72, 72, 72))
                                    .addGroup(ChangePinLayout.createSequentialGroup()
                                        .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)))
                                .addGroup(ChangePinLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pinField))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, ChangePinLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(ChangePinLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, ChangePinLayout.createSequentialGroup()
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(188, 188, 188))
                                    .addGroup(GroupLayout.Alignment.TRAILING, ChangePinLayout.createSequentialGroup()
                                        .addComponent(pinChangeBTN)
                                        .addGap(119, 119, 119)
                                        .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19))))))
            );
            ChangePinLayout.setVerticalGroup(
                ChangePinLayout.createParallelGroup()
                    .addGroup(ChangePinLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ChangePinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(label5))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ChangePinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ChangePinLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(backBTN)
                            .addComponent(pinChangeBTN))
                        .addGap(46, 46, 46))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel ChangePin;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JButton backBTN;
    private JLabel label4;
    private JTextField IDField;
    private JLabel label5;
    private JPasswordField pinField;
    private JButton pinChangeBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

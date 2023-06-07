/*
 * Created by JFormDesigner on Wed Dec 02 09:41:25 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 */
public class CreatePin {
    private JDBC datba;
    JFrame adFrame;
    public CreatePin(JDBC datba) {
        initComponents();
        this.datba=datba;
        adFrame = new JFrame();
        adFrame.setTitle("Client: Create PIN");
        // Add panel to frame
        adFrame.add(PinCreate);//name of panel
        adFrame.pack();
        adFrame.setSize(659, 517);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
        
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen test = new ATMAuthen(datba);
    }

    private void createPBTNActionPerformed(ActionEvent e) {
        try {
            int pinStr = Integer.parseInt(pinField.getText());
            int idStr = Integer.parseInt(IDField.getText());
            int i = datba.pinMaker(idStr,pinStr);

            if (i>0){
                JOptionPane.showMessageDialog(null, "PIN Successfully Created","Alert!",JOptionPane.WARNING_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null, "ERROR: PIN Not Created!","Alert!",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Please Enter The Correct Information!","Alert!",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        PinCreate = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        IDField = new JTextField();
        backBTN = new JButton();
        pinField = new JPasswordField();
        createPBTN = new JButton();

        //======== PinCreate ========
        {
            PinCreate.setBackground(Color.white);
            PinCreate.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,PinCreate. getBorder( )) )
            ; PinCreate. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("Create Your PIN");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(111, 111, 111))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(label2)
                            .addContainerGap(20, Short.MAX_VALUE))
                );
            }

            //---- label5 ----
            label5.setText("Enter Your New PIN");
            label5.setForeground(new Color(102, 102, 102));
            label5.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- label6 ----
            label6.setText("Enter Your ID");
            label6.setForeground(new Color(102, 102, 102));
            label6.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

            //---- IDField ----
            IDField.setForeground(Color.white);
            IDField.setBackground(new Color(153, 153, 153));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setForeground(Color.white);
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- pinField ----
            pinField.setBackground(new Color(153, 153, 153));
            pinField.setForeground(Color.white);

            //---- createPBTN ----
            createPBTN.setText("CREATE PIN");
            createPBTN.setForeground(Color.white);
            createPBTN.setBackground(new Color(153, 153, 153));
            createPBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            createPBTN.addActionListener(e -> createPBTNActionPerformed(e));

            GroupLayout PinCreateLayout = new GroupLayout(PinCreate);
            PinCreate.setLayout(PinCreateLayout);
            PinCreateLayout.setHorizontalGroup(
                PinCreateLayout.createParallelGroup()
                    .addGroup(PinCreateLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(158, Short.MAX_VALUE))
                    .addGroup(PinCreateLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(PinCreateLayout.createParallelGroup()
                            .addGroup(PinCreateLayout.createSequentialGroup()
                                .addGroup(PinCreateLayout.createParallelGroup()
                                    .addComponent(label6)
                                    .addComponent(IDField, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(PinCreateLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(pinField, GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                .addGap(43, 43, 43))
                            .addGroup(PinCreateLayout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addComponent(backBTN, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(GroupLayout.Alignment.TRAILING, PinCreateLayout.createSequentialGroup()
                        .addContainerGap(295, Short.MAX_VALUE)
                        .addComponent(createPBTN)
                        .addGap(237, 237, 237))
            );
            PinCreateLayout.setVerticalGroup(
                PinCreateLayout.createParallelGroup()
                    .addGroup(PinCreateLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PinCreateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label5)
                            .addComponent(label6))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PinCreateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createPBTN)
                        .addGap(4, 4, 4)
                        .addComponent(backBTN)
                        .addContainerGap(46, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel PinCreate;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label5;
    private JLabel label6;
    private JTextField IDField;
    private JButton backBTN;
    private JPasswordField pinField;
    private JButton createPBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Sun Nov 29 15:46:48 CAT 2020
 */

package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author CSE19-064
 *
 */
public class AccPicker {
    private JDBC datba;
    JFrame adFrame;
    public AccPicker(JDBC datba) {
        initComponents();
        this.datba = datba;
        adFrame = new JFrame();
        adFrame.setTitle("Client Account Options");
        adFrame.add(AccPick);
        adFrame.pack();
        adFrame.setSize(584, 490);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);
    }

    private void CAccBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ChequeAcc chequeAcc = new ChequeAcc();
    }

    private void SAccBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        SavingAcc savingAcc = new SavingAcc();
    }

    private void IAccBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        InterstAcc interstAcc = new InterstAcc();
    }

    private void backBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        ATMAuthen test = new ATMAuthen(datba);
    }
    private void openaccBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        AccountOpen accountOpen = new AccountOpen(datba);
    }

    private void closeaccBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        CloseAcc closeAcc = new CloseAcc(datba);
    }

    private void chgPinBTNActionPerformed(ActionEvent e) {
        adFrame.dispose();
        PinChanger pinChanger = new PinChanger(datba);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        AccPick = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        CAccBTN = new JButton();
        backBTN = new JButton();
        SAccBTN = new JButton();
        IAccBTN = new JButton();
        closeaccBTN = new JButton();
        openaccBTN = new JButton();
        chgPinBTN = new JButton();

        //======== AccPick ========
        {
            AccPick.setBackground(Color.white);
            AccPick.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,AccPick. getBorder
            ( )) ); AccPick. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/practice/odyssey bank log11.png")));

            //======== panel1 ========
            {
                panel1.setBackground(new Color(153, 153, 153));

                //---- label2 ----
                label2.setText("Pick An Account You Want To Deposit/Withdraw From");
                label2.setForeground(Color.white);
                label2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(label2)
                            .addContainerGap(26, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(label2)
                            .addContainerGap(22, Short.MAX_VALUE))
                );
            }

            //---- CAccBTN ----
            CAccBTN.setText("CHEQUEING ACCOUNT");
            CAccBTN.setBackground(new Color(153, 153, 153));
            CAccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            CAccBTN.setForeground(Color.white);
            CAccBTN.addActionListener(e -> CAccBTNActionPerformed(e));

            //---- backBTN ----
            backBTN.setText("BACK");
            backBTN.setBackground(new Color(153, 153, 153));
            backBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            backBTN.setForeground(Color.white);
            backBTN.addActionListener(e -> backBTNActionPerformed(e));

            //---- SAccBTN ----
            SAccBTN.setText("SAVINGS ACCOUNT");
            SAccBTN.setBackground(new Color(153, 153, 153));
            SAccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            SAccBTN.setForeground(Color.white);
            SAccBTN.addActionListener(e -> SAccBTNActionPerformed(e));

            //---- IAccBTN ----
            IAccBTN.setText("INTEREST ACCOUNT");
            IAccBTN.setBackground(new Color(153, 153, 153));
            IAccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            IAccBTN.setForeground(Color.white);
            IAccBTN.addActionListener(e -> IAccBTNActionPerformed(e));

            //---- closeaccBTN ----
            closeaccBTN.setText("CLOSE ACCOUNT");
            closeaccBTN.setBackground(new Color(153, 153, 153));
            closeaccBTN.setForeground(Color.white);
            closeaccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            closeaccBTN.addActionListener(e -> closeaccBTNActionPerformed(e));

            //---- openaccBTN ----
            openaccBTN.setText("OPEN ACCOUNT");
            openaccBTN.setBackground(new Color(153, 153, 153));
            openaccBTN.setForeground(Color.white);
            openaccBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            openaccBTN.addActionListener(e -> openaccBTNActionPerformed(e));

            //---- chgPinBTN ----
            chgPinBTN.setText("CHANGE PIN");
            chgPinBTN.setBackground(new Color(153, 153, 153));
            chgPinBTN.setForeground(Color.white);
            chgPinBTN.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
            chgPinBTN.addActionListener(e -> chgPinBTNActionPerformed(e));

            GroupLayout AccPickLayout = new GroupLayout(AccPick);
            AccPick.setLayout(AccPickLayout);
            AccPickLayout.setHorizontalGroup(
                AccPickLayout.createParallelGroup()
                    .addGroup(AccPickLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(AccPickLayout.createParallelGroup()
                            .addComponent(SAccBTN, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addComponent(CAccBTN, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                            .addGroup(AccPickLayout.createSequentialGroup()
                                .addGroup(AccPickLayout.createParallelGroup()
                                    .addComponent(openaccBTN, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IAccBTN, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(closeaccBTN, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addGroup(AccPickLayout.createParallelGroup()
                                    .addComponent(chgPinBTN)
                                    .addComponent(backBTN, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))))
                    .addGroup(AccPickLayout.createSequentialGroup()
                        .addGroup(AccPickLayout.createParallelGroup()
                            .addGroup(AccPickLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE))
                            .addGroup(AccPickLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(96, Short.MAX_VALUE))
            );
            AccPickLayout.setVerticalGroup(
                AccPickLayout.createParallelGroup()
                    .addGroup(AccPickLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CAccBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SAccBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IAccBTN)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccPickLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(openaccBTN)
                            .addComponent(chgPinBTN))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AccPickLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(closeaccBTN)
                            .addComponent(backBTN))
                        .addContainerGap(38, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel AccPick;
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JButton CAccBTN;
    private JButton backBTN;
    private JButton SAccBTN;
    private JButton IAccBTN;
    private JButton closeaccBTN;
    private JButton openaccBTN;
    private JButton chgPinBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

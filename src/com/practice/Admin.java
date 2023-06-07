package com.practice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author CSE19-064
 */

/*************************************************************/
/*************************************************************/
/*************************************************************/
/**********************ADMIN GUI******************************/
/*************************************************************/
/*************************************************************/
/*************************************************************/
public class Admin extends JFrame{
    private JPanel panel1;
    private JTextField Fnametextf;
    private JTextField Lnametextf;
    private JTextField Gendertextf;
    private JTextField IDtextf;
    private JTextField Addresstextf;
    private JButton addCustomerButton;
    private JButton viewCustomersButton;
    private JButton updateCustomerButton;
    private JButton deleteCustomersButton;
    private JButton customerAccountButton;
    private JButton savingsAccountsButton;
    private JButton chequeAccountsButton;
    private JButton interestBearingAccountsButton;
    private JTable table1;
    private JTextArea ListArea;


    private JDBC datba;
    private JFrame adFrame;

    public Admin(JDBC datba){
        this.datba=datba;
        // Create frame with title Registration Demo
        adFrame.setTitle(" Registration Demo");
        // Add panel to frame
        adFrame.add(panel1);
        adFrame.pack();
        adFrame.setSize(800, 600);
        adFrame.setLocationRelativeTo(null);
        adFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFrame.setVisible(true);

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                int ID = Integer.parseInt(IDtextf.getText());
                String Fname = Fnametextf.getText();
                String Lname = Lnametextf.getText();
                String Gender = Gendertextf.getText();
                String Address = Addresstextf.getText();
                int i = datba.addCustomer(ID,Fname,Lname,Gender,Address);
                if (i>0)
                    JOptionPane.showMessageDialog(null,"Successfully Added","Alert",JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"Error: Customer Not Added", "Alert",JOptionPane.WARNING_MESSAGE);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        viewCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Customer> list = datba.listCustomers();
                    ListArea.setText(" ");
                    for (int i = 0; i<list.size(); i++)
                        ListArea.append(list.get(i).toString()+"\n");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*try{
                    int ID = Integer.parseInt(Lnametextf.getText());
                    String Fname = Fnametextf.getText();
                    String Lname = Lnametextf.getText();
                    String Gender = Gendertextf.getText();
                    String Address = Addresstextf.getText();
                    int i = datba.updateCustomer(ID,Fname,Lname,Gender,Address);
                    if (i>0)
                        JOptionPane.showMessageDialog(null,"Successfully Updated","Alert",JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null,"Error: Customer Not Updated", "Aler",JOptionPane.WARNING_MESSAGE);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }*/
            }
        });
        deleteCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Fname = Fnametextf.getText();
                String Lname = Lnametextf.getText();

                int i = 0;
                try {
                    i = datba.deleteCustomer(Fname,Lname);
                    if (i>0)
                        JOptionPane.showMessageDialog(null,"Successfully Deleted","Alert",JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null,"Error: Customer Not Deleted","Alert",JOptionPane.WARNING_MESSAGE);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        customerAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

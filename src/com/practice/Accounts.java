package com.practice;

import javax.swing.*;
import java.util.Objects;
/**
 * @author CSE19-064
 */
  public class Accounts {
    private int ID,AccNo;
    private String AccType;
    private double Balance;

    public Accounts(int AccNo, int ID,String AccType,double Balance){
        this.ID=ID;
        this.AccNo=AccNo;
        this.AccType=AccType;
        this.Balance=Balance;

    }

    @Override
    public String toString() {
        return "Account{ " +
                "Account Number: " + AccNo + '\'' +
                "ID: " + ID + '\'' +
                "Account Type: " + AccType + '\'' +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ||getClass() != obj.getClass())return false;
        Accounts accounts = (Accounts)obj;
        return  AccNo == accounts.AccNo &&
                ID == accounts.ID &&
                Objects.equals(AccType,accounts.AccType);

    }
    /******************************SETTERS & GETTERS******************************************/

    public void setAccType(String accType) {
        AccType = accType;
    }

    public String getAccType() {
        return AccType;
    }

    public int getID() {
        return ID;
    }
    public int getAccNo() {
        return AccNo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAccNo(int accNo) {
        AccNo = accNo;
    }

}
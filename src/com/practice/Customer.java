package com.practice;
import java.util.Objects;
public class Customer {
    private int ID;
    private String Fname, Lname, Gender, Address;

    public Customer(int ID, String Fname, String Lname, String Gender, String Address) {
        this.ID= ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Gender= Gender;
        this.Address= Address;
    }

    @Override
    public String toString() {
        return "Customer{ "+
                "ID: " + ID +
                "Fname: " + Fname + '\'' +
                "Lname: " + Lname+ '\'' +
                "Gender"+ Gender+ '\'' +
                "Address"+ Address+ '\'' +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;;
        Customer customer= (Customer)obj;
        return ID == customer.ID &&
                Objects.equals(Fname, customer.Fname) &&
                Objects.equals(Lname, customer.Lname) &&
                Objects.equals(Gender, customer.Gender) &&
                Objects.equals(Address, customer.Address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID,Fname,Lname,Gender,Address);
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getID() {
        return ID;
    }


}
package com.practice;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author CSE19-064
 */
public class JDBC {
    Connection con;
    PreparedStatement pst;
    ResultSet rset;
    Statement stmt;
    public String UserName;
    public String Password;
    public int ID;
    public int PIN;

    public  JDBC(){
        String url = "jdbc:mysql://127.0.0.1:3306/BankSystem";
        String user = "root";
        String password = "cse19-064";
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Connected");

        }catch (Exception e){
            //JOptionPane.showMessageDialog(null, e);
            System.out.println("Connection failed");
        }

    }//to be called in various methods outside this class
    public static Connection dbConnect(){
        String url = "jdbc:mysql://127.0.0.1:3306/BankSystem";
        String user = "root";
        String password = "cse19-064";
        Connection con1=null;
        try {
            con1 = DriverManager.getConnection(url,user,password);
            System.out.println("Connected: con methods");
            return con1;
        }catch (Exception e){
            System.out.println("Connection Failed!: con methods");
        }
        return null;
    }
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /*******************************************ADMIN CONTROLS****************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    public int addCustomer(int ID, String Fname, String Lname, String Gender, String Address) throws SQLException{
        String query = "insert into Customers(ID, Fname, Lname, Gender, Address) values(?,?,?,?,?)";

        pst = con.prepareStatement(query);
        pst.setInt(1, ID);
        pst.setString(2,Fname);
        pst.setString(3, Lname);
        pst.setString(4, Gender);
        pst.setString(5,Address);
        int status= pst.executeUpdate();

        return status;
    }
    public int deleteCustomer(String Fname, String Lname) throws SQLException {
        String sql = "DELETE FROM customers where Fname =? and Lname=?";
        PreparedStatement preparedStatement= con.prepareStatement(sql);
        preparedStatement.setString(1, Fname);
        preparedStatement.setString(2, Lname);
        int del=preparedStatement.executeUpdate();

        return del;
    }

    public ArrayList<Customer> listCustomers() throws SQLException {
        stmt=con.createStatement();
        String sql = "SELECT ID, Fname, Lname, Gender, Address FROM customers";
        rset = stmt.executeQuery(sql);
        ArrayList<Customer> list = new ArrayList<>();

        while(rset.next()){
            //Retrieve by column name
            int ID  = rset.getInt("ID");
            String Fname = rset.getString("Fname");
            String Lname = rset.getString("Lname");
            String Gender = rset.getString("Gender");
            String Address = rset.getString("Address");

            Customer  cus = new Customer(ID,Fname,Lname,Gender,Address);
            list.add(cus);
        }
        rset.close();
        return list;
    }
    public boolean adminlogin(String Username, String Password) throws SQLException{
        String sql="select * from adminlogin where Username='"+
                Username+
                "'and Password='"+
                Password+
                "'";

        pst=con.prepareStatement(sql);
        rset=pst.executeQuery();
        while (rset.next()){
            this.UserName = rset.getString("Username");
            this.Password = rset.getString("Password");

            return true;
        }
        return false;
    }
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /********************************************USER CONTROLS****************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    /*************************************************************************************************************/
    public int addSavings(int AccNo,int ID,String AccType,double Balance)throws SQLException{
        String sql2="insert into savingsaccount(SavID,customers_ID,AccountType,Balance) values(?,?,?,?)";
        pst = con.prepareStatement(sql2);
        pst.setInt(1, AccNo);
        pst.setInt(2,ID);
        pst.setString(3, AccType);
        pst.setDouble(4,Balance);

        int status= pst.executeUpdate();

        return status;
    }
    public int addCheque(int AccNo,int ID,String AccType,double Balance)throws SQLException{
        String sql3="insert into chequeingaccount(CheID,customers_ID,AccountType,Balance) values(?,?,?,?)";
        pst = con.prepareStatement(sql3);
        pst.setInt(1, AccNo);
        pst.setInt(2,ID);
        pst.setString(3, AccType);
        pst.setDouble(4,Balance);

        int status= pst.executeUpdate();

        return status;
    }public int addInterestBearing(int AccNo,int ID,String AccType,double Balance)throws SQLException{
        String sql4="insert into interestbearingaccount(IntID,customers_ID,AccountType,Balance) values(?,?,?,?)";
        pst = con.prepareStatement(sql4);
        pst.setInt(1, AccNo);
        pst.setInt(2,ID);
        pst.setString(3, AccType);
        pst.setDouble(4,Balance);

        int status= pst.executeUpdate();

        return status;
    }
    public int deleteAccount(int OwnerID, int AccID)throws SQLException{
        String sql="DELETE FROM ownership WHERE OwnerID=? and AccID=?";
        pst = con.prepareStatement(sql);
        pst.setInt(1, OwnerID);
        pst.setInt(2, AccID);
        int del= pst.executeUpdate();

        return del;
    }
    public ArrayList<Accounts> listAccount()throws SQLException{
        stmt=con.createStatement();
        String sql="SELECT AccNo,ID,AccType,Balance FROM accounts";
        rset = stmt.executeQuery(sql);
        ArrayList<Accounts> list= new ArrayList<>();
        while (rset.next()){
            //retrive by column name
            int AccNo = rset.getInt("AccNo");
            int ID = rset.getInt("ID");
            String AccType= rset.getString("AccType");
            Double Balance= rset.getDouble("Balance");

            Accounts accounts = new Accounts(AccNo,ID,AccType,Balance);
            list.add(accounts);
        }rset.close();
        return list;
    }
    public int pinMaker(int ID,int PIN)throws SQLException{
        String sql = "insert into customerpin (ID,PIN) values (?,?)";
        pst=con.prepareStatement(sql);
        pst.setInt(1, ID);
        pst.setInt(2, PIN);
        int status = pst.executeUpdate();

        return status;
    }
    public int pinChange(int ID,int PIN)throws SQLException{
        String sql = "update customerpin set ID='"+ID+"',PIN='"+PIN+"'where ID='"+ID+"'";
        pst=con.prepareStatement(sql);
        pst.setInt(2,PIN);
        int update = pst.executeUpdate();

        return update;
    }
    public boolean clientLogin(int ID, int PIN) throws SQLException{
        String sql="select * from customerpin where PIN='"+
                PIN+
                "'and ID='"+
                ID+
                "'";

        pst=con.prepareStatement(sql);
        rset=pst.executeQuery();
        while (rset.next()){
            this.PIN = rset.getInt("PIN");
            this.ID = rset.getInt("ID");
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        JDBC datba = new JDBC();
        SignIn signIn = new SignIn(datba);
    }
}
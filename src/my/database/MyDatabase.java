/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Bill;
import model.Company;
import sun.security.jca.GetInstance;

/**
 *
 * @author Administrator
 */
public class MyDatabase {
    private static MyDatabase instance = null;
    Connection con;
    Statement st;
    ResultSet rs;
    
    
    private MyDatabase(){
    }
    
    public static MyDatabase getInstance(){
        if(instance == null){
            instance = new MyDatabase();
        }
        return instance;
    }
    
    public void createCompanyTable(){
   
        String sql2 = "CREATE TABLE [company_info] (\n" +
                "[id] AUTOINCREMENT PRIMARY KEY,\n" +
                "[name] VARCHAR(255)  NULL,\n" +
                "[address] VARCHAR(255)  NULL,\n" +
                "[phone] VARCHAR(255)  NULL\n" +
                ")";
        try {
            st.execute(sql2);
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createBillTable(){
        String sql = "CREATE TABLE [bill_tbl] (\n" +
                    "[Id] AUTOINCREMENT PRIMARY KEY,\n" +
                    "[Ngay] Date  NULL,\n" +
                    "[MaHang] NVARCHAR(255)  NULL,\n" +
                    "[TenHang] NVARCHAR(255)  NULL,\n" +
                    "[SoLuong] NVARCHAR(150)  NULL,\n" +
                    "[DonGia] NVARCHAR(255)  NULL\n" +
                     ")";
        try {
            st.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDatabase(){
        try{
             Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
             String url = "jdbc:ucanaccess://E:/hoadon.accdb"+ ";newdatabaseversion=V2007";
             String username ="";
             String password="";
             con = DriverManager.getConnection(url, username, password);
             
             DatabaseMetaData dbm = con.getMetaData();
             ResultSet tables = dbm.getTables(null,null,"company_info",null);
             if(tables.next()){
                 //table exists
             }
             else{
                st = con.createStatement();
                createCompanyTable();
                createBillTable();
             }
            System.out.println("DONE");
         }
         catch(Exception e){
             e.printStackTrace();
         }
     }
    
    public void insertCompanyTable(Company company){
        String sql = "INSERT INTO company_info(name,address,phone)"
                + "VALUES('" + company.getName()
                + "','"+company.getAddress()
                + "','"+company.getPhone()+ "')";
        String sqlDelete = "DELETE FROM company_info";
        try {
            st = con.createStatement();
            st.executeUpdate(sqlDelete); 
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Lưu thông tin thành công");
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Có lỗi");
        }
    }

    public Company getDataFromCompanyTable(){
        Company company = null;
     //   ArrayList<Company> myArr = new ArrayList<>();
        String sql = "SELECT * FROM company_info";
        
        try {
               st = con.createStatement();
             ResultSet result = st.executeQuery(sql);
             while(result.next()){
                 company = new Company(result.getString(2).toString(),
                         result.getString(3).toString(),result.getString(4).toString());

          //     myArr.add(item);
             }
             result.close();
             st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return company;
    }
       
    public void insertBillTable(Bill bill){
        String sql ="INSERT INTO bill_tbl(Ngay,MaHang,TenHang,SoLuong,DonGia)"
                +"VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDate(1, java.sql.Date.valueOf(bill.getDateInSql()));
            pre.setString(2,bill.getDSMaHang());
            pre.setString(3,bill.getDSTenHang());
            pre.setString(4,bill.getDSSoLuong());
            pre.setString(5,bill.getDSDonGia());
            
            pre.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String convertDate(String date){
        String[] s  = date.split(" ");
        return s[0];
    }
    
    public ArrayList<Bill> getDataFromBillTbl(){
        ArrayList<Bill> myArr = new ArrayList<>();
        String sql = "SELECT * FROM bill_tbl";
          try {
             st = con.createStatement();
             ResultSet result = st.executeQuery(sql);
             while(result.next()){
                Bill item = new Bill((Long)result.getLong(1),convertDate(result.getString(2)),
                result.getString(3),result.getString(4),result.getString(5),result.getString(6));
                System.out.println(item.toString());
                   
               myArr.add(item);
             }
             result.close();
             st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myArr;
    }
    
    public ArrayList<Bill> getDataFromBillTblBy(int day,int month,int year){
        ArrayList<Bill> myArr = new ArrayList<>();
        String sql ="";
        if(day>0){
            sql = "SELECT * FROM bill_tbl WHERE DAY(Ngay) = "+ day +
                    " AND MONTH(Ngay) = "+month + " AND YEAR(Ngay) = "+ year;
                   
        }
        else if(month >0){
             sql = "SELECT * FROM bill_tbl WHERE " +
                    "MONTH(Ngay) = "+month + " AND YEAR(Ngay) = "+ year;
        }
        else{
             sql = "SELECT * FROM bill_tbl WHERE " +
                    "YEAR(Ngay) = "+ year;
        }
      //  sql = "SELECT * FROM bill_tbl";
          try {
             st = con.createStatement();
             ResultSet result = st.executeQuery(sql);
             while(result.next()){
                Bill item = new Bill((Long)result.getLong(1),convertDate(result.getString(2)),
                result.getString(3),result.getString(4),result.getString(5),result.getString(6));
                System.out.println(item.toString());
                   
               myArr.add(item);
             }
             result.close();
             st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myArr;
    }
    
     public ArrayList<Bill> getDataFromBillTblById(int id){
        ArrayList<Bill> myArr = new ArrayList<>();
        String sql = "SELECT * FROM bill_tbl WHERE Id = "+ id;
          try {
             st = con.createStatement();
             ResultSet result = st.executeQuery(sql);
             while(result.next()){
                Bill item = new Bill((Long)result.getLong(1),convertDate(result.getString(2)),
                result.getString(3),result.getString(4),result.getString(5),result.getString(6));
                System.out.println(item.toString());
                   
               myArr.add(item);
             }
             result.close();
             st.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MyDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myArr;
    }
    
    
    
    public int getRowCountBillTbl(){
        int t = 0;
        
        String sql = "SELECT COUNT(*) FROM bill_tbl";
        try{
             st = con.createStatement();
             rs = st.executeQuery(sql);
             rs.next();
             t = rs.getInt(1);
             rs.close();
             st.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return t;
    }
    
}

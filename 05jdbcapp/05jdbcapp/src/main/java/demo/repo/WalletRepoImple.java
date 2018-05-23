package demo.repo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import demo.beans.Customer;
import demo.beans.Wallet;

import java.lang.annotation.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class WalletRepoImple implements WalletRepoInterface {
     	   static int id;
	       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
           static final String DB_URL = "jdbc:mysql://localhost/test";
	       Connection conn = null;
public boolean save(Customer c) throws SQLException, ClassNotFoundException{  
	   
		    Class.forName("com.mysql.jdbc.Driver");
	       // System.out.println("Connecting to a selected database...");
	        conn = DriverManager.getConnection(DB_URL);
	       // System.out.println("Connected database successfully...");
	        
	        int rows; 
	        id++;
	        String name = c.getName();
	        String mobileNo= c.getMobileNumber();
	        Wallet wallet = c.getWallet();
	        float balance = wallet.getBalance();
		 	
	        String insertQuery1;
			insertQuery1 = "insert into Wallet values("+ id +","+ balance +")";
			Statement insertStatement = conn.createStatement();
			rows = insertStatement.executeUpdate(insertQuery1);
			String insertQuery2 = "insert into Customer values(" + id +",'"+ name +"',"+ mobileNo + ","+ id +")";
			Statement insertStatement1 = conn.createStatement();
			rows = insertStatement1.executeUpdate(insertQuery2);
		    if(rows > 0){
				System.out.println("Row is added in a table");
				}
		    return true;
	}

	public Customer findOne(String mobileNumber){
		    try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        //System.out.println("Connecting to a selected database...");
	        try {
				conn = DriverManager.getConnection(DB_URL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    //    System.out.println("Connected database successfully...");
	      
		  Customer c = new Customer();
		  Wallet w = new Wallet();
	   String query = "select  Customer.name, Customer.mobile,wallet.balance from Customer natural join Wallet where Customer.id = Wallet.id and mobile like "+mobileNumber+" ;";
	    	 Statement statement = null;
	    	    ResultSet rs = null;
	    	try {
	    		statement = conn.createStatement();
	    		rs = statement.executeQuery(query);
		    	    while (rs.next()) {
		                String name = rs.getString(1);
	    	            String mobileNo = rs.getString(2);
	    	            float balance = rs.getFloat(3);
	    	            w.setBalance(balance);
	    	            c.setMobileNumber(mobileNo);
	    	            c.setName(name);
	    	            c.setWallet(w);
	    	            
	    	      }
	    	    } catch (SQLException e ) {
	    	        e.printStackTrace();
				    }
	    	finally {
	            if (statement != null) { try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} }
	        }
			return c;
    }
	public boolean update(Customer c) throws SQLException, ClassNotFoundException{  
		   
	    Class.forName("com.mysql.jdbc.Driver");
        //System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL);
        //System.out.println("Connected database successfully...");
        int rows; 
        String mobileNo= c.getMobileNumber();
        Wallet wallet = c.getWallet();
        float amount = wallet.getBalance();
	 	
        String insertQuery1;
		insertQuery1 = "Update customer INNER JOIN wallet on wallet.id = customer.walletid set wallet.balance= " + amount + "where customer.mobile = "+ mobileNo +"" ;  
		Statement statement = conn.createStatement();
		rows = statement.executeUpdate(insertQuery1);
		if(rows > 0){
			System.out.println("Row is updated in the table");
			}
	    return true;
}
}

package demo.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Entry {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/test";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   Statement stmt1 = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL);
	      System.out.println("Connected database successfully...");
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	      
	      String sql = "CREATE TABLE Wallet " +
	                   "(id INTEGER not NULL, " +
	                   " balance INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 

	      stmt.executeUpdate(sql);
	      System.out.println("Created table in given database...");
	      
     stmt1 = conn.createStatement();
	      
	      String sql1 = "CREATE TABLE Customer " +
	                   "(id INTEGER not NULL, " +
	                  " name VARCHAR(50), " + 
	                   " mobile VARCHAR(10), " + 
	                   //" balance INTEGER, " + 
	                   "Walletid INTEGER not NULL, "+
	                   " PRIMARY KEY (id)," +
	                    "foreign key(Walletid) references Wallet(id))";  
	      stmt1.executeUpdate(sql1);
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end JDBCExample



package demo.client;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import demo.anno.AppConfig;
import demo.beans.Customer;
import demo.repo.WalletRepoImple;
//import demo.repo.WalletRepoInterface;
import demo.service.WalletServiceImple;
import demo.service.WalletServiceInterface;
//import org.springframework.context.support.GenericXmlApplicationContext;
public class MainClient {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
	AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
	WalletServiceImple	s = con.getBean("service",WalletServiceImple.class);
    /* s.createAccount("laveena" , "9661410119" , 28000);
       s.createAccount("RK", "9656980756", 25000);
       s.createAccount("teena" , "9645410119" , 23000);
       s.createAccount("Subham", "9689980756", 21000);*/
 
    System.out.println(s.showBalance("9656980756"));
    s.deposit("9656980756", 2000);
    System.out.println(s.showBalance("9656980756"));
    System.out.println();
 
    s.withdraw("9656980756",1000);
    System.out.println(s.showBalance("9656980756"));
    
    boolean b = s.withdraw("9656980756",100000);
    if(b == false)
    {
    	System.out.println("Invalid Amount, Insufficient balance");
    }
    else{
    	System.out.println(s.showBalance("9656980756"));
    	}
	
}
}

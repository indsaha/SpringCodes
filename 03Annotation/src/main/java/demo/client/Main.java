package demo.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

import demo.beans.Customer;
import demo.repo.WalletRepo;
import demo.repo.WalletRepoImp;
import demo.service.WalletService;
import demo.service.WalletServiceImp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beanconfig.xml");
		WalletService service = (WalletServiceImp) ctx.getBean("service");
		
		//Map<String,Customer> data = new HashMap<>();
        //WalletRepo repo = new WalletRepoImp(data);
        //WalletService service = new WalletServiceImp(repo);
        
        
        service.createAccount("Subham", "9051740816", 5000);
        service.createAccount("Riyam", "12345678", 3000);
        service.createAccount("Laveena", "96124378", 8000);
        service.createAccount("Harshil", "95124568", 9000);
        
        
        System.out.println(service.showBalance("95124568"));
        
        
        service.withdraw(2000, "9051740816");
        System.out.println("Amount deducted :");
        System.out.println("Transaction successful");
        System.out.println(service.showBalance("9051740816"));
        
        
        service.deposit(3000, "96124378");
        System.out.println("Amount added:");
        System.out.println("Transaction successful");
        System.out.println(service.showBalance("96124378"));
                
        
        
        
		
		
		

	}

}

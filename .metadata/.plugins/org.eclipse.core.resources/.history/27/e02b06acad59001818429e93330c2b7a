package demo.client;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.support.GenericXmlApplicationContext;
import demo.bean.Customer;
import demo.repo.WalletRepo;
import demo.repo.WalletRepoImpl;
import demo.service.WalletService;
import demo.service.WalletServiceImpl;

public class Client {
	public static void main(String[] args)
	{
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("beanconfig.xml");
		WalletService service = (WalletServiceImpl) ctx.getBean("service");
//		Map<String, Customer> data = new HashMap<>();
//		WalletRepo repo =  new WalletRepoImpl(data);
//		WalletService service = new WalletServiceImpl(repo);
		
		service.createAccount("Ritam", "9674632276", 10000);
		service.createAccount("Indranil", "8981726625", 9000);
		service.createAccount("Subham", "7664545666", 7000);
		service.createAccount("Niharika", "7059593232", 5000);
		service.createAccount("Suraj", "9674645454", 7000);
		
		System.out.println(service.showBalance("8981726625"));
		System.out.println();
		System.out.println(service.showBalance("7059593232"));
		System.out.println();
		System.out.println(service.showBalance("7664545666"));
		System.out.println();
		System.out.println(service.showBalance("9674645454"));
		System.out.println();
		
		service.deposit(7000, "9674632276");
		System.out.println(service.showBalance("9674632276"));
		System.out.println();
		
		service.withdraw(2000, "8981726625");
		System.out.println(service.showBalance("8981726625"));
		
	}

}

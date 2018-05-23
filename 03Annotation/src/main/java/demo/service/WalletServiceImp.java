package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.beans.Customer;
import demo.beans.Wallet;
import demo.repo.WalletRepo;

@Service(value="service")




public class WalletServiceImp implements WalletService {
	   
			@Autowired
			private WalletRepo repo;
			           /* @Autowired
			             public WalletServiceImp(WalletRepo repo){
			            
			            	 this.repo=repo;
			             }*/
			                  
 public Customer createAccount(String name, String mobile, float amount){
            	Customer cust = new Customer();
            	Wallet wall = new Wallet();
            	
            	cust.setName(name);
            	cust.setMobileNumber(mobile);
            	wall.setBalance(amount);
            	cust.setWallet(wall);
            	repo.save(cust);
            	return cust;
            	
            }
            
            public Customer showBalance(String mobile){
            
            Customer d = repo.findone(mobile);
            return d;
            
            	
            }

			public boolean deposit(float amount, String mobile) {
				// Updating the balance when amount is deposited
				
				Customer customer = new Customer();
				Wallet wallet= new Wallet();
				customer=repo.findone(mobile);
                wallet = customer.getWallet();
                //float balance = amount + wallet.getBalance();
                wallet.setBalance(amount+wallet.getBalance());
                repo.save(customer);
				return true;
			}

			public boolean withdraw(float amount, String mobile) {
				// Updating the balance when amount is deducted
				
				Customer customer = new Customer();
				Wallet wallet = new Wallet();
				customer=repo.findone(mobile);
			    wallet = customer.getWallet();
				
				if(amount <= wallet.getBalance())
				{
					wallet.setBalance(wallet.getBalance()-amount);
					repo.save(customer);
					return true;
				}
				else
				return false;
			}

}

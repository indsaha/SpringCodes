package demo.repo;

import demo.beans.Customer;

public interface WalletRepo {
	public boolean save(Customer c);
	
	public Customer findOne(String mobile); 

}

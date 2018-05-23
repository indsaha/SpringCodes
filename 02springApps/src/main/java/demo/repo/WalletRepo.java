package demo.repo;

import demo.bean.Customer;

public interface WalletRepo {
	public boolean save(Customer c);
	
	public Customer findOne(String mobile); 

}

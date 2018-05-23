package demo.repo;

import java.util.HashMap;
import java.util.Map;

import demo.bean.Customer;

public class WalletRepoImpl implements WalletRepo{
	
	Map<String, Customer> data;
	
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	public boolean save(Customer c) {
		// Method to save customer in the map
		data.put(c.getMobileNumber(), c);
		return true;
	}

	public Customer findOne(String mobile) {
		// Method returns values from the map
		return data.get(mobile);
	}
	
	
	

}


package demo.service;

import demo.bean.Customer;
import demo.bean.Wallet;
import demo.repo.WalletRepo;

public class WalletServiceImpl implements WalletService{
	
	private WalletRepo repo;
	
		public WalletServiceImpl(WalletRepo repo) {
		super();
		this.repo = repo;
	}

	public Customer createAccount(String name, String mobile, float amount) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Wallet wallet = new Wallet();
		customer.setCustomerName(name);
		customer.setMobileNumber(mobile);
		wallet.setBalance(amount);
		customer.setWallet(wallet);
		repo.save(customer);
		return customer;
	}

	public Customer showBalance(String mobile) {
		// TODO Auto-generated method stub
		return repo.findOne(mobile);
	}

	public Customer deposit(float amount, String mobile) {
		// TODO Auto-generated method stub
		Customer customer;
		customer= repo.findOne(mobile);
		Wallet wallet = customer.getWallet();
		wallet.setBalance(amount + wallet.getBalance());
		repo.save(customer);
		return customer;
	}

	public Customer withdraw(float amount, String mobile) {
		// TODO Auto-generated method stub
		Customer customer;
		customer= repo.findOne(mobile);
		Wallet wallet = customer.getWallet();
		if(amount< wallet.getBalance())
		{
			wallet.setBalance(wallet.getBalance() - amount);
		}
		repo.save(customer);
		return customer;
	}
	
	

}


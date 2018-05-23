package demo.service;

import java.sql.SQLException;

import demo.beans.Customer;

public interface WalletServiceInterface {
	public Customer createAccount(String name, String mobileNumber, float amount) throws ClassNotFoundException, SQLException;
	public Customer showBalance(String mobileNumber);
    public boolean withdraw(String mobileNumber,float amount) throws ClassNotFoundException, SQLException;
    public boolean deposit(String mobileNumber,float amount) throws ClassNotFoundException, SQLException;
}

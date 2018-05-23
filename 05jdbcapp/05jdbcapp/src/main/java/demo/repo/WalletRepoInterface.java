package demo.repo;

import java.sql.SQLException;

import demo.beans.Customer;

public interface WalletRepoInterface {
	public boolean save(Customer c) throws SQLException, ClassNotFoundException;
	public boolean update(Customer c) throws SQLException, ClassNotFoundException;
	public Customer findOne(String mobileNumber);

}

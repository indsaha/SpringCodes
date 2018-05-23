package demo.service;

import demo.beans.Customer;

public interface WalletService {
       public Customer createAccount(String name, String mobile, float amount);
       public Customer showBalance(String mobile);
       public Customer deposit(float amount, String mobile);
       public Customer withdraw(float amount, String mobile);
}

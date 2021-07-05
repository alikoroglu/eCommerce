package business.abstracts;

import entities.concretes.Customer;

public interface CustomerService {
	
	void createAccount(Customer customer);
	void deleteAccount(Customer customer,String password);
	void updateAccount(Customer customer,String password);
	void loginAccount(String email, String password);
	void logoutAccount(Customer customer);




}

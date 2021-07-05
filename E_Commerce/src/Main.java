import GoogleAccount.GoogleManager;
import business.concretes.CustomerManager;
import core.GoogleManagerAdapter;
import core.GoogleService;
import dataAcces.abstracts.CustomerDao;
import dataAcces.concretes.HibernateCustomer;
import entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		Customer customer1 = new Customer("ali","osman","ali@g.com","123456");
		CustomerDao customerDao = new HibernateCustomer();
		GoogleService google = new GoogleManagerAdapter();
		CustomerManager manager = new CustomerManager(customerDao,google);
		
		manager.createAccount(customer1);
		manager.updateAccount(customer1, "123456");
		manager.loginAccount("ali@g.com", "123456");
		manager.logoutAccount(customer1);
		manager.deleteAccount(customer1, "123456");

	}

}

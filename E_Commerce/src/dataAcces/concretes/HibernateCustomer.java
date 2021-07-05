package dataAcces.concretes;

import dataAcces.abstracts.CustomerDao;
import entities.concretes.Customer;

public class HibernateCustomer implements CustomerDao{

	public void add(Customer customer) {
		System.out.println("hibernate ile veritabab�na eklendi: "+customer.getFirstName());
		
	}

	public void delete(Customer customer) {
		System.out.println("hibernate ile veritabab�n�ndan silindi: "+customer.getFirstName());

		
	}

	public void update(Customer customer) {
		System.out.println("hibernate ile g�ncellendi: "+customer.getFirstName());

		
	}

}

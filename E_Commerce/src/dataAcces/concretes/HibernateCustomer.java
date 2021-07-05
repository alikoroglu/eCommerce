package dataAcces.concretes;

import dataAcces.abstracts.CustomerDao;
import entities.concretes.Customer;

public class HibernateCustomer implements CustomerDao{

	public void add(Customer customer) {
		System.out.println("hibernate ile veritababýna eklendi: "+customer.getFirstName());
		
	}

	public void delete(Customer customer) {
		System.out.println("hibernate ile veritababýnýndan silindi: "+customer.getFirstName());

		
	}

	public void update(Customer customer) {
		System.out.println("hibernate ile güncellendi: "+customer.getFirstName());

		
	}

}

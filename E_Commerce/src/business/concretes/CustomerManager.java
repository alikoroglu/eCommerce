package business.concretes;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.CustomerService;
import core.GoogleService;
import dataAcces.abstracts.CustomerDao;
import entities.concretes.Customer;

public class CustomerManager implements CustomerService{
	
	private List<String> emailList = new ArrayList<String>();
	private List<String> passwordList = new ArrayList<String>();

	private CustomerDao customerDao;
	private GoogleService googleService;
	
	
	public CustomerManager(CustomerDao customerDao, GoogleService googleService) {
		super();
		this.customerDao = customerDao;
		this.googleService = googleService;
	}
	
	private boolean isEmailMatch(String email) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}
	
	private boolean isEmailVerificated (String email) {
		return true;
	}

	@Override
	public void createAccount(Customer customer) {
		if(customer.getPassword().length()<6 || customer.getPassword() == null) {
			System.out.println("Parola 6 karakterden k���k olamaz! ");
			return;
		}
		
		if(emailList.contains(customer.geteMail())) {
			System.out.println("Bu mail adresi daha �nce kullan�lm��!! ");
			return;
		}
		
		if (customer.getFirstName().length()<3 || customer.getLastName().length()<3) {
			System.out.println("isim veya soyisim 3 karakterden k���k olamaz! ");
			return;
		}
		else {
			System.out.println("E-Mail adresinize onay kodu g�nderildi: "+customer.geteMail());
			
		}
		
		if (isEmailVerificated(customer.geteMail())) {
			System.out.println("E mail do�ruland�");
			emailList.add(customer.geteMail());
			passwordList.add(customer.getPassword());
			this.customerDao.add(customer);
			this.googleService.connectToGoogle();
		}
		else {
			System.out.println("L�tfen email adresinizi do�rulay�n");
		}
		
	}
	
	@Override
	public void deleteAccount(Customer customer, String password) {
		if (customer.getPassword()==password) {
			System.out.println("Parola do�ruland�, silindi: "+customer.getFirstName());
		}else {System.out.println("Parola e�le�medi");}
		
	}

	

	@Override
	public void logoutAccount(Customer customer) {
		System.out.println(customer.getFirstName()+": ��k�� yap�ld�.");
		
	}


	@Override
	public void updateAccount(Customer customer, String password) {
		if (customer.getPassword()==password) {
			System.out.println("Parola do�ruland�, hesap g�ncellendi: "+customer.getFirstName());
		}else {System.out.println("Parola e�le�medi");}
	}

	@Override
	public void loginAccount(String email, String password) {
		if(emailList.contains(email)&&passwordList.contains(password)) {
			System.out.println("Giri� ba�ar�l�");
		}else {System.out.println("E mail ya da parola hatal�");}
		
	}

}

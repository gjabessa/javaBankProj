import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXMLLoader;

public class Admin{
	private String username = "admin";
	private String password = "admin";

	List<Account> accounts = new ArrayList<Account>();
	List<Transaction> transactions = new ArrayList<Transaction>();
	Admin(){
		
	}
	
	void addAccount(Account acc) {
		accounts.add(acc);
	}
	
	Account createAccount(String firstname, String lastname, int phone, accountType accType) {
		Account acc;
		 switch(accType) {
		 case SAVINGS:
	 		 acc = new Savings(this,firstname,lastname,phone,accType);
	 		 this.addAccount(acc);
	 		 break;
		 case CHECKING:
	 		acc = new Checking(this,firstname,lastname,phone,accType);
	 		this.addAccount(acc);
	 		break;
		 case CREDIT:
	 		acc = new Credit(this,firstname,lastname,phone,accType);
	 		this.addAccount(acc);
	 		break;
		default:
			return null;
		 }
		 
		 return acc;
		
	}
	
	boolean login(String username,String password){
		return (this.username.equals(password)) && (this.password.equals(password) );
	}
	boolean loginCustomer(int accountNumber,String password){
		return accounts.stream().anyMatch(n -> (n.accountNumber == accountNumber && n.password.equals(password)));
	}
	void updateAccount(Account acc) {
		int index = accounts.indexOf(acc);
		accounts.set(index, acc);
	}
	
	Account getAccount(int accountNumber) {
		return accounts.stream().filter(account -> (account.accountNumber == accountNumber)).collect(Collectors.toList()).get(0);
	}
	
}

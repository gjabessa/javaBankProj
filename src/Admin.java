import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Admin{
	private String username = "admin";
	private String password = "admin";

	List<Account> accounts = new ArrayList<Account>();
	
	
	void addAccount(Account acc) {
		accounts.add(acc);
	}
	
	void createAccount(String firstname, String lastname, String phone, accountType accType) {
		
	}
	
	boolean login(String username,String password){
		return (this.username.equals(password)) && (this.password.equals(password) );
	}
	void updateAccount(Account acc) {
		int index = accounts.indexOf(acc);
		accounts.set(index, acc);
	}
	
	Account getAccount(int accountNumber) {
		return accounts.stream().filter(account -> (account.accountNumber == accountNumber)).collect(Collectors.toList()).get(0);
	}
	

}

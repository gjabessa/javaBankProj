import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Admin extends Account{

	List<Account> accounts = new ArrayList<Account>();

	
	void addAccount(Account acc) {
		accounts.add(acc);
	}
	
	void updateAccount(Account acc) {
		int index = accounts.indexOf(acc);
		accounts.set(index, acc);
	}
	
	Account getAccount(int accountNumber) {
		return accounts.stream().filter(account -> (account.accountNumber == accountNumber)).collect(Collectors.toList()).get(0);
	}
	
	@Override
	int generateAccountNo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int generatePassword(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double getMonthInterest() {
		// TODO Auto-generated method stub
		return 0;
	}

}

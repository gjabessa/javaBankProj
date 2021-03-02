import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class Account {
	String firstname;
	String lastname;
	int accountNumber;
	String password;
	int phone;
	boolean isNewAccount;
	double balance;
	Transaction transaction;
	int monthlyInterest;
	List<Notification> notifications = new ArrayList<Notification>();
	Admin admin;
	public enum role {USER, ADMIN};
	
	Account(Admin admin){
		this.admin = admin;
	}
	void setName(String firstName, String lastName) {
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	 void setAccountNo(int number) {
		this.accountNumber = number;
	}
	
	abstract int generateAccountNo();
	
	abstract int generatePassword(String firstName, String lastName);
	
	double getBalance() {
		return this.balance;
	}
	
	double withdrawMoney(double amount) {	
		this.balance = this.balance - amount;
		return this.balance;
	}
	
	double makeDeposit(double amount) {
		this.balance += amount;
		return this.balance;
	}
	
	String transferMoney(double amount, Optional<Account> to) {
		 if(to.isPresent()) {
			 this.withdrawMoney(amount);
			 to.get().makeDeposit(amount);
			 notify(amount +" amount has been successfully transferred to account number "+to.get().accountNumber,this.accountNumber);
			 Account account = this.admin.getAccount(to.get().accountNumber);
			 account.notify(amount +" amount has been credited from "+this.accountNumber,to.get().accountNumber);
			 this.admin.updateAccount(account);
			 
			 return "Success";
		 } else {
			 return "Destination account not found";
		 }
	}
	
	
	abstract double getMonthInterest();
	
	void notify(String notification,int accountNumber) {
		notifications.add(new Notification(notification,accountNumber));
	}
	
	
	
	
	
}

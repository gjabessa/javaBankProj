import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class Account {
	String firstname;
	String lastname;
	int accountNumber;
	String password;
	int phone;
	boolean isNewAccount = true;
	double balance;
	Transaction transaction;
	int monthlyInterest;
	List<Notification> notifications = new ArrayList<Notification>();
	Admin admin;
	String reward = "";
	
	accountType accType;
	
	Account(Admin admin,String firstname, String lastname, int phone, accountType accType){
		this.admin = admin;
		this.generateAccountNo();
		this.generatePassword(firstname, lastname);
		this.phone = phone;
		this.accType = accType;
	}
	void setName(String firstName, String lastName) {
		this.firstname = firstName;
		this.lastname = lastName;
	}
	
	 void setAccountNo(int number) {
		this.accountNumber = number;
	}
	
	abstract int generateAccountNo();
	
	abstract String generatePassword(String firstName, String lastName);
	
	double getBalance() {
		return this.balance;
	}
	
	void updatePassword(String pass){
		this.password = pass;
		this.isNewAccount = false;
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
	
	void setReward(String reward){
		this.reward = reward;
	}
}

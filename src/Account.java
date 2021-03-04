import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

abstract class Account {
	String firstName;
	String lastName;
	int accountNumber;
	String password;
	boolean isNewAccount = true;
	double balance;
	Transaction transaction;
	int monthlyInterest;
	List<Notification> notifications = new ArrayList<Notification>();
	Admin admin;
	String reward = "";
	String accountStrType;
	
	accountType accType;
	
	Account(Admin admin,String firstname, String lastname, int phone, accountType accType){
		this.admin = admin;
		this.password = this.generatePassword(firstname, lastname);
		this.accountNumber = phone;
		this.accType = accType;
		this.setName(firstname, lastname);
		this.accountStrType = this.accType.toString();
	}
	void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	 void setAccountNumber(int number) {
		this.accountNumber = number;
	}
	 public int getAccountNumber() {
		 return this.accountNumber;
	 }
	
	 public String getAccountStrType() {
		 return this.accountStrType;
	 }
	 
	 public void setAccountStrType(String type) {
		 accountType act;
			
			switch(type) {
			case "Saving":
				act = accountType.SAVINGS;
				break;
			case "Checking":
				act = accountType.CHECKING;
				break;
			case "Credit":
				act = accountType.CREDIT;
				break;
			default:
				act = accountType.SAVINGS;
				break;
			}
			this.accType = act;
			this.accountStrType = type;
	 }
	abstract int generateAccountNo();
	
	String generatePassword(String firstName, String lastName) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return String.valueOf(rand.nextInt(1000));
	}
	public double getBalance() {
		return this.balance;
	}
	
	void updatePassword(String pass){
		this.password = pass;
		this.isNewAccount = false;
	}
	
	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setBalance(double balance) {
    	this.balance = balance;
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
	
	//toString for debug purpose
	public String toString(){
		return this.firstName+" account number: "+accountNumber+" password "+password;
	}
}

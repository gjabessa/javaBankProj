import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public class Transaction {

	LocalDate date;
	String transactionName;
	Account account;
	int accountNumber;
	double lastBalance;
	String reason;
	double amount;
	String strAmount;
	String strAccountNumber;
	Transaction(String transactionName, Account acc, double amount, Optional<String> reason){
		date = LocalDate.now();
		this.transactionName = transactionName;
		this.account = acc;
		this.lastBalance = acc.getBalance();
		this.accountNumber = account.accountNumber;
		this.amount = amount;
		this.strAmount = String.valueOf(amount);
//		this.reason =reason.orElse("Not specified");
		this.strAccountNumber = String.valueOf(this.accountNumber);
	}
	
	public void setStrAmount(String amount) {
		this.strAmount = amount;
	}
	public String getStrAccountNumber() {
		return this.strAccountNumber;
	}
	
	public void setStrAccountNumber(String acc) {
		this.strAccountNumber = acc;
	}
	public String getStrAmount() {
		return this.strAmount;
	}
	
	public void setTransactionName(String name) {
		this.transactionName = name;
	}
	
	public String getTransactionName() {
		return this.transactionName;
	}
	
}

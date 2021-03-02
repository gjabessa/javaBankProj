import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public class Transaction {

	LocalDate date;
	String transactionName;
	Account account;
	double lastBalance;
	String reason;
	Transaction(String transactionName, Account acc, Optional<String> reason){
		date = LocalDate.now();
		this.transactionName = transactionName;
		this.account = acc;
		this.lastBalance = acc.getBalance();
		this.reason =reason.orElse("Not specified");
	}
}

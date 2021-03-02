
public class Notification {
	String message;
	int accountNumber;
	Notification(String msg, int accountNumber){
		this.message = msg;
		this.accountNumber = accountNumber;
	}
	
	String notification() {
		return message;
	}
}

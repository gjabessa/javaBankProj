import java.util.Random;

public class Savings extends Account{
	Savings(Admin admin, String firstname, String lastname,int accountNumber,accountType accType) {
		super(admin, firstname, lastname, accountNumber, accType);
		// TODO Auto-generated constructor stub
	}

	@Override
	int generateAccountNo() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		return rand.nextInt(32);
	}

	@Override
	String generatePassword(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return firstName+lastName.hashCode();
	}

	@Override
	double getMonthInterest() {
		// TODO Auto-generated method stub
		//2 percent
		return 2;
	}
}

import java.util.Random;

public class Credit extends Account{

	Credit(Admin admin) {
		super(admin);
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
		//-3 percent
		return -3;
	}

}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML public Button loginBtn;
	@FXML TextField accountNumber;
	@FXML TextField password;
	Login loginManager;
	
	@FXML
	void handleLogin(ActionEvent evt) throws Exception{
		loginBtn.setText("Loggin in ..");
		if(this.login(accountNumber.getText(), password.getText())) {
			Stage stage = (Stage) loginBtn.getScene().getWindow();
			stage.close();
		} else {
			//try again correctly
			loginBtn.setText("Try again");
		}
	}
	
	boolean login(String accountNumber, String password){
		Admin admin = new Admin();
		return admin.login(accountNumber, password);
	}
	
	
}

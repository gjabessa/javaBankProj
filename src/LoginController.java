
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML public Button loginBtn;
	@FXML TextField accountNumber;
	@FXML TextField password;
	Login loginManager;
	Admin admin;
	@FXML
	void handleLogin(ActionEvent evt) throws Exception{
		if(accountNumber.getText().equals("admin")) {
			loginBtn.setText("Loggin in ..");
			if(this.login(accountNumber.getText(), password.getText())) {
				Stage stage = (Stage) loginBtn.getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(
				        getClass().getResource("AdminPanel.fxml")
				      );
				
				Parent root = loader.load();
				AdminController adm = loader.getController();
				this.admin.accounts.forEach(n -> {
					System.out.println(n);
				});
				adm.setAdmin(this.admin);
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				
				stage.show();
			} else {
				//try again correctly
				loginBtn.setText("Try again");
			}
		} else {
			loginBtn.setText("Loggin in");
	
				try {
					if(this.loginCustomer(Integer.valueOf(accountNumber.getText()), password.getText())) {
						Stage stage = (Stage) loginBtn.getScene().getWindow();
						FXMLLoader loader = new FXMLLoader(
						        getClass().getResource("customerPanel.fxml")
						      );
						
						
						
						Parent root = loader.load();
						
						CustomerController customer = loader.getController();
						customer.setAdmin(this.admin,this.admin.getAccount(Integer.valueOf(accountNumber.getText())));
						Scene scene = new Scene(root);
						stage.setScene(scene);
						
						stage.show();
					} else {
						//try again correctly
						loginBtn.setText("Try again");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					loginBtn.setText("Invalid format ....");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					loginBtn.setText("something went wrong");
					e.printStackTrace();
				}
		
			
		}
		
	}
	
	boolean login(String accountNumber, String password){
		if(this.admin == null) {
			Admin admin = new Admin();
			this.admin = admin;
		}
		
		return admin.login(accountNumber, password);
	}
	
	boolean loginCustomer(int accountNumber, String password){
	if(this.admin != null) {
		return this.admin.loginCustomer(accountNumber, password);
	} else {
		return false;
	}
		
	}
	
	void setAdmin(Admin admin) {
		this.admin = admin;
		System.out.println(admin);
	}
	
	
}

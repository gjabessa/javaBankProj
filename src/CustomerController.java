
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CustomerController {
	@FXML Button logout;
	@FXML Label balance;
	@FXML Label welcomeName;
	@FXML TableView transactionTbl;
	
	Admin admin;
	Account account;
	@FXML
	public void handleLogout(ActionEvent evt) throws Exception{
		Stage stage = (Stage) logout.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(
		        getClass().getResource("LoginPage.fxml")
		      );
		
		Parent root = loader.load();
		LoginController lc = loader.getController();
		lc.setAdmin(this.admin);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public void setAdmin(Admin admin, Account account) {
		System.out.println(admin);
		this.admin = admin;
		this.account = account;
		this.balance.setText(String.valueOf(this.account.balance));
		this.welcomeName.setText("Welcome "+this.account.firstName);
		

	       TableColumn<Transaction, String> transactionName = new TableColumn("Transaction Name");
			 transactionName.setCellValueFactory(new PropertyValueFactory<>("transactionName"));
		      TableColumn<Transaction, String> account1 = new TableColumn("Account");
		      account1.setCellValueFactory(new PropertyValueFactory<>("strAccountNumber"));
		      TableColumn<Transaction, String> amount = new TableColumn("Amount");
		      amount.setCellValueFactory(new PropertyValueFactory<>("strAmount"));
		      this.transactionTbl.getColumns().addAll(transactionName,account1,amount);
		
		     admin.transactions.stream().filter(n -> (n.accountNumber == this.account.accountNumber)).forEach(n -> {
		    	 this.transactionTbl.getItems().add(n);
		     });
	}
}

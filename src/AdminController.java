
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {
	@FXML Button logout;
	
	Admin admin;
	
	@FXML Button create;
	@FXML TextField fName;
	@FXML TextField lName;
	@FXML TextField phone;
	@FXML Label password;
	@FXML Label msg;
	@FXML TextField accountNumberDeposit;
	@FXML TextField amountDeposit;
	@FXML TextField accountNumberWd;
	@FXML TextField amountWd;
	@FXML TextField accountNumberTr;
	@FXML TextField accountNumberToTr;
	@FXML Button add;
	@FXML Button deposit;
	@FXML Button transfer;
	@FXML TableView accountsTable;
	@FXML TextField amountTr;
	@FXML Label depositBal;
	@FXML Label depositScc;
	@FXML Label withdrawMsg;
	@FXML Label wdCurrBal;
	@FXML ChoiceBox accType;
	@FXML TableView transactionTbl;
//	

	@FXML
	public void handleLogout(ActionEvent evt) throws Exception{
		Stage stage = (Stage) logout.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(
		        getClass().getResource("LoginPage.fxml")
		      );
		
		Parent root = loader.load();
		LoginController lc = loader.getController();
		this.admin.accounts.forEach(n -> {
			System.out.println(n);
		});
		System.out.println(admin);
		lc.setAdmin(this.admin);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		
		stage.show();
	}
	
	@FXML 
	public void handleCreateAccount(ActionEvent evt) throws Exception {
		accountType act;
		
		switch((String) this.accType.getValue()) {
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
		Account account = this.admin.createAccount(fName.getText(), lName.getText(), Integer.valueOf(phone.getText()), act);
	    password.setText("Temporary password: "+account.password);
	    this.admin.accounts.forEach(n -> {
			System.out.println(n);
		});
	    this.fName.setText(null);
	    this.lName.setText(null);
	    this.phone.setText(null);
	    this.accountsTable.getItems().add(account);
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
		System.out.println(this.admin);
		this.accountsTable.refresh();
		 TableColumn<Account, String> firstNameCol = new TableColumn("First Name");
		 firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
	      TableColumn<Account, String> lastNameCol = new TableColumn("Last Name");
	      lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
	      TableColumn<Account, String> accountNumber = new TableColumn("Account Number");
	      accountNumber.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
	      TableColumn<Account, String> balance = new TableColumn("Balance");
	      balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
	      TableColumn<Account, String> type = new TableColumn("Type");
	      type.setCellValueFactory(new PropertyValueFactory<>("accountStrType"));
	       this.accountsTable.getColumns().addAll(firstNameCol, lastNameCol, accountNumber, balance,type);
	       
	       
	       //for transactions 
	       
	       TableColumn<Transaction, String> transactionName = new TableColumn("Transaction Name");
			 transactionName.setCellValueFactory(new PropertyValueFactory<>("transactionName"));
		      TableColumn<Transaction, String> account = new TableColumn("Account");
		      account.setCellValueFactory(new PropertyValueFactory<>("strAccountNumber"));
		      TableColumn<Transaction, String> amount = new TableColumn("Amount");
		      amount.setCellValueFactory(new PropertyValueFactory<>("strAmount"));
		      this.transactionTbl.getColumns().addAll(transactionName,account,amount);
		     admin.accounts.forEach(n -> {
	    	   this.accountsTable.getItems().add(n);
	       });
		     admin.transactions.forEach(n -> {
		    	 this.transactionTbl.getItems().add(n);
		     });
	       
	       this.accType.getItems().add("Saving");
	}
	
	@FXML
	public void handleTransfer(ActionEvent evt) {
		Account acc = this.admin.getAccount(Integer.valueOf(this.accountNumberTr.getText()));
		Account accTo = this.admin.getAccount(Integer.valueOf(this.accountNumberToTr.getText()));
		this.accountNumberTr.setText(null);
		this.accountNumberToTr.setText(null);
		String transfer = acc.transferMoney(Double.valueOf(this.amountTr.getText()), Optional.of(accTo));
		msg.setText(transfer);
		Transaction tr = new Transaction("Outbound Transfer", acc, Double.valueOf(this.amountTr.getText()), null);
		this.admin.transactions.add(tr);
	}
	
	@FXML
	public void handleWithdraw(ActionEvent evt) {
		Account acc = this.admin.getAccount(Integer.valueOf(this.accountNumberWd.getText()));
		acc.withdrawMoney(Double.valueOf(this.amountWd.getText()));
		this.withdrawMsg.setText("Successful!");	
		Transaction tr = new Transaction("Withdraw", acc,Double.valueOf(this.amountWd.getText()), null);
		this.admin.transactions.add(tr);
		this.amountWd.setText("");
		this.accountNumberWd.setText("");
		this.wdCurrBal.setText(String.valueOf(acc.getBalance()));
		
	}
	
	@FXML
	public void handleMakeDeposit(ActionEvent evt) {
		System.out.println(Integer.valueOf(this.accountNumberDeposit.getText()));
		System.out.println(this.admin.accounts.get(0));
		Account acc = this.admin.getAccount(Integer.valueOf(this.accountNumberDeposit.getText()));
		acc.makeDeposit(Double.valueOf(this.amountDeposit.getText()));
		Transaction tr = new Transaction("Deposit", acc, Double.valueOf(this.amountDeposit.getText()), null);
		this.admin.transactions.add(tr);
		this.amountDeposit.setText("");
		this.accountNumberDeposit.setText("");
		this.depositScc.setText("Successful!");
		this.depositBal.setText(String.valueOf(acc.getBalance()));
		
		
	}
}

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Login extends Application {
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		FXMLLoader loader = new FXMLLoader(
		        getClass().getResource("loginPage.fxml")
		      );
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		      
				
				arg0.setScene(scene);
				arg0.show();
	}

	 
	void login(){
		
	}
}

import javafx.fxml.FXMLLoader;

public class LoginManager {
	public void showLoginScreen() {
	    try {
	      FXMLLoader loader = new FXMLLoader(
	        getClass().getResource("loginPage.fxml")
	      );
	      scene.setRoot((Parent) loader.load());
	      LoginController controller = 
	        loader.<LoginController>getController();
	      controller.initManager(this);
	    } catch (IOException ex) {
	      Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }

	  private void showMainView(String sessionID) {
	    try {
	      FXMLLoader loader = new FXMLLoader(
	        getClass().getResource("mainview.fxml")
	      );
	      scene.setRoot((Parent) loader.load());
	      LoginController controller = 
	        loader.<LoginController>getController();
	      controller.initSessionID(this, sessionID);
	    } catch (IOException ex) {
	      Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
	    }
	  }
}

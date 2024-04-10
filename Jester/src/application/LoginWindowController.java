package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginWindowController implements Initializable {

	@FXML
	private Button loginButton;
	@FXML
	private Button cancelButton;
	@FXML
	private TextField emailField = new TextField();
	@FXML
	private PasswordField passwordField = new PasswordField();
	@FXML
	private Label messageLabel = new Label("Mesaj");
	@FXML
	private Button registerButton;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	HashMap<String,ArrayList<String>> logininfo;
	
	protected String password;
	
	@FXML
	public void login(ActionEvent event) throws IOException{
		
		new AccountDetails();
		
		this.logininfo = AccountDetails.getLoginInfo();
		
		
		password = passwordField.getText();
		String email = emailField.getText();
		
		if(this.logininfo.containsKey(email)) {
			ArrayList<String> credentials = this.logininfo.get(email);
			if(credentials != null && credentials.size() == 2 && this.password.matches(credentials.get(1))) {
				
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("resources//MainWindow.fxml"));
				root = loader.load();
				MainWindowController mainWindow = loader.getController();
				mainWindow.setUsername(credentials.get(0));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
				messageLabel.setTextFill(javafx.scene.paint.Color.RED);
				messageLabel.setText("Wrong Username or Password");
				messageLabel.setOpacity(1);
			}
			
			
		} else {
			
			messageLabel.setTextFill(javafx.scene.paint.Color.RED);
			messageLabel.setText("Wrong Username or Password");
			messageLabel.setOpacity(1);
		}
	}
	@FXML
	public void cancel() {
		
			Scene scene = cancelButton.getScene();
			Stage stage = (Stage) scene.getWindow();
			stage.close();
			
		
	}
	
	public void createAccountPage(ActionEvent event) throws IOException {
		
		AccountDetails.readLoginInfoFromFile("D:\\proiecte eclips\\Jester\\src\\application\\AccountDetails.txt");
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("resources\\RegistrationWindow.fxml"));
		root = loader.load();
		RegistrationWindowController registrationPage = loader.getController();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AccountDetails.readLoginInfoFromFile("D:\\proiecte eclips\\Jester\\src\\application\\AccountDetails.txt");
        this.logininfo = AccountDetails.getLoginInfo();
		
	}
}
	


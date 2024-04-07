package application;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

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
	HashMap<String,String> logininfo;
	
	@FXML
	public void login(){
		
		new AccountDetails();
		
		this.logininfo = AccountDetails.getLoginInfo();
		
		
		String password = passwordField.getText();
		String email = emailField.getText();
		
		if(this.logininfo.containsKey(email)) {
			if(this.logininfo.get(email).equals(password)) {
				messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
				messageLabel.setText("Login Successful");
				messageLabel.setOpacity(1);
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
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistrationWindow.fxml"));
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
	


package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationWindowController {

	@FXML
	private TextField usernameField;
	
	@FXML
	private TextField emailField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private PasswordField confirmPasswordField;
	
	@FXML
	private Button registerButton;
	
	@FXML
	private Button returnButton;
	
	@FXML
	private Label messageLabel;
	
	Scene scene;
	Parent root;
	Stage stage;
	
	public void register(){
		
		String username = usernameField.getText();
		String password = "";
		if(passwordField.getText().equals(confirmPasswordField.getText())) {
			password = passwordField.getText();
		}
		String email = emailField.getText();
		
		new AccountDetails();
		
		HashMap<String,String> logininfo = AccountDetails.getLoginInfo();
		
		
		if (logininfo.containsKey(email)) {
	        messageLabel.setText("E-mail already in use");
	        messageLabel.setTextFill(javafx.scene.paint.Color.RED);
	        messageLabel.setOpacity(1);
	    } else {
	        if (!password.isEmpty()) {
	            logininfo.put(email, password);
	            
	            messageLabel.setText("Account registered successfully");
	            messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
	            messageLabel.setOpacity(1);
	            
	            try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\proiecte eclips\\Jester\\src\\application\\AccountDetails.txt", true))){
	    			writer.write(email + ", " + password);
	    			writer.newLine();
	    			writer.flush();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	            
	        } else {
	            messageLabel.setText("Invalid password");
	            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
	            messageLabel.setOpacity(1);
	        }
	    }
		
		
	}
		
		

	
	
	public void returnToLoginWindow(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
		root = loader.load();
		LoginWindowController loginPage = loader.getController();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

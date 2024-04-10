package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainWindowController implements Initializable {

	@FXML
	private TextField messageField;
	
	@FXML
	private VBox chatBox;
	
	@FXML
	private Button sendButton;

	@FXML
	private Label accountName;
	
	String username;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sendButton.setOnAction(event -> sendMessage());
		messageField.setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.ENTER) {
				sendMessage();
			}
		});
		
	}
	
	private void sendMessage() {
			
			String message = messageField.getText();
			
			Text messageText = new Text(username + ": " + message);
			
			chatBox.getChildren().add(messageText);
			messageField.clear();
		
	}

	public void setUsername(String username) {
        this.accountName.setText(username);
        this.username = username;
    }
	
	
	
}

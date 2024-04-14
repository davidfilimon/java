package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller{
	
	@FXML
	private Label username;
	
	

	public void connectButton(ActionEvent event) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String connectQuery = "SELECT name FROM users";
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput = statement.executeQuery(connectQuery);
			
			while(queryOutput.next()) {
				username.setText(queryOutput.getString("name"));
			}
			
			
;		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

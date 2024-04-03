import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


public class LoginPage implements ActionListener{

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Username: ");
	JLabel passwordLabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel("TEST TEST TEST");
	
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LoginPage(HashMap<String,String> loginInfoOriginal){

		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		frame.add(userIDLabel);
		frame.add(passwordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource() == loginButton) {
			String username = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(username)) {
				if(logininfo.get(username).equals(password)) {

					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(username);
					
					
				}
				else {
					messageLabel.setForeground(Color.RED);
					messageLabel.setText("Wrong password");
				}
			} else {
				messageLabel.setForeground(Color.RED);
				messageLabel.setText("Username not found");
			}
		}
		
	}
	
}

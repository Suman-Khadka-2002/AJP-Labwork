package lab2package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
	private JTextField username;
	private JPasswordField password;
	
	public LoginForm() {
		setTitle("Login Form");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		username = new JTextField(20);
		password = new JPasswordField(20);
		
		JLabel usernamelbl = new JLabel("Username: ");
		JLabel passwordlbl = new JLabel("Password: ");
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				authenticate();
			}
		});
		
		setLayout(new GridLayout(3,2));
		add(usernamelbl);
		add(username);
		add(passwordlbl);
		add(password);
		add(new JLabel());
		add(loginBtn);
		
		setLocationRelativeTo(null);// center the frame
		setVisible(true);
	}
	
	private void authenticate() {
		String enteredUsername = username.getText();
		char[] enteredPasswordChars = password.getPassword();
		String enteredPassword = new String(enteredPasswordChars);
		
		if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
			JOptionPane.showMessageDialog(this,  "Access Granted", "Success", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this,  "Access Denied", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		//clear the password field for security reasons
		password.setText("");
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(LoginForm::new);
	}
}

package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login implements ActionListener {
	
	JFrame jf;
	JLabel userNameLabel, passwordLabel, imageLabel;
	JTextField userName;
	JPasswordField passWord;
	JButton loginButton, cancelButton;
	
	Login(){
		
		jf = new JFrame("Login");
		
		jf.setBackground(Color.WHITE);
		jf.setLayout(null);
		
		userNameLabel = new JLabel("Username");
		userNameLabel.setBounds(40, 10, 100, 30);
		userNameLabel.setFont(new Font("calibri", Font.BOLD, 20));
		jf.add(userNameLabel);
		
		passwordLabel = new JLabel("PassWord");
		passwordLabel.setBounds(40, 50, 100, 30);
		passwordLabel.setFont(new Font("calibri", Font.BOLD, 20));
		jf.add(passwordLabel);
		
		userName = new JTextField();
		userName.setBounds(150, 10, 150, 30);
		jf.add(userName);
		
		passWord = new JPasswordField();
		passWord.setBounds(150, 50, 150, 30);
		jf.add(passWord);
		
		
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 400, 300);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/login.jpg"));
		imageLabel.setIcon(img);
		
		jf.add(imageLabel);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(40, 200, 120, 30);
		loginButton.setFont(new Font("serif", Font.BOLD, 20));
		loginButton.addActionListener(this);
		
		imageLabel.add(loginButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(220, 200, 120, 30);
		cancelButton.setFont(new Font("serif", Font.BOLD, 20));
		cancelButton.addActionListener(this);
		imageLabel.add(cancelButton);
		
		
		
		jf.getContentPane().setBackground(Color.WHITE);
		
		jf.setVisible(true);
		jf.setSize(400, 300);
		jf.setLocation(600, 300);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == loginButton){
			try {
		
				DataBaseConnection connection = new DataBaseConnection();
				String user = userName.getText();
				@SuppressWarnings("deprecation")
				String password = passWord.getText();
				
				String query = "select * from login where username = '"+user+"' and pass = '"+password+"'";
				
				ResultSet rs = connection.statement.executeQuery(query);
				
				if(rs.next()) {
					new ManagementActions().jf.setVisible(true);
					jf.setVisible(false);
				
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Login or Password");
					//jf.setVisible(false);		
				}
			} catch(Exception e) {
					e.printStackTrace();
			}
		}else if(ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new FrontPage();
		}
	}
	
	public static void main(String[] args) {
		new Login();

	}
}


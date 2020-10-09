package employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login implements ActionListener {
	
	JFrame jf;
	JLabel label1, label2;
	JTextField textField;
	JPasswordField pass;
	JButton button1, button2;
	
	Login(){
		
		jf = new JFrame("Login");
		
		jf.setBackground(Color.WHITE);
		jf.setLayout(null);
		
		label1 = new JLabel("Username");
		label1.setBounds(40, 10, 100, 30);
		label1.setFont(new Font("calibri", Font.BOLD, 20));
		jf.add(label1);
		
		label2 = new JLabel("PassWord");
		label2.setBounds(40, 50, 100, 30);
		label2.setFont(new Font("calibri", Font.BOLD, 20));
		jf.add(label2);
		
		textField = new JTextField();
		textField.setBounds(150, 10, 150, 30);
		jf.add(textField);
		
		pass = new JPasswordField();
		pass.setBounds(150, 50, 150, 30);
		jf.add(pass);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/icons/login.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		
		l1.setBounds(0, 0, 400, 300);
		jf.add(l1);
		
		button1 = new JButton("Login");
		button1.setBounds(40, 200, 120, 30);
		button1.setFont(new Font("serif", Font.BOLD, 20));
		button1.addActionListener(this);
		
		l1.add(button1);
		
		button2 = new JButton("Cancel");
		button2.setBounds(220, 200, 120, 30);
		button2.setFont(new Font("serif", Font.BOLD, 20));
		button2.addActionListener(this);
		l1.add(button2);
		
		jf.getContentPane().setBackground(Color.WHITE);
		
		jf.setVisible(true);
		jf.setSize(400, 300);
		jf.setLocation(600, 300);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
		DataBaseConnection connection = new DataBaseConnection();
		String user = textField.getText();
		@SuppressWarnings("deprecation")
		String password = pass.getText();
		
		String query = "select * from login where username = '"+user+"' and pass = '"+password+"'";
		
		ResultSet rs = connection.st.executeQuery(query);
		
		if(rs.next()) {
			new ManagementActions().jf.setVisible(true);
			jf.setVisible(false);
			
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Login or Password");
			jf.setVisible(false);		
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Login();

	}
}


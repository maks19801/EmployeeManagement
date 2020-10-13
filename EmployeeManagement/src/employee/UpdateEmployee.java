package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateEmployee extends AddEmployee implements ActionListener {

	JFrame jf;
	JLabel empIdLabel, nameLabel, lastNameLabel, ageLabel, dateOfBirthLabel, addressLabel, phoneNoLabel, emailLabel,
		   educationLabel, positionLabel, iTaxNoLabel, mainLabel, imageLabel;
	JTextField employeeId, name, lastName, age, dateOfBirth, address, phoneNo, email, education, position, iTaxNo;
	JButton cancelButton, updateButton;
	String ID;


	UpdateEmployee(String id) {
		super(0);
		jf = new JFrame("Update Employee details");
		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setLocation(300, 50);
		jf.setBackground(Color.white);
		jf.setLayout(null);

		ID = id;
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 1000, 700);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		imageLabel.setIcon(img);

		mainLabel = new JLabel("Update Employee Detail:");
		mainLabel.setBounds(50, 10, 500, 50);
		mainLabel.setFont(new Font("serif", Font.ITALIC, 40));
		mainLabel.setForeground(Color.black);
		imageLabel.add(mainLabel);
		jf.add(imageLabel);

		empIdLabel = new JLabel("Employee Id");
		empIdLabel.setBounds(50, 150, 150, 30);
		empIdLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(empIdLabel);

		employeeId = new JTextField();
		employeeId.setBounds(250, 150, 150, 30);
		imageLabel.add(employeeId);

		nameLabel = new JLabel("Name");
		nameLabel.setBounds(50, 200, 100, 30);
		nameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(nameLabel);

		name = new JTextField();
		name.setBounds(250, 200, 150, 30);
		imageLabel.add(name);

		lastNameLabel = new JLabel("Lastname");
		lastNameLabel.setBounds(50, 250, 100, 30);
		lastNameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(lastNameLabel);

		lastName = new JTextField();
		lastName.setBounds(250, 250, 150, 30);
		imageLabel.add(lastName);

		ageLabel = new JLabel("Age");
		ageLabel.setBounds(50, 300, 100, 30);
		ageLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(ageLabel);

		age = new JTextField();
		age.setBounds(250, 300, 150, 30);
		imageLabel.add(age);

		dateOfBirthLabel = new JLabel("Date of Birth (yyyy-mm-dd)");
		dateOfBirthLabel.setBounds(50, 350, 200, 30);
		dateOfBirthLabel.setFont(new Font("serif", Font.BOLD, 17));
		imageLabel.add(dateOfBirthLabel);

		dateOfBirth = new JTextField();
		dateOfBirth.setBounds(250, 350, 150, 30);
		imageLabel.add(dateOfBirth);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(50, 400, 150, 30);
		addressLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(addressLabel);

		address = new JTextField();
		address.setBounds(250, 400, 150, 30);
		imageLabel.add(address);

		phoneNoLabel = new JLabel("Phone No");
		phoneNoLabel.setBounds(450, 150, 100, 30);
		phoneNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(phoneNoLabel);

		phoneNo = new JTextField();
		phoneNo.setBounds(600, 150, 150, 30);
		imageLabel.add(phoneNo);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(450, 200, 100, 30);
		emailLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(emailLabel);

		email = new JTextField();
		email.setBounds(600, 200, 150, 30);
		imageLabel.add(email);

		educationLabel = new JLabel("Education");
		educationLabel.setBounds(450, 250, 100, 30);
		educationLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(educationLabel);

		education = new JTextField();
		education.setBounds(600, 250, 150, 30);
		imageLabel.add(education);

		positionLabel = new JLabel("Position");
		positionLabel.setBounds(450, 300, 100, 30);
		positionLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(positionLabel);

		position = new JTextField();
		position.setBounds(600, 300, 150, 30);
		imageLabel.add(position);

		iTaxNoLabel = new JLabel("Individual TaxNo");
		iTaxNoLabel.setBounds(450, 350, 200, 30);
		iTaxNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(iTaxNoLabel);

		iTaxNo = new JTextField();
		iTaxNo.setBounds(600, 350, 150, 30);
		imageLabel.add(iTaxNo);

		updateButton = new JButton("Update");
		updateButton.setBounds(250, 550, 150, 40);
		updateButton.addActionListener(this);
		imageLabel.add(updateButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(450, 550, 150, 40);
		cancelButton.addActionListener(this);
		imageLabel.add(cancelButton);

		showData(id);
	}

	int i = 0;

	void showData(String s) {
		try {
			DataBaseConnection connection = new DataBaseConnection();
			String query = "select * from employee where empId = '" + s + "'";
			ResultSet rs = connection.statement.executeQuery(query);

			if (rs.next()) {
				jf.setVisible(true);
				i = 1;

				employeeId.setText(rs.getString(1));
				name.setText(rs.getString(2));
				lastName.setText(rs.getString(3));
				age.setText(rs.getString(4));
				dateOfBirth.setText(rs.getString(5));
				address.setText(rs.getString(6));
				phoneNo.setText(rs.getString(7));
				email.setText(rs.getString(8));
				education.setText(rs.getString(9));
				position.setText(rs.getString(10));
				iTaxNo.setText(rs.getString(11));

			} else {
				JOptionPane.showMessageDialog(null, "Id not found");
				new SearchEmployee();
				jf.setVisible(false);
			}
		} catch (Exception ex) {
		}
		//jf.setVisible(true);
		//jf.setSize(1000, 700);
		//jf.setLocation(400, 100);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == updateButton && i == 1) {
			try {
				DataBaseConnection connectin = new DataBaseConnection();
				String query = "update employee set empId='" + employeeId.getText() + "', name='" + name.getText()
						+ "', lastName='" + lastName.getText() + "', age='" + age.getText() + "'," + "dOb='"
						+ dateOfBirth.getText() + "', address ='" + address.getText() + "', phone ='" + phoneNo.getText()
						+ "', email='" + email.getText() + "'," + " education ='" + education.getText() + "', position ='"
						+ position.getText() + "',iTaxNo='" + iTaxNo.getText() + "' where empId='" + ID + "'";
				connectin.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "successfully updated");
				jf.setVisible(false);
				new SearchEmployee();
			} catch (Exception e) {
				System.out.println("The error is:" + e);
			}
		}
		if (ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] arg) {
		new UpdateEmployee("Update Employee");
	}
}
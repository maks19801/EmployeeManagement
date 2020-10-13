package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddEmployee implements ActionListener {

	JFrame jf;
	JLabel empIdLabel, nameLabel, lastNameLabel, ageLabel, dateOfBirthLabel, addressLabel, phoneNoLabel, emailLabel,
			educationLabel, positionLabel, iTaxNoLabel, mainLabel, imageLabel;
	JTextField employeeId, name, lastName, age, dateOfBirth, address, phoneNo, email, education, position, iTaxNo;
	JButton cancelButton, submitButton;

	AddEmployee(int i) {
	}

	AddEmployee() {
		jf = new JFrame("Add Employee");
		jf.setBackground(Color.white);
		jf.setLayout(null);

		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 1000, 700);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		imageLabel.setIcon(img);

		mainLabel = new JLabel("New Employee Details");
		mainLabel.setBounds(320, 30, 500, 50);
		mainLabel.setFont(new Font("serif", Font.BOLD, 40));
		imageLabel.add(mainLabel);
		jf.add(imageLabel);

		empIdLabel = new JLabel("Employee Id");
		empIdLabel.setBounds(50, 150, 150, 30);
		empIdLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(empIdLabel);

		employeeId = new JTextField();
		employeeId.setBounds(300, 150, 150, 30);
		imageLabel.add(employeeId);

		nameLabel = new JLabel("Name");
		nameLabel.setBounds(50, 200, 100, 30);
		nameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(nameLabel);

		name = new JTextField();
		name.setBounds(300, 200, 150, 30);
		imageLabel.add(name);

		lastNameLabel = new JLabel("Lastname");
		lastNameLabel.setBounds(50, 250, 100, 30);
		lastNameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(lastNameLabel);

		lastName = new JTextField();
		lastName.setBounds(300, 250, 150, 30);
		imageLabel.add(lastName);

		ageLabel = new JLabel("Age");
		ageLabel.setBounds(50, 300, 100, 30);
		ageLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(ageLabel);

		age = new JTextField();
		age.setBounds(300, 300, 150, 30);
		imageLabel.add(age);

		dateOfBirthLabel = new JLabel("Date of Birth (yyyy-mm-dd)");
		dateOfBirthLabel.setBounds(50, 350, 250, 30);
		dateOfBirthLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(dateOfBirthLabel);

		dateOfBirth = new JTextField();
		dateOfBirth.setBounds(300, 350, 150, 30);
		imageLabel.add(dateOfBirth);

		addressLabel = new JLabel("Address");
		addressLabel.setBounds(50, 400, 150, 30);
		addressLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(addressLabel);

		address = new JTextField();
		address.setBounds(300, 400, 150, 30);
		imageLabel.add(address);

		phoneNoLabel = new JLabel("Phone No");
		phoneNoLabel.setBounds(500, 150, 100, 30);
		phoneNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(phoneNoLabel);

		phoneNo = new JTextField();
		phoneNo.setBounds(700, 150, 150, 30);
		imageLabel.add(phoneNo);

		emailLabel = new JLabel("Email");
		emailLabel.setBounds(500, 200, 100, 30);
		emailLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(emailLabel);

		email = new JTextField();
		email.setBounds(700, 200, 150, 30);
		imageLabel.add(email);

		educationLabel = new JLabel("Education");
		educationLabel.setBounds(500, 250, 100, 30);
		educationLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(educationLabel);

		education = new JTextField();
		education.setBounds(700, 250, 150, 30);
		imageLabel.add(education);

		positionLabel = new JLabel("Position");
		positionLabel.setBounds(500, 300, 100, 30);
		positionLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(positionLabel);

		position = new JTextField();
		position.setBounds(700, 300, 150, 30);
		imageLabel.add(position);

		iTaxNoLabel = new JLabel("Individual Tax No");
		iTaxNoLabel.setBounds(500, 350, 200, 30);
		iTaxNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(iTaxNoLabel);

		iTaxNo = new JTextField();
		iTaxNo.setBounds(700, 350, 150, 30);
		imageLabel.add(iTaxNo);

		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.setBounds(250, 550, 150, 40);

		imageLabel.add(submitButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(450, 550, 150, 40);

		imageLabel.add(cancelButton);

		submitButton.addActionListener(this);
		cancelButton.addActionListener(this);

		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setLocation(300, 50);
	}

	public void actionPerformed(ActionEvent ae) {

		String id = employeeId.getText();
		String nameString = name.getText();
		String lastNameString = lastName.getText();
		String ageString = age.getText();
		String dObString = dateOfBirth.getText();
		String addressString = address.getText();
		String phoneString = phoneNo.getText();
		String emailString = email.getText();
		String educationString = education.getText();
		String positionString = position.getText();
		String iTaxNoString = iTaxNo.getText();
		if (ae.getSource() == submitButton) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "insert into employee values('" + id + "','" + nameString + "','" + lastNameString
						+ "','" + ageString + "','" + dObString + "','" + addressString + "','" + phoneString + "','"
						+ emailString + "','" + educationString + "','" + positionString + "','" + iTaxNoString + "')";
				connection.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
				jf.setVisible(false);
				new ManagementActions();
			} catch (Exception ee) {
				System.out.println("The error is:" + ee);
				JOptionPane.showMessageDialog(null, "Id is already exists!!!");

			}
		} else if (ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] arg) {
		new AddEmployee();
	}
}

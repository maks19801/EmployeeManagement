package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class PrintData implements ActionListener {
	JFrame jf;
	JLabel empIdLabel, empIdLabelDb, nameLabel, nameLabelDb, lastNameLabel, lastNameLabelDb, ageLabel, ageLabelDb,
			dateOfBirthLabel, dateOfBirthLabelDb, addressLabel, addressLabelDb, phoneNoLabel, phoneNoLabelDb,
			emailLabel, emailLabelDb, educationLabel, educationLabelDb, positionLabel, positionLabelDb,
			iTaxNoLabel, iTaxNoLabelDb, mainLabel, imageLabel;
	String ID, name, lastName, age, dOb, address, phone, email, education, position, iTaxNo;
	JButton printButton, cancelButton;

	PrintData(String empId) {
		try {
			DataBaseConnection connection = new DataBaseConnection();
			String query = "select * from employee where empId = '" + empId + "'";
			ResultSet rs = connection.statement.executeQuery(query);

			if (rs.next()) {

				ID = rs.getString(1);
				name = rs.getString(2);
				lastName = rs.getString(3);
				age = rs.getString(4);
				dOb = rs.getString(5);
				address = rs.getString(6);
				phone = rs.getString(7);
				email = rs.getString(8);
				education = rs.getString(9);
				position = rs.getString(10);
				iTaxNo = rs.getString(11);
			} else {
				JOptionPane.showMessageDialog(null, "Id not found");
				new ViewEmployee();
				jf.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		jf = new JFrame("Print Data");
		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setLocation(300, 50);
		jf.setBackground(Color.black);
		jf.setLayout(null);

		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 1000, 700);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		imageLabel.setIcon(img);

		mainLabel = new JLabel("Employee Details");
		mainLabel.setBounds(50, 10, 250, 30);
		mainLabel.setFont(new Font("serif", Font.BOLD, 25));
		imageLabel.add(mainLabel);
		jf.add(imageLabel);

		empIdLabel = new JLabel("Employee Id:");
		empIdLabel.setBounds(50, 70, 200, 30);
		empIdLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(empIdLabel);

		empIdLabelDb = new JLabel(ID);
		empIdLabelDb.setBounds(250, 70, 300, 30);
		empIdLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(empIdLabelDb);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(50, 100, 200, 30);
		nameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(nameLabel);

		nameLabelDb = new JLabel(name);
		nameLabelDb.setBounds(250, 100, 300, 30);
		nameLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(nameLabelDb);

		lastNameLabel = new JLabel("Lastname:");
		lastNameLabel.setBounds(50, 130, 200, 30);
		lastNameLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(lastNameLabel);

		lastNameLabelDb = new JLabel(lastName);
		lastNameLabelDb.setBounds(250, 130, 300, 30);
		lastNameLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(lastNameLabelDb);

		ageLabel = new JLabel("Age:");
		ageLabel.setBounds(50, 160, 200, 30);
		ageLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(ageLabel);

		ageLabelDb = new JLabel(age);
		ageLabelDb.setBounds(250, 160, 300, 30);
		ageLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(ageLabelDb);

		dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthLabel.setBounds(50, 190, 200, 30);
		dateOfBirthLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(dateOfBirthLabel);

		dateOfBirthLabelDb = new JLabel(dOb);
		dateOfBirthLabelDb.setBounds(250, 190, 300, 30);
		dateOfBirthLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(dateOfBirthLabelDb);

		addressLabel = new JLabel("Address:");
		addressLabel.setBounds(50, 220, 200, 30);
		addressLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(addressLabel);

		addressLabelDb = new JLabel(address);
		addressLabelDb.setBounds(250, 220, 300, 30);
		addressLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(addressLabelDb);

		phoneNoLabel = new JLabel("Phone No:");
		phoneNoLabel.setBounds(50, 250, 200, 30);
		phoneNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(phoneNoLabel);

		phoneNoLabelDb = new JLabel(phone);
		phoneNoLabelDb.setBounds(250, 250, 300, 30);
		phoneNoLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(phoneNoLabelDb);

		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(50, 280, 200, 30);
		emailLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(emailLabel);

		emailLabelDb = new JLabel(email);
		emailLabelDb.setBounds(250, 280, 300, 30);
		emailLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(emailLabelDb);

		educationLabel = new JLabel("Education:");
		educationLabel.setBounds(50, 310, 200, 30);
		educationLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(educationLabel);

		educationLabelDb = new JLabel(education);
		educationLabelDb.setBounds(250, 310, 300, 30);
		educationLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(educationLabelDb);

		positionLabel = new JLabel("Position:");
		positionLabel.setBounds(50, 340, 200, 30);
		positionLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(positionLabel);

		positionLabelDb = new JLabel(position);
		positionLabelDb.setBounds(250, 340, 300, 30);
		positionLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(positionLabelDb);

		iTaxNoLabel = new JLabel("Individual Tax No:");
		iTaxNoLabel.setBounds(50, 370, 200, 30);
		iTaxNoLabel.setFont(new Font("serif", Font.BOLD, 20));
		imageLabel.add(iTaxNoLabel);

		iTaxNoLabelDb = new JLabel(iTaxNo);
		iTaxNoLabelDb.setBounds(250, 370, 300, 30);
		iTaxNoLabelDb.setFont(new Font("serif", Font.PLAIN, 20));
		imageLabel.add(iTaxNoLabelDb);

		printButton = new JButton("Print");
		printButton.setBounds(100, 520, 100, 30);
		printButton.addActionListener(this);
		imageLabel.add(printButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(250, 520, 100, 30);
		cancelButton.addActionListener(this);
		imageLabel.add(cancelButton);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == printButton) {
			JOptionPane.showMessageDialog(null, "printed successfully");
			jf.setVisible(false);
			new ManagementActions();
		}
		if (ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new ViewEmployee();
		}
	}

	public static void main(String[] args) {
		new PrintData("Print Data");
	}

}
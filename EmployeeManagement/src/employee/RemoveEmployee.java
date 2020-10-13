package employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RemoveEmployee implements ActionListener {
	JFrame jf;
	JTextField employeeId;
	JLabel employeeIdLabel, nameLabel, nameLabelDb, lastNameLabel, lastNameLabelDb, phoneNoLabel, phoneNoLabelDb, imageLabel;
	JButton searchButton, backButton, removeButton, cancelButton;

	RemoveEmployee() {
		jf = new JFrame("Remove Employee");
		jf.setBackground(Color.green);
		jf.setLayout(null);

		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 500, 500);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/remove.jpg"));
		imageLabel.setIcon(img);
		jf.add(imageLabel);

		employeeIdLabel = new JLabel("Employee Id");
		employeeIdLabel.setBounds(50, 50, 250, 30);
		employeeIdLabel.setForeground(Color.white);
		Font f2 = new Font("serif", Font.BOLD, 25);
		employeeIdLabel.setFont(f2);
		imageLabel.add(employeeIdLabel);

		employeeId = new JTextField();
		employeeId.setBounds(250, 50, 150, 30);
		imageLabel.add(employeeId);

		searchButton = new JButton("Search");
		searchButton.setBounds(200, 100, 100, 30);
		searchButton.addActionListener(this);
		imageLabel.add(searchButton);

		backButton = new JButton("Back");
		backButton.setBounds(360, 100, 100, 30);
		backButton.addActionListener(this);
		imageLabel.add(backButton);

		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(50, 150, 250, 30);
		nameLabel.setForeground(Color.white);
		Font f3 = new Font("serif", Font.BOLD, 20);
		nameLabel.setFont(f3);
		imageLabel.add(nameLabel);

		nameLabelDb = new JLabel();
		nameLabelDb.setBounds(200, 150, 350, 30);
		nameLabelDb.setForeground(Color.white);
		Font f6 = new Font("serif", Font.BOLD, 20);
		nameLabelDb.setFont(f6);
		imageLabel.add(nameLabelDb);

		lastNameLabel = new JLabel("Lastname:");
		lastNameLabel.setBounds(50, 200, 250, 30);
		lastNameLabel.setForeground(Color.white);
		Font f4 = new Font("serif", Font.BOLD, 20);
		lastNameLabel.setFont(f4);
		imageLabel.add(lastNameLabel);

		lastNameLabelDb = new JLabel();
		lastNameLabelDb.setBounds(200, 200, 350, 30);
		lastNameLabelDb.setForeground(Color.white);
		Font f7 = new Font("serif", Font.BOLD, 20);
		lastNameLabelDb.setFont(f7);
		imageLabel.add(lastNameLabelDb);

		phoneNoLabel = new JLabel("Phone No:");
		phoneNoLabel.setBounds(50, 250, 250, 30);
		phoneNoLabel.setForeground(Color.white);
		Font f5 = new Font("serif", Font.BOLD, 20);
		phoneNoLabel.setFont(f5);
		imageLabel.add(phoneNoLabel);

		phoneNoLabelDb = new JLabel();
		phoneNoLabelDb.setBounds(200, 250, 350, 30);
		phoneNoLabelDb.setForeground(Color.white);
		Font f8 = new Font("serif", Font.BOLD, 20);
		phoneNoLabelDb.setFont(f8);
		imageLabel.add(phoneNoLabelDb);

		removeButton = new JButton("Remove");
		removeButton.setBounds(120, 300, 100, 30);
		removeButton.addActionListener(this);
		imageLabel.add(removeButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(300, 300, 100, 30);
		cancelButton.addActionListener(this);
		imageLabel.add(cancelButton);
		
		nameLabel.setVisible(false);
		lastNameLabel.setVisible(false);
		phoneNoLabel.setVisible(false);
		removeButton.setVisible(false);
		cancelButton.setVisible(false);

		jf.setSize(500, 500);
		jf.setLocation(500, 100);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == searchButton) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "select name, lastName, phone from employee where empId ='" + employeeId.getText() + "' ";
				ResultSet rs = connection.statement.executeQuery(query);

				int i = 0;
				if (rs.next()) {
					String name = rs.getString(1);
					String mob = rs.getString(2);
					String phone = rs.getString(3);

					nameLabel.setVisible(true);
					lastNameLabel.setVisible(true);
					phoneNoLabel.setVisible(true);
					removeButton.setVisible(true);
					cancelButton.setVisible(true);
					i = 1;
					nameLabelDb.setText(name);
					lastNameLabelDb.setText(mob);
					phoneNoLabelDb.setText(phone);
				}
				if (i == 0)
					JOptionPane.showMessageDialog(null, "Id not found");
			} catch (Exception ex) {
			}
		}
		if (ae.getSource() == removeButton) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "delete from employee where empId = '" + employeeId.getText() + "'";
				connection.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "deleted successfully");
				nameLabel.setVisible(false);
				lastNameLabel.setVisible(false);
				phoneNoLabel.setVisible(false);
				nameLabelDb.setVisible(false);
				lastNameLabelDb.setVisible(false);
				phoneNoLabelDb.setVisible(false);
				removeButton.setVisible(false);
				cancelButton.setVisible(false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception occured while deleting record " + ex);
			}
		}
		if (ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new ManagementActions();
		}
		if (ae.getSource() == backButton) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] ar) {
		new RemoveEmployee();
	}
}
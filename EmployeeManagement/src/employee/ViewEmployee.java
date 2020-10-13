package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewEmployee implements ActionListener {

	JFrame jf;
	JTextField employeeId;
	JLabel imageLabel, mainLabel;
	JButton searchButton, cancelButton;

	ViewEmployee() {
		jf = new JFrame("View");
		jf.setBackground(Color.green);
		jf.setLayout(null);

		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 500, 270);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/view.jpg"));
		imageLabel.setIcon(img);

		mainLabel = new JLabel("Employee Id");
		mainLabel.setVisible(true);
		mainLabel.setBounds(40, 60, 250, 30);
		mainLabel.setForeground(Color.white);
		Font F1 = new Font("serif", Font.BOLD, 30);
		mainLabel.setFont(F1);
		imageLabel.add(mainLabel);
		jf.add(imageLabel);

		employeeId = new JTextField();
		employeeId.setBounds(240, 60, 220, 30);
		imageLabel.add(employeeId);

		searchButton = new JButton("Search");
		searchButton.setBounds(240, 150, 100, 30);
		searchButton.addActionListener(this);
		imageLabel.add(searchButton);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(360, 150, 100, 30);
		cancelButton.addActionListener(this);
		imageLabel.add(cancelButton);

		jf.setSize(500, 270);
		jf.setLocation(450, 250);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == cancelButton) {
			jf.setVisible(false);
			new ManagementActions();
		}
		if (ae.getSource() == searchButton) {
			jf.setVisible(false);
			new PrintData(employeeId.getText());
		}

	}

	public static void main(String[] ar) {
			new ViewEmployee();
	}
}

package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ManagementActions implements ActionListener {

	JFrame jf;
	JLabel imageLabel, mainLabel;
	JButton addButton, viewButton, removeButton, updateButton;

	ManagementActions() {
		jf = new JFrame("Management Actions");
		jf.setBackground(Color.white);
		jf.setLayout(null);
		
		imageLabel = new JLabel();
		imageLabel.setBounds(0, 0, 700, 600);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/details.jpg"));
		imageLabel.setIcon(img);
		
		jf.add(imageLabel);

		mainLabel = new JLabel("Management Actions");
		mainLabel.setBounds(410, 20, 250, 40);
		mainLabel.setFont(new Font("serif", Font.BOLD, 25));
		mainLabel.setForeground(Color.GREEN);
		imageLabel.add(mainLabel);

		addButton = new JButton("Add");
		addButton.setBounds(420, 80, 100, 40);
		addButton.setFont(new Font("serif", Font.BOLD, 15));
		addButton.addActionListener(this);
		imageLabel.add(addButton);

		viewButton = new JButton("View");
		viewButton.setBounds(530, 80, 100, 40);
		viewButton.setFont(new Font("serif", Font.BOLD, 15));
		viewButton.addActionListener(this);
		imageLabel.add(viewButton);

		removeButton = new JButton("Remove");
		removeButton.setBounds(420, 140, 100, 40);
		removeButton.setFont(new Font("serif", Font.BOLD, 15));
		removeButton.addActionListener(this);
		imageLabel.add(removeButton);

		updateButton = new JButton("Update");
		updateButton.setBounds(530, 140, 100, 40);
		updateButton.setFont(new Font("serif", Font.BOLD, 15));
		updateButton.addActionListener(this);
		imageLabel.add(updateButton);

		jf.setVisible(true);
		jf.setSize(700, 500);
		jf.setLocation(450, 200);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addButton) {
			jf.setVisible(false);
			new AddEmployee();
		}
		if (ae.getSource() == viewButton) {
			jf.setVisible(false);
			new ViewEmployee();
		}
		if (ae.getSource() == removeButton) {
			jf.setVisible(false);
			new RemoveEmployee();
		}
		if (ae.getSource() == updateButton) {
			jf.setVisible(false);
			new SearchEmployee();
		}
	}

	public static void main(String[] arg) {
		new ManagementActions();
	}

}
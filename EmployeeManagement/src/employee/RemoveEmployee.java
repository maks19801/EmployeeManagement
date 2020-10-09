package employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RemoveEmployee implements ActionListener {
	JFrame jf;
	JTextField text;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;
	JButton button1, button2, button3, button4;

	RemoveEmployee() {
		jf = new JFrame("Remove Employee");
		jf.setBackground(Color.green);
		jf.setLayout(null);

		label5 = new JLabel();
		label5.setBounds(0, 0, 500, 500);
		label5.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/remove.jpg"));
		label5.setIcon(img);
		jf.add(label5);

		label1 = new JLabel("Employee Id");
		label1.setBounds(50, 50, 250, 30);
		label1.setForeground(Color.white);
		Font f2 = new Font("serif", Font.BOLD, 25);
		label1.setFont(f2);
		label5.add(label1);

		text = new JTextField();
		text.setBounds(250, 50, 150, 30);
		label5.add(text);

		button1 = new JButton("Search");
		button1.setBounds(200, 100, 100, 30);
		button1.addActionListener(this);
		label5.add(button1);

		button4 = new JButton("Back");
		button4.setBounds(360, 100, 100, 30);
		button4.addActionListener(this);
		label5.add(button4);

		label2 = new JLabel("Name:");
		label2.setBounds(50, 150, 250, 30);
		label2.setForeground(Color.white);
		Font f3 = new Font("serif", Font.BOLD, 20);
		label2.setFont(f3);
		label5.add(label2);

		label6 = new JLabel();
		label6.setBounds(200, 150, 350, 30);
		label6.setForeground(Color.white);
		Font f6 = new Font("serif", Font.BOLD, 20);
		label6.setFont(f6);
		label5.add(label6);

		label3 = new JLabel("Lastname:");
		label3.setBounds(50, 200, 250, 30);
		label3.setForeground(Color.white);
		Font f4 = new Font("serif", Font.BOLD, 20);
		label3.setFont(f4);
		label5.add(label3);

		label7 = new JLabel();
		label7.setBounds(200, 200, 350, 30);
		label7.setForeground(Color.white);
		Font f7 = new Font("serif", Font.BOLD, 20);
		label7.setFont(f7);
		label5.add(label7);

		label4 = new JLabel("Phone No:");
		label4.setBounds(50, 250, 250, 30);
		label4.setForeground(Color.white);
		Font f5 = new Font("serif", Font.BOLD, 20);
		label4.setFont(f5);
		label5.add(label4);

		label8 = new JLabel();
		label8.setBounds(200, 250, 350, 30);
		label8.setForeground(Color.white);
		Font f8 = new Font("serif", Font.BOLD, 20);
		label8.setFont(f8);
		label5.add(label8);

		button2 = new JButton("Remove");
		button2.setBounds(120, 300, 100, 30);
		button2.addActionListener(this);
		label5.add(button2);

		button3 = new JButton("Cancel");
		button3.setBounds(300, 300, 100, 30);
		button3.addActionListener(this);
		label5.add(button3);
		
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);

		jf.setSize(500, 500);
		jf.setLocation(500, 100);
		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == button1) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "select name,lastName,phone from employee where empId ='" + text.getText() + "' ";
				ResultSet rs = connection.st.executeQuery(query);

				int i = 0;
				if (rs.next()) {
					String name = rs.getString(1);
					String mob = rs.getString(2);
					String email = rs.getString(3);

					label2.setVisible(true);
					label3.setVisible(true);
					label4.setVisible(true);
					button2.setVisible(true);
					button3.setVisible(true);
					i = 1;
					label6.setText(name);
					label7.setText(mob);
					label8.setText(email);
				}
				if (i == 0)
					JOptionPane.showMessageDialog(null, "Id not found");
			} catch (Exception ex) {
			}
		}
		if (ae.getSource() == button2) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "delete from employee where empId = '" + text.getText() + "'";
				connection.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "deleted successfully");
				label2.setVisible(false);
				label3.setVisible(false);
				label4.setVisible(false);
				label6.setVisible(false);
				label7.setVisible(false);
				label8.setVisible(false);
				button2.setVisible(false);
				button3.setVisible(false);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Exception occured while deleting record " + ex);
			}
		}
		if (ae.getSource() == button3) {
			jf.setVisible(false);
			new ManagementActions();
		}
		if (ae.getSource() == button4) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] ar) {
		new RemoveEmployee();
	}
}
package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateEmployee extends AddEmployee implements ActionListener {

	JFrame jf;
	JLabel id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13;
	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13;
	JButton button, button1;
	String employeeId;

	UpdateEmployee(String id) {
		super(0);
		jf = new JFrame("Update Employee details");
		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setLocation(300, 50);
		jf.setBackground(Color.white);
		jf.setLayout(null);

		employeeId = id;
		id13 = new JLabel();
		id13.setBounds(0, 0, 1000, 700);
		id13.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		id13.setIcon(img);

		id12 = new JLabel("Update Employee Detail:");
		id12.setBounds(50, 10, 500, 50);
		id12.setFont(new Font("serif", Font.ITALIC, 40));
		id12.setForeground(Color.black);
		id13.add(id12);
		jf.add(id13);

		id1 = new JLabel("Employee Id");
		id1.setBounds(50, 150, 150, 30);
		id1.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id1);

		text1 = new JTextField();
		text1.setBounds(250, 150, 150, 30);
		id13.add(text1);

		id2 = new JLabel("Name");
		id2.setBounds(50, 200, 100, 30);
		id2.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id2);

		text2 = new JTextField();
		text2.setBounds(250, 200, 150, 30);
		id13.add(text2);

		id3 = new JLabel("Lastname");
		id3.setBounds(50, 250, 100, 30);
		id3.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id3);

		text3 = new JTextField();
		text3.setBounds(250, 250, 150, 30);
		id13.add(text3);

		id4 = new JLabel("Age");
		id4.setBounds(50, 300, 100, 30);
		id4.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id4);

		text4 = new JTextField();
		text4.setBounds(250, 300, 150, 30);
		id13.add(text4);

		id5 = new JLabel("Date of Birth (yyyy-mm-dd)");
		id5.setBounds(50, 350, 200, 30);
		id5.setFont(new Font("serif", Font.BOLD, 17));
		id13.add(id5);

		text5 = new JTextField();
		text5.setBounds(250, 350, 150, 30);
		id13.add(text5);

		id6 = new JLabel("Address");
		id6.setBounds(50, 400, 150, 30);
		id6.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id6);

		text6 = new JTextField();
		text6.setBounds(250, 400, 150, 30);
		id13.add(text6);

		id7 = new JLabel("Phone No");
		id7.setBounds(450, 150, 100, 30);
		id7.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id7);

		text7 = new JTextField();
		text7.setBounds(600, 150, 150, 30);
		id13.add(text7);

		id8 = new JLabel("Email");
		id8.setBounds(450, 200, 100, 30);
		id8.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id8);

		text8 = new JTextField();
		text8.setBounds(600, 200, 150, 30);
		id13.add(text8);

		id9 = new JLabel("Education");
		id9.setBounds(450, 250, 100, 30);
		id9.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id9);

		text9 = new JTextField();
		text9.setBounds(600, 250, 150, 30);
		id13.add(text9);

		id10 = new JLabel("Position");
		id10.setBounds(450, 300, 100, 30);
		id10.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id10);

		text10 = new JTextField();
		text10.setBounds(600, 300, 150, 30);
		id13.add(text10);

		id11 = new JLabel("Individual TaxNo");
		id11.setBounds(450, 350, 200, 30);
		id11.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id11);

		text11 = new JTextField();
		text11.setBounds(600, 350, 150, 30);
		id13.add(text11);

		button = new JButton("Update");
		button.setBounds(250, 550, 150, 40);
		button.addActionListener(this);
		id13.add(button);

		button1 = new JButton("Cancel");
		button1.setBounds(450, 550, 150, 40);
		button1.addActionListener(this);
		id13.add(button1);

		showData(id);
	}

	int i = 0;

	void showData(String s) {
		try {
			DataBaseConnection connection = new DataBaseConnection();
			String query = "select * from employee where empId = '" + s + "'";
			ResultSet rs = connection.st.executeQuery(query);

			if (rs.next()) {
				jf.setVisible(true);
				i = 1;

				text1.setText(rs.getString(1));
				text2.setText(rs.getString(2));
				text3.setText(rs.getString(3));
				text4.setText(rs.getString(4));
				text5.setText(rs.getString(5));
				text6.setText(rs.getString(6));
				text7.setText(rs.getString(7));
				text8.setText(rs.getString(8));
				text9.setText(rs.getString(9));
				text10.setText(rs.getString(10));
				text11.setText(rs.getString(11));

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
		if (ae.getSource() == button && i == 1) {
			try {
				DataBaseConnection connectin = new DataBaseConnection();
				String query = "update employee set empId='" + text1.getText() + "', name='" + text2.getText()
						+ "', lastName='" + text3.getText() + "', age='" + text4.getText() + "'," + "dOb='"
						+ text5.getText() + "', address ='" + text6.getText() + "', phone ='" + text7.getText()
						+ "', email='" + text8.getText() + "'," + " education ='" + text9.getText() + "', position ='"
						+ text10.getText() + "',iTaxNo='" + text11.getText() + "' where empId='" + employeeId + "'";
				connectin.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "successfully updated");
				jf.setVisible(false);
				new SearchEmployee();
			} catch (Exception e) {
				System.out.println("The error is:" + e);
			}
		}
		if (ae.getSource() == button1) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] arg) {
		new UpdateEmployee("Update Employee");
	}
}
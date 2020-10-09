package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class PrintData implements ActionListener {
	JFrame jf;
	JLabel id, aid, id1, aid1, id2, aid2, id3, aid3, id4, aid4, id5, aid5, id6, aid6, id7, aid7, id8, id9, id10, aid10,
			id11, aid11, id12, aid12;
	String employeeId, ID, name, lastName, age, dOb, address, phone, email, education, position, iTaxNo;
	JButton button1, button2;

	PrintData(String empId) {
		try {
			DataBaseConnection connection = new DataBaseConnection();
			String query = "select * from employee where empId = '" + empId + "'";
			ResultSet rs = connection.st.executeQuery(query);

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

		id9 = new JLabel();
		id9.setBounds(0, 0, 1000, 700);
		id9.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		id9.setIcon(img);

		id8 = new JLabel("Employee Details");
		id8.setBounds(50, 10, 250, 30);
		jf.add(id8);
		id8.setFont(new Font("serif", Font.BOLD, 25));
		id9.add(id8);
		jf.add(id9);

		id = new JLabel("Employee Id:");
		id.setBounds(50, 70, 200, 30);
		id.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id);

		aid = new JLabel(ID);
		aid.setBounds(250, 70, 300, 30);
		aid.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid);

		id1 = new JLabel("Name:");
		id1.setBounds(50, 100, 200, 30);
		id1.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id1);

		aid1 = new JLabel(name);
		aid1.setBounds(250, 100, 300, 30);
		aid1.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid1);

		id2 = new JLabel("Lastname:");
		id2.setBounds(50, 130, 200, 30);
		id2.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id2);

		aid2 = new JLabel(lastName);
		aid2.setBounds(250, 130, 300, 30);
		aid2.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid2);

		id3 = new JLabel("Age:");
		id3.setBounds(50, 160, 200, 30);
		id3.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id3);

		aid3 = new JLabel(age);
		aid3.setBounds(250, 160, 300, 30);
		aid3.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid3);

		id4 = new JLabel("Date of Birth:");
		id4.setBounds(50, 190, 200, 30);
		id4.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id4);

		aid4 = new JLabel(dOb);
		aid4.setBounds(250, 190, 300, 30);
		aid4.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid4);

		id5 = new JLabel("Address:");
		id5.setBounds(50, 220, 200, 30);
		id5.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id5);

		aid5 = new JLabel(address);
		aid5.setBounds(250, 220, 300, 30);
		aid5.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid5);

		id6 = new JLabel("Phone No:");
		id6.setBounds(50, 250, 200, 30);
		id6.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id6);

		aid6 = new JLabel(phone);
		aid6.setBounds(250, 250, 300, 30);
		aid6.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid6);

		id7 = new JLabel("Email:");
		id7.setBounds(50, 280, 200, 30);
		id7.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id7);

		aid7 = new JLabel(email);
		aid7.setBounds(250, 280, 300, 30);
		aid7.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid7);

		id10 = new JLabel("Education:");
		id10.setBounds(50, 310, 200, 30);
		id10.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id10);

		aid10 = new JLabel(education);
		aid10.setBounds(250, 310, 300, 30);
		aid10.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid10);

		id11 = new JLabel("Position:");
		id11.setBounds(50, 340, 200, 30);
		id11.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id11);

		aid11 = new JLabel(position);
		aid11.setBounds(250, 340, 300, 30);
		aid11.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid11);

		id12 = new JLabel("Individual Tax No:");
		id12.setBounds(50, 370, 200, 30);
		id12.setFont(new Font("serif", Font.BOLD, 20));
		id9.add(id12);

		aid12 = new JLabel(iTaxNo);
		aid12.setBounds(250, 370, 300, 30);
		aid12.setFont(new Font("serif", Font.PLAIN, 20));
		id9.add(aid12);

		button1 = new JButton("Print");
		button1.setBounds(100, 520, 100, 30);
		button1.addActionListener(this);
		id9.add(button1);

		button2 = new JButton("cancel");
		button2.setBounds(250, 520, 100, 30);
		button2.addActionListener(this);
		id9.add(button2);

	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "printed successfully");
			jf.setVisible(false);
			new ManagementActions();
		}
		if (ae.getSource() == button2) {
			jf.setVisible(false);
			new ViewEmployee();
		}
	}

	public static void main(String[] args) {
		new PrintData("Print Data");
	}

}
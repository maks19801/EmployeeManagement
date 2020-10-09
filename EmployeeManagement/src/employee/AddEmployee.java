package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddEmployee implements ActionListener {

	JFrame jf;
	JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13;
	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13;
	JButton button, button1;

	AddEmployee(int i) {
	}

	AddEmployee() {
		jf = new JFrame("Add Employee");
		jf.setBackground(Color.white);
		jf.setLayout(null);

		id13 = new JLabel();
		id13.setBounds(0, 0, 1000, 700);
		id13.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/addEmployee1.jpg"));
		id13.setIcon(img);

		id12 = new JLabel("New Employee Details");
		id12.setBounds(320, 30, 500, 50);
		id12.setFont(new Font("serif", Font.BOLD, 40));
		id13.add(id12);
		jf.add(id13);

		id1 = new JLabel("Employee Id");
		id1.setBounds(50, 150, 150, 30);
		id1.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id1);

		text1 = new JTextField();
		text1.setBounds(300, 150, 150, 30);
		id13.add(text1);

		id2 = new JLabel("Name");
		id2.setBounds(50, 200, 100, 30);
		id2.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id2);

		text2 = new JTextField();
		text2.setBounds(300, 200, 150, 30);
		id13.add(text2);

		id3 = new JLabel("Lastname");
		id3.setBounds(50, 250, 100, 30);
		id3.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id3);

		text3 = new JTextField();
		text3.setBounds(300, 250, 150, 30);
		id13.add(text3);

		id4 = new JLabel("Age");
		id4.setBounds(50, 300, 100, 30);
		id4.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id4);

		text4 = new JTextField();
		text4.setBounds(300, 300, 150, 30);
		id13.add(text4);

		id5 = new JLabel("Date of Birth (yyyy-mm-dd)");
		id5.setBounds(50, 350, 250, 30);
		id5.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id5);

		text5 = new JTextField();
		text5.setBounds(300, 350, 150, 30);
		id13.add(text5);

		id6 = new JLabel("Address");
		id6.setBounds(50, 400, 150, 30);
		id6.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id6);

		text6 = new JTextField();
		text6.setBounds(300, 400, 150, 30);
		id13.add(text6);

		id7 = new JLabel("Phone No");
		id7.setBounds(500, 150, 100, 30);
		id7.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id7);

		text7 = new JTextField();
		text7.setBounds(700, 150, 150, 30);
		id13.add(text7);

		id8 = new JLabel("Email");
		id8.setBounds(500, 200, 100, 30);
		id8.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id8);

		text8 = new JTextField();
		text8.setBounds(700, 200, 150, 30);
		id13.add(text8);

		id9 = new JLabel("Education");
		id9.setBounds(500, 250, 100, 30);
		id9.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id9);

		text9 = new JTextField();
		text9.setBounds(700, 250, 150, 30);
		id13.add(text9);

		id10 = new JLabel("Position");
		id10.setBounds(500, 300, 100, 30);
		id10.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id10);

		text10 = new JTextField();
		text10.setBounds(700, 300, 150, 30);
		id13.add(text10);

		id11 = new JLabel("Individual Tax No");
		id11.setBounds(500, 350, 200, 30);
		id11.setFont(new Font("serif", Font.BOLD, 20));
		id13.add(id11);

		text11 = new JTextField();
		text11.setBounds(700, 350, 150, 30);
		id13.add(text11);

		button = new JButton("Submit");
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setBounds(250, 550, 150, 40);

		id13.add(button);

		button1 = new JButton("Cancel");
		button1.setBackground(Color.BLACK);
		button1.setForeground(Color.WHITE);
		button1.setBounds(450, 550, 150, 40);

		id13.add(button1);

		button.addActionListener(this);
		button1.addActionListener(this);

		jf.setVisible(true);
		jf.setSize(1000, 700);
		jf.setLocation(300, 50);
	}

	public void actionPerformed(ActionEvent ae) {

		String id = text1.getText();
		String name = text2.getText();
		String lastName = text3.getText();
		String age = text4.getText();
		String dOb = text5.getText();
		String address = text6.getText();
		String phone = text7.getText();
		String email = text8.getText();
		String education = text9.getText();
		String position = text10.getText();
		String iTaxNo = text11.getText();
		if (ae.getSource() == button) {
			try {
				DataBaseConnection connection = new DataBaseConnection();
				String query = "insert into employee values('" + id + "','" + name + "','" + lastName + "','" + age
						+ "','" + dOb + "','" + address + "','" + phone + "','" + email + "','" + education + "','"
						+ position + "','" + iTaxNo + "')";
				connection.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
				jf.setVisible(false);
				new ManagementActions();
			} catch (Exception ee) {
				System.out.println("The error is:" + ee);
				JOptionPane.showMessageDialog(null, "Id is already exists!!!");
				
			}
		} else if (ae.getSource() == button1) {
			jf.setVisible(false);
			new ManagementActions();
		}
	}

	public static void main(String[] arg) {
		new AddEmployee();
	}
}

package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ManagementActions implements ActionListener {

	JFrame jf;
	JLabel label1;
	JButton button1, button2, button3, button4;

	ManagementActions() {
		jf = new JFrame("Management Actions");
		jf.setBackground(Color.white);
		jf.setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/icons/details.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);

		JLabel l1 = new JLabel(i3);

		l1.setBounds(0, 0, 700, 600);
		jf.add(l1);

		label1 = new JLabel("Management Actions");
		label1.setBounds(410, 20, 250, 40);
		label1.setFont(new Font("serif", Font.BOLD, 25));
		label1.setForeground(Color.GREEN);
		l1.add(label1);

		button1 = new JButton("Add");
		button1.setBounds(420, 80, 100, 40);
		button1.setFont(new Font("serif", Font.BOLD, 15));
		button1.addActionListener(this);
		l1.add(button1);

		button2 = new JButton("View");
		button2.setBounds(530, 80, 100, 40);
		button2.setFont(new Font("serif", Font.BOLD, 15));
		button2.addActionListener(this);
		l1.add(button2);

		button3 = new JButton("Remove");
		button3.setBounds(420, 140, 100, 40);
		button3.setFont(new Font("serif", Font.BOLD, 15));
		button3.addActionListener(this);
		l1.add(button3);

		button4 = new JButton("Update");
		button4.setBounds(530, 140, 100, 40);
		button4.setFont(new Font("serif", Font.BOLD, 15));
		button4.addActionListener(this);
		l1.add(button4);

		jf.setVisible(true);
		jf.setSize(700, 500);
		jf.setLocation(450, 200);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button1) {
			jf.setVisible(false);
			new AddEmployee();
		}
		if (ae.getSource() == button2) {
			jf.setVisible(false);
			new ViewEmployee();
		}
		if (ae.getSource() == button3) {
			jf.setVisible(false);
			new RemoveEmployee();
		}
		if (ae.getSource() == button4) {
			jf.setVisible(false);
			new SearchEmployee();
		}
	}

	public static void main(String[] arg) {
		new ManagementActions();
	}

}
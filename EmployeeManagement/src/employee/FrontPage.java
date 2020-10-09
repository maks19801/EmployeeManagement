package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPage implements ActionListener {

	JFrame jf;
	JLabel id, l1;
	JButton button;

	public FrontPage() {
		jf = new JFrame("Employee Management System");
		jf.setBackground(Color.PINK);
		jf.setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employee/icons/front.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1400, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);

		l1.setBounds(0, 100, 1400, 700);
		jf.add(l1);

		button = new JButton("CLICK HERE TO CONTINUE");
		button.setFont(new Font("calibri", Font.BOLD, 20));

		button.setBounds(850, 550, 300, 70);
		button.addActionListener(this);

		id = new JLabel();
		id.setBounds(0, 0, 1370, 750);
		id.setLayout(null);

		JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		lid.setBounds(75, 50, 1500, 100);
		lid.setFont(new Font("calibri", Font.PLAIN, 70));
		lid.setForeground(Color.DARK_GRAY);
		id.add(lid);

		id.add(button);
		jf.add(id);

		jf.getContentPane().setBackground(Color.WHITE);

		jf.setVisible(true);
		jf.setSize(1200, 700);
		jf.setLocation(200, 50);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			jf.setVisible(false);
			new Login();
		}

	}

	public static void main(String[] arg) {
		new FrontPage();
	}

}

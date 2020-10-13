package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrontPage implements ActionListener {

	JFrame jf;
	JLabel mainLabel, imageLabel;
	JButton continueButton;

	public FrontPage() {
		jf = new JFrame("Employee Management System");
		jf.setBackground(Color.PINK);
		jf.setLayout(null);

		imageLabel = new JLabel();
		imageLabel.setBounds(0, 100, 1400, 700);
		imageLabel.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employee/icons/front.jpg"));
		imageLabel.setIcon(img);

		jf.add(imageLabel);

		continueButton = new JButton("CLICK HERE TO CONTINUE");
		continueButton.setFont(new Font("calibri", Font.BOLD, 20));

		continueButton.setBounds(850, 550, 300, 70);
		continueButton.addActionListener(this);

		mainLabel = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		mainLabel.setBounds(75, 50, 1500, 100);
		mainLabel.setFont(new Font("calibri", Font.PLAIN, 70));
		mainLabel.setForeground(Color.DARK_GRAY);
		imageLabel.add(mainLabel);

		imageLabel.add(continueButton);
		jf.add(imageLabel);

		jf.getContentPane().setBackground(Color.WHITE);

		jf.setVisible(true);
		jf.setSize(1200, 700);
		jf.setLocation(200, 50);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == continueButton) {
			jf.setVisible(false);
			new Login();
		}

	}

	public static void main(String[] arg) {
		new FrontPage();
	}

}

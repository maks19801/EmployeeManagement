package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchEmployee implements ActionListener{
    JFrame jf;
    JTextField employeeId;
    JLabel employeeIdLabel,imageLabel;
    JButton searchButton, cancelButton;

    SearchEmployee(){
        jf=new JFrame("Search");
        jf.setBackground(Color.green);
        jf.setLayout(null);

        imageLabel=new JLabel();
        imageLabel.setBounds(0,0,500,270);
        imageLabel.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("employee/icons/view.jpg"));
        imageLabel.setIcon(img);


        employeeIdLabel=new JLabel("Employee Id");
        employeeIdLabel.setVisible(true);
        employeeIdLabel.setBounds(40,50,250,30);
        employeeIdLabel.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        employeeIdLabel.setFont(F1); 
        imageLabel.add(employeeIdLabel);
        jf.add(imageLabel);

        employeeId=new JTextField();
        employeeId.setBounds(240,50,220,30);
        imageLabel.add(employeeId);

        searchButton=new JButton("Search");
        searchButton.setBounds(240,150,100,30);
        searchButton.addActionListener(this);
        imageLabel.add(searchButton);


        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(360,150,100,30);
        cancelButton.addActionListener(this);
        imageLabel.add(cancelButton);

        jf.setSize(500,270);
        jf.setLocation(450,250);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancelButton){
            jf.setVisible(false);
            new ManagementActions();
        }
        if(ae.getSource()==searchButton){
            new UpdateEmployee(employeeId.getText());
            jf.setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new SearchEmployee();
    } 	
}
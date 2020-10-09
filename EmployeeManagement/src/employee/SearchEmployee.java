package employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchEmployee implements ActionListener{
    JFrame jf;
    JTextField text;
    JLabel label,label1;
    JButton button1,button2;

    SearchEmployee(){
        jf=new JFrame("Search");
        jf.setBackground(Color.green);
        jf.setLayout(null);

        label1=new JLabel();
        label1.setBounds(0,0,500,270);
        label1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("employee/icons/view.jpg"));
        label1.setIcon(img);


        label=new JLabel("Employee Id");
        label.setVisible(true);
        label.setBounds(40,50,250,30);
        label.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        label.setFont(F1); 
        label1.add(label);
        jf.add(label1);

        text=new JTextField();
        text.setBounds(240,50,220,30);
        label1.add(text);

        button1=new JButton("Search");
        button1.setBounds(240,150,100,30);
        button1.addActionListener(this);
        label1.add(button1);


        button2=new JButton("Cancel");
        button2.setBounds(360,150,100,30);
        button2.addActionListener(this);
        label1.add(button2);

        jf.setSize(500,270);
        jf.setLocation(450,250);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==button2){
            jf.setVisible(false);
            new ManagementActions();
        }
        if(ae.getSource()==button1){
            new UpdateEmployee(text.getText());
            jf.setVisible(false);
        }

    }
    
    public static void main(String[]ar){
        new SearchEmployee();
    } 	
}
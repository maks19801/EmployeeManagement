package employee;

import java.sql.*;


public class DataBaseConnection {
	public Connection conn;
    public Statement st;
 
    public DataBaseConnection(){
        try{
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/max","root","root");
            st = conn.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

package employee;

import java.sql.*;


public class DataBaseConnection {
	public Connection connection;
    public Statement statement;
 
    public DataBaseConnection(){
        try{
           
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/max","root","root");
            statement = connection.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}

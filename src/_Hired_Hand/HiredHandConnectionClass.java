package _Hired_Hand;

import java.sql.*;
public class HiredHandConnectionClass {
	static String user_name="root";
	static String password="anand";
	static String DB_URL="jdbc:mysql://localhost:3306/";
	static String DataBase_name="hiredhand";
	static String driver="com.mysql.jdbc.Driver";
	static Connection connection;
	//public  ResultSet resultSet;
	public static  Statement statement;
	public static Connection connectionCheck() throws Exception
	{
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(DB_URL+DataBase_name,user_name,password);
			statement=connection.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}

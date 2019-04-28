package _Hired_Hand;

import java.sql.*;

public class FastServiceDAO extends HiredHandConnectionClass{
		/*String user_name="root";
		String password="anand";
		String DB_URL="jdbc:mysql://localhost:3306/";
		String DataBase_name="hiredhand";
		String driver="com.mysql.jdbc.Driver";
		static Connection connection;
		public  Statement statement;*/
	public  ResultSet resultSet;
		public  String Query2;
		public  String Query1;
		public  String name,email, mobile,service,message,ContactUsName,ContactUsEmail,ContactUsMessage=null;
		public  FastServiceDAO(String name,String email,String mobile,String service,String message) 
		{
			this.name=name;
			this.mobile=mobile;
			this.email=email;
			this.service=service;
			this.message=message;
			this.Query2="insert into hiredhand.fastservicevisitors(NAME,EMAIL,MOBILE,SERVICE,MESSAGE) VALUES('"+name+"','"+email+"','"+mobile+"','"+service+"','"+message+"')";
			//Query2="insert into fastServiceVisitors (visitorName,visitorEmail,visitorMobile,visitorService,visitorMessage) VALUES('"+name+"','"+email+"','"+mobile+"','"+service+"','"+message+"')";
			this.Query1="select * from hiredhand.fastservicevisitors where EMAIL='"+email+"'";
		}
		public boolean connectionProcess() throws Exception 
		{
			try {
			HiredHandConnectionClass.connectionCheck();
			//Class.forName(driver);
			// connection=DriverManager.getConnection(DB_URL+DataBase_name,user_name,password);
			//=connection.createStatement();
			resultSet=statement.executeQuery(Query1);
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(resultSet.next())
			{
				statement.executeUpdate(Query2);
			//	System.out.println("Data was already same email ID");
				HiredHandConnectionClass.connection.close();
				HiredHandConnectionClass.statement.close();
				resultSet.close();
				return true;
				
			
			}
			else
			{
				statement.executeUpdate(Query2);
				//System.out.println("New Data inserted");
				HiredHandConnectionClass.connection.close();
				HiredHandConnectionClass.statement.close();
				resultSet.close();
				return false;
				
			}
			
			
		}
		}


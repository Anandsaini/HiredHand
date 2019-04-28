package _Hired_Hand;
import java.sql.*;

public class ContactUsDao extends HiredHandConnectionClass {
	/*String userName;
	String password;
	String driver;
	String url;
	String DB_name;
	Connection connection;
	Statement statement;*/
	public String CONTACT_US_NAME,CONTACT_US_EMAIL,CONTACT_US_MESSAGE;
	String Query1;
	String Query2;	
	ResultSet result_set;
	public ContactUsDao(String CONTACT_US_NAME,String CONTACT_US_EMAIL,String CONTACT_US_MESSAGE)
	{
		/*driver="com.mysql.jdbc.Driver";
		DB_name="HiredHand";
		url="jdbc:mysql://localhost:3306/";
		userName="root";
		password="anand";*/
		this.CONTACT_US_NAME=CONTACT_US_NAME;
		this.CONTACT_US_EMAIL=CONTACT_US_EMAIL;
		this.CONTACT_US_MESSAGE=CONTACT_US_MESSAGE;
		Query1="select * from HiredHand.contactusvisitor where Email='"+CONTACT_US_EMAIL+"'";
		Query2="insert into HiredHand.contactusvisitor(Name,Email,Message) values('"+CONTACT_US_NAME+"','"+CONTACT_US_EMAIL+"','"+CONTACT_US_MESSAGE+"')";
	}
	public boolean connection_Check() throws Exception
	{
		try {
			HiredHandConnectionClass.connectionCheck();
			 result_set=statement.executeQuery(Query1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result_set.next())
		{
			statement.executeUpdate(Query2);
			//System.out.println("Data was already there");
			HiredHandConnectionClass.connection.close();
			HiredHandConnectionClass.statement.close();
			result_set.close();
			return true;
		}
		else
		{
			statement.executeUpdate(Query2);
			//.out.println("New Daa inserted");
			HiredHandConnectionClass.connection.close();
			HiredHandConnectionClass.statement.close();
			result_set.close();
			return false;
		}
	}

}

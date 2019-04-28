package _Hired_Hand;

import java.sql.*;

public class GetVisitorsDetails extends HiredHandConnectionClass{
	public GetVisitorsDetails()
	{
		String Query1="select * from hiredhand.fastservicevisitors";
		try {
			HiredHandConnectionClass.connectionCheck();
			ResultSet rs=statement.executeQuery(Query1);
			if(rs.next()) {
			while(rs.next())
			{
				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
			}}
			else
			{
				System.out.println("No record found!!!!!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	public static void main(String args[])
	{
		new GetVisitorsDetails();
	
	}

}

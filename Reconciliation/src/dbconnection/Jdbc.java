//database connectivity class
package dbconnection;

import java.sql.*;
public class Jdbc {
	
	//function to return connection object
	 public static void main(String args[]) {
		 public Connection getConnection{ 
		 Connection con=null;
		 
		 //registering the driver
		 
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		
			//creating a connection to the database
			
			con=DriverManager.getConnection("jdbc:mysql://localhost//:3306","root","root");
			 PreparedStatement stmt= con.prepareStatement("select * from bank_book_register");
			 ResultSet rs=stmt.executeQuery();
				while(rs.next())
					System.out.println(rs.getString(1));
				 
				
				//closing the connection
			
				con.close();
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		 }
		
	//	return con;
	
		/* //creating statment
		PreparedStatement stmt= con.prepareStatement("select * from BANK where ID=?");
		String str="A12DF";
		stmt.setString(1,str);
		//executing the query
		//ResultSet rs=stmt.executeQuery("select * from BANK where ID='"+str+"'");
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getInt(2)+ " "+rs.getString(3));
		 
		
		//closing the connection
		 con.close();
		 */
		
	}
}

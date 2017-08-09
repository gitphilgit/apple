import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect{		
	
	public static String strUser;
	public static String strPassword;	
	
	public static void connect(){
		try {			 
			//Connecting to ODBC Data Source
			String url = "jdbc:ucanaccess://c:/Users/phil/Documents/Security.mdb";			
			Connection con = DriverManager.getConnection(url);
 
			//Using the Connection Object now Create a Statement
			Statement s = con.createStatement();
 
			//Save The Data Into the Database Table
			String SQL = "SELECT * FROM Authentication";
			s.execute(SQL);
			ResultSet rs = s.getResultSet();
			while((rs!=null) && (rs.next()))
			{
				System.out.println(rs.getString(1) + " : " + rs.getString(2)+ " : " + rs.getString(3));
				strUser = rs.getString(2);
				strPassword = rs.getString(3);				
			}
 
			//Close the Statement & connection
			s.close();
			con.close(); 
		} 
 
		catch (Exception e) {
			System.out.println("Error Connecting : "+e.getMessage());
			e.printStackTrace();
		}
	}
}
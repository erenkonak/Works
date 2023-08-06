package Helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect {
	Connection c=null;
	
	public Dbconnect() {
		
	}
	
	public Connection dbcon() {
	try {
		this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bilgin?user=root&password=eren");
		return c;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
		return c;
	}
	

}
}
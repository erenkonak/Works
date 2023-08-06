package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect {
	
	Connection c=null;
	public  Dbconnect() {}
	
	public Connection dbcon() {
	try {
		this.c = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-6SHG7ON;Database=price;user=sa;password=1234;encrypt=true;trustServerCertificate=true;");
		return c;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace(); 
		return c;
	}
	

}

}

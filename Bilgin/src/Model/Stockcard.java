package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.Dbconnect;

public class Stockcard {
	
	 Dbconnect con=new Dbconnect();
	    Connection c=con.dbcon();
	    Statement st=null;
	    ResultSet rs=null;
	    PreparedStatement preparedstatement=null;
	    
	    
	    public Stockcard(String product_code, String product_name, String unit) {
			super();
			this.product_code = product_code;
			this.product_name = product_name;
			this.unit = unit;
		}
	    public Stockcard() {
	    	
	    }

		private String product_code,product_name,unit;
		
		public ArrayList<Stockcard> getstokkard1() throws SQLException{
	    	ArrayList<Stockcard> list=new ArrayList<>();
	    	Stockcard obj;
	    	try {
				st=c.createStatement();
				rs=st.executeQuery("select * from stokkart");
				while(rs.next()) {
				obj=new	Stockcard(rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"));
				list.add(obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	return list;
	    	
	    	
	    }
		
		public ArrayList<Stockcard> getfindstokkard(String str) throws SQLException{
	    	ArrayList<Stockcard> list=new ArrayList<>();
	    	Stockcard obj;
	    	try {
				st=c.createStatement();
				rs=st.executeQuery("select * from stokkart where product_code like '%"+str+"%'");
				while(rs.next()) {
				obj=new	Stockcard(rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"));
				list.add(obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	return list;
	    	
	    	
	    }
		
		public ArrayList<Stockcard> getfindstokkardname(String str) throws SQLException{
	    	ArrayList<Stockcard> list=new ArrayList<>();
	    	Stockcard obj;
	    	try {
				st=c.createStatement();
				rs=st.executeQuery("select * from stokkart where product_name like '%"+str+"%'");
				while(rs.next()) {
				obj=new	Stockcard(rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"));
				list.add(obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	return list;
	    	
	    	
	    }
		
		
		public boolean addstockkart(String product_code,String product_name,String Unit) {
			boolean key=false;
			try {
				st=c.createStatement();
				
				String query="INSERT INTO stokkart (product_code,product_name,Unit) VALUES"+"(?,?,?)";
				preparedstatement=c.prepareStatement(query);
				preparedstatement.setString(1, product_code);
				preparedstatement.setString(2, product_name);
				preparedstatement.setString(3, Unit);
				preparedstatement.executeUpdate();
				key=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(key) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean deletestokkart(String product_code) {
			boolean key=false;
			try {
				st=c.createStatement();
				
				String query="DELETE FROM stokkart Where product_code=?";
				preparedstatement=c.prepareStatement(query);
				preparedstatement.setString(1, product_code);
				preparedstatement.executeUpdate();
				key=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(key) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean updatestokkart(String product_code,String product_name,String Unit,String selprocod) {
			boolean key=false;
			try {
				st=c.createStatement();
				
				String query="Update stokkart set product_code=?,product_name=?,Unit=? where product_code=?" ;
				preparedstatement=c.prepareStatement(query);
				preparedstatement.setString(1, product_code);
				preparedstatement.setString(2, product_name);
				preparedstatement.setString(3, Unit);
				preparedstatement.setString(4, selprocod);
				preparedstatement.executeUpdate();
				key=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(key) {
				return true;
			}else {
				return false;
			}
		}

		public String getProduct_code() {
			return product_code;
		}

		public void setProduct_code(String product_code) {
			this.product_code = product_code;
		}

		public String getProduct_name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}
	    

}

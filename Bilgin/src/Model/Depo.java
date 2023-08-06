package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import Helper.Dbconnect;

public class Depo {
	Dbconnect con=new Dbconnect();
    Connection c=con.dbcon();
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement preparedstatement=null;
private int value;
private String instance_id,product_code,product_name,unit,buyer,Proje,Raf,status,EO;

public Depo() {
	
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getEO() {
	return EO;
}

public void setEO(String eO) {
	EO = eO;
}

public String getProje() {
	return Proje;
}

public void setProje(String proje) {
	Proje = proje;
}

public String getRaf() {
	return Raf;
}

public void setRaf(String raf) {
	Raf = raf;
}


public Depo(int value, String instance_id, String product_code, String product_name, String unit, String buyer,
		String proje, String raf) {
	super();
	this.value = value;
	this.instance_id = instance_id;
	this.product_code = product_code;
	this.product_name = product_name;
	this.unit = unit;
	this.buyer = buyer;
	this.Proje = proje;
	this.Raf = raf;
}
public Depo(int value, String instance_id, String product_code, String product_name, String unit, String buyer,
		String proje, String raf,String status,String EO) {
	super();
	this.value = value;
	this.instance_id = instance_id;
	this.product_code = product_code;
	this.product_name = product_name;
	this.unit = unit;
	this.buyer = buyer;
	this.Proje = proje;
	this.Raf = raf;
	this.status = status;
	this.EO = EO;
}

public ArrayList<Depo> getdepo() throws SQLException{
	ArrayList<Depo> list=new ArrayList<>();
	Depo obj;
	try {
		st=c.createStatement();
		rs=st.executeQuery("select * from depog");
		while(rs.next()) {
		obj=new Depo(rs.getInt("value"),rs.getString("instance_id"),rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"),rs.getString("buyer"),rs.getString("Proje"),rs.getString("Raf"));
		list.add(obj);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public String getInstance_id() {
	return instance_id;
}
public void setInstance_id(String instance_id) {
	this.instance_id = instance_id;
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
public String getBuyer() {
	return buyer;
}
public void setBuyer(String buyer) {
	this.buyer = buyer;
}

public boolean adddepo(String product_code,String product_name,String Unit,int value,String buyer,String Proje,String Raf) {
	boolean key=false;
	String ins=null;
	clock(ins);
	System.out.println(instance_id);
	try {
		st=c.createStatement();
		
		String query="INSERT INTO depog (instance_id,product_code,product_name,Unit,value,buyer,Proje,Raf) VALUES ('"+instance_id+"',?,?,?,?,?,?,?)";
		preparedstatement=c.prepareStatement(query);
		preparedstatement.setString(1, product_code);
		preparedstatement.setString(2, product_name);
		preparedstatement.setString(3, Unit);
		preparedstatement.setInt(4, value);
		preparedstatement.setString(5, buyer);
		preparedstatement.setString(6, Proje);
		preparedstatement.setString(7, Raf);
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

public boolean updatedepo(String product_code) {
	boolean key=false;
	String ins=null;
	clock(ins);
	try {
		st=c.createStatement();
		
		String query="update depog set status='P' WHERE product_code=? and status='A'";
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

public boolean dropdepo(String product_code,String product_name,String Unit,int value,String buyer,String Proje,String Raf) {
	boolean key=false;
	String ins=null;
	clock(ins);
	System.out.println(instance_id);
	try {
		st=c.createStatement();
		
		String query="INSERT INTO depog (instance_id,product_code,product_name,Unit,value,buyer,Proje,Raf,EO) VALUES ('"+instance_id+"',?,?,?,?,?,?,?,'O')";
		preparedstatement=c.prepareStatement(query);
		preparedstatement.setString(1, product_code);
		preparedstatement.setString(2, product_name);
		preparedstatement.setString(3, Unit);
		preparedstatement.setInt(4, value);
		preparedstatement.setString(5, buyer);
		preparedstatement.setString(6, Proje);
		preparedstatement.setString(7, Raf);
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

public void clock(String ins) {
	Calendar cl=new GregorianCalendar();
	int day=cl.get(Calendar.DAY_OF_MONTH);
	int month=cl.get(Calendar.MONTH);
	int year=cl.get(Calendar.YEAR);
	
	int sec=cl.get(Calendar.SECOND);
	int min=cl.get(Calendar.MINUTE);
	int hour=cl.get(Calendar.HOUR);
	String instance=year+"/"+month+"/"+day+"\t"+hour+":"+min+":"+sec;
	System.out.println(instance);
	ins=year+"/"+month+"/"+day+"--"+hour+":"+min+":"+sec;
	this.instance_id=ins;
	
}

public ArrayList<Depo> deneme1() throws SQLException{
	ArrayList<Depo> list=new ArrayList<>();
	Depo obj;
	try {
		st=c.createStatement();
		rs=st.executeQuery("select * from depog");
		while(rs.next()) {
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}
public ArrayList<Depo> getdepo2() throws SQLException{
	ArrayList<Depo> list=new ArrayList<>();
	Depo obj;
	try {
		st=c.createStatement();
		rs=st.executeQuery("select * from depog WHERE status='A'");
		while(rs.next()) {
		obj=new Depo(rs.getInt("value"),rs.getString("instance_id"),rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"),rs.getString("buyer"),rs.getString("Proje"),rs.getString("Raf"));
		list.add(obj);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}

public ArrayList<Depo> getdepo3(String name) throws SQLException{
	ArrayList<Depo> list=new ArrayList<>();
	Depo obj;
	try {
		st=c.createStatement();
		rs=st.executeQuery("select * from depog WHERE status='A' and product_name like '%"+name+"%'");
		while(rs.next()) {
		obj=new Depo(rs.getInt("value"),rs.getString("instance_id"),rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"),rs.getString("buyer"),rs.getString("Proje"),rs.getString("Raf"));
		list.add(obj);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}
public ArrayList<Depo> getdepo4(String name) throws SQLException{
	ArrayList<Depo> list=new ArrayList<>();
	Depo obj;
	try {
		st=c.createStatement();
		rs=st.executeQuery("select * from depog WHERE product_name like '%"+name+"%'");
		while(rs.next()) {
		obj=new Depo(rs.getInt("value"),rs.getString("instance_id"),rs.getString("product_code"),rs.getString("product_name"),rs.getString("Unit"),rs.getString("buyer"),rs.getString("Proje"),rs.getString("Raf"),rs.getString("status"),rs.getString("EO"));
		list.add(obj);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
	
}
}

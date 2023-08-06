package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.Dbconnect;

public class activity_detail extends activity {
	Dbconnect con=new Dbconnect();
    Connection c=con.dbcon();
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement preparedstatement=null;
	private int AD_ID,D_ID,needs,reserve,transfer,demand,ceki,consume;
	private String product_code,product_name,unit,category_2,Storage;
	
	public activity_detail() {
		
	}
	public activity_detail(int aD_ID, int d_ID, int needs, int reserve, int transfer, int demand, int ceki, int consume,
			String product_code, String product_name, String unit, String category_2, String storage) {
		super();
		this.AD_ID = aD_ID;
		this.D_ID = d_ID;
		this.needs = needs;
		this.reserve = reserve;
		this.transfer = transfer;
		this.demand = demand;
		this.ceki = ceki;
		this.consume = consume;
		this.product_code = product_code;
		this.product_name = product_name;
		this.unit = unit;
		this.category_2 = category_2;
		this.Storage = storage;
	}
	
	public ArrayList<activity_detail> getactivity_Detail(){
    	ArrayList<activity_detail> list=new ArrayList<>();
    	activity_detail obj;
    	try {
			st=c.createStatement();
			rs=st.executeQuery("select * from act_dtl");
			while(rs.next()) {
			obj=new	activity_detail(rs.getInt("AD_ID"),rs.getInt("D_ID"),rs.getInt("needs"),rs.getInt("reserve"),rs.getInt("transfer"),rs.getInt("demand"),rs.getInt("ceki"),rs.getInt("consume"),rs.getString("product_code"),rs.getString("product_name"),rs.getString("unit"),rs.getString("category_2"),rs.getString("storage"));
			list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    	
    }
	
	public int getAD_ID() {
		return AD_ID;
	}
	public void setAD_ID(int aD_ID) {
		AD_ID = aD_ID;
	}
	public int getD_ID() {
		return D_ID;
	}
	public void setD_ID(int d_ID) {
		D_ID = d_ID;
	}
	public int getNeeds() {
		return needs;
	}
	public void setNeeds(int needs) {
		this.needs = needs;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public int getTransfer() {
		return transfer;
	}
	public void setTransfer(int transfer) {
		this.transfer = transfer;
	}
	public int getDemand() {
		return demand;
	}
	public void setDemand(int demand) {
		this.demand = demand;
	}
	public int getCeki() {
		return ceki;
	}
	public void setCeki(int ceki) {
		this.ceki = ceki;
	}
	public int getConsume() {
		return consume;
	}
	public void setConsume(int consume) {
		this.consume = consume;
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
	public String getCategory_2() {
		return category_2;
	}
	public void setCategory_2(String category_2) {
		this.category_2 = category_2;
	}
	public String getStorage() {
		return Storage;
	}
	public void setStorage(String storage) {
		Storage = storage;
	}
	

}

package Code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import GUI.Demand;
import GUI.KullanýcýGiris;
import Helper.helper;

public class Pri_dem {
	
	Connection connection;
	Helper.helper helper=new Helper.helper();
	public Timestamp create_time;
	public Pri_dem() {
		
	};
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getCustomer_code() {
		return Customer_code;
	}
	public void setCustomer_code(int customer_code) {
		Customer_code = customer_code;
	}
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public int getItem_code() {
		return Item_code;
	}
	public void setItem_code(int item_code) {
		Item_code = item_code;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public Date getDeadline() {
		return Deadline;
	}
	public void setDeadline(Date deadline) {
		Deadline = deadline;
	}
	public int getLead_Time() {
		return Lead_Time;
	}
	public void setLead_Time(int lead_Time) {
		Lead_Time = lead_Time;
	}
	public double getProfit_Margin() {
		return Profit_Margin;
	}
	public void setProfit_Margin(double profit_Margin) {
		Profit_Margin = profit_Margin;
	}
	public double getTrans_Cost() {
		return Trans_Cost;
	}
	public void setTrans_Cost(double trans_Cost) {
		Trans_Cost = trans_Cost;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	public int getCreate_Userid() {
		return Create_Userid;
	}
	public void setCreate_Userid(int create_Userid) {
		Create_Userid = create_Userid;
	}
	public int getUpdate_Userid() {
		return Update_Userid;
	}
	public void setUpdate_Userid(int update_Userid) {
		Update_Userid = update_Userid;
	}
	public int getResponsible_Userid() {
		return Responsible_Userid;
	}
	public void setResponsible_Userid(int responsible_Userid) {
		Responsible_Userid = responsible_Userid;
	}
	public Timestamp update_time;
	public int item_id;
	public int Customer_code;
	public String Customer_Name;
	public int Item_code;
	public String Item_name;
	public Date Deadline;
	public int  Lead_Time ;
	public double  Profit_Margin ;
	public double  Trans_Cost ;
	public double  Cost ;
	public int Create_Userid;
	public int Update_Userid;
	public int Responsible_Userid;
	public String Status;
	public String Brand;
	public int Min_Order_Quantity;
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public int getMin_Order_Quantity() {
		return Min_Order_Quantity;
	}
	public void setMin_Order_Quantity(int min_Order_Quantity) {
		Min_Order_Quantity = min_Order_Quantity;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public String Project_name;  
	public String department;  
	public String Ýtem_description ; 
	public int Order_Size; 
	public int Size;
	public String Logistic; 
	public int Annual_unit;
	public String getProject_name() {
		return Project_name;
	}
	public void setProject_name(String project_name) {
		Project_name = project_name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getÝtem_description() {
		return Ýtem_description;
	}
	public void setÝtem_description(String item_description) {
		Ýtem_description = item_description;
	}
	public int getOrder_Size() {
		return Order_Size;
	}
	public void setOrder_Size(int order_Size) {
		Order_Size = order_Size;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public String getLogistic() {
		return Logistic;
	}
	public void setLogistic(String logistic) {
		Logistic = logistic;
	}
	public int getAnnual_unit() {
		return Annual_unit;
	}
	public void setAnnual_unit(int annual_unit) {
		Annual_unit = annual_unit;
	}
	public Date getQuote_date() {
		return Quote_date;
	}
	public void setQuote_date(Date quote_date) {
		Quote_date = quote_date;
	}
	public double getQuote_dollar() {
		return Quote_dollar;
	}
	public void setQuote_dollar(double quote_dollar) {
		Quote_dollar = quote_dollar;
	}
	public String getNBA() {
		return NBA;
	}
	public void setNBA(String nBA) {
		NBA = nBA;
	}
	public Date Quote_date; 
	public double Quote_dollar; 
	public String NBA ;
	public double Price;
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public Pri_dem(Timestamp create_time, Timestamp update_time, int item_id, int customer_code, String customer_Name,
			int item_code, String item_name, Date deadline, int lead_Time, double profit_Margin, double trans_Cost,
			double cost, int create_Userid, int update_Userid, int responsible_Userid,int Min_order,String Brand, String status, String Project_name, String department, String Ýtem_description,int Order_Size,int Size,String Logistic, int Annual_unit
,Date Quote_date,double Quote_dollar,String NBA,Double price) {
		super();
		this.create_time = create_time;
		this.update_time = update_time;
		this.item_id = item_id;
		Customer_code = customer_code;
		Customer_Name = customer_Name;
		Item_code = item_code;
		Item_name = item_name;
		Deadline = deadline;
		Lead_Time = lead_Time;
		Profit_Margin = profit_Margin;
		Trans_Cost = trans_Cost;
		Cost = cost;
		Create_Userid = create_Userid;
		Update_Userid = update_Userid;
		Responsible_Userid = responsible_Userid;
		Min_Order_Quantity=Min_order;
		this.Brand=Brand;
		Status = status;
		this.Project_name=Project_name;
		this.department=department;
		this.Ýtem_description=Ýtem_description;
		this.Order_Size=Order_Size;
		this.Size=Size;
		this.Logistic=Logistic;
		this.Annual_unit=Annual_unit;
		this.Quote_date=Quote_date;
		this.Quote_dollar=Quote_dollar;
		this.NBA=NBA;
		this.Price=price;

	}
	public boolean insert(String Project_name,  String customer_Name,String department, int item_code, String item_name,
			 Date Deadline,String Brand,String Item_description,int Size,int Annual_unit,Date Quote_date,double Quote_dollar,String NBA,int Order_size,int Lead_time
) {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		try {
			String SQL= "insert into item_code (Create_Userid,Status,Customer_Name,Project_name,department,Item_name,Item_code,Brand,Item_description,Size,Annual_unit,Deadline,Quote_date,Quote_dollar,NBA,Order_Size,Lead_Time)"
					+ " values  ("+GUI.KullanýcýGiris.id+",'W',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			//String SQL= "insert into item_code (`Create_Userid`,`Status`,`Customer_Name`,`Project_name`,`department`,`Item_name`,`Item_code`,`Brand`,`Ýtem_description`,`Size`,`Annual_unit`) values  ("+GUI.KullanýcýGiris.id+",'W', ? , ? , ? , ? , ? , ? , ? , ? , ? , ?);";

			Statement smt =connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(SQL);
			preparedStatement.setString(2, Project_name);
			preparedStatement.setString(1, customer_Name);
			preparedStatement.setString(3, department);
			preparedStatement.setString(4, item_name);
			preparedStatement.setInt(5, item_code);
			preparedStatement.setDate(10, Deadline);
			preparedStatement.setString(6, Brand);
			preparedStatement.setString(7, Item_description);
			preparedStatement.setInt(8, Size);
			preparedStatement.setInt(9, Annual_unit);
			preparedStatement.setDate(11, Quote_date);
			preparedStatement.setDouble(12, Quote_dollar);
			preparedStatement.setString(13, NBA);
			preparedStatement.setInt(14, Order_size);
			preparedStatement.setInt(15, Lead_time);
			System.out.println(preparedStatement.toString());
            int set=preparedStatement.executeUpdate();
            System.out.println(set);
            smt.close();
           
            
            
            	
		           
            	if (set>0) {
   
            		helper.showmsg("insert succces");
            		return true;
            		
					
				}else {
					helper.showmsg("wrong");
					return false;
				}
	}catch (Exception e) {
		e.getMessage();
		System.out.println(e.getMessage());
		System.out.println("Baþarýsýz");
		return false;
	}
	}
	public boolean insert1() {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		System.out.println("deneme");


		
		try {
			String SQL= "insert into item_code (Create_Userid,Status) values  ("+GUI.KullanýcýGiris.id+",'W');";
			Statement smt =connection.createStatement();
			System.out.println(SQL);
            int set=smt.executeUpdate(SQL);
            System.out.println(set);
            smt.close();
            
            
            	
		           
            	if (set>0) {
            		return true;
			
				}else {
					helper.showmsg("wrong");
					return false;
				}
	}catch (Exception e) {
		e.getMessage();
		return false;
	}}
		
		public boolean insert2(int customer_id) throws IOException {
			Dbconnect c=new Dbconnect();
			connection=c.dbcon();
			System.out.println("deneme");


			
			try {
				String SQL= "insert into item_code (`Create_Userid`,`Status`,`customer_code`) values  ("+GUI.KullanýcýGiris.id+",'W',"+customer_id+");";
				Statement smt =connection.createStatement();
				System.out.println(SQL);
	            int set=smt.executeUpdate(SQL);
	            System.out.println(set);
	            smt.close();
	            
	            
	            	
			           
	            	if (set>0) {
	   
	            		helper.showmsg("insert succces");
	            		return true;
	            		
						
					}else {
						helper.showmsg("wrong");
						return false;
					}
		}catch (SQLException e) {
			((Throwable) e).getMessage();
			return false;
		}
		
		
	
	

}
	public ArrayList<Pri_dem> getlist() throws SQLException{
		ArrayList<Pri_dem> list=new ArrayList<>();
		
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		Pri_dem pri = null;
		


		
		try {
			String SQL="SELECT create_time,  isnull(update_time,cast(GETDATE() as time)), isnull(item_id,0), isnull(Customer_code,0), isnull(Customer_Name,''), isnull(Item_code,0), isnull(Item_name,''), isnull(Deadline,'0001-01-01'), isnull(Lead_Time,0),  isnull(Profit_Margin,0),isnull(Trans_Cost,0), isnull(Cost,0), Create_Userid, Update_Userid, Responsible_Userid, Min_Order_Quantity, isnull(Brand,''), Status, isnull(Project_name,''), isnull(department,''), isnull(Item_description,''), Order_Size, Size, isnull(Logistic,''), Annual_unit, isnull(Quote_date,'0001-01-01'), Quote_dollar, isnull(NBA,''),Price FROM price..item_code where Status not in ('C')";
			Statement smt =connection.createStatement();
			
            ResultSet set=smt.executeQuery(SQL);
         
            
            while(set.next()) {
            	pri=new Pri_dem(set.getTimestamp(1),set.getTimestamp(2),set.getInt(3),set.getInt(4),set.getString(5),set.getInt(6),set.getString(7),set.getDate(8),set.getInt(9),set.getDouble(10),set.getDouble(11),set.getDouble(12)
            			,set.getInt(13),set.getInt(14),set.getInt(15),set.getInt(16),set.getString(17),set.getString(18),set.getString(19),set.getString(20),set.getString(21),set.getInt(22),set.getInt(23),set.getString(24),set.getInt(25)
            			,set.getDate(26),set.getDouble(27),set.getString(28),set.getDouble(29));
            	 list.add(pri);
            }
            
            smt.close();
            
            	
		
	}catch (Exception e) {
		e.getMessage();
	}
		return list;
	
}
	public boolean updateDemand1 (String Project_name,  String customer_Name,String department, int item_code, String item_name,
			Date deadline,String Brand,int item_id,String Item_description,int Size,int Annual_unit,Date Quote_date,double Quote_dollar,String NBA,int Order_size,int Lead_time) {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		


		
		try {
			String SQL= "update item_code set  Project_name=?,customer_name=?,department=?,Item_code=?,Item_name=?,deadline=?,brand=?,update_userid=?,update_time=getDate(),Item_description=?,Size=?"
					+ ",Annual_unit=?,Quote_date=?,Quote_dollar=?,NBA=?,Order_size=?,Lead_time=?  where item_id=?";
			
			Statement smt =connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, Project_name);
			preparedStatement.setString(2, customer_Name);
			preparedStatement.setString(3, department);
			preparedStatement.setString(5, item_name);
			preparedStatement.setInt(4, item_code);
			preparedStatement.setDate(6, deadline);
			preparedStatement.setString(7, Brand);
			preparedStatement.setInt(8, KullanýcýGiris.id);
			preparedStatement.setString(9, Item_description);
			preparedStatement.setInt(10, Size);
			preparedStatement.setInt(11, Annual_unit);
			preparedStatement.setDate(12, Quote_date);
			preparedStatement.setDouble(13, Quote_dollar);
			preparedStatement.setString(14, NBA);
			preparedStatement.setInt(15, Order_size);
			preparedStatement.setInt(16, Lead_time);
			
			
			preparedStatement.setInt(17, item_id);
			System.out.println(preparedStatement.toString());
							
			
            int set=preparedStatement.executeUpdate();
            System.out.println(set);
            
            
            smt.close();
		           
            	if (set>0) {
            		return true;
            		
					
				}else {
					helper.showmsg("wrong");
					return false;
				}
	}catch (Exception e) {
		e.getMessage();
		System.out.println(e.getMessage());
		
		return false;
		
		}
	}
	
	public boolean updateonay(int id) throws IOException {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		System.out.println("deneme");


		
		try {
			String SQL= "update  item_code set Status='P'  where item_id=?"; 
			Statement smt =connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
            int set=preparedStatement.executeUpdate();
            System.out.println(set);
            
            
            smt.close();
		           
            	if (set>0) {
   
            		helper.showmsg("Approval succces");
            		return true;
            		
					
				}else {
					helper.showmsg("wrong");
					return false;
				}
	}catch (SQLException e) {
		((Throwable) e).getMessage();
		return false;
	}
	
	



}
	public boolean updatereject(int id) throws IOException {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		System.out.println("deneme");


		
		try {
			String SQL= "update  item_code set Status='W'  where item_id=?"; 
			Statement smt =connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(SQL);
			preparedStatement.setInt(1, id);
            int set=preparedStatement.executeUpdate();
            
            
            
            smt.close();  	
		           
            	if (set>0) {
   
            		helper.showmsg("Rejection succces");
            		return true;
            		
					
				}else {
					helper.showmsg("Error");
					return false;
				}
	}catch (SQLException e) {
		((Throwable) e).getMessage();
		return false;
	}
	
	



}
	public boolean updatePrice(int id,double Price,double Cost,double Transportation_Cost) throws IOException {
		Dbconnect c=new Dbconnect();
		connection=c.dbcon();
		System.out.println("deneme");
		double margin=((Price/(Cost+Transportation_Cost))-1)*100;


		
		try {
			String SQL= "update  item_code set Status='O',Price=?,Cost=?,Trans_Cost=?,Profit_Margin=?  where item_id=?"; 
			Statement smt =connection.createStatement();
			PreparedStatement preparedStatement=connection.prepareStatement(SQL);
			preparedStatement.setDouble(1, Price);
			preparedStatement.setDouble(2, Cost);
			preparedStatement.setDouble(3, Transportation_Cost);
			preparedStatement.setDouble(4, margin);
			preparedStatement.setInt(5, id);
            int set=preparedStatement.executeUpdate();
            
            
            
            smt.close();  	
		           
            	if (set>0) {
   
            		helper.showmsg("Price send to Approve");
            		return true;
            		
					
				}else {
					helper.showmsg("Error");
					return false;
				}
	}catch (SQLException e) {
		((Throwable) e).getMessage();
		return false;
	}
	
	



}
	}

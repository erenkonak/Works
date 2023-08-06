package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.Dbconnect;

public class proj {
	private int P_ID;
    private String proje,taným,detay,enddate,kategori,durum,grup,type;
    Dbconnect con=new Dbconnect();
    Connection c=con.dbcon();
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement preparedstatement=null;
	public proj(int p_ID, String proje, String taným, String detay, String enddate, String kategori, String durum,
			String grup, String type) {
		super();
		P_ID = p_ID;
		this.proje = proje;
		this.taným = taným;
		this.detay = detay;
		this.enddate = enddate;
		this.kategori = kategori;
		this.durum = durum;
		this.grup = grup;
		this.type = type;
	}
    public proj() {
    	
    }
    public ArrayList<proj> getProje1(){
    	ArrayList<proj> list=new ArrayList<>();
    	proj obj;
    	try {
			st=c.createStatement();
			rs=st.executeQuery("select * from proje");
			while(rs.next()) {
			obj=new	proj(rs.getInt("P_ID"),rs.getString("Proje"),rs.getString("Taným"),rs.getString("Detay"),rs.getString("enddate"),rs.getString("Kategori"),rs.getString("Durum"),rs.getString("Grup"),rs.getString("Type"));
			list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    	
    }
    
    public proj getFetch(int id) {
    	 Connection c=con.dbcon();
    	 proj p=new proj();
    	 try {
			st=c.createStatement();
			rs=st.executeQuery("SELECT * FROM proje where P_ID="+id);
			while(rs.next()) {
				p.setP_ID(rs.getInt("P_ID"));
				p.setProje(rs.getString("Proje"));
				p.setTaným(rs.getString("Taným"));
				p.setDetay(rs.getString("Detay"));
				p.setEnddate(rs.getString("enddate"));
				p.setKategori(rs.getString("Kategori"));
				p.setDurum(rs.getString("Durum"));
				p.setGrup(rs.getString("Grup"));
				p.setType(rs.getString("Type"));
				
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return p;
    	 
    }
	public int getP_ID() {
		return P_ID;
	}
	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}
	public String getProje() {
		return proje;
	}
	public void setProje(String proje) {
		this.proje = proje;
	}
	public String getTaným() {
		return taným;
	}
	public void setTaným(String taným) {
		this.taným = taným;
	}
	public String getDetay() {
		return detay;
	}
	public void setDetay(String detay) {
		this.detay = detay;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public String getGrup() {
		return grup;
	}
	public void setGrup(String grup) {
		this.grup = grup;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
	public boolean addProje(String Proje,String Taným,String Detay,String enddate,String Kategori,String Durum,String Grup,String Type) {
		boolean key=false;
		try {
			st=c.createStatement();
			
			String query="INSERT INTO proje (Proje,Taným,Detay,enddate,Kategori,Durum,Grup,Type) VALUES"+"(?,?,?,?,?,?,?,?)";
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setString(1, Proje);
			preparedstatement.setString(2, Taným);
			preparedstatement.setString(3, Detay);
			preparedstatement.setString(4, enddate);
			preparedstatement.setString(5, Kategori);
			preparedstatement.setString(6, Durum);
			preparedstatement.setString(7, Grup);
			preparedstatement.setString(8, Type);
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
	public boolean deleteProje(int p_id) {
		boolean key=false;
		try {
			st=c.createStatement();
			
			String query="DELETE FROM proje Where P_ID=?";
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setInt(1, p_id);
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
	
	public boolean updateProje(String Proje,String Taným,String Detay,String enddate,String Kategori,String Durum,String Grup,String Type,int id) {
		boolean key=false;
		try {
			st=c.createStatement();
			
			String query="Update proje set Proje=?,Taným=?,Detay=?,enddate=?,Kategori=?,Durum=?,Grup=?,Type=? where P_ID=?" ;
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setString(1, Proje);
			preparedstatement.setString(2, Taným);
			preparedstatement.setString(3, Detay);
			preparedstatement.setString(4, enddate);
			preparedstatement.setString(5, Kategori);
			preparedstatement.setString(6, Durum);
			preparedstatement.setString(7, Grup);
			preparedstatement.setString(8, Type);
			preparedstatement.setInt(9, id);
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
	}}

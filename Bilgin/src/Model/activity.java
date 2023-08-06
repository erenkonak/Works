package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GUI.Proje;
import Helper.Dbconnect;

public class activity extends proj {

	
	Dbconnect con=new Dbconnect();
	    Connection c=con.dbcon();
	    Statement st=null;
	    ResultSet rs=null;
	    PreparedStatement preparedstatement=null;
	
	private int AP_ID,Sr;
	private String Acitivity_code,tanim,base_inf,begindate,enddate,succesdate;
	private float P_hours;
	private int selected_id;
	
	public int getSelected_id() {
		return selected_id;
	}

	public void setSelected_id(int selected_id) {
		this.selected_id = selected_id;
	}
	public activity() {
		
	}

	public activity(int aP_ID, int sr, String acitivity_code, String tanim, String base_inf, String begindate,
			String enddate, String succesdate, float p_hours) {
		super();
		this.AP_ID = aP_ID;
		this.Sr = sr;
		this.Acitivity_code = acitivity_code;
		this.tanim = tanim;
		this.base_inf = base_inf;
		this.begindate = begindate;
		this.enddate = enddate;
		this.succesdate = succesdate;
		this.P_hours = p_hours;
	

}
	
	public ArrayList<activity> getactivity1(){
    	ArrayList<activity> list=new ArrayList<>();
    	activity obj;
    	try {
			st=c.createStatement();
			rs=st.executeQuery("select * from activity where AP_ID="+selected_id);
			while(rs.next()) {
			obj= new activity(rs.getInt("AP_ID"),rs.getInt("Sr"),rs.getString("Activity_code"),rs.getString("Taným"),rs.getString("base_inf"),rs.getString("begindate"),rs.getString("enddate"),rs.getString("succesdate"),Float.parseFloat(rs.getString("P_hours")));
			list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    	
    }

	public int getAP_ID() {
		return AP_ID;
	}

	public void setAP_ID(int aP_ID) {
		AP_ID = aP_ID;
	}

	public int getSr() {
		return Sr;
	}

	public void setSr(int sr) {
		Sr = sr;
	}

	public String getAcitivity_code() {
		return Acitivity_code;
	}

	public void setAcitivity_code(String acitivity_code) {
		Acitivity_code = acitivity_code;
	}

	public String getTanim() {
		return tanim;
	}

	public void setTanim(String tanim) {
		this.tanim = tanim;
	}

	public String getBase_inf() {
		return base_inf;
	}

	public void setBase_inf(String base_inf) {
		this.base_inf = base_inf;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getSuccesdate() {
		return succesdate;
	}

	public void setSuccesdate(String succesdate) {
		this.succesdate = succesdate;
	}

	public float getP_hours() {
		return P_hours;
	}

	public void setP_hours(float p_hours) {
		P_hours = p_hours;
	}
	public boolean addProje(int sr, String acitivity_code, String tanim, String base_inf, String begindate,
			String enddate, String succesdate, float p_hours) {
		boolean key=false;
		try {
			st=c.createStatement();
			
			String query="INSERT INTO activity (AP_ID,Sr,Activity_code,Taným,base_inf,begindate,enddate,succesdate,P_hours) VALUES("+selected_id+",?,?,?,?,?,?,?,?)";
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setInt(1, sr);
			preparedstatement.setString(2, acitivity_code);
			preparedstatement.setString(3, tanim);
			preparedstatement.setString(4, base_inf);
			preparedstatement.setString(5, begindate);
			preparedstatement.setString(6, enddate);
			preparedstatement.setString(7, succesdate);
			preparedstatement.setFloat(8, p_hours);
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
	public boolean deleteactivity(int sr) {
		boolean key=false;
		try {
			st=c.createStatement();
			
			String query="delete from activity where Sr=? and AP_ID="+selected_id;
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setInt(1, sr);
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
	public boolean updateactivity(int sr, String acitivity_code, String tanim, String base_inf, String begindate,
			String enddate, String succesdate, float p_hours) {
		boolean key=false;
		try {
			Connection c=con.dbcon();
			st=c.createStatement();
			
			String query="update activity set Sr=?,Activity_code=?,Taným=?,base_inf=?,begindate=?,enddate=?,succesdate=?,P_hours=? where Sr=? and AP_ID="+selected_id;
			preparedstatement=c.prepareStatement(query);
			preparedstatement.setInt(1, sr);
			preparedstatement.setString(2, acitivity_code);
			preparedstatement.setString(3, tanim);
			preparedstatement.setString(4, base_inf);
			preparedstatement.setString(5, begindate);
			preparedstatement.setString(6, enddate);
			preparedstatement.setString(7, succesdate);
			preparedstatement.setFloat(8, p_hours);
			preparedstatement.setInt(9, sr);
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

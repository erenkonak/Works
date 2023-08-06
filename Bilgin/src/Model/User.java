package Model;

public class User {
	private int ID;
	private String user_name,password,Type;
	public User(int iD, String user_name, String password, String type) {
		super();
		this.ID = iD;
		this.user_name = user_name;
		this.password = password;
		this.Type = type;
	}
	public User() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID= iD;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	

}

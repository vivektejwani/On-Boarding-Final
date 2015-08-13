package Entities;

public class Admin {

	private int adminId;
	private String email,password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

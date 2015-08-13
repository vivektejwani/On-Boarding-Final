package Entities;

import java.util.ArrayList;

public class HR {

	private int hrId;
	private String password,firstName,lastName,email;
	private ArrayList<Group> groupList = new ArrayList<Group>();
	
	public HR() {
		// TODO Auto-generated constructor stub
	}
	
	public HR(String email,String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
	}
	public int getHrId() {
		return hrId;
	}
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}
	public String getPassword() {
		return password;
	}
	public ArrayList<Group> getGroupList() {
		return groupList;
	}
	public void setGroupList(ArrayList<Group> groupList) {
		this.groupList = groupList;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

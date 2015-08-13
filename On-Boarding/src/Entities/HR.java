package Entities;

import java.util.ArrayList;

public class HR {

	int hrId;
	String password,firstName,lastName,email;
	ArrayList<Group> groupList = new ArrayList<Group>();
	
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

package Entities;

import java.util.ArrayList;

public class Group {

	int groupId,hrId;
	String groupName;
	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getHrId() {
		return hrId;
	}
	public void setHrId(int hrId) {
		this.hrId = hrId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}

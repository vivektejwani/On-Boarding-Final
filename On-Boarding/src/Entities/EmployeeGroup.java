package Entities;

public class EmployeeGroup {
	/*
	 * emp_id int,
	                   group_id int,
	                   primary key (emp_id,group_id),
	                   foreign key emp_id references emp(emp_id),
	                   foreign key group_id references ggroup(group_id)
	 */
	int empId,groupId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	

}

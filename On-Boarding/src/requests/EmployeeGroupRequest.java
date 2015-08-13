package requests;
import Entities.*;
public class EmployeeGroupRequest {
	
	
	private Employee employee;
	private Group group;
	public EmployeeGroupRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeGroupRequest(Employee emp, Group grp) {
		// TODO Auto-generated constructor stub
		this.employee = emp;
		this.group = grp;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	

}

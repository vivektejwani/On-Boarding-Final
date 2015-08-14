package requests;

import Entities.Employee;
import Entities.Group;

public class EmployeeMessagesRequest {

	private Employee employee;
	private Group group;
	private int pageNumber;

	public EmployeeMessagesRequest() {
	}

	public EmployeeMessagesRequest(Employee employee, Group group,
			int pageNumber) {
		super();
		this.employee = employee;
		this.group = group;
		this.pageNumber = pageNumber;
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

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}

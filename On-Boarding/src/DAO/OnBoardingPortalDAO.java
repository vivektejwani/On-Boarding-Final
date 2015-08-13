package DAO;

import Entities.*;


public interface OnBoardingPortalDAO 
{
	public boolean addEmployee(Employee employee);
	public boolean addHr(HR hr);
	public boolean addGroup(Group group);
	public boolean addMessage(Message message);
	
	public boolean addEmployeeGroup(Employee employee);
	
	public boolean removeEmployee(Employee employee);
	public boolean removeGroup(Group group);
	//public boolean removeEmployeeGroup();
	public boolean removeMessage(Message message);
	
	//public Employee validateEmployee(Employee employee);
	//public HR validateHr(HR hr);
	//public Admin validateAdmin(Admin admin);

	//public boolean updateEmployee(Employee employee);
	//public boolean updateHr(HR hr);
}
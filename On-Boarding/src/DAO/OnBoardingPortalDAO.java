package DAO;

import Entities.*;


public interface OnBoardingPortalDAO 
{
	public int addEmployee(Employee employee);
	public int addHr(HR hr);
	public int addGroup(Group group);
	
	public int removeEmployee(Employee employee);
	public int removeGroup(Group group);
	public int removeEmployeeGroup(Employee employee,Group group);
	
	public boolean validateEmployee(Employee employee);
	public boolean validateHr(HR hr);
	public boolean validateAdmin(Admin admin);

}

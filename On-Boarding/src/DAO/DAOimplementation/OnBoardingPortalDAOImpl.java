package DAO.DAOimplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import requests.EmployeeGroupRequest;
import DAO.OnBoardingPortalDAO;
import Entities.*;


public class OnBoardingPortalDAOImpl implements OnBoardingPortalDAO{
	
	    private DataSource dataSource;
	    private JdbcTemplate jdbcTemplate;
	    
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
	    
	      
	    
	    public boolean addEmployee(Employee employee){
	        String sql = "INSERT INTO employee " +
	            "(password, name_first, name_last, email, designation ) VALUES (?, ?, ?, ?, ?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] {
	                 employee.getPassword(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDesignation() });
	      if(u>0)
	    	  return true;
	      else 
	    	  return false;
	     
	    }  
	    
	    
	    public boolean addEmployeeGroup(EmployeeGroupRequest empgrpreq)
	    {
	    	
	    	String sql="insert into emp_group (emp_id, group_id) values(?, ?)";
    		jdbcTemplate = new JdbcTemplate(dataSource);
	        int u=jdbcTemplate.update(sql, new Object[] {empgrpreq.getEmployee().getEmpId(), empgrpreq.getGroup().getGroupId()});
	 
	    	if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }
	    
	    
	    public boolean addHr(HR hr){
	        String sql = "INSERT INTO hr" +
	            "( password, name_first, name_last, email) VALUES ( ?, ?, ?, ?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] {
	                 hr.getPassword(), hr.getFirstName(), hr.getLastName(), hr.getEmail() });
	        if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }  
	    
	    
	    public boolean addGroup(Group group){
	        String sql = "INSERT INTO ggroup" +
	            "( group_name, hr_id,venue_id) VALUES (?, ?, ?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] { 
	                 group.getGroupName(), group.getHrId(), group.getVenueId() });
	        if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }  
	    
	    
	    public boolean addMessage(Message message)
	    {
	    	String sql = "INSERT INTO message" +
		            "(msg, subject, msg_time, group_id) VALUES (?, ?, ?, ?)";
		  
		        jdbcTemplate = new JdbcTemplate(dataSource);
		        
		        int u=jdbcTemplate.update(sql, new Object[] { message.getMsg(), message.getSubject(), message.getMsgTime(), message.getGroupId() });
		        if(u>0)
			    	  return true;
			      else 
			    	  return false;
	    }
	    
	    
	    public boolean addVenue(Venue venue)
	    {
	    	String sql = "INSERT INTO veneue" +
		            "( venue_name, trainer_name, capacity) VALUES (?, ?, ?)";
		  
		        jdbcTemplate = new JdbcTemplate(dataSource);
		        
		        int u=jdbcTemplate.update(sql, new Object[] {venue.getVenueName(), venue.getTrainerName(), venue.getCapacity() });
		        if(u>0)
			    	  return true;
			      else 
			    	  return false;
	    }
	    
	    
	    	
	    
	    public boolean removeEmployee(Employee employee)
	    {
	    	int u=0;
            String sql="delete from employee where emp_id=?";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u1=jdbcTemplate.update(sql,new Object[] {employee.getEmpId()});
	    		
	        String sql2="delete from emp_group where empId=?";
	    		jdbcTemplate = new JdbcTemplate(dataSource);
		      int u2=jdbcTemplate.update(sql, new Object[] {employee.getEmpId()});
		      
		      if(u1>0&&u2>0)
		      {
		    	 return true; 
		      }
		      else 
		    	 return false;
	    }



		public boolean removeGroup(Group group) {
			
            String sql="delete from ggroup where group_id=?";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql,new Object[] {group.getGroupId()});
	    	if(u>0)
		      {
		    	 return true; 
		      }
		      else 
		    	 return false;
		}



		public boolean removeMessage(Message message) {
			
            String sql="delete from message where msg_id=?";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql,new Object[] {message.getMsgId()});
	    	if(u>0)
		      {
		    	 return true; 
		      }
		      else 
		    	 return false;
		}



		public boolean removeEmployeeGroup(EmployeeGroupRequest empgrpreq) {
			String sql="delete from ggroup where group_id=?  and emp_id=?";
			jdbcTemplate = new JdbcTemplate(dataSource);
	        int u=jdbcTemplate.update(sql, new Object[] { empgrpreq.getGroup().getGroupId(), empgrpreq.getEmployee().getEmpId()});
	 
	    	if(u>0)
		    	  return true;
		      else 
		    	  return false;
		}



		public Employee validateEmployee(Employee employee) {
			String sql="select * from employee";
			return null;
		}



		public HR validateHr(HR hr) {
			// TODO Auto-generated method stub
			return null;
		}



		public Admin validateAdmin(Admin admin) {
			// TODO Auto-generated method stub
			return null;
		}



		public boolean updateEmployee(Employee employee) {
			String sql="update employee set  password=?, name_first=?,name_last=?, email=?, designation=? where emp_id=?";
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql, new Object[] {employee.getPassword(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDesignation(), employee.getEmpId() });
			
	    	if(u>0)
	    	return true;
			else
				return false;
		}



		public boolean updateHr(HR hr) {
			String sql="update hr set password=?,name_first=?, name_last=?, email=?";
			jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql, new Object[] {hr.getPassword(), hr.getFirstName(), hr.getLastName(), hr.getEmail() });
			if(u>0)
				return true;
			else
	    	    return false;
		}



		public Employee validateEmployee(Employee employee) {
			// TODO Auto-generated method stub
			return null;
		}



		public HR validateHr(HR hr) {
			// TODO Auto-generated method stub
			return null;
		}



		public Admin validateAdmin(Admin admin) {
			// TODO Auto-generated method stub
			return null;
		}



		public boolean updateEmployee(Employee employee) {
			// TODO Auto-generated method stub
			return false;
		}



		public boolean updateHr(HR hr) {
			// TODO Auto-generated method stub
			return false;
		}
	    
	    
	
	}




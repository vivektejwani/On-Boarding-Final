package DAO.DAOimplementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

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
	            "(emp_id, password, name_first, name_last, email, designation ) VALUES (?, ?, ?, ?, ?, ?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] { employee.getEmpId(),
	                 employee.getPassword(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDesignation() });
	      if(u>0)
	    	  return true;
	      else 
	    	  return false;
	     
	    }  
	    
	    
	    public boolean addEmployeeGroup(Employee employee)
	    {
	    	int u=0;
	    	ArrayList<Group> groupList = new ArrayList<Group>();
	    	groupList=employee.getGroupList();
	    	Iterator i=groupList.iterator();
	    	while(i.hasNext())
	    	{
	    		Group g=(Group)i.next();
	    		
	    		String sql="insert into emp_group (emp_id, group_id) values(?, ?)";
	    		jdbcTemplate = new JdbcTemplate(dataSource);
		        u=jdbcTemplate.update(sql, new Object[] {employee.getEmpId(),g.getGroupId()});
		        if(u<0)
		        	break;
		        
	    	}
	    	if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }
	    
	    
	    public boolean addHr(HR hr){
	        String sql = "INSERT INTO hr" +
	            "(hr_id, password, name_first, name_last, email) VALUES (?, ?, ?, ?, ?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] { hr.getHrId(),
	                 hr.getPassword(), hr.getFirstName(), hr.getLastName(), hr.getEmail() });
	        if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }  
	    
	    
	    public boolean addGroup(Group group){
	        String sql = "INSERT INTO ggroup" +
	            "(group_id, group_name, hr_id,venue_id) VALUES (?, ?, ?,?)";
	  
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        int u=jdbcTemplate.update(sql, new Object[] { group.getGroupId(),
	                 group.getGroupName(), group.getHrId(), group.getVenueId() });
	        if(u>0)
		    	  return true;
		      else 
		    	  return false;
	    }  
	    
	    
	    public boolean addMessage(Message message)
	    {
	    	String sql = "INSERT INTO message" +
		            "(msg_id, msg, subject, msg_time, group_id) VALUES (?, ?, ?, ?, ?)";
		  
		        jdbcTemplate = new JdbcTemplate(dataSource);
		        
		        int u=jdbcTemplate.update(sql, new Object[] { message.getMsgId(), message.getMsg(), message.getSubject(), message.getMsgTime(), message.getGroupId() });
		        if(u>0)
			    	  return true;
			      else 
			    	  return false;
	    }
	    
	    
	    public boolean addVenue(Venue venue)
	    {
	    	String sql = "INSERT INTO veneue" +
		            "(venue_id, venue_name, trainer_name, capacity) VALUES (?, ?, ?, ?)";
		  
		        jdbcTemplate = new JdbcTemplate(dataSource);
		        
		        int u=jdbcTemplate.update(sql, new Object[] { venue.getVenueId(), venue.getVenueName(), venue.getTrainerName(), venue.getCapacity() });
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
			
			return false;
		}



		public boolean removeMessage(Message message) {
			// TODO Auto-generated method stub
			return false;
		}
	    
	    
	 /*   public int removeEmployeeGroup(Employee employee)
	    {
            String sql="delete from emp_group where emp_id=? and group_id=?";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql,new Object[] {employeegroup.getEmpId(), employeegroup.getGroupId()});
	    	return u;
	    }
	    
	    public int removeGroup(Group group)
	    {
            String sql="delete from emp_group where group_id=?";
	    	
	    	jdbcTemplate = new JdbcTemplate(dataSource);
	    	int u=jdbcTemplate.update(sql,new Object[] { group.getGroupId()});
	    	ArrayList<Employee> employeeList = new ArrayList<Employee>();
	    	Iterator i=employeeList.iterator();
	    	while(i.hasNext())
	    	{
	    		Employee e=(Employee)i.next();
	    		ArrayList<Group> group1 = new ArrayList<Group>();
	    		group1=e.getGroupList();
	    		Iterator i1=group1.iterator();
	    		
	    		
	    		
	    	}
	    	
	    	
	    	return u;
	    }
	    
	*/
	    
	    
	    
	  

	    
	}




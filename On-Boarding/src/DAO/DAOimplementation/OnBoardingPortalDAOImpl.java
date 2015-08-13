package DAO.DAOimplementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	    
	    
		 class EmployeeRowMapper implements RowMapper
			{
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Employee employee = new Employee();
					employee.setEmpId(rs.getInt("emp_id"));
					employee.setFirstName(rs.getString("name_first"));
					employee.setLastName(rs.getString("name_last"));
					employee.setDesignation(rs.getString("designation"));
					employee.setPassword(rs.getString("password"));
					employee.setEmail(rs.getString("email"));
					return employee;
				}

				
			}
		    
		    
			public Employee validateEmployee(Employee employee)
			{
				
				String query="select * from employee where email=? ;";
				jdbcTemplate = new JdbcTemplate(dataSource);
				
				Employee emp = (Employee)jdbcTemplate.queryForObject(query,new Object[]{employee.getEmail()}, new EmployeeRowMapper());
				
				if (!(emp.getPassword().equals(employee.getPassword())))
				{
					return null;
				}
				
				ArrayList<Group> groups = new ArrayList<Group>();
				
				String sql ="select * from emp_group natural join employee natural join ggroup where email=?";
				
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
				
				for (Map<String,Object> row : rows) {
					Group group = new Group();
					group.setGroupId((Integer)(row.get("group_id")));
					group.setHrId((Integer)(row.get("hr_id")));
					group.setVenueId((Integer)(row.get("venue_id")));
					group.setGroupName((String)row.get("group_name"));
					
					groups.add(group);
				}
				
				emp.setGroupList(groups);
				
				return emp;
				
				
			}
			
			
			 class HrRowMapper implements RowMapper
				{
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						HR hr = new HR();
						hr.setHrId(rs.getInt("hr_id"));
						hr.setFirstName(rs.getString("name_first"));
						hr.setLastName(rs.getString("name_last"));
						hr.setPassword(rs.getString("password"));
						hr.setEmail(rs.getString("email"));
						return hr;
					}
					
				}
			    
			
			public HR validateHr(HR hr)
			{
				String query="select * from hr where email=? ;";
				jdbcTemplate = new JdbcTemplate(dataSource);
				
				HR hrl = (HR)jdbcTemplate.queryForObject(query,new Object[]{hr.getEmail()}, new HrRowMapper());
				
				if (!(hrl.getPassword().equals(hr.getPassword())))
				{
					return null;
				}
				
				ArrayList<Group> groups = new ArrayList<Group>();
				
				String sql ="select * from ggroup natural join hr where email=?";
				
				List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
				
				for (Map<String,Object> row : rows) {
					Group group = new Group();
					group.setGroupId((Integer)(row.get("group_id")));
					group.setHrId((Integer)(row.get("hr_id")));
					group.setVenueId((Integer)(row.get("venue_id")));
					group.setGroupName((String)row.get("group_name"));
					
					groups.add(group);
				}
				
				hrl.setGroupList(groups);
				
				return hrl;
				
			}
			
			 class AdminRowMapper implements RowMapper
				{
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
					{
						Admin admin = new Admin();
						admin.setAdminId(rs.getInt("admin_id"));
						admin.setPassword(rs.getString("password"));
						admin.setEmail(rs.getString("email"));
						return admin;
					}
					
				}

			
			public Admin validateAdmin(Admin admin)
			{
				String query="select * from admin where email=? ;";
				jdbcTemplate = new JdbcTemplate(dataSource);
				
				Admin adm = (Admin)jdbcTemplate.queryForObject(query,new Object[]{admin.getEmail()}, new AdminRowMapper());
				
				if(adm.getPassword().equals(admin.getPassword()))
				{
					return adm;
				}
				else
				{
					return null;
				}
				
			}

		
	
	}




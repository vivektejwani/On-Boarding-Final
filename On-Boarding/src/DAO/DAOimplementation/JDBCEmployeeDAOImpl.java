package DAO.DAOimplementation;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
public class JDBCEmployeeDAOImpl implements JDBCEmployeeDAO{
    private DataSource dataSource;
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
   /* public void create()
    {
    	String sql="create table employee(empid int PRIMARY KEY NOT NULL AUTO_INCREMENT, empname varchar(20) NOT NULL,empage int NOT NULL,password varchar(20),empemail varchar(20),salary BIGINT NOT NULL, address varchar(20) NOT NULL)";
    	jdbcTemplate = new JdbcTemplate(dataSource);
    	jdbcTemplate.execute(sql);
    	System.out.println("Table created successfully");
    }
    */
    
    
    
    public int addEmployee(Employee employee){
        String sql = "INSERT INTO employee " +
            "(emp_id, password, name_first, name_last, email, designation ) VALUES (?, ?, ?, ?, ?, ?)";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        int u=jdbcTemplate.update(sql, new Object[] { employee.getEmp_id(),
                 employee.getPassword(), employee.getName_first, employee.getName_last, employee.getEmail(), employee.getDesignation() });
        return u;
    }  
    
    
    public int addHr(HR hr){
        String sql = "INSERT INTO hr" +
            "(hr_id, password, name_first, name_last, email) VALUES (?, ?, ?, ?, ?)";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        int u=jdbcTemplate.update(sql, new Object[] { hr.getHr_id(),
                 hr.getPassword(), hr.getName_first, hr.getName_last, hr.getEmail() });
        return u;
    }  
    
    
    public int addgroup(Group group){
        String sql = "INSERT INTO ggroup" +
            "(group_id, group_name, hr_id) VALUES (?, ?, ?)";
  
        jdbcTemplate = new JdbcTemplate(dataSource);
        
        int u=jdbcTemplate.update(sql, new Object[] { group.getGroup_id(),
                 group.getGroup_name(), group.getHr().hr_id });
        return u;
    }  
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int update(Employee employee)
    {
    	String sql="update employee set empname=?, empage=?, password=?, empemail=?, salary=?, address=? where empid=?";
    	jdbcTemplate = new JdbcTemplate(dataSource);
    	int u=jdbcTemplate.update(sql, new Object[] { employee.getEmpname(), employee.getEmpage(), employee.getPassword(), employee.getEmpemail(), employee.getSalary(), employee.getAddress(), employee.getEmpid() });
    	//System.out.println("Row Entry deleted successfully");
    	return u;
    }
    
   
    public int delete(int id)
    {
    	
    	String sql="delete from employee where empid=?";
    	
    	jdbcTemplate = new JdbcTemplate(dataSource);
    	int u=jdbcTemplate.update(sql,new Object[] {id});
    	return u;
    
    }
    
    
    
    public List<Employee> list()
    {
    	String sql="Select * from employee";
    	jdbcTemplate = new JdbcTemplate(dataSource);
    
    	List<Employee> lt=new ArrayList<Employee>();
    	 
    	lt=jdbcTemplate.queryForObject(sql,new EmpRowMapper());
    	return lt;
    
    	
    }
    

  
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//        public Employee findById(int id){
//            String sql = "SELECT * FROM EMPLOYEE WHERE ID = ?";
//            jdbcTemplate = new JdbcTemplate(dataSource);
//            Employee employee = (Employee) jdbcTemplate.queryForObject(
//                    sql, new Object[] { id }, new BeanPropertyRowMapper(Employee.class));
//            return employee;
//        }
    

    
}

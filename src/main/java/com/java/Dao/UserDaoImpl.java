package com.java.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	// Session session=sessionFactory.openSession();
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void create(User user) {
		// openSession().beginTransaction();
		currentSession().save(user);
		System.out.println(user.getId());
		// openSession().getTransaction();
		// openSession().close();

	}
	

	public void update(User user) {
		//System.out.println(user.getUsername()+user.getId());
		currentSession().update(user);
		/*String sql="update user set username='"+user.getUsername()+"', email="+user.getEmail()+",password='"+user.getPassword()+"' where username="+user.getUsername()+"";    
	    return jdbcTemplate.update(sql);*/  
	}

	public void delete(User user) {
		currentSession().delete(user);

	}
	public User getEmpById(Long id){    
	    /*String sql="select * from user where username=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<User>(User.class));  */
		List<User> temp=this.getAll();
		User obj=new User();
		//System.out.println(temp);
		for(User a:temp)
		{
			System.out.println(id+" "+a.getId());
			if(id.equals(a.getId()))
			{
				obj.setId(a.getId());
				obj.setEmail(a.getEmail());
				obj.setPassword(a.getPassword());
				obj.setUsername(a.getUsername());
			}
		}
		System.out.println(obj);
		return obj;
	}    
	public User edit(Long userId) {

		return find(userId);
	}

	public User find(Long userId) {

		return (User) currentSession().get(User.class, userId);
	}

	public List<User> getAll() {

return jdbcTemplate.query("select * from user", new RowMapper<User>() {
			
			public User mapRow(ResultSet result, int row) throws SQLException {
				//System.out.println("hg");
				User user = new User();
				//System.out.println("hg");
				//user.setUserid(result.getInt(2));
				user.setUsername(result.getString(6));
				user.setEmail(result.getString(4));
				user.setPassword(result.getString(5));
				user.setId(result.getLong(1));
				user.setCaptcha1(result.getString(2));
				user.setCaptcha2(result.getString(3));
				//System.out.println(result.getString(1));
				//System.out.println(result.getLong(2));
				//System.out.println(result.getString(3));
				//System.out.println(result.getString(4));
				//System.out.println(result.getString(5));
				//System.out.println(result.getString(6));
				//System.out.println(user);
				return user;
			}
		});
	}



	public String loginUser(User user) {
		
		List<User> temp=this.getAll();
		
		for(User a:temp)
		{
			System.out.println(user.getUsername()+""+a.getUsername());
			if(user.getUsername().equals(a.getUsername()))
			{
				System.out.println(user.getPassword()+""+a.getPassword());
				if(user.getPassword().equals(a.getPassword()))
				{
					return user.getUsername();
				}
			}
		}
		
		return null;
		/*String sql = "SELECT username FROM user WHERE username=? AND password=?";
		 System.out.println(sql);
		try {
			 System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			// System.out.println(user.getPasswordConf());

			String username = jdbcTemplate.queryForObject(sql,
					new Object[] { user.getUsername(), user.getPassword() }, String.class);
			//File file = new File("c:/test.txt");
			
			
			            
			            
			//file.write(file, username);
			 System.out.println("username");
			return username;

		} catch (Exception e) {
			return null;
		}*/
	}


	public List<User> get(User user) {
		
        List<User> temp=this.getAll();
        List<User> temp1=new ArrayList<User>();
        User b=new User();
		for(User a:temp)
		{
			System.out.println(user.getUsername()+""+a.getUsername());
			if(user.getUsername().equals(a.getUsername()))
			{
				System.out.println(user.getPassword()+""+a.getPassword());
				if(user.getPassword().equals(a.getPassword()))
				{
					b.setId(a.getId());
					b.setEmail(a.getEmail());
					b.setPassword(a.getPassword());
					b.setUsername(a.getUsername());
					temp1.add(b);
				}
			}
		}
		return temp1;
	}
}



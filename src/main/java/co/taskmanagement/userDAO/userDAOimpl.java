package co.taskmanagement.userDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
@Component
public class userDAOimpl implements userDAO {
	@Autowired
	DataSource myDataSource;
	public void insertData(user User) {
		String sql = "INSERT INTO t_User(user_Date,user_password,user_name,role,email,real_name) VALUES (?,?,?,?,?,?);";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
        jdbcTemplate.update(sql, new Object[] { User.getDate(),User.getPassword(),User.getUser_name(),User.getRole(),User.getEmail(),User.getRealName()});
    
	}

	public user getUser(int userID) {
		 String sql = "SELECT * FROM t_User where user_id=?";
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 user items = jdbcTemplate.queryForObject(sql,new Object[]{userID},((RowMapper<user>) new userRowMapper()));
	     return items;
	}
	
}

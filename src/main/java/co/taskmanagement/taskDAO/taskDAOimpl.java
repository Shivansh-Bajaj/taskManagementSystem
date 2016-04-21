package co.taskmanagement.taskDAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class taskDAOimpl implements taskDAO{
	@Autowired
	DataSource myDataSource;
	public void insertData(task com) {
		String sql = "INSERT INTO t_task(task_StartDate,task_lastDate,task_title,detail,status,createdBy) VALUES (?,?,?,?,?,?);";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
        jdbcTemplate.update(sql, new Object[] {com.getStartDate(),com.getEndDate(),com.getTitle(),com.getDetail(),com.getStatus(),com.getCreatedBy()});
	}
	public List<task> gettasksByProjectID(int proID) {
		 String sql = "SELECT * FROM t_task where project_id=?";
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 List<task> items = (List<task>) jdbcTemplate.queryForObject(sql,new Object[]{proID}, new taskDAORowMapper());
	    return items;
	}
	public List<task> gettaskDetail(int taskID) {
		 String sql = "SELECT * FROM t_task where task_id=?";
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 List<task> items = (List<task>) jdbcTemplate.queryForObject(sql,new Object[]{taskID}, new taskDAORowMapper());
	    return items;
	}
	
	
	public List<task> getTask(int proID, String Status) {
		 String sql = "SELECT * FROM t_task where project_id=? and status=?";
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 List<task> items = (List<task>) jdbcTemplate.queryForObject(sql,new Object[]{proID,Status}, new taskDAORowMapper());
	    return items;
	}
}



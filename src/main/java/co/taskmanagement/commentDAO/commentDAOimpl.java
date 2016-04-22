package co.taskmanagement.commentDAO;


import javax.sql.DataSource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class commentDAOimpl implements commentDAO{
	@Autowired
	DataSource myDataSource;
	public void insertData(comment com) {
		String sql = "INSERT INTO t_comment(project_id,user_name,task_id,detail) VALUES (?,?,?,?);";
        JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
        jdbcTemplate.update(sql, new Object[] {com.getProject_id(),com.getUser_name(),com.getTask_id(),com.getDetail()});
	}

	public List<comment> getCommentsByProjectID(int taskID) {
		 String sql = "SELECT * FROM t_comment where task_id="+taskID;
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 List<comment> items = (List<comment>) jdbcTemplate.query(sql, new commentDAORowMapper());
	    return items;
	}
}
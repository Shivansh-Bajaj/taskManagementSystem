package co.taskmanagement.ProjectDAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class ProjectDAOimpl implements projectDAO{
		@Autowired
		DataSource myDataSource;
		public void insertData(Project pro) {
			String sql = "INSERT INTO t_Project(project_StartDate,project_lastDate,user_title,detail,createdBy) VALUES (?,?,?,?,?);";
	        JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
	        jdbcTemplate.update(sql, new Object[] { pro.getStartDate(),pro.getEndDate(),pro.title,pro.getDetail(),pro.getCreatedBy()});
	        System.out.println(sql);
		}

	public List<Project> getProject(int proID) {
		 String sql = "SELECT * FROM t_Project where project_id="+proID;
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		 List<Project> items =  jdbcTemplate.query(sql,(new ProjectDAORowMapper()));
		 return items;
	}
	
	public List<Project> getProjectByUser(String User) {
		String sql = "SELECT * FROM t_Project where t_Project.project_id=userToProject.projectID and userToProject.user_name="+"'"+User+"'";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		List<Project> items = (List<Project>) jdbcTemplate.query(sql,(RowMapper<Project>) ( new ProjectDAORowMapper()));
	    return items;
	}

	public List<Project> searchProject(String name) {
		String sql = "SELECT * FROM t_Project where user_title="+"'"+name+"'";
		JdbcTemplate jdbcTemplate=new JdbcTemplate(myDataSource);
		List<Project> items = (List<Project>) jdbcTemplate.query(sql,(RowMapper<Project>) ( new ProjectDAORowMapper()));
	    return items;
	}
}

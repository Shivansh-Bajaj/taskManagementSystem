package co.taskmanagement.ProjectDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProjectDAORowMapper implements RowMapper<Project>{

	  public Project mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		  ProjectDAOExtractor Extracter = new ProjectDAOExtractor();
	        return Extracter.extractData(resultSet);
	    }

}

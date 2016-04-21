package co.taskmanagement.ProjectDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class ProjectDAOExtractor {
	public Project extractData(ResultSet resultSet) throws SQLException,
    DataAccessException {
		Project item = new Project();
		item.setProject_id(resultSet.getInt(1));
		item.setStartDate(resultSet.getDate(2));
		item.setEndDate(resultSet.getDate(3));
		item.setTitle(resultSet.getString(4));
		item.setDetail(resultSet.getString(5));
		item.setCreatedBy(resultSet.getString(6));
		return item;
		}
}

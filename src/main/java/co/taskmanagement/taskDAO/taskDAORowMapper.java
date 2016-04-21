package co.taskmanagement.taskDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class taskDAORowMapper implements RowMapper<task> {

	public task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		taskDAOExtractor Extracter = new taskDAOExtractor();
        return Extracter.extractData(resultSet);
	}
}

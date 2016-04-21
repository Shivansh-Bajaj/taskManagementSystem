package co.taskmanagement.commentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class commentDAORowMapper implements RowMapper<comment> {

	public comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		commentDAOExtrator Extracter = new commentDAOExtrator();
        return Extracter.extractData(resultSet);
	}
	
}

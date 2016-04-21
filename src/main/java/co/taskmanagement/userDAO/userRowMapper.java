package co.taskmanagement.userDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.taskmanagement.taskDAO.task;


public class userRowMapper implements RowMapper<user>{
	  public user mapRow(ResultSet resultSet, int rowNum) throws SQLException {
	    	userExtractor Extracter = new userExtractor();
	        return Extracter.extractData(resultSet);
	    }
}

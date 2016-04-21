package co.taskmanagement.commentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;


class commentDAOExtrator{
	public comment extractData(ResultSet resultSet) throws SQLException,
    DataAccessException {
		comment item = new comment();
		item.setComment_id(resultSet.getInt(1));
		item.setProject_id(resultSet.getInt(2));
		item.setUser_name(resultSet.getString(3));
		item.setTask_id(resultSet.getInt(4));
		item.setDetail(resultSet.getString(5));
		return item;
		}
}

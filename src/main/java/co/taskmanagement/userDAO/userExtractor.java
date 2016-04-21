package co.taskmanagement.userDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

public class userExtractor {
	public user extractData(ResultSet resultSet) throws SQLException,
    DataAccessException {
user item = new user();

item.setDate(resultSet.getDate(1));
item.setPassword(resultSet.getString(2));
item.setRole(resultSet.getString(3));
item.setEmail(resultSet.getNString(4));
item.setRealName(resultSet.getString(5));
item.setUser_name(resultSet.getString(6));
return item;
}
}

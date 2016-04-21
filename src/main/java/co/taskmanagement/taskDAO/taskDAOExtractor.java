package co.taskmanagement.taskDAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
public class taskDAOExtractor {
	public task extractData(ResultSet resultSet) throws SQLException,
    DataAccessException {
		task item = new task();
		item.setTask_id(resultSet.getInt(1));
		item.setStartDate(resultSet.getDate(2));
		item.setEndDate(resultSet.getDate(3));
		item.setTitle(resultSet.getString(4));
		item.setDetail(resultSet.getString(5));
		item.setStatus(resultSet.getString(6));
		item.setCreatedBy(resultSet.getString(7));
		return item;

	}
}

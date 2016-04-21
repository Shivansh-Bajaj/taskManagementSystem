package co.taskmanagement.userDAO;
import  java.util.List;

public interface userDAO {
	public void insertData(user User);
	public user getUser(int userID);
}
package co.taskmanagement.taskDAO;
import java.util.List;
public interface taskDAO {
	public void insertData(task Task);
	public List<task> gettaskDetail(int taskID);
	public List<task> gettasksByProjectID(int proID);
	public List<task> getTask(int proID,String Status);
}

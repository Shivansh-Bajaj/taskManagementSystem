package co.taskmanagement.commentDAO;

import java.util.List;
public interface commentDAO {
	public void insertData(comment com);
	public List<comment> getCommentsByProjectID(int taskID);
}

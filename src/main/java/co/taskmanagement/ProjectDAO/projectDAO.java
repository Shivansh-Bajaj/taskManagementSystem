package co.taskmanagement.ProjectDAO;
import java.util.List;
import co.taskmanagement.userDAO.*;;

public interface projectDAO {

	public void insertData(Project project);
	public List<Project> getProject(int proID);
	public List<Project> searchProject(String name);
	public List<Project> getProjectByUser(String userName);
}

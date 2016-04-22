package co.taskmanagement.controller;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.taskmanagement.ProjectDAO.Project;
import co.taskmanagement.ProjectDAO.projectDAO;
import co.taskmanagement.commentDAO.comment;
import co.taskmanagement.commentDAO.commentDAO;
import co.taskmanagement.taskDAO.task;
import co.taskmanagement.taskDAO.taskDAO;
import co.taskmanagement.userDAO.*;
@Controller
public class mainController {
	@Autowired
	userDAO UserObject;
	@Autowired
	projectDAO pro;
	@Autowired
	taskDAO Task;
	@Autowired
	commentDAO com;
	/////welcome pages/////////
	@RequestMapping(value =  "/welcome" , method = RequestMethod.GET)
	  public String welcomePage(Model model) {
	      model.addAttribute("title", "taskManagementSystem");
	      model.addAttribute("message", "Hey");
	      return "welcomePage";
	  }
	/////signup and login//////
	@RequestMapping(value = "/Signup", method = RequestMethod.GET)
	public ModelAndView user(){
		return new ModelAndView("user","command",new user());
	}
	@RequestMapping(value="/userRegistration", method= RequestMethod.POST)
	public String userRegistration(@ModelAttribute("SpringWeb")user User,ModelMap model){
		
		System.out.println(User.getUser_name()+User.getPassword()+User.getEmail()+User.getRealName());
		if(User.getPassword().isEmpty() || User.getUser_name().isEmpty()){
			return "redirect:/Signup";
		}
		if(User.getPassword().length()<5||User.getPassword().length()>18){
			return "redirect:/Signup";
		}
		System.out.println(User.getEmail());
		UserObject.insertData(User);
		return "redirect:/user";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String loginPage(Model model) {
	      model.addAttribute("title", "Login");
	      model.addAttribute("message", "Enter your username/password:");
	      return "loginPage";
	  }
	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	  public String logoutSuccessfulPage(Model model) {
	      model.addAttribute("title", "Logout");
	      return "redirect:/welcome/";
	  }
	/////user info page/////
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	  public String loginPage(Model model, Principal principal) {
	      model.addAttribute("title", "User Info");
	      String userName = principal.getName();
	      return "userInfo";
	  }
	/////project URLS/////
	@RequestMapping(value = "/user/projects/", method = RequestMethod.GET)
	  public String userProjects(Model model, Principal principal) {
	      model.addAttribute("title", "User Info");
	      String userName = principal.getName();
	      System.out.println("add projectID");
	      model.addAttribute(userName);
	      model.addAttribute("project",pro.getProjectByUser(userName));
	      return "userInfoPage";
	  }
	@RequestMapping(value= "/user/search/", method=RequestMethod.GET)
	public String search(){
		      
		      return "Searchproject";
	}
	@RequestMapping(value= "/user/search/result", method=RequestMethod.GET)
	public String search(@RequestParam("searchText")String searchText,Model model){
		System.out.println(pro.searchProject(searchText));
		model.addAttribute("searchResult",pro.searchProject(searchText));
		return "SearchOutput";
	}
	@RequestMapping(value= "/createProject", method= RequestMethod.GET)
	public ModelAndView createProject(){
		return new ModelAndView("project","command",new Project());
	}
	@RequestMapping(value= "/addProject", method= RequestMethod.POST)
	public String addProject(@ModelAttribute("SpringWeb")Project project,ModelMap model){
		System.out.println(project.getDetail());
		pro.insertData(project);
		return "redirect:/user/";
	}
	@RequestMapping(value= "/user/projects/{ProID}",method = RequestMethod.GET)
	public String projectInfo(@PathVariable("ProID") int ProID,Model model){
		model.addAttribute("project", pro.getProject(ProID));
		return "ProjectInfo";
	}
	@RequestMapping(value= "/user/projects/{ProID}/{status}/",method = RequestMethod.GET)
	public String projectTask(@PathVariable("ProID") int ProID,@PathVariable("status") String Status,Model model){
		System.out.println(Task.getTask(ProID,Status));
		model.addAttribute("task", Task.getTask(ProID,Status));
		model.addAttribute("projectID", ProID);
		model.addAttribute("Status", Status);
		return "ProjectTask";
	}
	//////task URL/////
	@RequestMapping(value= "/user/projects/{proID}/Task/", method= RequestMethod.GET)
	public ModelAndView addTask(@PathVariable("proID") int ProID,Model model){
		return new ModelAndView("task","command",new task());
	}
	@RequestMapping(value= "/user/projects/{proID}/Task/addTask/", method= RequestMethod.POST)
	public String addProject(@PathVariable("proID") int ProID,@ModelAttribute("SpringWeb")task TASK,ModelMap model){
		System.out.println();
		TASK.setProject_id(ProID);
		
		Task.insertData(TASK);
		return "redirect:/user/projects/"+ProID+"/" ;
	}
	@RequestMapping(value= "/user/projects/{ProID}/Task/{taskID}/",method = RequestMethod.GET)
	public String projectInfo(@PathVariable("ProID") int ProID,@PathVariable("taskID") int taskID,Model model){
		model.addAttribute("taskDetail", Task.gettaskDetail(taskID));
		model.addAttribute("comments",com.getCommentsByProjectID(taskID));
		return "TaskPage";
	}
	@RequestMapping(value= "/user/projects/{ProID}/Task/{taskID}/addcomment",method = RequestMethod.GET)
	public String addComment(@RequestParam("comment")String comment,@PathVariable("ProID") int ProID,@PathVariable("taskID") int taskID,Principal principal,Model model){
		comment cm=new comment();
		cm.setDetail(comment);
		cm.setUser_name(principal.getName());
		cm.setTask_id(taskID);
		cm.setProject_id(ProID);
		com.insertData(cm);
		return "redirect:/user/projects/{ProID}/Task/{taskID}/";
	}
	@RequestMapping(value= "/user/projects/{ProID}/Task/{taskID}/ChangeStatus",method = RequestMethod.GET)
	public String ChangeStatus(@RequestParam("status")String status,@PathVariable("ProID") int ProID,@PathVariable("taskID") int taskID,Model model){
		Task.updateStatus(status, taskID);
		return "redirect:/user/projects/{ProID}/Task/{taskID}/";
	}
	//////access denied URL/////
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	  public String accessDenied(Model model, Principal principal) {
	      model.addAttribute("title", "Access Denied!");
	 
	      if (principal != null) {
	          model.addAttribute("message", "Hi " + principal.getName()
	                  + "<br> You do not have permission to access this page!");
	      } else {
	          model.addAttribute("msg",
	                  "You do not have permission to access this page!");
	      }
	      return "403Page";
	  }
	
}

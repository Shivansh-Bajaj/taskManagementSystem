package co.taskmanagement.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.taskmanagement.ProjectDAO.Project;
import co.taskmanagement.ProjectDAO.projectDAO;
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
	@RequestMapping(value =  "/" , method = RequestMethod.GET)
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
		UserObject.insertData(User);
		return "redirect:/user";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String loginPage(Model model) {
	      model.addAttribute("title", "Login");
	      model.addAttribute("message", "Enter your username/password:");
	      return "loginPage";
	  }
	@RequestMapping(value = "/logoutSuccessful/", method = RequestMethod.GET)
	  public String logoutSuccessfulPage(Model model) {
	      model.addAttribute("title", "Logout");
	      return "logoutSuccessfullPage";
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
//	@RequestMapping(value= "/user/search/", method=RequestMethod.GET)
//	public string search()
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
		System.out.println(ProID);
		Task.insertData(TASK);
		return "redirect:/user/projects/"+ProID+"/" ;
	}
	@RequestMapping(value= "/user/projects/{ProID}/Task/{taskID}/",method = RequestMethod.GET)
	public String projectInfo(@PathVariable("ProID") int ProID,@PathVariable("taskID") int taskID,Model model){
		model.addAttribute("taskDetail", Task.gettaskDetail(taskID));
		model.addAttribute("comment", com.getCommentsByProjectID(taskID));
		return "taskInfo";
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

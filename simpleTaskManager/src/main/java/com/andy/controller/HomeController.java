package com.andy.controller;


import com.andy.dao.DeveloperDAO;
import com.andy.dao.ManagerDAO;
import com.andy.dao.ProjectDAO;
import com.andy.dao.TaskDAO;
import com.andy.model.Developer;
import com.andy.model.Manager;
        import com.andy.model.Project;
import com.andy.model.Task;
import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.ModelMap;
        import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
        import java.util.ArrayList;
import java.util.Set;


@Controller
//@RequestMapping(value = {"/", "/home"})
public class HomeController {
    private ManagerDAO managerDAO;
    private DeveloperDAO developerDAO;
    private ProjectDAO projectDAO;
    private TaskDAO taskDAO;

    @Inject
    public HomeController(ManagerDAO managerDAO, DeveloperDAO developerDAO, ProjectDAO projectDAO, TaskDAO taskDAO) {
        this.managerDAO = managerDAO;
        this.developerDAO = developerDAO;
        this.projectDAO = projectDAO;
        this.taskDAO = taskDAO;
    }


    @RequestMapping(method = RequestMethod.GET, value = {"/", "/home"})
    public String getHome(ModelMap modelMap){
        return "views/home";
    }

    @RequestMapping(value = "/getProjects", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<String> getProjects(){

        Manager manager = managerDAO.getManagerById(17);

        Set<Project> projects = manager.getProjects();
        ArrayList<String> p = new ArrayList<String>();
        for (Project pr:projects
             ) {
            p.add(pr.getProject_name());
        }
        return p;
    }

    @RequestMapping(value = "/createProject", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    //@ResponseBody
    public void createProject(@Valid @RequestBody Project project, BindingResult bindingResult) {
        System.out.println("here");
        System.out.println(project.getProject_name());

        if (bindingResult.hasErrors()) {
            System.out.println("problem");
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername();
        int id = managerDAO.getIdByManagerLogin(login);
        project.setManager_id(id);
        projectDAO.createNewProject(project);
    }

    @RequestMapping(value = "/getTasks", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<Task> getTasks(){
        int projectId = 7;
        ArrayList<Task> list = (ArrayList<Task>) taskDAO.getAllProjectTasks(projectId);
        return list;
    }

    @RequestMapping(value = "/createTask", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    //@ResponseBody
    public void createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        System.out.println(task.getTask_name());
        if (bindingResult.hasErrors()) {
            System.out.println("problem");
        }
        taskDAO.createNewTask(task);
    }

    @RequestMapping(value = "/findDeveloper", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    //@ResponseBody
    public Developer getDeveloperByName(@RequestBody Developer developer) {
        Developer developerResult = developerDAO.getDeveloperByName(developer);
        return developerResult;
    }
}


/*
package com.andy.controller;

import com.andy.dao.ManagerDAO;
import com.andy.dao.ProjectDAO;
import com.andy.dao.ProjectDAOImpl;
import com.andy.model.Manager;
import com.andy.model.Project;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;


*/
/*@Controller*//*

@RestController
@RequestMapping("/managers")
public class ConcreteManagerController {
    private ManagerDAO managerDAO;
    private ProjectDAO projectDAO;

    @Inject
    public ConcreteManagerController(ManagerDAO managerDAO, ProjectDAO projectDAO) {
        this.managerDAO = managerDAO;
        this.projectDAO = projectDAO;
    }


    //Request param явно указывает имя переменной переданной в url, если явно не указать то спринг будут
    // свзывать по имени в url и в методе
    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String infoManager(*/
/*@RequestParam("id") int user_id,*//*
 Model model){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername();
        int user_id = managerDAO.getIdByManagerLogin(login);
        List<Manager> list = managerDAO.list();
        Manager m = managerDAO.getManagerById(user_id);

        if (m.getUser_login().equals(login)) {
            List<Project> projects = projectDAO.getAllManagerProjects(user_id);
            model.addAttribute("manager", m);
            model.addAttribute("projects", projects);
            return "views/info";
        } else
            return "views/permissionError";
    }

    @RequestMapping(value = "showProjects", method = RequestMethod.GET)
    public @ResponseBody List<Project> showProjects(@RequestParam("id") int user_id){
*/
/*        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername();
        int user_id = managerDAO.getIdByManagerLogin(login);*//*


        List<Project> projects = projectDAO.getAllManagerProjects(user_id);
        String s = "";
        for (Project p:projects
             ) {
            s = s.concat(p.getProject_name());
        }
        return projects;
    }



    @RequestMapping(value = "/manager", method = RequestMethod.GET, params = "new")
    public String ManagerCreateNewProject(Model model) {
        model.addAttribute(new Project());
        return "views/newProject";


    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    public String addProjectFromForm(@Valid Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/newProject";
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = userDetails.getUsername();
        int id = managerDAO.getIdByManagerLogin(login);
        project.setUser_id(id);
        projectDAO.createNewProject(project);
        return "redirect:/managers/manager";
    }

    */
/*обработчик для отображения параметризированного пути*//*

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String showManagerProfile(@PathVariable int userId, Model model) {
        */
/*model.addAttribute(managerDAO.getManagerById(id));*//*

        List<Manager> list = managerDAO.list();
        Manager m = new Manager();
        for (Manager manager:list
                ) {
            if (manager.getUser_id() == userId){
                m = manager;
            }
        }
        model.addAttribute(m);
        return "views/info";
    }

}
*/

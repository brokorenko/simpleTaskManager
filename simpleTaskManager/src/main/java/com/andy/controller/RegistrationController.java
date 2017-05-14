/*
package com.andy.controller;

import com.andy.dao.ManagerDAO;
import com.andy.model.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;

*/
/**
 * Created by Andrew on 25.03.2017.
 *//*

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private ManagerDAO managerDAO;

    @Inject
    public RegistrationController(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String newManager(Model model) {
        model.addAttribute(new Manager());
        return "views/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    */
/*Valid - объект будет подвергаться проверке*//*

    public String addManagerFromForm(@Valid Manager manager, BindingResult result){
        if (result.hasErrors()){
            return "views/register";
        }
        System.out.println(manager);
        managerDAO.save(manager);
        return "redirect:/managers/";
    }
}
*/

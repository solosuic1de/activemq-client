package com.mycompany.server.controller;

import com.mycompany.server.model.entity.Employee;
import com.mycompany.server.service.MessageService;
import com.mycompany.server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

/**
 * @author imssbora
 */
@Controller
public class CRUDController {
    @Autowired
  private  MessageService messageService;
    private static final String EMPLOYEE = "employee";


    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("message", "Hello Spring MVC!");
        return "index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) throws InterruptedException, ExecutionException {
        String uuid = messageService.sendMessage(JsonUtils.getAllMessage());
        model.addAttribute("list", JsonUtils.getList(messageService.getMessage(uuid)));
        return "getall";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String getById(Model model, @PathVariable String id) throws InterruptedException, ExecutionException {
        String uuid = messageService.sendMessage(JsonUtils.getByIdMessage(Integer.parseInt(id)));
        String response;
        try {
            response = messageService.getMessage(uuid);
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "getbyid";
        }
        model.addAttribute(EMPLOYEE, JsonUtils.getEmployee(response));
        return "getbyid";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add", "employee", new Employee());
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute(EMPLOYEE) Employee employee,
                         BindingResult result, ModelMap model) throws ExecutionException, InterruptedException {
        if (result.hasErrors()) {
            return "error";
        }
        String uuid = messageService.sendMessage(JsonUtils.addMessage(employee));
        model.addAttribute(EMPLOYEE, JsonUtils.getEmployee(messageService.getMessage(uuid)));
        return "getbyid";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable String id) throws InterruptedException, ExecutionException {
        String uuid = messageService.sendMessage(JsonUtils.deleteMessage(Integer.parseInt(id)));
        String response;
        try {
            response = messageService.getMessage(uuid);
        } catch (NoSuchElementException e) {
            model.addAttribute("error", e.getMessage());
            return "getall";
        }
        return "redirect:/getAll";
    }


}

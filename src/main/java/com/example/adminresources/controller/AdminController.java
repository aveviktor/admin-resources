package com.example.adminresources.controller;

import com.example.adminresources.bean.NewExerciseCommand;
import com.example.adminresources.service.AdminService;
import com.example.adminresources.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/")
    public String index() {
        return BaseService.ADMIN_PAGE;
    }

    @RequestMapping("/admin")
    public String admin() {
        return BaseService.ADMIN_PAGE;
    }

    @RequestMapping("/addExercise")
    @ResponseBody
    public ModelAndView addExercise() {
        return adminService.addExercise();
    }

    @RequestMapping("/saveNewExercise")
    @ResponseBody
    public ModelAndView saveNewExercise(@ModelAttribute @Valid NewExerciseCommand newExerciseCommand, BindingResult bindingResult) {
        return adminService.saveNewExercise(newExerciseCommand, bindingResult);
    }

    @RequestMapping("/showApprovingPage")
    @ResponseBody
    ModelAndView showApprovingPage() { return adminService.showApprovingPage(); }

    @RequestMapping("/showExistedExercises")
    @ResponseBody
    ModelAndView showExistedExercises() { return adminService.showExistedExercises(); }

}

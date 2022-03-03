package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProject() {
        System.out.println("Invoking add project.");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProject() {
        System.out.println("Invoking save project.");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"type=multi"})
    public String yearProject() {
        System.out.println("Invoking year project.");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"type=multi","special"})
    public String specialProject() {
        System.out.println("Invoking special project.");
        return "project_add";
    }


}

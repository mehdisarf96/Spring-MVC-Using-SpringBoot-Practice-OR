package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.controller;

import com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.entity.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class MainController {

    @RequestMapping("/")
    public String greeting(Model model) {

        Project project = new Project();
        project.setName("Mehdi's Spring MVC Project");
        project.setSponsor("Mehdi Sarf");
        project.setDescription("This is my MVC project.");

        model.addAttribute("myCurrentProject", project);

        return "home";
    }
}

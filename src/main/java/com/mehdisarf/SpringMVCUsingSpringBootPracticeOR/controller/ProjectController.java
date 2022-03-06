package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.controller;

import com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.entity.Project;
import com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/{projectId}")
    public String findProject(@PathVariable("projectId") Long projectIdValue, Model model) {
        model.addAttribute("project", projectService.find(projectIdValue));
        return "project";
    }

    @RequestMapping(value = "/find")
    public String find(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

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

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"type=multi", "special"})
    public String specialProject() {
        System.out.println("Invoking special project.");
        return "project_add";
    }
}

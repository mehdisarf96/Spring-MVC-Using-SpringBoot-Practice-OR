package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.controller;

import com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String addProject(HttpSession session) {

        session.setAttribute("token", "12345");
        System.out.println("Invoking add project.");
        return "project_add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProject(HttpServletRequest request, HttpSession session) {

        System.out.println(request.getParameter("name"));
        System.out.println(session.getAttribute("token"));

        System.out.println("Invoking save project.");
        return "project_add";
    }

    // In 2 method yekar ro anjam midan o farqi nadaran. in va balayii.
    /*
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProject(@RequestParam("name") String name, HttpSession session) {

        System.out.println(name);
        System.out.println(session.getAttribute("token"));

        System.out.println("Invoking save project.");
        return "project_add";
    }
     */

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

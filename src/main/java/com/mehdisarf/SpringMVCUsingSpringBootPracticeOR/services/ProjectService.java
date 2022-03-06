package com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.mehdisarf.SpringMVCUsingSpringBootPracticeOR.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectService {

    private List<Project> projects = new LinkedList<>();

    public ProjectService() {

        Project javaProject = this.createProject("Java Project", "This is a Java Project", 1L);
        Project javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project", 2L);
        Project htmlProject = this.createProject("HTML Project", "This is an HTML project", 3L);

        projects.addAll(Arrays.asList(new Project[]{javaProject, javascriptProject, htmlProject}));
    }

    private Project createProject(String title, String description, Long id) {
        Project project = new Project();
        project.setName(title);
        project.setAuthorizedFunds(new BigDecimal("100000"));
        project.setAuthorizedHours(new BigDecimal("1000"));
        project.setProjectId(id);
        project.setSpecial(false);
        project.setType("multi");
        project.setYear("2015");
        project.setDescription(description);
        return project;
    }

    public List<Project> findAll() {
        return projects;
    }

    public Project find(Long projectId) {
        return this.projects.stream().filter(p -> {
            return p.getProjectId().equals(projectId);
        }).collect(Collectors.toList()).get(0);
    }
}

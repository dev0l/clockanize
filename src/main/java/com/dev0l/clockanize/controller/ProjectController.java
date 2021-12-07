package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Project;
import com.dev0l.clockanize.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @Autowired
  private LocationService locationService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private EducationService educationService;

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/projects")
  public String showProjects(Model model) {
    model.addAttribute("projects", projectService.findAllProjects());
    model.addAttribute("locations", locationService.findAllLocations());
    model.addAttribute("clients", clientService.findAllClients());
    model.addAttribute("educations", educationService.findAllEducations());
    model.addAttribute("employees", employeeService.findAllEmployees());
    return "project";
  }

  @PostMapping("projects/add")
  public String add(Project project) {
    projectService.save(project);
    return "redirect:/projects";
  }

  @RequestMapping("projects/edit")
  @ResponseBody
  public Optional<Project> findById(int id) {
    return projectService.findById(id);
  }

  @RequestMapping(value="/projects/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Project project) {
    projectService.save(project);
    return "redirect:/projects";
  }

  @RequestMapping(value="/projects/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    projectService.delete(id);
    return "redirect:/projects";
  }

}
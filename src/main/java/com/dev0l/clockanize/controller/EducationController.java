package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Education;
import com.dev0l.clockanize.service.*;
import com.dev0l.clockanize.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EducationController {

  @Autowired
  private EducationService educationService;

  @Autowired
  private EducationTypeService educationTypeService;

  @Autowired
  private EducationStatusService educationStatusService;

  @Autowired
  private ProjectService projectService;

  @GetMapping("/educations")
  public String showEducations(Model model) {
    model.addAttribute("projects", projectService.findAllProjects());
    model.addAttribute("educations", educationService.findAllEducations());
    model.addAttribute("educationTypes", educationTypeService.findAllEducationTypes());
    model.addAttribute("educationStatus", educationStatusService.findAllEducationStatus());
    return "education";
  }

  @PostMapping("educations/add")
  public String add(Education education) {
    educationService.save(education);
    return "redirect:/educations";
  }

  @RequestMapping("educations/edit")
  @ResponseBody
  public Optional<Education> findById(int id) {
    return educationService.findById(id);
  }

  @RequestMapping(value="/educations/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Education education) {
    educationService.save(education);
    return "redirect:/educations";
  }

  @RequestMapping(value="/educations/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    educationService.delete(id);
    return "redirect:/educations";
  }

}
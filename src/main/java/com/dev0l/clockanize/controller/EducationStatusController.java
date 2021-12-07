package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.EducationStatus;
import com.dev0l.clockanize.service.EducationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EducationStatusController {

  @Autowired
  private EducationStatusService educationStatusService;

  @GetMapping("/education-status")
  public String showEducationStatus(Model model) {
    List<EducationStatus> educationStatusList = educationStatusService.findAllEducationStatus();
    model.addAttribute("educationStatus", educationStatusList);
    return "education-status";
  }

  @PostMapping("education-status/add")
  public String add(EducationStatus educationStatus) {
    educationStatusService.save(educationStatus);
    return "redirect:/education-status";
  }

  @RequestMapping("education-status/edit")
  @ResponseBody
  public Optional<EducationStatus> findById(int id) {
    return educationStatusService.findById(id);
  }

  @RequestMapping(value="/education-status/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(EducationStatus educationStatus) {
    educationStatusService.save(educationStatus);
    return "redirect:/education-status";
  }

  @RequestMapping(value="/education-status/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    educationStatusService.delete(id);
    return "redirect:/education-status";
  }

}
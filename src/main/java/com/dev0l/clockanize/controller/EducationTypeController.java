package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.EducationType;
import com.dev0l.clockanize.service.EducationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EducationTypeController {

  @Autowired
  private EducationTypeService educationTypeService;

  @GetMapping("/education-types")
  public String showEducationTypes(Model model) {
    List<EducationType> educationTypeList = educationTypeService.findAllEducationTypes();
    model.addAttribute("educationTypes", educationTypeList);
    return "education-type";
  }

  @PostMapping("education-types/add")
  public String add(EducationType educationType) {
    educationTypeService.save(educationType);
    return "redirect:/education-types";
  }

  @RequestMapping("education-types/edit")
  @ResponseBody
  public Optional<EducationType> findById(int id) {
    return educationTypeService.findById(id);
  }

  @RequestMapping(value="/education-types/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(EducationType educationType) {
    educationTypeService.save(educationType);
    return "redirect:/education-types";
  }

  @RequestMapping(value="/education-types/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    educationTypeService.delete(id);
    return "redirect:/education-types";
  }

}
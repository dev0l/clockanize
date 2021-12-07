package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.EmployeeType;
import com.dev0l.clockanize.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

  @Autowired
  private EmployeeTypeService employeeTypeService;

  @GetMapping("/employee-types")
  public String showEmployeeTypes(Model model) {
    List<EmployeeType> employeeTypeList = employeeTypeService.findAllEmployeeTypes();
    model.addAttribute("employeeTypes", employeeTypeList);
    return "employee-type";
  }

  @PostMapping("employee-types/add")
  public String add(EmployeeType employeeType) {
    employeeTypeService.save(employeeType);
    return "redirect:/employee-types";
  }

  @RequestMapping("employee-types/edit")
  @ResponseBody
  public Optional<EmployeeType> findById(int id) {
    return employeeTypeService.findById(id);
  }

  @RequestMapping(value="/employee-types/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(EmployeeType employeeType) {
    employeeTypeService.save(employeeType);
    return "redirect:/employee-types";
  }

  @RequestMapping(value="/employee-types/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    employeeTypeService.delete(id);
    return "redirect:/employee-types";
  }

}
package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Employee;
import com.dev0l.clockanize.service.EmployeeService;
import com.dev0l.clockanize.service.EmployeeStatusService;
import com.dev0l.clockanize.service.EmployeeTypeService;
import com.dev0l.clockanize.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private EmployeeTypeService employeeTypeService;

  @Autowired
  private EmployeeStatusService employeeStatusService;

  @Autowired
  private JobTitleService jobTitleService;

  @GetMapping("/employees")
  public String showEmployees(Model model) {
    model.addAttribute("employees", employeeService.findAllEmployees());
    model.addAttribute("employeeTypes", employeeTypeService.findAllEmployeeTypes());
    model.addAttribute("employeeStatus", employeeStatusService.findAllEmployeeStatus());
    model.addAttribute("jobTitles", jobTitleService.findAllJobTitles());
    return "employee";
  }

  @PostMapping("employees/add")
  public String add(Employee employee) {
    employeeService.save(employee);
    return "redirect:/employees";
  }

  @RequestMapping("employees/edit")
  @ResponseBody
  public Optional<Employee> findById(int id) {
    return employeeService.findById(id);
  }

  @RequestMapping(value="/employees/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Employee employee) {
    employeeService.save(employee);
    return "redirect:/employees";
  }

  @RequestMapping(value="/employees/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    employeeService.delete(id);
    return "redirect:/employees";
  }

  //Assign Employee Username
  @RequestMapping(value = "/employees/assignUsername")
  public  String assignUsername(int id) {
    employeeService.assignUsername(id);
    return "redirect:/employees";
  }

}
package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.EmployeeStatus;
import com.dev0l.clockanize.service.EmployeeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeStatusController {

  @Autowired
  private EmployeeStatusService employeeStatusService;

  @GetMapping("/employee-status")
  public String showEmployeeStatus(Model model) {
    List<EmployeeStatus> employeeStatusList = employeeStatusService.findAllEmployeeStatus();
    model.addAttribute("employeeStatus", employeeStatusList);
    return "employee-status";
  }

  @PostMapping("employee-status/add")
  public String add(EmployeeStatus employeeStatus) {
    employeeStatusService.save(employeeStatus);
    return "redirect:/employee-status";
  }

  @RequestMapping("employee-status/edit")
  @ResponseBody
  public Optional<EmployeeStatus> findById(int id) {
    return employeeStatusService.findById(id);
  }

  @RequestMapping(value="/employee-status/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(EmployeeStatus employeeStatus) {
    employeeStatusService.save(employeeStatus);
    return "redirect:/employee-status";
  }

  @RequestMapping(value="/employee-status/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    employeeStatusService.delete(id);
    return "redirect:/employee-status";
  }

}
package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.service.EmployeeService;
import com.dev0l.clockanize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class ProfileController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private UserService userService;

  @RequestMapping(value="/profile")
  public String profile(Model model, Principal principal) {
    String un = principal.getName();
    model.addAttribute("employee", employeeService.findByUsername(un));
    model.addAttribute("user", userService.findByUsername(un));
    return "user-profile";
  }

}
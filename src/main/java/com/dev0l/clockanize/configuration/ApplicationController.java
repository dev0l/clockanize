package com.dev0l.clockanize.configuration;

import com.dev0l.clockanize.entity.TimeCard;
import com.dev0l.clockanize.service.EmployeeService;
import com.dev0l.clockanize.service.ProjectService;
import com.dev0l.clockanize.service.TimeCardService;
import com.dev0l.clockanize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Collection;

@Controller
public class ApplicationController {

  @Autowired
  private UserService userService;

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private TimeCardService timeCardService;

  private void currentUser(Model model, TimeCard timeCard, Principal principal) {
    String un = principal.getName();
    model.addAttribute("user", userService.findByUsername(un));
    model.addAttribute("employee", employeeService.findByUsername(un));
    model.addAttribute("projects", projectService.findAllProjects());
    model.addAttribute("timeCards", timeCardService.findAllTimeCards());
    model.addAttribute("weekLists", timeCard.getWeek());
  }

  @RequestMapping(value="/")
  public String home(Model model, TimeCard timeCard, Principal principal) {
    currentUser(model, timeCard, principal);
    return "index";
  }

  @RequestMapping(value="/dashboard")
  public String admin(Model model, TimeCard timeCard, Principal principal) {
    currentUser(model, timeCard, principal);
    return "admin-dashboard";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/logout")
  public String logout() {
    return "login";
  }

  @GetMapping("/register")
  public String register() {
    return "register";
  }

  @GetMapping("/access-denied")
  public String accessDenied() {
    return "access-denied";
  }

  @RequestMapping(value= {"/success-handler"}, method={RequestMethod.GET})
  public String defaultAfterLogin() {
    Collection<? extends GrantedAuthority> authorities;
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    authorities = auth.getAuthorities();
    String myRole = authorities.toArray()[0].toString();
    String admin = "ADMIN";

    if (myRole.equals(admin)) {
      return "redirect:/dashboard";
    }

    return "redirect:/";
  }

}
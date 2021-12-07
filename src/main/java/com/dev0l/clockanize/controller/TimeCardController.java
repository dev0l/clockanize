package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.TimeCard;
import com.dev0l.clockanize.service.EmployeeService;
import com.dev0l.clockanize.service.ProjectService;
import com.dev0l.clockanize.service.TimeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class TimeCardController {

  @Autowired
  private TimeCardService timeCardService;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private EmployeeService employeeService;

  // ##### EMPLOYEE/PROJECT TIMECARDS #####
//  @RequestMapping(value="/time-cards")
//  public String showTimeCards(Model model, Principal principal) {

//    code here... (Employee TimeCards / Project TimeCards???)

//    return "time-card";
//  }

  // ##### REPORTED TIMECARDS #####
  @GetMapping("/reports")
  public String showReports(Model model, TimeCard timeCard, Principal principal) {
    String un = principal.getName();
    model.addAttribute("employee", employeeService.findByUsername(un));
    model.addAttribute("projects", projectService.findAllProjects());
    model.addAttribute("employees", employeeService.findAllEmployees());
    model.addAttribute("timeCards", timeCardService.findAllTimeCards());
    model.addAttribute("weekLists", timeCard.getWeek());
    return "report";
  }

  @PostMapping("time-cards/add")
  public String add(TimeCard timeCard, Authentication authentication) {
    timeCardService.save(timeCard);
    if (authentication.getAuthorities().stream().anyMatch(ga -> ga.getAuthority().equals("ADMIN"))) {
      return "redirect:/reports";
    }
    return "redirect:/";
  }

  @RequestMapping("time-cards/edit")
  @ResponseBody
  public Optional<TimeCard> findById(int id, TimeCard timeCard) {
    timeCard.getTimeDifference();
    return timeCardService.findById(id);
  }

  @RequestMapping(value="/time-cards/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(TimeCard timeCard) {
    timeCardService.save(timeCard);
    return "redirect:/time-cards";
  }

  @RequestMapping(value="/time-cards/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    timeCardService.delete(id);
    return "redirect:/time-cards";
  }

}
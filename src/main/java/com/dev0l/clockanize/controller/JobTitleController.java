package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.JobTitle;
import com.dev0l.clockanize.service.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {

  @Autowired
  private JobTitleService jobTitleService;

  @GetMapping("/job-titles")
  public String showJobTitles(Model model) {
    List<JobTitle> jobTitleList = jobTitleService.findAllJobTitles();
    model.addAttribute("jobTitles", jobTitleList);
    return "job-title";
  }

  @PostMapping("job-titles/add")
  public String add(JobTitle jobTitle) {
    jobTitleService.save(jobTitle);
    return "redirect:/job-titles";
  }

  @RequestMapping("job-titles/edit")
  @ResponseBody
  public Optional<JobTitle> findById(int id) {
    return jobTitleService.findById(id);
  }

  @RequestMapping(value="/job-titles/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(JobTitle jobTitle) {
    jobTitleService.save(jobTitle);
    return "redirect:/job-titles";
  }

  @RequestMapping(value="/job-titles/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    jobTitleService.delete(id);
    return "redirect:/job-titles";
  }

}
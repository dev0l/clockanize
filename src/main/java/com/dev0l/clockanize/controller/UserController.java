package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public String showUsers(Model model) {
    List<User> userList = userService.findAllUsers();
    model.addAttribute("users", userList);
    return "user";
  }

  // ### Modified method to Add a new user User because 'redirect' removes all model attributes ###
  @PostMapping(value="users/add")
  public RedirectView add(User user, RedirectAttributes redir) {
    userService.save(user);
    RedirectView  redirectView= new RedirectView("/login",true);
    redir.addFlashAttribute("message",
            "You successfully registered! You can now login");
    return redirectView;
  }

  @RequestMapping("users/edit")
  @ResponseBody
  public User findById(int id) {
    return userService.findById(id);
  }

  @RequestMapping(value="/users/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(User user) {
    userService.save(user);
    return "redirect:/users";
  }

  @RequestMapping(value="/users/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    userService.delete(id);
    return "redirect:/users";
  }

}
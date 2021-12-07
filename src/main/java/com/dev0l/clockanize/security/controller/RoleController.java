package com.dev0l.clockanize.security.controller;

import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.security.entity.Role;
import com.dev0l.clockanize.security.service.RoleService;
import com.dev0l.clockanize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {

  @Autowired
  private RoleService roleService;

  @Autowired
  private UserService userService;

  @GetMapping("/roles")
  public String roles(Model model) {
    List<Role> roleList = roleService.findAllRoles();
    model.addAttribute("roles", roleList);
    return "role";
  }

  @PostMapping("roles/add")
  public String add(Role role) {
    roleService.save(role);
    return "redirect:/roles";
  }

  @RequestMapping("roles/edit")
  @ResponseBody
  public Optional<Role> findById(int id) {
    return roleService.findById(id);
  }

  @RequestMapping(value="/roles/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Role role) {
    roleService.save(role);
    return "redirect:/roles";
  }

  @RequestMapping(value="/roles/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    roleService.delete(id);
    return "redirect:/roles";
  }

  @GetMapping("/security/user/edit/{id}")
  public String editUserRole(@PathVariable Integer id, Model model){
    User user = userService.findById(id);
    model.addAttribute("user", user);
    model.addAttribute("userRoles", roleService.getUserRoles(user));
    model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
    return "/user-edit";
  }

  @RequestMapping("/security/role/assign/{userId}/{roleId}")
  public String assignRole(@PathVariable Integer userId,
                           @PathVariable Integer roleId){
    roleService.assignUserRole(userId, roleId);
    return "redirect:/security/user/edit/"+userId;
  }

  @RequestMapping("/security/role/unassign/{userId}/{roleId}")
  public String unassignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId){
    roleService.unassignUserRole(userId, roleId);
    return "redirect:/security/user/edit/"+userId;
  }
  
}
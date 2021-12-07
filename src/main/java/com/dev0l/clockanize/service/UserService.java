package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.repository.UserRepository;
import com.dev0l.clockanize.security.entity.Role;
import com.dev0l.clockanize.security.repository.RoleRepository;
import com.dev0l.clockanize.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private RoleRepository roleRepo;

  @Autowired
  private RoleService roleService;

  public List<User> findAllUsers() {
    return userRepo.findAll();
  }

  public void save(User user) {
    Role roleUser = roleRepo.findRoleByDescription("USER");
    user.addRole(roleUser);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
  }

  public User findById(int id) {
    return userRepo.findById(id).orElse(null);
  }

  public User findByUsername(String un) {
    return userRepo.findByUsername(un);
  }

  public void delete(int id) {
    roleService.unassignAllUserRoles(id);
    userRepo.deleteById(id);
  }

}
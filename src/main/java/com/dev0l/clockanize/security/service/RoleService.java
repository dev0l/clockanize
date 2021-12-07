package com.dev0l.clockanize.security.service;

import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.repository.UserRepository;
import com.dev0l.clockanize.security.entity.Role;
import com.dev0l.clockanize.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepo;

  @Autowired
  private UserRepository userRepo;

  public List<Role> findAllRoles() {
    return roleRepo.findAll();
  }

  public void save(Role role) {
    roleRepo.save(role);
  }

  public Optional<Role> findById(int id) {
    return roleRepo.findById(id);
  }

  public void delete(int id) {
    roleRepo.deleteById(id);
  }

  // Assign Role to User
  public void assignUserRole(Integer userId, Integer roleId){
    User user  = userRepo.findById(userId).orElse(null);
    Role role = roleRepo.findById(roleId).orElse(null);
    Set<Role> userRoles = user.getRoles();
    userRoles.add(role);
    user.setRoles(userRoles);
    userRepo.save(user);
  }

  // Unassign Role from User
  public void unassignUserRole(Integer userId, Integer roleId){
    User user  = userRepo.findById(userId).orElse(null);
    user.getRoles().removeIf(x -> x.getId()==roleId);
    userRepo.save(user);
  }

  // Unassign All Roles from User
  public void unassignAllUserRoles(Integer userId){
    User user  = userRepo.findById(userId).orElse(null);
    Set<Role> userRoles = user.getRoles();
    userRoles.forEach(role -> {
      userRoles.remove(role);
    });
    userRepo.save(user);
  }

  public Set<Role> getUserRoles(User user){
    return user.getRoles();
  }

  public List<Role> getUserNotRoles(User user){
    return roleRepo.getUserNotRoles(user.getId());
  }
  
}
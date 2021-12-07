package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Employee;
import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.repository.EmployeeRepository;
import com.dev0l.clockanize.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepo;

  @Autowired
  private UserRepository userRepo;

  public List<Employee> findAllEmployees() {
    return employeeRepo.findAll();
  }

  public void save(Employee employee) {
    employeeRepo.save(employee);
  }

  public Optional<Employee> findById(int id) {
    return employeeRepo.findById(id);
  }

  public Employee findByUsername(String un) {
    return employeeRepo.findByUsername(un);
  }

  public void delete(int id) {
    employeeRepo.deleteById(id);
  }

//  public List<Employee> findByKeyword(String keyword) {
//    return employeeRepo.findByKeyword(keyword);
//  }

  // Set the Username of the employee where firstname, lastname and othername match
  public void assignUsername(int id){
    Employee employee = employeeRepo.findById(id).orElse(null);
    User user = userRepo.findByFirstnameAndOthernameAndLastname(
            employee.getFirstname(),
            employee.getOthername(),
            employee.getLastname());
    employee.setUsername(user.getUsername());
    employeeRepo.save(employee);
  }

}
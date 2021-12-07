package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.EmployeeStatus;
import com.dev0l.clockanize.repository.EmployeeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeStatusService {

  @Autowired
  private EmployeeStatusRepository employeeStatusRepo;

  public List<EmployeeStatus> findAllEmployeeStatus() {
    return employeeStatusRepo.findAll();
  }

  public void save(EmployeeStatus employeeStatus) {
    employeeStatusRepo.save(employeeStatus);
  }

  public Optional<EmployeeStatus> findById(int id) {
    return employeeStatusRepo.findById(id);
  }

  public void delete(int id) {
    employeeStatusRepo.deleteById(id);
  }

}
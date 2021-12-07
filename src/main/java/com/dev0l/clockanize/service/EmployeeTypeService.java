package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.EmployeeType;
import com.dev0l.clockanize.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

  @Autowired
  private EmployeeTypeRepository employeeTypeRepo;

  public List<EmployeeType> findAllEmployeeTypes() {
    return employeeTypeRepo.findAll();
  }

  public void save(EmployeeType employeeType) {
    employeeTypeRepo.save(employeeType);
  }

  public Optional<EmployeeType> findById(int id) {
    return employeeTypeRepo.findById(id);
  }

  public void delete(int id) {
    employeeTypeRepo.deleteById(id);
  }

}
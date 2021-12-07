package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  Employee findByUsername(String un);

//  List<Employee> findByKeywordsIn(List<String> keywords);
//  List<Employee> findByKeyword(String keyword);

}
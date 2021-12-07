package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {

}
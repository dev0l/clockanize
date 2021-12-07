package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer> {

}
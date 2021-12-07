package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.EducationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationStatusRepository extends JpaRepository<EducationStatus, Integer> {

}
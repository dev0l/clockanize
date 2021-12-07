package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.EducationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationType, Integer> {

}
package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Education;
import com.dev0l.clockanize.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

  @Autowired
  private EducationRepository educationRepo;

  public List<Education> findAllEducations() {
    return educationRepo.findAll();
  }

  public void save(Education education) {
    educationRepo.save(education);
  }

  public Optional<Education> findById(int id) {
    return educationRepo.findById(id);
  }

  public void delete(int id) {
    educationRepo.deleteById(id);
  }

}
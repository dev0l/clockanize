package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.EducationStatus;
import com.dev0l.clockanize.repository.EducationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationStatusService {

  @Autowired
  private EducationStatusRepository educationStatusRepo;

  public List<EducationStatus> findAllEducationStatus() {
    return educationStatusRepo.findAll();
  }

  public void save(EducationStatus educationStatus) {
    educationStatusRepo.save(educationStatus);
  }

  public Optional<EducationStatus> findById(int id) {
    return educationStatusRepo.findById(id);
  }

  public void delete(int id) {
    educationStatusRepo.deleteById(id);
  }

}
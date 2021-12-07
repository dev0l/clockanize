package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.EducationType;
import com.dev0l.clockanize.repository.EducationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationTypeService {

  @Autowired
  private EducationTypeRepository educationTypeRepo;

  public List<EducationType> findAllEducationTypes() {
    return educationTypeRepo.findAll();
  }

  public void save(EducationType educationType) {
    educationTypeRepo.save(educationType);
  }

  public Optional<EducationType> findById(int id) {
    return educationTypeRepo.findById(id);
  }

  public void delete(int id) {
    educationTypeRepo.deleteById(id);
  }

}
package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.JobTitle;
import com.dev0l.clockanize.repository.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {

  @Autowired
  private JobTitleRepository jobTitleRepo;

  public List<JobTitle> findAllJobTitles() {
    return jobTitleRepo.findAll();
  }

  public void save(JobTitle jobTitle) {
    jobTitleRepo.save(jobTitle);
  }

  public Optional<JobTitle> findById(int id) {
    return jobTitleRepo.findById(id);
  }

  public void delete(int id) {
    jobTitleRepo.deleteById(id);
  }

}
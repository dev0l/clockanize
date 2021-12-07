package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Project;
import com.dev0l.clockanize.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepo;

  public List<Project> findAllProjects() {
    return projectRepo.findAll();
  }

  public void save(Project project) {
    projectRepo.save(project);
  }

  public Optional<Project> findById(int id) {
    return projectRepo.findById(id);
  }

  public void delete(int id) {
    projectRepo.deleteById(id);
  }

}
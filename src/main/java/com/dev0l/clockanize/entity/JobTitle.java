package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.CommonObject;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "job_titles")
public class JobTitle extends CommonObject {

  @OneToMany(mappedBy="jobTitle")
  private List<Employee> employees;

}
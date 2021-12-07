package com.dev0l.clockanize.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "employees")
public class Employee extends Person {

  @Column(unique=true)
  private String username;

  private String photo;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate hireDate;

  @ManyToOne
  @JoinColumn(name="employeetype_id", insertable=false, updatable=false)
  private EmployeeType employeeType;
  private Integer employeetype_id;

  @ManyToOne
  @JoinColumn(name="employeestatus_id", insertable=false, updatable=false)
  private EmployeeStatus employeeStatus;
  private Integer employeestatus_id;

  @ManyToOne
  @JoinColumn(name="jobtitle_id", insertable=false, updatable=false)
  private JobTitle jobTitle;
  private Integer jobtitle_id;

  @OneToMany(mappedBy = "owner")
  private List<Project> ownedProjects;

  @OneToMany(mappedBy = "educator")
  private List<Project> activeProjects;

  @OneToMany(mappedBy="timeCardEmployee")
  private List<TimeCard> timeCards;

}
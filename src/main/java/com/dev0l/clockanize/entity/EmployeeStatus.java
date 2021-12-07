package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.CommonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EmployeeStatus extends CommonObject {

  @OneToMany(mappedBy="employeeStatus")
  private List<Employee> employees;

}
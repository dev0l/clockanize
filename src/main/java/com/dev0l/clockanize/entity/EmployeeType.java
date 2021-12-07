package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.CommonObject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "employee_types")
public class EmployeeType extends CommonObject {

  @OneToMany(mappedBy="employeeType")
  private List<Employee> employees;

}
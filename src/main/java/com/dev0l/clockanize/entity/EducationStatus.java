package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.CommonObject;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class EducationStatus extends CommonObject {

  @OneToMany(mappedBy="educationStatus")
  private List<Education> educations;

}
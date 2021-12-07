package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.Auditable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "educations")
public class Education extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  private String name;
  private String description;
  private String course;
  private String remarks;

  @ManyToOne
  @JoinColumn(name="educationtype_id", insertable=false, updatable=false)
  private EducationType educationType;
  private Integer educationtype_id;

  @ManyToOne
  @JoinColumn(name="educationstatus_id", insertable=false, updatable=false)
  private EducationStatus educationStatus;
  private Integer educationstatus_id;

  @OneToMany(mappedBy="education")
  private List<Project> projects;

}
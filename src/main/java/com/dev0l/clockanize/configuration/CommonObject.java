package com.dev0l.clockanize.configuration;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CommonObject extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String description;
  private String details;

  public CommonObject(int id, String description, String details) {
    this.id = id;
    this.description = description;
    this.details = details;
  }

  public CommonObject() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Override
  public String toString() {
    return "CommonObject{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", details='" + details + '\'' +
            '}';
  }

}
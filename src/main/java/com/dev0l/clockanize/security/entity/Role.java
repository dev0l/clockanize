package com.dev0l.clockanize.security.entity;

import com.dev0l.clockanize.configuration.Auditable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper=false)
//@Table(name = "roles")
public class Role extends Auditable<String> {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;

  private String description;
  private String details;

  public Role() {

  }

  public Role(String description) {
    this.description = description;
  }

  public Role(int id) {
    this.id = id;
  }

  public Role(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public int getId() {
    return id;
  }

}
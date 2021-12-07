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
@Table(name = "locations")
public class Location extends Auditable<String>  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private Integer id;

  private String address;
  private String city;

  private String description;
  private String details;

  @OneToMany(mappedBy="location")
  private List<Project> projects;

  @OneToMany(mappedBy="location")
  private List<Client> clients;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
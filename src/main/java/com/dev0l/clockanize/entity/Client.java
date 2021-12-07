package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.Auditable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "clients")
public class Client extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int id;

  private String name;
  private String phone;
  private String mobile;
  private String website;
  private String email;
  private String details;

  @ManyToOne
  @JoinColumn(name="location_id", insertable=false, updatable=false)
  private Location location;
  private Integer location_id;

}
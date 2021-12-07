package com.dev0l.clockanize.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String firstname;
  private String lastname;
  private String othername;
  private String title;
  private String initials;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateOfBirth;

  private String city;
  private String address;
  private String phone;
  private String mobile;

  @Column(unique=true)
  private String email;

  private String photo;

}
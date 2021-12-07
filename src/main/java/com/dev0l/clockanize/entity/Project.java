package com.dev0l.clockanize.entity;

import com.dev0l.clockanize.configuration.Auditable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "projects")
public class Project extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;
  private String description;

  private long educationTime;
  private long plannedTime;
  private long overtime;
  private boolean overdue;

  public long calcTime() {
    if(educationTime > plannedTime) {
      overtime = educationTime - plannedTime;
      overdue = true;
    }
    return overtime;
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;

//  @Column(name = "start_date")
//  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
//  private LocalDateTime startDate;

//  @Column(name = "end_date")
//  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
//  private LocalDateTime endDate;

//  @Column(name = "duration")
//  @Convert(converter = DurationConverter.class)
//  private Duration duration;

  @ManyToOne
  @JoinColumn(name="location_id", insertable=false, updatable=false)
  private Location location;
  private Integer location_id;

  @ManyToOne
  @JoinColumn(name="client_id", insertable=false, updatable=false)
  private Client client;
  private Integer client_id;

  @ManyToOne
  @JoinColumn(name="owner_id", insertable=false, updatable=false)
  private Employee owner;
  private Integer owner_id;

  @ManyToOne
  @JoinColumn(name="education_id", insertable=false, updatable=false)
  private Education education;
  private Integer education_id;

  @ManyToOne
  @JoinColumn(name="educator_id", insertable=false, updatable=false)
  private Employee educator;
  private Integer educator_id;

  @OneToMany(mappedBy="timeCardProject")
  private List<TimeCard> timeCards;

}
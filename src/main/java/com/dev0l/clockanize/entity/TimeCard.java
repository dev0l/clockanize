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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "time_cards")
public class TimeCard extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String details;

  public static List<DayOfWeek> getWeek() {
    List<DayOfWeek> weekList = new ArrayList<>();
    DayOfWeek[] dayOfWeeks = DayOfWeek.values();
    for (int i = 0; i < dayOfWeeks.length; i++) {
      DayOfWeek dayOfWeek = dayOfWeeks[i];
      weekList.add(dayOfWeek);
    }
    DayOfWeek dayToRemove = getDay();
    if (weekList.contains(dayToRemove)) {
      weekList.remove(dayToRemove);
    }
    return weekList;
  }

  public static DayOfWeek getDay() {
    LocalDate todayDate = LocalDate.now();
    DayOfWeek today = todayDate.getDayOfWeek();
    return today;
  }

//  public LocalDateTime getHours() {
//    Duration plannedHours = Duration.between(startTime, endTime);
//    LocalDateTime date = LocalDateTime.now();
//    System.out.println(date);
//    date = (LocalDateTime)plannedHours.addTo(date);
//    System.out.println(date);
//    long hours = plannedHours.toHours();
//    System.out.println(hours);
//    return date;
//  }

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate reportDate;

  @DateTimeFormat(pattern = "HH:mm:ss")
  private LocalTime startTime;

  @DateTimeFormat(pattern = "HH:mm:ss")
  private LocalTime endTime;

//  @Column(name = "start_time")
//  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
//  private LocalDateTime startTime;

//  @Column(name = "end_time")
//  @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
//  private LocalDateTime endTime;

//  @Column(name = "duration")
//  @Convert(converter = DurationConverter.class)
//  private Duration duration;

  public void getTimeDifference() {

    System.out.println("Following values are fixed test values (Check TimeCard.Java and TimeCardController.java -> time-cards/edit). Create a method for startTime and endTime");

    // Parsing Time Period in the format HH:MM:SS
    LocalTime time1 = LocalTime.of(18, 00, 00);
    LocalTime time2 = LocalTime.of(21, 22, 00);

    // Calculating the difference in Hours
    long hours = ChronoUnit.HOURS.between(time1, time2);

    // Calculating the difference in Minutes
    long minutes
            = ChronoUnit.MINUTES.between(time1, time2) % 60;

    // Calculating the difference in Seconds
    long seconds
            = ChronoUnit.SECONDS.between(time1, time2) % 60;

    // Printing the difference
    System.out.println(
            "Difference is " + hours + " hours " + minutes
                    + " minutes " + seconds + " seconds.");
  }

  @ManyToOne
  @JoinColumn(name="project_id", insertable=false, updatable=false)
  private Project timeCardProject;
  private int project_id;

  @ManyToOne
  @JoinColumn(name="employee_id", insertable=false, updatable=false)
  private Employee timeCardEmployee;
  private int employee_id;

}
package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.TimeCard;
import com.dev0l.clockanize.repository.TimeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeCardService {

  @Autowired
  private TimeCardRepository timeCardRepo;

  public List<TimeCard> findAllTimeCards() {
    return timeCardRepo.findAll();
  }

  public void save(TimeCard timeCard) {
    timeCardRepo.save(timeCard);
  }

  public Optional<TimeCard> findById(int id) {
    return timeCardRepo.findById(id);
  }

  public void delete(int id) {
    timeCardRepo.deleteById(id);
  }

}
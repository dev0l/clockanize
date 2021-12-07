package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Location;
import com.dev0l.clockanize.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

  @Autowired
  private LocationRepository locationRepo;

  public List<Location> findAllLocations() {
    return locationRepo.findAll();
  }

  public void save(Location location) {
    locationRepo.save(location);
  }

  public Optional<Location> findById(int id) {
    return locationRepo.findById(id);
  }

  public void delete(int id) {
    locationRepo.deleteById(id);
  }

}
package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Location;
import com.dev0l.clockanize.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LocationController {

  @Autowired
  private LocationService locationService;

  @GetMapping("/locations")
  public String showLocations(Model model) {
    model.addAttribute("locations", locationService.findAllLocations());
    return "location";
  }

  @PostMapping("locations/add")
  public String add(Location location) {
    locationService.save(location);
    return "redirect:/locations";
  }

  @RequestMapping("locations/edit")
  @ResponseBody
  public Optional<Location> findById(int id) {
    return locationService.findById(id);
  }

  @RequestMapping(value="/locations/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Location location) {
    locationService.save(location);
    return "redirect:/locations";
  }

  @RequestMapping(value="/locations/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    locationService.delete(id);
    return "redirect:/locations";
  }

}
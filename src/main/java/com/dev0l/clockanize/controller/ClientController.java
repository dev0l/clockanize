package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Client;
import com.dev0l.clockanize.service.ClientService;
import com.dev0l.clockanize.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private LocationService locationService;

  @GetMapping("/clients")
  public String showClients(Model model) {
    model.addAttribute("clients", clientService.findAllClients());
    model.addAttribute("locations", locationService.findAllLocations());
    return "client";
  }

  @PostMapping("clients/add")
  public String add(Client client) {
    clientService.save(client);
    return "redirect:/clients";
  }

  @RequestMapping("clients/edit")
  @ResponseBody
  public Optional<Client> findById(int id) {
    return clientService.findById(id);
  }

  @RequestMapping(value="/clients/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Client client) {
    clientService.save(client);
    return "redirect:/clients";
  }

  @RequestMapping(value="/clients/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    clientService.delete(id);
    return "redirect:/clients";
  }

}
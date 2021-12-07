package com.dev0l.clockanize.controller;

import com.dev0l.clockanize.entity.Contact;
import com.dev0l.clockanize.service.ContactService;
import com.dev0l.clockanize.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

  @Autowired
  private ContactService contactService;

  @Autowired
  private LocationService locationService;

  @GetMapping("/contacts")
  public String showContacts(Model model) {
    model.addAttribute("contacts", contactService.findAllContacts());
    model.addAttribute("locations", locationService.findAllLocations());
    return "contact";
  }

  @PostMapping("contacts/add")
  public String add(Contact contact) {
    contactService.save(contact);
    return "redirect:/contacts";
  }

  @RequestMapping("contacts/edit")
  @ResponseBody
  public Optional<Contact> findById(int id) {
    return contactService.findById(id);
  }

  @RequestMapping(value="/contacts/update", method={RequestMethod.PUT, RequestMethod.GET})
  public String update(Contact contact) {
    contactService.save(contact);
    return "redirect:/contacts";
  }

  @RequestMapping(value="/contacts/delete", method={RequestMethod.DELETE, RequestMethod.GET})
  public String delete(int id) {
    contactService.delete(id);
    return "redirect:/contacts";
  }

}
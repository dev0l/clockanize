package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Contact;
import com.dev0l.clockanize.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

  @Autowired
  private ContactRepository contactRepo;

  public List<Contact> findAllContacts() {
    return contactRepo.findAll();
  }

  public void save(Contact contact) {
    contactRepo.save(contact);
  }

  public Optional<Contact> findById(int id) {
    return contactRepo.findById(id);
  }

  public void delete(int id) {
    contactRepo.deleteById(id);
  }

}
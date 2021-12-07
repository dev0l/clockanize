package com.dev0l.clockanize.service;

import com.dev0l.clockanize.entity.Client;
import com.dev0l.clockanize.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepo;

  public List<Client> findAllClients() {
    return clientRepo.findAll();
  }

  public void save(Client client) {
    clientRepo.save(client);
  }

  public Optional<Client> findById(int id) {
    return clientRepo.findById(id);
  }

  public void delete(int id) {
    clientRepo.deleteById(id);
  }

}
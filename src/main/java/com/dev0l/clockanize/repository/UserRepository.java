package com.dev0l.clockanize.repository;

import com.dev0l.clockanize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUsername(String username);

  User findByFirstnameAndOthernameAndLastname(String firstname, String othername, String lastname);

//  User findByFirstnameAndLastname(String firstname, String lastname);

//  @Query("SELECT u FROM User u WHERE u.email = ?1")
//  User findByEmail(String email);

}
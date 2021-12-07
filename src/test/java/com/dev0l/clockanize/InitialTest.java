package com.dev0l.clockanize;

import com.dev0l.clockanize.entity.EmployeeStatus;
import com.dev0l.clockanize.entity.User;
import com.dev0l.clockanize.repository.EmployeeStatusRepository;
import com.dev0l.clockanize.repository.UserRepository;
import com.dev0l.clockanize.security.entity.Role;
import com.dev0l.clockanize.security.repository.RoleRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InitialTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private RoleRepository roleRepo;

  @Autowired
  private EmployeeStatusRepository employeeStatusRepo;

  // STEP 1
  @Test
  @Order(1)
  public void testCreateUser() {
    User user = new User();
    user.setUsername("admin");
    user.setPassword("Admin123");
    user.setFirstname("Admin");
    user.setOthername("Adminer");
    user.setLastname("Adminson");

    User savedUser = userRepo.save(user);

    User existUser = entityManager.find(User.class, savedUser.getId());

    assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
  }

  // STEP 2
  @Test
  @Order(2)
  public void testFindUserByUsername() {
    String username = "admin";
    User user = userRepo.findByUsername(username);

    assertThat(user).isNotNull();
  }

  // STEP 3
  @Test
  @Order(3)
  public void testCreateRoles() {
    Role user = new Role("USER");
    Role employee = new Role("EMPLOYEE");
    Role admin = new Role("ADMIN");
    Role hrAdmin = new Role("HR_ADMIN");

    roleRepo.saveAll(List.of(user, employee, admin, hrAdmin));

    List<Role> listRoles = roleRepo.findAll();

    assertThat(listRoles.size()).isEqualTo(4);
  }

  // STEP 4
  @Test
  @Order(4)
  public void testAddRoleToNewUser() {
    Role roleUser = roleRepo.findRoleByDescription("USER");

    User user = new User();
    user.setUsername("test");
    user.setPassword("Test1234");
    user.setFirstname("Test");
    user.setOthername("Tester");
    user.setLastname("Testson");

    user.addRole(roleUser);

    User savedUser = userRepo.save(user);

    assertThat(savedUser.getRoles().size()).isEqualTo(1);
  }

  // STEP 5
  @Test
  @Order(5)
  public void testAddRoleToExistingUser() {
    User user = userRepo.findById(1).get();
    Role roleAdmin = roleRepo.findRoleByDescription("ADMIN");

    user.addRole(roleAdmin);

    User savedUser = userRepo.save(user);

    assertThat(savedUser.getRoles().size()).isEqualTo(1);
  }

  // STEP 6
  @Test
  @Order(6)
  public void testEncodePassword1() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    User user = userRepo.findById(1).orElse(null);
    String NoHashedPassword = user.getPassword();
    String result = encoder.encode(NoHashedPassword);

    assertThat(result.equals(NoHashedPassword)).isFalse();
    assertThat(encoder.matches(NoHashedPassword, result)).isTrue();

    user.setPassword(result);
    userRepo.save(user);
  }

  // STEP 7
  @Test
  @Order(7)
  public void testEncodePassword2() {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    User user = userRepo.findById(2).orElse(null);
    String NoHashedPassword = user.getPassword();
    String result = encoder.encode(NoHashedPassword);

    assertThat(result.equals(NoHashedPassword)).isFalse();
    assertThat(encoder.matches(NoHashedPassword, result)).isTrue();

    user.setPassword(result);
    userRepo.save(user);
  }

  // STEP 8
  @Test
  @Order(8)
  public void testCreateEmployeeStatus() {
    EmployeeStatus employeeStatus = new EmployeeStatus();

    employeeStatus.setDescription("Vacation");
    employeeStatus.setDetails("Employee is on vacation");

    EmployeeStatus savedStatus = employeeStatusRepo.save(employeeStatus);

    EmployeeStatus existStatus = entityManager.find(EmployeeStatus.class, savedStatus.getId());

    assertThat(employeeStatus.getDescription()).isEqualTo(existStatus.getDescription());
  }

}
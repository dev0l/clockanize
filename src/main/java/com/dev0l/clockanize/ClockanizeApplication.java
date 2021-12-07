package com.dev0l.clockanize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJdbcHttpSession
public class ClockanizeApplication {

//  @Bean
//  public AuditorAware<String> auditorAware() {
//    return new JpaAuditingConfiguration();
//  }

  public static void main(String[] args) {
    SpringApplication.run(ClockanizeApplication.class, args);
  }

}
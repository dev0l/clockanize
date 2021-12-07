package com.dev0l.clockanize.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http

    // ATTENTION!!! Consider ENABLING CSRF protection on Build?

    .csrf().disable()
    .authorizeRequests()
    .antMatchers(
            "/login",
            "/resources/**",
            "/assets/vendor/**",
            "/assets/css/**",
            "/assets/fonts/**",
            "/assets/img/**").permitAll()
    .antMatchers("/register",
            "/resources/**",
            "/assets/css/**",
            "/assets/fonts/**",
            "/assets/img/**",
            "/assets/js/**").permitAll()
    .antMatchers("/users/add").permitAll()
    .antMatchers("/dashboard").hasAnyAuthority("ADMIN, HR_ADMIN")
    .antMatchers("/users").hasAnyAuthority("ADMIN, HR_ADMIN")
    .antMatchers("/security/user/edit/**").hasAnyAuthority("ADMIN, HR_ADMIN")
    .antMatchers("/reports").hasAnyAuthority("ADMIN, HR_ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin()
    .loginPage("/login")
    .failureUrl("/login?error=true")
    .defaultSuccessUrl("/success-handler", true).permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/access-denied")
    .and()
    .logout().invalidateHttpSession(true)
    .clearAuthentication(true)
    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    .logoutSuccessUrl("/login").permitAll();
  }

}
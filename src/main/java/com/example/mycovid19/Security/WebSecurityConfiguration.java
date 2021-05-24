package com.example.mycovid19.Security;

import com.example.mycovid19.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin()
    // .loginPage("/login").permitAll().and().logout().permitAll();
    http.authorizeRequests().antMatchers("/signup").permitAll().anyRequest().authenticated().and().formLogin();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
    dap.setUserDetailsService(userService);
    dap.setPasswordEncoder(bCryptPasswordEncoder);
    return dap;
  }
}


package com.example.mycovid19.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.mycovid19.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  // @Autowired
  // private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and().formLogin()
    // .loginPage("/login").permitAll().and().logout().permitAll();
    // http.authorizeRequests().antMatchers("/signup").permitAll().anyRequest().authenticated().and().formLogin();
    http.csrf().disable().authorizeRequests().antMatchers("/signup").permitAll()
        .antMatchers("/user/**/*", "/edit_my_tests", "/edit_my_tests", "/update_profile")
        .hasAnyAuthority("USER", "ADMIN").antMatchers("/admin/**/*").hasAuthority("ADMIN").anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll().successHandler(new AuthenticationSuccessHandler() {
          @Override
          public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
              Authentication authentication) throws IOException {
            String role = authentication.getAuthorities().iterator().next().getAuthority();
            response.sendRedirect(role.equals("ADMIN") ? "/admin/statistics" : "/user/my_profile");
          }
        }).and().logout().logoutSuccessUrl("/login");
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
    dap.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    dap.setUserDetailsService(userService);
    return dap;
  }
}


package com.example.mycovid19.Model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCredentials implements UserDetails {

  private int id;
  private String email;
  private String password;

  public UserCredentials(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public UserCredentials(int id, String email, String password) {
    this(email, password);
    this.id = id;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new GrantedAuthority() {
      @Override
      public String getAuthority() {
        return getUsername().equals("admin") ? "ADMIN" : "USER";
      }
    });
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public int getId() {
    return id;
  }
}

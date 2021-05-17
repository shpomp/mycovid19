package com.example.mycovid19.Model;

import java.sql.Date;
import org.springframework.data.annotation.Id;

public class User {
  @Id
  private int user_id;
  private String first_name;
  private String last_name;
  private Date date_of_birth;

  public User() {
  }

  public User(int user_id, String first_name, String last_name, Date date_of_birth) {
    this.user_id = user_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.date_of_birth = date_of_birth;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public Date getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(Date date_of_birth) {
    this.date_of_birth = date_of_birth;
  }
}

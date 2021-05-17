package com.example.mycovid19.Model;

import java.sql.Date;
import java.sql.Time;
import org.springframework.data.annotation.Id;

public class Test {
  @Id
  private int test_id;
  private Date test_date;
  private Time test_time;
  private String test_status;

  public Test() {
  }

  public Test(int test_id, Date test_date, Time test_time, String test_status) {
    this.test_id = test_id;
    this.test_date = test_date;
    this.test_time = test_time;
    this.test_status = test_status;
  }

  public int getTest_id() {
    return test_id;
  }

  public void setTest_id(int test_id) {
    this.test_id = test_id;
  }

  public Date getTest_date() {
    return test_date;
  }

  public void setTest_date(Date test_date) {
    this.test_date = test_date;
  }

  public Time getTest_time() {
    return test_time;
  }

  public void setTest_time(Time test_time) {
    this.test_time = test_time;
  }

  public String getTest_status() {
    return test_status;
  }

  public void setTest_status(String test_status) {
    this.test_status = test_status;
  }
}

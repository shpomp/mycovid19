package com.example.mycovid19.Model;

import java.sql.Date;
import java.sql.Time;
import org.springframework.data.annotation.Id;

public class Test {

  @Id
  private int testId;
  private Date testDate;
  private Time testTime;
  private String testStatus;

  public Test() {
  }

  public Test(int testId, Date testDate, Time testTime, String testStatus) {
    this.testId = testId;
    this.testDate = testDate;
    this.testTime = testTime;
    this.testStatus = testStatus;
  }

  public int getTestId() {
    return testId;
  }

  public void setTestId(int testId) {
    this.testId = testId;
  }

  public Date getTestDate() {
    return testDate;
  }

  public void setTestDate(Date testDate) {
    this.testDate = testDate;
  }

  public Time getTestTime() {
    return testTime;
  }

  public void setTestTime(Time testTime) {
    this.testTime = testTime;
  }

  public String getTestStatus() {
    return testStatus;
  }

  public void setTestStatus(String testStatus) {
    this.testStatus = testStatus;
  }
}



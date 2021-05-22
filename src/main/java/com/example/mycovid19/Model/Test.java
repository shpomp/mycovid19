package com.example.mycovid19.Model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class Test {

  @Id
  private int testId;
  private Date testDate;
  private String testTime;
  private String testStatus;

  public Test() {
  }

  public Test(int testId, Date testDate, String testTime, String testStatus) {
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

  public String getTestTime() {
    return testTime;
  }

  public void setTestTime(String testTime) {
    this.testTime = testTime;
  }

  public String getTestStatus() {
    return testStatus;
  }

  public void setTestStatus(String testStatus) {
    this.testStatus = testStatus;
  }

  @Override
  public String toString() {
    return "Test{" +
            "testId=" + testId +
            ", testDate=" + testDate +
            ", testTime=" + testTime +
            ", testStatus='" + testStatus + '\'' +
            '}';
  }
}



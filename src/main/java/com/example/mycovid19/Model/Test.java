package com.example.mycovid19.Model;

import java.sql.Date;

import org.springframework.data.annotation.Id;

public class Test {

  @Id
  private int test_id;
  private Date testDate;
  private String testTime;
  private String testStatus;

  public Test() {
  }

  public Test(int testId, Date testDate, String testTime, String testStatus) {
    this.test_id = testId;
    this.testDate = testDate;
    this.testTime = testTime;
    this.testStatus = testStatus;
  }

  public int getTest_id() {
    return test_id;
  }

  public void setTest_id(int test_id) {
    this.test_id = test_id;
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
            "testId=" + test_id +
            ", testDate=" + testDate +
            ", testTime=" + testTime +
            ", testStatus='" + testStatus + '\'' +
            '}';
  }
}



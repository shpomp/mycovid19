package com.example.mycovid19.Model;


public class TestResult {
  private String firstName;
  private String lastName;
  private String testDate;
  private String testTime;
  private String testStatus;
  private String testDiagnosis;

  public TestResult(String firstName, String lastName, String testDate, String testTime,
      String testStatus, String testDiagnosis) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.testDate = testDate;
    this.testTime = testTime;
    this.testStatus = testStatus;
    this.testDiagnosis = testDiagnosis;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getTestDate() {
    return testDate;
  }

  public void setTestDate(String testDate) {
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

  public String getTestDiagnosis() {
    return testDiagnosis;
  }

  public void setTestDiagnosis(String testDiagnosis) {
    this.testDiagnosis = testDiagnosis;
  }

  @Override
  public String toString() {
    return "TestResult{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", testDate='" + testDate + '\'' +
        ", testTime='" + testTime + '\'' +
        ", testStatus='" + testStatus + '\'' +
        ", testDiagnosis='" + testDiagnosis + '\'' +
        '}';
  }
}

package com.example.mycovid19.Admin.Model;


public class TestResult {
  private String firstName;
  private String lastName;
  private String testStatus;
  private String testDiagnosis;

  public TestResult(String firstName, String lastName, String testStatus,
      String testDiagnosis) {
    this.firstName = firstName;
    this.lastName = lastName;
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
        ", testStatus='" + testStatus + '\'' +
        ", testDiagnosis='" + testDiagnosis + '\'' +
        '}';
  }
}

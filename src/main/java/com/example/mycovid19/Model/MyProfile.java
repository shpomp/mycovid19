package com.example.mycovid19.Model;


public class MyProfile {
  private String userId;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String phoneNumber;
  private String streetName;
  private String homeNumber;
  private String userDistrict;
  private String userEmail;
  private String userPassword;

  public MyProfile() {
  }

  public MyProfile(String userId, String firstName, String lastName, String dateOfBirth,
      String phoneNumber, String streetName, String homeNumber, String userDistrict,
      String userEmail, String userPassword) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.streetName = streetName;
    this.homeNumber = homeNumber;
    this.userDistrict = userDistrict;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public void setHomeNumber(String homeNumber) {
    this.homeNumber = homeNumber;
  }

  public String getUserDistrict() {
    return userDistrict;
  }

  public void setUserDistrict(String userDistrict) {
    this.userDistrict = userDistrict;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "userId='" + userId + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", dateOfBirth='" + dateOfBirth + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", streetName='" + streetName + '\'' +
        ", homeNumber='" + homeNumber + '\'' +
        ", userDistrict='" + userDistrict + '\'' +
        ", userEmail='" + userEmail + '\'' +
        ", userPassword='" + userPassword + '\'' +
        '}';
  }
}

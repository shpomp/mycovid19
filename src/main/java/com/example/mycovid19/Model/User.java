package com.example.mycovid19.Model;

public class User {

  private int userId;
  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private UserContactData userContactData;
  private UserCredentials userCredentials;

  public User(String firstName, String lastName, String dateOfBirth, UserContactData userContactData,
      UserCredentials userCredentials) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.userContactData = userContactData;
    this.userCredentials = userCredentials;
  }

  public User(int userId, String firstName, String lastName, String dateOfBirth, UserContactData userContactData,
      UserCredentials userCredentials) {
    this(firstName, lastName, dateOfBirth, userContactData, userCredentials);
    this.userId = userId;
  }

  public int getUserId() {
    return userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public UserContactData getUserContactData() {
    return userContactData;
  }

  public UserCredentials getUserCredentials() {
    return userCredentials;
  }
}

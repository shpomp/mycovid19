package com.example.mycovid19.DTO;

public class UserDTO {

  private String firstName;
  private String lastName;
  private String dateOfBirth;
  private String phoneNumber;
  private String streetName;
  private String homeNumber;
  private String district;
  private String email;
  private String password;

  public UserDTO(String firstName, String lastName, String dateOfBirth, String phoneNumber, String streetName,
      String homeNumber, String district, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.streetName = streetName;
    this.homeNumber = homeNumber;
    this.district = district;
    this.email = email;
    this.password = password;
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public String getDistrict() {
    return district;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }
}

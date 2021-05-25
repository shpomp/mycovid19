package com.example.mycovid19.Model;

public class UserContactData {

  private int userId;
  private String phoneNumber;
  private String streetName;
  private String homeNumber;
  private String district;

  public UserContactData(String phoneNumber, String streetName, String homeNumber, String district) {
    this.phoneNumber = phoneNumber;
    this.streetName = streetName;
    this.homeNumber = homeNumber;
    this.district = district;
  }

  public UserContactData(int userId, String phoneNumber, String streetName, String homeNumber, String district) {
    this(phoneNumber, streetName, homeNumber, district);
    this.userId = userId;
  }

  public int getUserId() {
    return userId;
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
}

package com.example.mycovid19.Service;

import com.example.mycovid19.Model.MyProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyProfileService {

  static ArrayList<MyProfile> list = new ArrayList<>();

  public static ArrayList<MyProfile> ResultSet() {

    //DB setup
    String username = "mycovid19";
    String password  = "Constanza1.";
    String database = "mycovid19";
    String url = "jdbc:mysql://den1.mysql6.gear.host:3306/";

    try(Connection conn = DriverManager.getConnection(url + database, username, password)){
      if (!conn.isClosed()){
        String sql =
            "SELECT user.user_id, user.first_name, user.last_name, user.date_of_birth,\n "
          + "user_contact_data.phone_number, user_contact_data.street_name, "
          + "user_contact_data.home_number, user_contact_data.district, \n"
          + "user_credentials.email, user_credentials.password\n"
          + "FROM user  JOIN user_contact_data \n"
          + "ON user.user_id = user_contact_data.user_id\n"
          + "JOIN user_credentials  ON user_contact_data.user_id = user_credentials.user_id\n"
          + "WHERE user.user_id = 3";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        System.out.println(resultSet);

        while (resultSet.next()) {
          String user_id = resultSet.getString("user_id");
          String first_name = resultSet.getString("first_name");
          String last_name = resultSet.getString("last_name");
          String date_of_birth = resultSet.getString("date_of_birth");
          String phone_number  = resultSet.getString("phone_number");
          String street_name = resultSet.getString("street_name");
          String home_number = resultSet.getString("home_number");
          String district = resultSet.getString("district");
          String email = resultSet.getString("email");
          String pass = resultSet.getString("password");

          MyProfile myProfile = new MyProfile("", "", "", "", "", "", "", "", "", "");
          myProfile.setUserId(user_id);
          myProfile.setFirstName(first_name);
          myProfile.setLastName(last_name);
          myProfile.setDateOfBirth(date_of_birth);
          myProfile.setPhoneNumber(phone_number);
          myProfile.setStreetName(street_name);
          myProfile.setHomeNumber(home_number);
          myProfile.setUserDistrict(district);
          myProfile.setUserEmail(email);
          myProfile.setUserPassword(pass);
          list.add(myProfile);
        }

      } else {
        System.out.println("No connection");
      }

    } catch (Exception e){
      System.out.println("Error " + e.getMessage());
    }
    return list;
  }
}

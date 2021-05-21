package com.example.mycovid19.Service.Admin;

import com.example.mycovid19.Model.MyProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SeeAllUsersService {

    static ArrayList<MyProfile> list = new ArrayList<>();

    public static ArrayList<MyProfile> ResultSet() {

      //DB setup
      String DBusername = "mycovid19";
      String DBpassword  = "Constanza1.";
      String database = "mycovid19";
      String DBurl = "jdbc:mysql://den1.mysql6.gear.host:3306/";

      try(Connection conn = DriverManager.getConnection(DBurl + database, DBusername, DBpassword)){
        if (!conn.isClosed()){
          String sql =
              "SELECT user.user_id, user.first_name, user.last_name, user.date_of_birth,\n "
                  + "user_contact_data.phone_number, user_contact_data.street_name, "
                  + "user_contact_data.home_number, user_contact_data.district, \n"
                  + "user_credentials.email, user_credentials.password\n"
                  + "FROM user  JOIN user_contact_data \n"
                  + "ON user.user_id = user_contact_data.user_id\n"
                  + "JOIN user_credentials  ON user_contact_data.user_id = user_credentials.user_id\n"
                  + "ORDER BY user.first_name";

          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet resultSet = ps.executeQuery();

          while (resultSet.next()) {
            String userID = resultSet.getString("user_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String dateOfBirth = resultSet.getString("date_of_birth");
            String phoneNumber  = resultSet.getString("phone_number");
            String streetName = resultSet.getString("street_name");
            String homeNumber = resultSet.getString("home_number");
            String district = resultSet.getString("district");
            String userEmail = resultSet.getString("email");
            String userPassword = resultSet.getString("password");

            MyProfile myProfile = new MyProfile(
                userID,
                firstName,
                lastName,
                dateOfBirth,
                phoneNumber,
                streetName,
                homeNumber,
                district,
                userEmail,
                userPassword
            );

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

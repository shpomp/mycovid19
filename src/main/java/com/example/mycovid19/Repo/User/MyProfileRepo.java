package com.example.mycovid19.Repo.User;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Service.User.MyProfileService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MyProfileRepo {

  String table = "user_credentials";
  private JdbcTemplate jdbc;

  public MyProfileRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  // public List<MyProfile> fetchAllUsers(){ }

  public MyProfile joinUserProfileInfo() throws SQLException {
    String sql = "SELECT user.user_id, user.first_name, user.last_name, user.date_of_birth,\n "
        + "user_contact_data.phone_number, user_contact_data.street_name, "
        + "user_contact_data.home_number, user_contact_data.district, \n"
        + "user_credentials.email, user_credentials.password\n" + "FROM user  JOIN user_contact_data \n"
        + "ON user.user_id = user_contact_data.user_id\n"
        + "JOIN user_credentials  ON user_contact_data.user_id = user_credentials.user_id\n" + "WHERE user.user_id = 3";

    return jdbc.query(sql, new RowMapper<MyProfile>() {
      @Override
      public MyProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userID = rs.getString(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        String dateOfBirth = rs.getString(4);
        String phoneNumber = rs.getString(5);
        String streetName = rs.getString(6);
        String homeNumber = rs.getString(7);
        String district = rs.getString(8);
        String userEmail = rs.getString(9);
        String userPassword = rs.getString(10);

        return new MyProfile(userID, firstName, lastName, dateOfBirth, phoneNumber, streetName, homeNumber, district,
            userEmail, userPassword);
      }
    }).get(0);
  }

  public int updateUserCredentials(MyProfile user) {
    String sql = " UPDATE " + table + " SET email = ?, password = ? WHERE user_id = ? ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }

}

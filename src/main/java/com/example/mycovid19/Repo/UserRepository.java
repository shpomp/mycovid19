/*
package com.example.mycovid19.Repo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.example.mycovid19.Model.User;
import com.example.mycovid19.Model.UserContactData;
import com.example.mycovid19.Model.UserCredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private static final String USER_TABLE = "user";
  private static final String USER_CONTACT_DATA_TABLE = "user_contact_data";
  private static final String USER_CREDENTIALS_TABLE = "user_credentials";

  @Autowired
  private JdbcTemplate jdbc;

  public User findByEmail(String email) {
    String sql = String.format( //
        "SELECT * from %s\n" + //
            "JOIN %s ON %s.user_id = %s.user_id\n" + //
            "JOIN %s ON %s.user_id = %s.user_id\n" + //
            "WHERE email = ?", //
        USER_TABLE, USER_CONTACT_DATA_TABLE, USER_TABLE, USER_CONTACT_DATA_TABLE, USER_CREDENTIALS_TABLE, USER_TABLE,
        USER_CREDENTIALS_TABLE);
    List<User> user = jdbc.query(sql, new Object[] { email }, new int[] { Types.VARCHAR }, new RowMapper<User>() {

      @Override
      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        int userId = rs.getInt("user_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String dateOfBirth = rs.getString("date_of_birth");
        String phoneNumber = rs.getString("phone_number");
        String streetName = rs.getString("street_name");
        String homeNumber = rs.getString("home_number");
        String district = rs.getString("district");
        String email = rs.getString("email");
        String password = rs.getString("password");

        return new User(userId, firstName, lastName, dateOfBirth,
            new UserContactData(phoneNumber, streetName, homeNumber, district), new UserCredentials(email, password));
      }
    });

    if (user.isEmpty()) {
      throw new UsernameNotFoundException(String.format("Unable to find user with email %s", email));
    }

    return user.get(0);
  }

  public boolean addUser(User user) {
    String userSql = String.format("INSERT INTO %s (first_name, last_name, date_of_birth) VALUES (?, ?, ?)",
        USER_TABLE);
    String userContactDataSql = String.format(
        "INSERT INTO %s (user_id, phone_number, street_name, home_number, district) VALUES(?, ?, ?, ?, ?)",
        USER_CONTACT_DATA_TABLE);
    String userCredentialsSql = String.format("INSERT INTO %s (user_id, email, password) VALUES (?, ?, ?)",
        USER_CREDENTIALS_TABLE);

    UserContactData userContactData = user.getUserContactData();
    UserCredentials userCredentials = user.getUserCredentials();

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbc.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(userSql, new String[] { "user_id" });
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getDateOfBirth());
        return ps;
      }
    }, keyHolder);

    int insertedId = keyHolder.getKey().intValue();

    jdbc.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(userContactDataSql);
        ps.setInt(1, insertedId);
        ps.setString(2, userContactData.getPhoneNumber());
        ps.setString(3, userContactData.getStreetName());
        ps.setString(4, userContactData.getHomeNumber());
        ps.setString(5, userContactData.getDistrict());
        return ps;
      }
    });

    jdbc.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement ps = con.prepareStatement(userCredentialsSql);
        ps.setInt(1, insertedId);
        ps.setString(2, userCredentials.getUsername());
        ps.setString(3, userCredentials.getPassword());
        return ps;
      }
    });

    return true;
  }
}
*/
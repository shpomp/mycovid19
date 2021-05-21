package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Service.Admin.SeeAllUsersService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SeeAllUsersRepo {

  static SeeAllUsersService seeAllUsersService;
  JdbcTemplate jdbc;

  public SeeAllUsersRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<MyProfile> fetchAllUsers() throws SQLException {
    return seeAllUsersService.ResultSet();
  }

  public int addUser (MyProfile user){
    //user table
    String sql = " INSERT INTO user VALUES (?,?,?,?)";
    //addUserContactData(user);
    //addUserCredentials(user);
    return jdbc.update(sql, null, user.getFirstName(), user.getLastName(), user.getDateOfBirth());
  }

  public int addUserContactData (MyProfile user){
    //user contact data table
    String sql = " INSERT INTO user_contact_data VALUES (?,?,?,?)";
    return jdbc.update(sql, user.getPhoneNumber(), user.getStreetName(), user.getHomeNumber(), user.getUserDistrict());
  }

  public int addUserCredentials (MyProfile user){
    //user credentials table
    String sql = "INSERT INTO user_credentials VALUES (?,?)";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword());
  }

  public int updateUser (MyProfile user){
    //update user table
    String sql = "UPDATE user SET first_name = ?, last_name = ?, date_of_birth = ?";
    return jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getDateOfBirth());
  }

  public int updateUserContactData (MyProfile user){
    //update user contact data table
    String sql = "UPDATE user_contact_data SET phone_number = ?, street_name = ?, home_number = ?, user_district = ?";
    return jdbc.update(sql, user.getPhoneNumber(), user.getStreetName(), user.getHomeNumber(), user.getUserDistrict());
  }

  public int updateUserCredentials (MyProfile user){
    //update user credentials table
    String sql = "UPDATE user_credentials SET user_email = ?, user_password = ?";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword());
  }

  /*public int deleteUser (int user_id){
    //delete user by id
    String sql = "DELETE FROM user WHERE user_id = 168";
    return jdbc.update(sql, user_id);
  }*/

  // once again, works with hard-coding, not with passing in an id.
  // is this beceause we are trying to fecth an id from a result set that is coming from a join?

  public int deleteUser (){
    //delete user by id
    String sql = "DELETE FROM user WHERE user_id = 168";
    return jdbc.update(sql);
  }
}

package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Service.Admin.SeeAllUsersService;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SeeAllUsersRepo {


  private static SeeAllUsersService seeAllUsersService;
  private static JdbcTemplate jdbc;

  public SeeAllUsersRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  // Juan, here
  public List<MyProfile> fetchAllUsers() throws SQLException {
    System.out.println(seeAllUsersService.ResultSet());
    return seeAllUsersService.ResultSet();
  }



  public int addUser (MyProfile user){
    //user table
    String sql = " INSERT INTO user VALUES (?,?,?,?)";
    return jdbc.update(sql, null, user.getFirstName(), user.getLastName(), user.getDateOfBirth());
  }

  public int addUserContactData (MyProfile user){
    //user contact data table
    String sql = " INSERT INTO user_contact_data VALUES (?,?,?,?,?)";
    return jdbc.update(sql, user.getPhoneNumber(), user.getStreetName(), user.getHomeNumber(), user.getUserDistrict(), user.getUserId());
  }

  public int addUserCredentials (MyProfile user){
    //user credentials table
    //user.setUserEmail(user.getUserEmail());
    //user.setUserPassword(user.getUserPassword());
    String sql = "INSERT INTO user_credentials VALUES (?,?,?)";
    System.out.println(user.toString());
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }


  public int updateUser (MyProfile user){
    //update user table
    String sql = "UPDATE user SET first_name = ?, last_name = ?, date_of_birth = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getUserId());
  }

  public int updateUserContactData (MyProfile user){
    //update user contact data table
    String sql = "UPDATE user_contact_data SET phone_number = ?, street_name = ?, home_number = ?, district = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getPhoneNumber(), user.getStreetName(), user.getHomeNumber(), user.getUserDistrict(), user.getUserId());
  }

  public int updateUserCredentials (MyProfile user){
    //update user credentials table
    String sql = "UPDATE user_credentials SET email = ?, password = ? WHERE user_id = ?";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }



  public int deleteUser (String user_id){
    //delete user by id
    System.out.println(user_id);
    String sql = "DELETE FROM user WHERE user_id = ?";
    return jdbc.update(sql, user_id);
  }




}

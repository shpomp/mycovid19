package com.example.mycovid19.Admin.Repository;

import com.example.mycovid19.Admin.Model.User;
import com.example.mycovid19.Admin.Service.UsersProfileInfoService;
import com.example.mycovid19.User.Model.MyProfile;
import com.example.mycovid19.User.Service.MyProfileService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsersProfileInfoRepo {

  String table = "user";
  private static JdbcTemplate jdbc;
  public UsersProfileInfoRepo(JdbcTemplate jdbc) {
    UsersProfileInfoRepo.jdbc = jdbc;
  }


  public int addUser(User user){
    String sql= "INSERT INTO " + table + " VALUES (?,?,?,?,?,?,?,?,?,?)";
    return jdbc.update(sql, null, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getPhoneNumber(),
                       user.getStreetName(), user.getHomeNumber(), user.getUserDistrict(), user.getUserEmail(), user.getUserPassword());
  }

  public static List<User> joinUserProfileInfo() throws SQLException {
    return UsersProfileInfoService.ResultSet();
  }

  public int updateUserInfo(User user) {
    System.out.println(user.getUserEmail());
    System.out.println(user.getUserPassword());

    String sql = " UPDATE " + table + " SET first_name = ?, last_name = ?, date_of_birth = ?, phone_number = ?, "
               + " street_name = ?, home_number = ?, user_district = ?, user_email = ?, user_password = ? "
               + "WHERE user_id = ? ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }

  public int deleteUserInfo(int id){
    String sql = " DELETE FROM " + table + " WHERE + id=?";
    return jdbc.update(sql, id);
  }

}

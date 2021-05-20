package com.example.mycovid19.Repo;

import com.example.mycovid19.Model.UserInfo;
import com.example.mycovid19.Service.UserInfoService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoRepo {

  String table = "user_credentials";
  private static JdbcTemplate jdbc;
  public UserInfoRepo(JdbcTemplate jdbc) {
    UserInfoRepo.jdbc = jdbc;
  }


  public static List<UserInfo> createJoin() throws SQLException {
    return UserInfoService.ResultSet();
  }

  public int updateUser(UserInfo user) {
    System.out.println(user.getUserEmail());
    System.out.println(user.getUserPassword());

    String sql = " UPDATE " + table + " SET email = ?, password = ? WHERE user_id = ? ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }
  // need fix : above the user is null

  /*
  String sql = " UPDATE " + table + " SET email = ?, password = ? WHERE user_id =  ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword(), user.getUserId());
  }

  String sql = " UPDATE " + table + " SET email = ?, password = ? WHERE user_id = 3 ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword());
  }

  public int updateUser(UserInfo user) {
    String sql = " UPDATE " + table + " SET email = 'banana', password = 'banana' WHERE user_id = 3 ";
    return jdbc.update(sql);
  }
  */

}

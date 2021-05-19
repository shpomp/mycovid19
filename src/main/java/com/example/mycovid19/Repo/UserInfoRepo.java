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
  JdbcTemplate jdbc;

  public static List<UserInfo> createJoin() throws SQLException {
    return UserInfoService.ResultSet();
  }

  public int updateUser(UserInfo user) {
    String sql = " UPDATE " + table + " SET email = ?, password = ? WHERE user_id = ? ";
    return jdbc.update(sql, user.getUserEmail(), user.getUserPassword());
  }

}

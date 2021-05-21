package com.example.mycovid19.Repo.User;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Service.User.MyProfileService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyProfileRepo {

  String table = "user_credentials";
  private static JdbcTemplate jdbc;
  public MyProfileRepo(JdbcTemplate jdbc) {
    MyProfileRepo.jdbc = jdbc;
  }


  //public  List<MyProfile> fetchAllUsers(){  }

  public static List<MyProfile> joinUserProfileInfo() throws SQLException {
    return MyProfileService.ResultSet();
  }

  public int updateUserCredentials(MyProfile user) {
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

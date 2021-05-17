package com.example.mycovid19.Repo;

import com.example.mycovid19.Model.User;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class UserRepo {

  private static String table = "user";
  private static JdbcTemplate jdbc;


  public UserRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public int addUser(User user){
    String sql= "INSERT INTO " + table + " VALUES (?,?)";
    return jdbc.update(sql, null, user.getUser_id());
  }

  public static List<User> fetchAll() throws SQLException{
    String sql = " SELECT * FROM " + table + " ORDER BY first_name ASC ";
    RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
    return jdbc.query(sql, rowMapper);
  }

  public int updateUser(User user){
    String sql = " UPDATE " + table + " SET first_name = ?, last_name = ?, date_of_birth = ?" + "WHERE user_id = ? ";
    return jdbc.update(sql, user.getFirst_name(), user.getLast_name(), user.getDate_of_birth(), user.getUser_id());
  }

  public int delete(int user_id){
    String sql = " DELETE FROM " + table + " WHERE user_id = ?";
    return jdbc.update(sql, user_id);
  }
}

package com.example.mycovid19.Admin.Repository;

import com.example.mycovid19.User.Model.Test;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UsersTestsRepo {
  private final static String table = "test";
  private static JdbcTemplate jdbc;


  public UsersTestsRepo(JdbcTemplate jdbc) {
    UsersTestsRepo.jdbc = jdbc;
  }

  public static List<Test> fetchAll() throws SQLException {
    String sql = " SELECT * FROM " + table + " WHERE (test_status = 'booked' OR test_status = 'done') "
        + "AND user_id = 30 ORDER BY test_date ";
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }

  public static int cancelTest(int test_id) {
    String sql = " UPDATE " + table + " SET test_status = 'available', user_id = NULL WHERE test_id = ? ";
    return jdbc.update(sql, test_id);
  }

  // need to set user_id to null when test is canceled
  // did not work:
  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = default WHERE test_id = ? ";
  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = 'default' WHERE test_id = ? ";
  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = 'null' WHERE test_id = ? ";
  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = null WHERE test_id = ? ";

  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = ? WHERE test_id = ? ";
  // return jdbc.update(sql, test_id);

  // String sql = " UPDATE " + table + " SET test_status = 'available', user_id = ? WHERE test_id = ? ";
  // return jdbc.update(sql, null,test_id);





}


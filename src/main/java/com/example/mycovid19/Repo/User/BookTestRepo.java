package com.example.mycovid19.Repo.User;

import com.example.mycovid19.Model.Test;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BookTestRepo {

  private final static String table = "test";
  private static JdbcTemplate jdbc;


  public BookTestRepo(JdbcTemplate jdbc) {
    BookTestRepo.jdbc = jdbc;
  }

  /*public static int addTest(Test test){
    String sql= "INSERT INTO " + table + " VALUES (?,?,?,?)";
    return jdbc.update(sql, null, test.getTest_date(), test.getTest_time(), test.getTest_status());
  }*/

  public static List<Test> fetchAll() throws SQLException {
    String sql = " SELECT * FROM " + table + " WHERE test_status = 'available' ORDER BY test_date ASC";
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }

  /*public static int cancelTest(int test_id){
    String sql = " UPDATE " + table + " SET test_status = 'available' WHERE test_id = ? ";
    return jdbc.update(sql, test_id);
  }*/

  public static int bookTest(int test_id){
    String sql = " UPDATE " + table + " SET test_status = 'booked', user_id = 30 WHERE test_id = ? ";
    return jdbc.update(sql, test_id);
  }

  /*public static List<Test> confirmTest() {
    String sql = " SELECT * FROM " + table + " WHERE test_status = 'available' ORDER BY test_date ";
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }*/

}

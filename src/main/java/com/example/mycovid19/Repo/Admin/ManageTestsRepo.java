package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.Test;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ManageTestsRepo {

  JdbcTemplate jdbc;

  public ManageTestsRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<Test> fetchAllTests() throws SQLException {
    String sql= " SELECT * FROM test" ;
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }

  public int addTest (Test test){
    //test table
    String sql = " INSERT INTO test VALUES (?,?,?,?)";
    return jdbc.update(sql, null, test.getTestDate(), test.getTestTime(), test.getTestStatus());
  }

  public int updateTest (Test test){
    //update test table
    String sql = "UPDATE test SET test_date = ?, test_time = ?, test_status = ?";
    return jdbc.update(sql, test.getTestDate(), test.getTestTime(), test.getTestStatus());
  }

  public int deleteTest (int test_id){
    //delete test by id
    String sql = "DELETE FROM test WHERE test_id = ?";
    return jdbc.update(sql, test_id);
  }

}

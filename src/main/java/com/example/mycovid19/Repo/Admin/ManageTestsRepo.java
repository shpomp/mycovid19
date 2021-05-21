package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.Test;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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

  // does not work
  public int addTest (Test test){
    //test table
    System.out.println("breaks");

    String sql = " INSERT INTO test (test_date, test_time, test_status) VALUES (?,?,?)";
    System.out.println(test.toString());
    // Test{testId=0, testDate=null, testTime=null, testStatus='null'}

    return jdbc.update(sql, LocalDate.now(), LocalTime.now(), "available");
    // tihis works. So it is not reading the Test object
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

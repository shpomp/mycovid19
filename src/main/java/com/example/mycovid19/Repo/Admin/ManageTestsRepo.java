package com.example.mycovid19.Repo.Admin;

import com.example.mycovid19.Model.Test;
import com.example.mycovid19.Model.TestResult;
import com.example.mycovid19.Service.Admin.ManageTestsService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class ManageTestsRepo {

  private final static String testTable = "test";
  private final static String resultTable = "test_result";

  private static ManageTestsService manageTestsService;

  private static JdbcTemplate jdbc;

  public ManageTestsRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<Test> fetchAllTests() throws SQLException {
    String sql= " SELECT * FROM " + testTable + " ORDER BY test_date " ;
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }


  public int addTest (Test test){
    String sql = " INSERT INTO " + testTable +" VALUES (?,?,?,?,?)";
    return jdbc.update(sql, null, test.getTestDate(), test.getTestTime(), "available", null);
  }


  public int updateTest (Test test){
    String sql = "UPDATE test SET test_date = ?, test_time = ? WHERE test_id = ?";
    return jdbc.update(sql, test.getTestDate(), test.getTestTime(), test.getTest_id());
  }



  public int deleteTest (int test_id){
    System.out.println(test_id);

    String sql = "DELETE FROM " + testTable + " WHERE test_id = ?";
    return jdbc.update(sql, test_id);
  }

  // RESULTS
  public List<TestResult> fetchAllTestsResults() throws SQLException {
    return manageTestsService.ResultSet();
  }

  public int updateResult (TestResult testResult) {
    System.out.println(testResult.toString());
    String sql = " UPDATE " + resultTable + " SET test_diagnosis = ? WHERE test_test_id = ?";
    return jdbc.update(sql, testResult.getTestDiagnosis(), testResult.getTest_id());
  }

  public int deleteResult (int test_id){
    System.out.println(test_id);
    String sql = "DELETE FROM " + testTable + " WHERE test_id = ?";
    return jdbc.update(sql, test_id);
  }



}

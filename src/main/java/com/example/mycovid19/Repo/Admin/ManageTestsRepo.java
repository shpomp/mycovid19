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

@Repository
public class ManageTestsRepo {

  private final static String testTable = "test";
  private final static String resultTable = "test_result";

  private static ManageTestsService manageTestsService;

  private static JdbcTemplate jdbc;

  public ManageTestsRepo(JdbcTemplate jdbc) {
    ManageTestsRepo.jdbc = jdbc;
  }

  public List<Test> fetchAllTests() throws SQLException {
    String sql= " SELECT * FROM " + testTable + " WHERE test_status = 'available' ORDER BY test_date " ;
    RowMapper<Test> rowMapper = new BeanPropertyRowMapper<>(Test.class);
    return jdbc.query(sql, rowMapper);
  }

  public List<TestResult> fetchAllTestsResults() throws SQLException {
    return manageTestsService.ResultSet();
  }

  public int updateResult (TestResult testResult) {
    String sql = " UPDATE " + resultTable + " SET test_diagnosis = ? WHERE test_test_id = ?";
    return jdbc.update(sql, testResult.getTestDiagnosis(), testResult.getTest_id());
  }


  public int addTest (Test test){
    //test table
    String sql = " INSERT INTO " + testTable +" VALUES (?,?,?,?,?)";
    return jdbc.update(sql, null, test.getTestDate(), test.getTestTime(), test.getTestStatus(), null);
  }


  public int updateTest (Test test){
    //update test table
    System.out.print(test.toString());
    String sql = "UPDATE test SET test_date = ?, test_time = ?, test_status = ? WHERE test_id = ?";
    return jdbc.update(sql, test.getTestDate(), test.getTestTime(), test.getTestStatus(), test.getTest_id());
  }



  public int deleteTest (int test_id){
    System.out.print(test_id);
    // here we could add functionality to put into a file?
    //delete test by id
   String sql = "DELETE FROM" + testTable + "WHERE test_id = ?";
    return jdbc.update(sql, test_id);
  }

}

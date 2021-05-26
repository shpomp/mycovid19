package com.example.mycovid19.Repo.User;

import com.example.mycovid19.Model.TestResult;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MyTestsResultsRepo {

  @Autowired
  private JdbcTemplate jdbc;

  public List<TestResult> joinTestsResults() throws SQLException {
    String sql = "SELECT u.user_id, first_name, last_name, test_id, test_date, test_time, test_status, test_diagnosis\n"
        + "FROM user u JOIN test t\n" + "ON u.user_id = t.user_id\n"
        + "JOIN test_result r ON t.test_id = r.test_test_id\n" + " WHERE t.test_status='done' AND u.user_id=30";

    return jdbc.query(sql, new RowMapper<TestResult>() {

      @Override
      public TestResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userId = rs.getString("user_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String test_id = rs.getString("test_id");
        String testDate = rs.getString("test_date");
        String testTime = rs.getString("test_time");
        String testStatus = rs.getString("test_status");
        String testDiagnosis = rs.getString("test_diagnosis");

        return new TestResult(userId, firstName, lastName, test_id, testDate, testTime, testStatus, testDiagnosis);
      }

    });
  }



}

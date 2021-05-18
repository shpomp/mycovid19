package com.example.mycovid19.Repo;

import com.example.mycovid19.Model.TestResult;
import com.example.mycovid19.Service.TestResultService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TestResultRepo {

  public static List<TestResult> createJoin() throws SQLException {
    return TestResultService.ResultSet();
  }
}

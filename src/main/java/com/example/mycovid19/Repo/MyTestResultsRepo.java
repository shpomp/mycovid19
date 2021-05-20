package com.example.mycovid19.Repo;

import com.example.mycovid19.Model.TestResult;
import com.example.mycovid19.Service.MyTestResultsService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MyTestResultsRepo {

  private static int user_id;

  public static List<TestResult> createJoin() throws SQLException {
    return MyTestResultsService.ResultSet(user_id);
  }
}

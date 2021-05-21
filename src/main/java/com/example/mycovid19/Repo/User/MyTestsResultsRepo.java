package com.example.mycovid19.Repo.User;

import com.example.mycovid19.Model.TestResult;
import com.example.mycovid19.Service.User.MyTestsResultsService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MyTestsResultsRepo {

  private static int user_id;

  public static List<TestResult> joinTestsResults() throws SQLException {
    return MyTestsResultsService.ResultSet(user_id);
  }
}

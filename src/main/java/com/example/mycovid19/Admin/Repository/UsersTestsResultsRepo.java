package com.example.mycovid19.Admin.Repository;

import com.example.mycovid19.User.Model.TestResult;
import com.example.mycovid19.User.Service.MyTestsResultsService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class UsersTestsResultsRepo {

  private static int user_id;

  public static List<TestResult> joinTestsResults() throws SQLException {
    return MyTestsResultsService.ResultSet(user_id);
  }
}

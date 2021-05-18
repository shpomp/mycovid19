package com.example.mycovid19.Repo;

import com.example.mycovid19.Model.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ResultRepo {

  public static List<String> createJoin() throws SQLException {
    return ResultSet.ResultSet();
  }
}

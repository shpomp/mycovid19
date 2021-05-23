package com.example.mycovid19.Service.User;

import com.example.mycovid19.Model.TestResult;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyTestsResultsService {


    static ArrayList<TestResult> list = new ArrayList<>();


    public static ArrayList<TestResult> ResultSet(int user_id) {

      //DB setup
      String username = "mycovid19";
      String password  = "Constanza1.";
      String database = "mycovid19";
      String url = "jdbc:mysql://den1.mysql6.gear.host:3306/";

      try(Connection conn = DriverManager.getConnection(url + database, username, password)){
        if (!conn.isClosed()){
          String sql =
              "SELECT first_name, last_name, test_date, test_time, test_status, test_diagnosis\n"
               + "FROM user u JOIN test t\n"
               + "ON u.user_id = t.user_id\n"
               + "JOIN test_result r ON t.test_id = r.test_test_id\n"
               + " WHERE t.test_status='done' AND u.user_id=30";

          PreparedStatement ps = conn.prepareStatement(sql);
          java.sql.ResultSet resultSet = ps.executeQuery();

          while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String testDate = resultSet.getString("test_date");
            String testTime = resultSet.getString("test_time");
            String testStatus = resultSet.getString("test_status");
            String testDiagnosis = resultSet.getString("test_diagnosis");

            TestResult testResult = new TestResult(
                firstName,
                lastName,
                testDate,
                testTime,
                testStatus,
                testDiagnosis
            );
            list.add(testResult);
          }

        } else {
          System.out.println("No connection");
        }

      } catch (Exception e){
        System.out.println("Error " + e.getMessage());
      }
      return list;
    }
}

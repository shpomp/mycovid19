package com.example.mycovid19.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ResultSet {

    static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> ResultSet() {

      //DB setup
      String username = "mycovid19";
      String password  = "Constanza1.";
      String database = "mycovid19";
      String url = "jdbc:mysql://den1.mysql6.gear.host:3306/";

      try(Connection conn = DriverManager.getConnection(url + database, username, password)){
        if (!conn.isClosed()){
          String sql =
              "SELECT first_name, last_name, test_status, test_diagnosis\n"
                  + "FROM user u JOIN test t\n"
                  + "ON u.user_id = t.user_id\n"
                  + "JOIN test_result r ON t.test_id = r.test_test_id";

          PreparedStatement ps = conn.prepareStatement(sql);
          java.sql.ResultSet resultSet = ps.executeQuery();

          while (resultSet.next()) {
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String test_status = resultSet.getString("test_status");
            String test_diagnosis = resultSet.getString("test_diagnosis");

            list.add(first_name + " " + last_name + " "+ test_status + " " + test_diagnosis);
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

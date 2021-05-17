package com.example.mycovid19.Model;

import java.sql.Date;
import org.springframework.data.annotation.Id;

public class Test {
  @Id
  private int test_id;
  private Date date_and_time;
  private String test_status;
}

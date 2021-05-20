package com.example.mycovid19.User.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("/user_index")
  public String Home() { return "user_index"; }

}

package com.example.mycovid19.Admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  @GetMapping("/admin_index")
  public String Home() { return "admin_index"; }

}

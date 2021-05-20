package com.example.mycovid19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

  @GetMapping("/")
  public String Home() {
    return "index"; }

}

package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.UserRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/")
  public String index(Model model) throws SQLException {
    model.addAttribute("users", UserRepo.fetchAll());
    return "index";
  }



}

package com.example.mycovid19.Controller;

import com.example.mycovid19.Model.User;
import com.example.mycovid19.Repo.UserRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/user")
  public String user(Model model) throws SQLException {
    model.addAttribute("users", userRepo.fetchAll());
    return "/user";
  }

  @PostMapping("/create")
  public String addUser(User user){
    userRepo.addUser(user);
    return "redirect:/user";
  }

  @PostMapping(value = "/edit", params="delete")
  public String deleteUser(@RequestParam("user_id") int user_id){
    userRepo.deleteUser(user_id);
    return "redirect:/user";
  }

  @PostMapping(value = "/edit", params="update")
  public String updateUser(User user){
    userRepo.updateUser(user);
    return "redirect:/user";
  }
}

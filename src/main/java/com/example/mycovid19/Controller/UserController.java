package com.example.mycovid19.Controller;

import com.example.mycovid19.Model.User;
import com.example.mycovid19.Repo.UserRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping("/users")
  public String users(Model model) throws SQLException {
    model.addAttribute("users", userRepo.fetchAll());
    return "/users";
  }

  @PostMapping("/user/create")
  public String addUser(User user) {
    userRepo.addUser(user);
    return "redirect:/users";
  }

  @GetMapping("/user/delete/{user_id}")
  public String deleteUser(@PathVariable("user_id") int user_id) {
    userRepo.deleteUser(user_id);
    return "redirect:/users";
  }

  @PostMapping("/user/update")
  public String updateUser(User user) {
    userRepo.updateUser(user);
    return "redirect:/users";
  }
}

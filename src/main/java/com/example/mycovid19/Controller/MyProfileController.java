package com.example.mycovid19.Controller;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Repo.MyProfileRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyProfileController {

  @Autowired
  private MyProfileRepo myProfileRepo;

  @GetMapping("/my_profile")
  public String usersInfo(Model model) throws SQLException {
    model.addAttribute("usersInfo", myProfileRepo.createJoin());
    return "my_profile";
  }

  @PostMapping(value = "/update_user", params="update")
  public String updateUser(MyProfile user) {
    myProfileRepo.updateUser(user);
    return "redirect:/my_profile";
  }
}

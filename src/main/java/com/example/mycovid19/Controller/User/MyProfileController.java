package com.example.mycovid19.Controller.User;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.User.MyProfileRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyProfileController {

  @Autowired
  private MyProfileRepo myProfileRepo;

  @GetMapping("/user/my_profile")
  public String userProfileInfo(Model model, @AuthenticationPrincipal UserCredentials userCredentials)
      throws SQLException {
    model.addAttribute("user", myProfileRepo.joinUserProfileInfo(userCredentials.getId()));
    return "/user/my_profile";
  }

  @PostMapping(value = "/update_profile", params = "update")
  public String updateUserProfileInfo(MyProfile user) {
    myProfileRepo.updateUserCredentials(user);
    return "redirect:/user/my_profile";
  }
}

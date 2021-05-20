package com.example.mycovid19.Admin.Controller;

import com.example.mycovid19.Admin.Model.User;
import com.example.mycovid19.Admin.Repository.UsersProfileInfoRepo;
import com.example.mycovid19.User.Model.MyProfile;
import com.example.mycovid19.User.Repo.MyProfileRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersProfileInfoController {

  @Autowired
  private UsersProfileInfoRepo usersProfileInfoRepo;

  @GetMapping("/users_profile_info2")
  public String userProfileInfo(Model model) throws SQLException {
    model.addAttribute("usersProfileInfo", usersProfileInfoRepo.joinUserProfileInfo());
    return "users_profile_info2";
  }

  @PostMapping("/user_profile_info2/create")
  public String addUser(User user) {
    usersProfileInfoRepo.addUser(user);
    return "redirect:/users_profile_info2";
  }

  @PostMapping(value = "/update_user_profile_info2", params="update")
  public String updateUserProfileInfo(User user) {
    usersProfileInfoRepo.updateUserInfo(user);
    return "redirect:/users_profile_info2";
  }

  @GetMapping("/user_profile_info2/delete/{user_id}")
  public String deleteUserInfo(@PathVariable("user_id") int user_id) {
    usersProfileInfoRepo.deleteUserInfo(user_id);
    return "redirect:/users_profile_info2";
  }
}

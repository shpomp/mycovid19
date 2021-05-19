package com.example.mycovid19.Controller;

import com.example.mycovid19.Model.UserInfo;
import com.example.mycovid19.Repo.UserInfoRepo;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInfoController {

  @Autowired
  private UserInfoRepo userInfoRepo;

  @GetMapping("/usersInfo")
  public String usersInfo(Model model) throws SQLException {
    model.addAttribute("usersInfo", userInfoRepo.createJoin());
    return "/usersInfo";
  }

  @PostMapping(value = "/update_user", params="update")
  public String updateUser(UserInfo user) {
    userInfoRepo.updateUser(user);
    return "redirect:/usersInfo";
  }
}

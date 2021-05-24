package com.example.mycovid19.Controller;

import com.example.mycovid19.DTO.UserDTO;
import com.example.mycovid19.Model.User;
import com.example.mycovid19.Model.UserContactData;
import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  @GetMapping("/signup")
  public String getSignup() {
    return "signup";
  }

  @PostMapping("/signup")
  public String postSignUp(UserDTO userDTO) {
    userService.signUpUser(userDTO);
    return "redirect:/";
  }

}

package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.DTO.UserDTO;
import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Repo.Admin.SeeAllUsersRepo;
import java.sql.SQLException;

import com.example.mycovid19.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SeeAllUsersController {

  @Autowired
  private SeeAllUsersRepo seeAllUsersRepo;

  @Autowired
  private UserService userService;

  @GetMapping("/admin/all_users")
  public String usersProfileInfo(Model model) throws SQLException {
    model.addAttribute("usersProfileInfo", seeAllUsersRepo.fetchAllUsers());
    return "/admin/all_users";
  }


  @PostMapping("/create_user")
  public String addUser(UserDTO user){
      userService.signUpUser(user); // using user service for the user creation method
    return "redirect:/admin/all_users";
  }


  @PostMapping(value = "/update_user_info", params="update")
  public String updateUser(MyProfile user){
    seeAllUsersRepo.updateUser(user);
    seeAllUsersRepo.updateUserContactData(user);
    seeAllUsersRepo.updateUserCredentials(user);
    return "redirect:/admin/all_users";
  }


  @PostMapping(value = "/update_user_info", params="delete")
  public String deleteUser(@RequestParam("user_id") int userId){
    seeAllUsersRepo.deleteUser(userId);
    return "redirect:/admin/all_users";
  }


}

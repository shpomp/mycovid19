package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.Model.MyProfile;
import com.example.mycovid19.Repo.Admin.SeeAllUsersRepo;
import java.sql.SQLException;
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

  //fetch all the users information through the join built in SeeAllUsersService
  @GetMapping("/admin/all_users")
  public String usersProfileInfo(Model model) throws SQLException {
    model.addAttribute("usersProfileInfo", seeAllUsersRepo.fetchAllUsers());
    return "/admin/all_users";
  }

  //the three create-add methods doesnt work.
  //not sure why...maybe its related to the join?
  //the error says the first_name column is null even though I was providing text in the input fields
  @PostMapping("/create_user")
  public String addUser(MyProfile user){
    seeAllUsersRepo.addUser(user);
    return "redirect:/admin/all_users";
  }

  @PostMapping("/add_user_contact_data")
  public String addUserContactData(MyProfile user){
    seeAllUsersRepo.addUserContactData(user);
    return "redirect:/admin/all_users";
  }

  @PostMapping("/add_user_credentials")
  public String addUserCredentials(MyProfile user){
    seeAllUsersRepo.addUserCredentials(user);
    return "redirect:/admin/all_users";
  }

  //I dont know how to call the 3 update methods (1 for each table) on 1 update controller method
  //so neither 3 update methods is working
  //related to the join? same as update credentials features for "user"?
  @PostMapping(value = "/update_user_info", params="update")
  public String updateUser(MyProfile user){
    seeAllUsersRepo.updateUser(user);
    return "redirect:/admin/all_users";
  }


  @PostMapping(value = "/update_user_info", params="delete")
  public String deleteUser(@RequestParam("user_id") int user_id){
    seeAllUsersRepo.deleteUser(user_id);
    return "redirect:/admin/all_users";
  }

/*
  @PostMapping(value = "/update_user_info", params="delete")
  public String deleteUser(){
    seeAllUsersRepo.deleteUser();
    return "redirect:/admin/all_users";
  }*/
}

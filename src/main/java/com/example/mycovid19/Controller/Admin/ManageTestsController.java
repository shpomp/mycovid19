package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.Model.Test;
import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.Admin.ManageTestsRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManageTestsController {


  @Autowired
  private ManageTestsRepo manageTestsRepo;

  @GetMapping("/admin/all_tests")
  public String testList(Model model, @AuthenticationPrincipal UserCredentials userCredentials) throws SQLException {
    model.addAttribute("seeAllTests", manageTestsRepo.fetchAllTests());
    model.addAttribute("userCred", userCredentials);
    return "/admin/all_tests";
  }

  @PostMapping("/create_test")
  public String addTest(Test test){
    manageTestsRepo.addTest(test);
    return "redirect:/admin/all_tests";
  }

  @PostMapping(value = "/update_test", params="update")
  public String updateTest(Test test) {
    manageTestsRepo.updateTest(test);
    return "redirect:/admin/all_tests";
  }

    @PostMapping(value = "update_test", params="delete")
    public String deleteTest(@RequestParam("test_id") int test_id){
      manageTestsRepo.deleteTest(test_id);
      return "redirect:/admin/all_tests";
    }
}

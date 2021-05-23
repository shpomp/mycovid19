package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.Repo.Admin.ManageTestsRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManageTestsResultsController {

  @Autowired
  private ManageTestsRepo manageTestsRepo;

  @GetMapping("/admin/all_tests_results")
  public String adminResults(Model model) throws SQLException {
    model.addAttribute("adminResults", manageTestsRepo.fetchAllTestsResults());
    return "admin/all_tests_results";
  }
}

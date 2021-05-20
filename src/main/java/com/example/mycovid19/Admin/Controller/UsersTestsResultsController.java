package com.example.mycovid19.Admin.Controller;

import com.example.mycovid19.User.Repo.MyTestsResultsRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersTestsResultsController {

  private MyTestsResultsRepo myTestsResultsRepo;

  @GetMapping("/templates/Admin/user_tests_results.html")
  public String results(Model model) throws SQLException {
    model.addAttribute("myTestsResults", myTestsResultsRepo.joinTestsResults());
    return "templates/Admin/user_tests_results.html";
  }
}

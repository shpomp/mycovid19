package com.example.mycovid19.User.Controller;

import com.example.mycovid19.User.Repo.MyTestsResultsRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestsResultsController {

  private MyTestsResultsRepo myTestsResultsRepo;

  @GetMapping("templates/User/my_results")
  public String results(Model model) throws SQLException {
    model.addAttribute("myTestsResults", myTestsResultsRepo.joinTestsResults());
    return "templates/User/my_results";
  }
}

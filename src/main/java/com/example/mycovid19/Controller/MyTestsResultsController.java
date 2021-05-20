package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.MyTestsResultsRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestsResultsController {

  private MyTestsResultsRepo myTestsResultsRepo;

  @GetMapping("/my_results")
  public String results(Model model) throws SQLException {
    model.addAttribute("myTestsResults", myTestsResultsRepo.joinTestsResults());
    return "my_results";
  }
}

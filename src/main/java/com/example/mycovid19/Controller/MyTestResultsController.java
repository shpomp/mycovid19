package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.MyTestResultsRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyTestResultsController {

  private MyTestResultsRepo myTestResultsRepo;

  @GetMapping("/my_results")
  public String results(Model model) throws SQLException {
    model.addAttribute("testResult", myTestResultsRepo.createJoin());
    return "my_results";
  }
}

package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.TestResultRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestResultController {

  private TestResultRepo testResultRepo;

  @GetMapping("/results")
  public String results(Model model) throws SQLException {
    model.addAttribute("testResult", testResultRepo.createJoin());
    return "/results";
  }
}

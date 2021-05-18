package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.ResultRepo;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {

  private ResultRepo resultRepo;

  @GetMapping("/results")
  public String results(Model model) throws SQLException {
    model.addAttribute("results", resultRepo.createJoin());
    return "/results";
  }
}

package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.TestRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

  @Autowired
  private TestRepo testRepo;

  @GetMapping("/test")
  public String test(Model model) throws SQLException {
    model.addAttribute("tests", testRepo.fetchAll());
    return "/test";
  }

  /*@PostMapping("/createTest")
  public String addTest(Test test){
    testRepo.addTest(test);
    return "redirect:/test";
  }*/

  /*@PostMapping(value = "/editTest", params="cancel")
  public String cancelTest(@RequestParam("test_id") int test_id){
    testRepo.cancelTest(test_id);
    return "redirect:/test";
  }*/

  @PostMapping(value = "/editTest", params="update")
  public String bookTest(@RequestParam("test_id") int test_id){
    testRepo.bookTest(test_id);
    return "redirect:/test";
  }

}

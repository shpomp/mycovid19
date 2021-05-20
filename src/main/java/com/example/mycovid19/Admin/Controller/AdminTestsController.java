package com.example.mycovid19.Admin.Controller;

import com.example.mycovid19.Admin.Repository.TestsRepo;
import com.example.mycovid19.User.Repo.BookTestRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminTestsController {

  @Autowired
  private TestsRepo testsRepo;

  @GetMapping("/templates.Admin/book_tests")
  public String test(Model model) throws SQLException {
    model.addAttribute("tests", testsRepo.fetchAll());
    return "/templates.Admin/book_tests";
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

  @PostMapping(value = "/edit_test", params="update")
  public String bookTest(@RequestParam("test_id") int test_id){
    testsRepo.bookTest(test_id);
    return "redirect:/templates.Admin/book_tests";
  }

}

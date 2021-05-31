package com.example.mycovid19.Controller.User;

import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.User.BookTestRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookTestController {

  @Autowired
  private BookTestRepo bookTestRepo;

  @GetMapping("/user/book_tests")
  public String test(Model model) throws SQLException {
    model.addAttribute("tests", bookTestRepo.fetchAll());
    return "/user/book_tests";
  }

  /*
   * @PostMapping("/createTest") public String addTest(Test test){
   * testRepo.addTest(test); return "redirect:/test"; }
   */

  /*
   * @PostMapping(value = "/editTest", params="cancel") public String
   * cancelTest(@RequestParam("test_id") int test_id){
   * testRepo.cancelTest(test_id); return "redirect:/test"; }
   */

  @PostMapping(value = "/edit_book_test", params = "update")
  public String bookTest(@RequestParam("test_id") int test_id,
      @AuthenticationPrincipal UserCredentials userCredentials) {
    System.out.println(userCredentials.getId());
    System.out.println(userCredentials.getUsername());
    bookTestRepo.bookTest(test_id, userCredentials.getId());
    return "redirect:/user/book_tests";
  }

}

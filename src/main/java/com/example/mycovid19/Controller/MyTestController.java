package com.example.mycovid19.Controller;

import com.example.mycovid19.Repo.MyTestsRepo;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyTestController {

    @Autowired
    private MyTestsRepo myTestsRepo;

    @GetMapping("/MyTests")
    public String MyTests(Model model) throws SQLException {
      model.addAttribute("mytests", myTestsRepo.fetchAll());
      return "/MyTests";
    }

    @PostMapping(value = "/editMyTest", params="cancel")
    public String cancelTest(@RequestParam("test_id") int test_id){
      myTestsRepo.cancelTest(test_id);
      return "redirect:/MyTests";
    }

}

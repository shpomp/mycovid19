package com.example.mycovid19.Controller.Admin;

import com.example.mycovid19.Model.UserCredentials;
import com.example.mycovid19.Repo.Admin.SeeAllUsersRepo;
import com.example.mycovid19.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class StatisticsController {

    @Autowired
    private SeeAllUsersRepo seeAllUsersRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/statistics")
    public String statistics(Model model, @AuthenticationPrincipal UserCredentials userCredentials) throws SQLException {
        //model.addAttribute("statistics", ?);
        model.addAttribute("userCred", userCredentials);

        return "/admin/statistics";
    }



}





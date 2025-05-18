package se.elijah.cloudproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.elijah.cloudproject.Model.HockeyPlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class HomeController extends BaseController {
    @Autowired
    private HockeyPlayerRepository hockeyPlayerRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("players", hockeyPlayerRepository.findAll());
        model.addAttribute("user", "Biplob");
        return "home";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
//        String user = getLoggedInEmail();
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", user);
        return "profile";
    }
}
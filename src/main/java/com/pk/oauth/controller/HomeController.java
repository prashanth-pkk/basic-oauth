package com.pk.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
        model.addAttribute("user", oauth2User.getAttributes());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

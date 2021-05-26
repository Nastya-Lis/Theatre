package com.lad.springserver.controller;

import com.lad.springserver.model.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
//@RequestMapping("/")
public class MainController {

    /*@Value("${spring.profiles.active}")
    private String profile;

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal Users user) {
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index.html";
    }
*/
}

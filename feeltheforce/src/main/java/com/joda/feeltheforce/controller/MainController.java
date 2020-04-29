package com.joda.feeltheforce.controller;

import com.joda.feeltheforce.entities.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/match")
    public String match(Model model) {

        return "/";
    }

    @GetMapping("/about-us")
    public String aboutUs() {

        return "about-us";
    }
}
package com.joda.feeltheforce.controller;

import com.joda.feeltheforce.entities.People;
import com.joda.feeltheforce.entities.Planet;
import com.joda.feeltheforce.repository.PeopleRepository;
import com.joda.feeltheforce.repository.PlanetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    PeopleRepository peopleRepository = new PeopleRepository();
    PlanetRepository planetRepository = new PlanetRepository();

    @GetMapping("/")
    public String match(Model model) {


        List<Planet> planets = planetRepository.findAll();
        List<People> peoples = new ArrayList<>();
        model.addAttribute("planets", planets);

        model.addAttribute(peoples);

        return "index";
    }


    @GetMapping("/about-us")
    public String aboutUs() {

        return "about-us";
    }
}
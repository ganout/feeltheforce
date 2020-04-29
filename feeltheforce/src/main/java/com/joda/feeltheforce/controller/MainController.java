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

    @GetMapping("/")
    public String match(Model model) {

        PlanetRepository planetRepository = new PlanetRepository();
        List<Planet> planets = planetRepository.findAll();

        model.addAttribute(planets);

        PeopleRepository peopleRepository = new PeopleRepository();
        List<People> peoples = new ArrayList<>();

        model.addAttribute(peoples);

        return "index";
    }


    @GetMapping("/about-us")
    public String aboutUs() {

        return "about-us";
    }
}
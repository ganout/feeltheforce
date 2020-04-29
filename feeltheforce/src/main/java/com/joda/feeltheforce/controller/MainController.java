package com.joda.feeltheforce.controller;

import com.joda.feeltheforce.entities.People;
import com.joda.feeltheforce.repository.PeopleRepository;
import com.joda.feeltheforce.repository.PlanetRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
public class MainController {
    PeopleRepository peopleRepository = new PeopleRepository();
    PlanetRepository planetRepository = new PlanetRepository();

    @GetMapping("/")
    public String match(Model model) {

        model.addAttribute("eyes", peopleRepository.findAllEye());
        model.addAttribute("planets", planetRepository.findAll());
        model.addAttribute("genders", peopleRepository.findAllGender());
        model.addAttribute("hairColors", peopleRepository.findAllHairColors());
        model.addAttribute("perso1", new People());
        model.addAttribute("perso2", new People());
        return "index";
    }

    @PostMapping("/match")
    public String matchPost(Model model,
                            @RequestParam() int planetId,
                            @RequestParam String gender,
                            @RequestParam String eyeColor,
                            @RequestParam String hairColor) {
        List<People> people = peopleRepository.findAllPeople(planetId, gender, eyeColor, hairColor);
        int sizePeople = people.size();
        People perso1 = new People();
        People perso2 = new People();

        if (sizePeople > 2) {
            Random randomNumberGenerator = new Random();
            int[] peoplePositions = randomNumberGenerator.ints(2, 1, sizePeople).toArray();
            perso1 = people.get(peoplePositions[0]);
            perso2 = people.get(peoplePositions[1]);
        }

        model.addAttribute("perso1", perso1);
        model.addAttribute("perso2", perso2);
        model.addAttribute("eyes", peopleRepository.findAllEye());
        model.addAttribute("planets", planetRepository.findAll());
        model.addAttribute("genders", peopleRepository.findAllGender());
        model.addAttribute("hairColors", peopleRepository.findAllHairColors());
        return "index";
    }

    @GetMapping("/about-us")
    public String aboutUs() {

        return "about-us";
    }

}
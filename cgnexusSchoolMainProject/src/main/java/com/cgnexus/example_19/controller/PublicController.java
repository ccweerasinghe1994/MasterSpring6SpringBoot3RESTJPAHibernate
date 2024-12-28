package com.cgnexus.example_19.controller;

import com.cgnexus.example_19.model.Person;
import com.cgnexus.example_19.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("public")
@RequiredArgsConstructor
public class PublicController {

    private final PersonService personService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {

        boolean isSaved = personService.createNewPerson(person);

        if (isSaved) {
            return "redirect:/login?register=true";
        } else {
            return "register";
        }

    }
}

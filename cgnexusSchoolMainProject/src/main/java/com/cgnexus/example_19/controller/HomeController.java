package com.cgnexus.example_19.controller;


import com.cgnexus.example_19.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/home","/",""})
    public String displayHomePage() {
        return "home";
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser() {
        return ResponseEntity.ok(new UserDto("John Doe"));
    }
}

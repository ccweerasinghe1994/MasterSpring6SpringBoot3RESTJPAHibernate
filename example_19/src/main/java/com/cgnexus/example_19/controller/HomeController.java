package com.cgnexus.example_19.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping(value ={"/home", "", "/"})
    public String getHome(){
        return "home.html";
    }
}

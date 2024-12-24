package com.cgnexus.example_19.controller;


import com.cgnexus.example_19.model.Contact;
import com.cgnexus.example_19.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ContactController {

    private final ContactService contactService;

    @RequestMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to : {}", errors.toString());
            return "contact";
        }
        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @GetMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contacts = contactService.findMessagesWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages");
        modelAndView.addObject("contactMsgs", contacts);
        return modelAndView;
    }

}

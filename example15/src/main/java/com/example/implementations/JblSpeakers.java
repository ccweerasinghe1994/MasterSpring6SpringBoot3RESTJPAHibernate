package com.example.implementations;

import com.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class JblSpeakers implements Speakers {
    @Override
    public String makeSound() {
        return "playing music using JBL speakers";
    }
}

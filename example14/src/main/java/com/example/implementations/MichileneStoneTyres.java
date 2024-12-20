package com.example.implementations;

import com.example.interfaces.Tyre;
import org.springframework.stereotype.Component;

@Component
public class MichileneStoneTyres implements Tyre {
    @Override
    public String rotate() {
        return "Rotating using MichileneStone Tyres";
    }
}

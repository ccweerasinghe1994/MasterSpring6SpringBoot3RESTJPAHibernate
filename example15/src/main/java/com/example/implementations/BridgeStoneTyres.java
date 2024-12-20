package com.example.implementations;

import com.example.interfaces.Tyre;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BridgeStoneTyres implements Tyre {
    @Override
    public String rotate() {
        return "Rotating using BridgeStone Tyres";
    }
}

package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {

    Tyre tyre;

    Speakers speakers;

    @Autowired
    public VehicleService(Tyre tyre, Speakers speakers) {
        this.tyre = tyre;
        this.speakers = speakers;
    }

    public void moveTheVehicle() {
        System.out.println(tyre.rotate());
    }

    public void palMusic() {
        System.out.println(speakers.makeSound());
    }
}

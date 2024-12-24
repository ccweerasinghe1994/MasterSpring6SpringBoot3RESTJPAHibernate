package com.cgnexus.example_19.controller;

import com.cgnexus.example_19.model.Holiday;
import com.cgnexus.example_19.repository.HolidayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class HolidaysController {

    private final HolidayRepository holidayRepository;

    public HolidaysController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @GetMapping("/holidays/{display}")
    public String displayHolidays(
            Model model,
            @PathVariable String display) {

        if (null != display && display.equals("all")) {
            model.addAttribute("festival", true);
            model.addAttribute("federal", true);
        } else if (null != display && display.equals("festival")) {
            model.addAttribute("festival", true);
        } else if (null != display && display.equals("federal")) {
            model.addAttribute("federal", true);
        }

        List<Holiday> holidays = holidayRepository.findAllHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }
        return "holidays";
    }
}

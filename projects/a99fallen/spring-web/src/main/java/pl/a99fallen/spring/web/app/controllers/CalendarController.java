package pl.a99fallen.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/calendar")
public class CalendarController {
    @GetMapping
    public String sundays() {
        LocalDate today = LocalDate.now();
        LocalDate lastDay = Year.now().plusYears(1).atDay(1).minusDays(1);
        return today.datesUntil(lastDay)
                .filter(day -> day.getDayOfWeek() == DayOfWeek.SATURDAY || day.getDayOfWeek() == DayOfWeek.SUNDAY)
                .map(day -> day.getDayOfWeek().name() + " " + day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .collect(Collectors.joining());
    }
}

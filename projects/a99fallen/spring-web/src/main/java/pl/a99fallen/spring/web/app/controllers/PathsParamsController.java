package pl.a99fallen.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Controller
@ResponseBody
@RequestMapping("/paths/user")
public class PathsParamsController {

    @GetMapping("/raw/**")
    public String raw(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String[] segments = requestURI.substring(requestURI.indexOf("/paths/user")).split("/");

        String id = null;
        String operation = null;

        if (segments.length == 5) {
            id = segments[4];
            operation = null;
        } else if (segments.length == 6) {
            id = segments[4];
            operation = segments[5];
        }

        if (id == null && operation == null) {
            return "Brak wartości w ścieżce";
        } else if (operation == null) {
            return "id=" + id;
        } else if (id == null) {
            return "operation=" + operation;
        } else {
            return "id=" + id + " i operation=" + operation;
        }
    }

    @GetMapping("/spring/{id:[1-9][0-9]*}/{operation:get|add|edit|delete}")
    public String spring(@PathVariable("id") Long id, @PathVariable() String operation) {
        return "id=" + id + " i operation=" + operation;
    }
}

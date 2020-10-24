package pl.a99fallen.spring.web.app.controllers;

import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RequestMapping("/parameters")
public class ParameterController {

    @GetMapping("/raw")
    public String serveRawParameters (HttpServletRequest request) {
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        if (first == null && second == null) {
            return "Brak parametrów";
        } else if (first == null) {
            return "second=" + second;
        } else if (second == null) {
            return "first=" + first;
        } else {
            return "fists=" + first + " i second=" + second;
        }
    }

    @GetMapping("/spring")
    public String serveSpringParameters(@RequestParam(required = false) String first,
                                        @RequestParam(defaultValue = "Abrakadabra") String second) {
        if (first == null) {
            return "second=" + second;
        }
        else {
            return "first=" + first + " i second=" + second;
        }
    }

}

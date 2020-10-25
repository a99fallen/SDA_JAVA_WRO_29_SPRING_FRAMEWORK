package pl.a99fallen.spring.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Value("#{systemProperties['user.name']}")
    private String username;

    @GetMapping
    @ResponseBody
    public String sayHello() {
        return username + " jesteś dupa";
    }

    @GetMapping("/say-hello")
    public String sayHelloWithView() {
        return "hello";
    }
}

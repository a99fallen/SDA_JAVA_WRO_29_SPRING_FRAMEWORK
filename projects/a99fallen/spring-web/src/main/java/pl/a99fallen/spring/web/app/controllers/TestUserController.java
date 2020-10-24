package pl.a99fallen.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/user/test")
public class TestUserController {
    @GetMapping
    public String get() {
        return "TestUserController.get";
    }
    @PostMapping
    public String post() {
        return "TestUserController.post";
    }
    @PutMapping
    public String put() {
        return "TestUserController.get";
    }
    @DeleteMapping
    public String delete() {
        return "TestUserController.delete";
    }
}

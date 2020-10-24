package pl.a99fallen.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/book/test/{id}")
public class TestBookController {
    @GetMapping
    public String get() {
        return "TestBookController.get";
    }
    @PostMapping("/add")
    public String add() {
      return "TestBookController.add";
    }
    @PostMapping("/edit")
    public String edit() {
        return "TestBookController.edit";
    }
    @PostMapping("/delete")
    public String delete() {
        return "TestBookController.delete";
    }
}

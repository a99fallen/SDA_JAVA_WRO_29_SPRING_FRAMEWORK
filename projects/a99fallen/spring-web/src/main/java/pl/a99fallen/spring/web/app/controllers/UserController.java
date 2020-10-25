package pl.a99fallen.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.a99fallen.spring.web.app.data.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id:[1-9][0-9]*}")
    public String showUser(@PathVariable Long id, Model model) {
        User user = User.builder()
        .id(id)
        .firstName("Jan")
        .lastName("Kowalski")
        .age(35)
        .gender("mężczyzna")
        .build();
//        User user = new User();
//        user.setId(id);
//        user.setFirstName("Jan");
//        user.setLastName("Kowalski");
//        user.setAge(35);
//        user.setGender("mężczyzna");
        model.addAttribute("user", user);
//        model.addAttribute(user);     //to jest skrócona wersja zapisu
//        ale trzeba pamiętać
//        UserFake user = UserFake.builder().build;()
//        model.addAttribute("userFake", user); -> model.addAttribute(user);
        return "user";
    }

    @GetMapping("/add")
    public String prepareUserCreation() {
        return "add-user";
    }

    @PostMapping("/add")
    public String createUser(String firstName, String lastName, Integer age, String gender, Model model, HttpSession httpSession) {
        Long id = nextIdFromSession(httpSession);
        User user = User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .gender(gender)
                .build();
        model.addAttribute("newUser", user);
        return "user";
    }

    private Long nextIdFromSession(HttpSession httpSession) {
        if (httpSession.getAttribute("nextUserId") == null) {
            httpSession.setAttribute("nextUserId", 1L);
        }
        Long nextUserId = (Long) httpSession.getAttribute("nextUserId");
        httpSession.setAttribute("nextUserId", nextUserId + 1);
        return nextUserId;
    }
}

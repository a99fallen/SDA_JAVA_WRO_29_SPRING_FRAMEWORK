package pl.a99fallen.spring.web.app.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.a99fallen.spring.web.app.data.User;
import pl.a99fallen.spring.web.app.data.UserDTO;
import pl.a99fallen.spring.web.app.services.UserService;
import pl.a99fallen.spring.web.app.session.UserIdGenerator;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

//    private final UserIdGenerator userIdGenerator;
    private final UserService userService;

    @GetMapping("/{id:[1-9][0-9]*}")
    public String showUser(@PathVariable Long id, Model model) {
        UserDTO user = userService.getUser(id);
        if (user == null) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND), "Użytkownik o id = " + id + " nie istnieje");
        }
//        to było wcześniej
//        User user = User.builder()
//        .id(id)
//        .firstName("Jan")
//        .lastName("Kowalski")
//        .age(35)
//        .gender("mężczyzna")
//        .country("Polska")
//        .build();
////        User user = new User();
////        user.setId(id);
////        user.setFirstName("Jan");
////        user.setLastName("Kowalski");
////        user.setAge(35);
////        user.setGender("mężczyzna");
        model.addAttribute("user", user);
////        model.addAttribute(user);     //to jest skrócona wersja zapisu
////        ale trzeba pamiętać
////        UserFake user = UserFake.builder().build;()
////        model.addAttribute("userFake", user); -> model.addAttribute(user);
        return "user";
    }

    @GetMapping("/add")
    public String prepareUserCreation() {
        return "add-user";
    }

    @PostMapping("/add")
    public String createUser(UserDTO userDTO) {
//            (String firstName, String lastName, Integer age, String gender,
//                             String country, Model model) { //Wyrzucony z parametru HttpSession httpSession
//        Long id = nextIdFromSession(httpSession);
//        Long id = userIdGenerator.getNextId();
//        User user = User.builder()
//                .id(id)
//                .firstName(firstName)
//                .lastName(lastName)
//                .age(age)
//                .gender(gender)
//                .country(country)
//                .build();
//        model.addAttribute("user", user);
//        return "user";
        Long userId = userService.saveUser(userDTO);
        return "redirect:/users/" + userId;
    }

//    private Long nextIdFromSession(HttpSession httpSession) {
//        if (httpSession.getAttribute("nextUserId") == null) {
//            httpSession.setAttribute("nextUserId", 1L);
//        }
//        Long nextUserId = (Long) httpSession.getAttribute("nextUserId");
//        httpSession.setAttribute("nextUserId", nextUserId + 1);
//        return nextUserId;
//    }

    @ModelAttribute("countries")
    public List<String> countries() {
//        List<String> countries = new ArrayList<>();
//        countries.add("Polska");
//        countries.add("Niemcy");
//        countries.add("Hiszpania");
        return Arrays.asList("Polska","Niemcy", "Francja");
    }
}

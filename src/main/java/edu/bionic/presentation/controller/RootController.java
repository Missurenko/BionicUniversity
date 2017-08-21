package edu.bionic.presentation.controller;

import edu.bionic.domain.User;
import edu.bionic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RootController {

    private UserService userService;

    public RootController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMainPage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("newUser") User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerNewUser(user);
        return "redirect:/";
    }
}
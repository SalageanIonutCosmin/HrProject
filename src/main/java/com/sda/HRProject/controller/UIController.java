package com.sda.HRProject.controller;

import com.sda.HRProject.converter.UserConverter;
import com.sda.HRProject.dto.UserDto;
import com.sda.HRProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "")
public class UIController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public String index() {
        return "homePage";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "adminHomePage";
    }

    @GetMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "userAddView";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute(name = "user") UserDto userDto) {
        try {
            userService.addUser(UserConverter.convertBack(userDto));
        } catch (Exception e) {
            return "redirect:register?error";
        }
        return "redirect:register?success";
    }
}

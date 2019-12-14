package com.sda.HRProject.controller;

import com.sda.HRProject.dto.UserDto;
import com.sda.HRProject.model.User;
import com.sda.HRProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public String findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "100") Integer size,
                          ModelMap modelMap) {
        List<UserDto> userDtos = userService.findAll(page, size);
        modelMap.addAttribute("userList", userDtos);
        return "userListView";
    }

    @GetMapping(value = "{id}")
    public String findById(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        User byId = userService.findById(id);
        modelMap.addAttribute("userList", byId);
        return "userListView";
    }

    @GetMapping(value = "/findByUserName/{userName}")
    public String findByUserName(@PathVariable(name = "userName") String userName, ModelMap modelMap) {
        User byUserName = userService.findByUserName(userName);
        modelMap.addAttribute("userList", byUserName);
        return "userListView";
    }

    @GetMapping(value = "/findByFirstName/{firstName}")
    public String findByFirstName(@PathVariable(name = "firstName") String firstName, ModelMap modelMap) {
        List<User> byFirstName = userService.findByFirstName(firstName);
        modelMap.addAttribute("userList", byFirstName);
        return "userListView";
    }

    @GetMapping(value = "findByLastName/{lastName}")
    public String findByLastName(@PathVariable(name = "lastName") String lastName, ModelMap modelMap) {
        List<User> byLastName = userService.findByLastName(lastName);
        modelMap.addAttribute("userList", byLastName);
        return "userListView";
    }

    @GetMapping(value = "findByEmail/{email}")
    public String findByEmail(@PathVariable(name = "email") String email, ModelMap modelMap) {
        User byEmail = userService.findByEmail(email);
        modelMap.addAttribute("userList", byEmail);
        return "userListView";
    }

    @PostMapping(value = "")
    public String addUser(@RequestBody User user, ModelMap modelMap) {
        List<User> userList = userService.addUser(user);
        modelMap.addAttribute("userList", userList);
        return "userListView";
    }

    @GetMapping(value = "/update")
    public String updateUserView(@PathVariable(name = "id") Integer id,
                                 ModelMap modelMap) {
        User user = userService.findById(id);
        modelMap.addAttribute("userList", user);
        return "userUpdateView";
    }

    @PostMapping(value = "/update")
    public String updateUserSave(@PathVariable(name = "id") Integer id,
                                 @RequestBody User user,
                                 ModelMap modelMap) {
        List<User> userList = userService.updateUser(id, user);
        modelMap.addAttribute("userList", userList);
        return "userListView";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id, ModelMap modelMap) {
        List<User> userList = userService.deleteUser(id);
        modelMap.addAttribute("userList", userList);
        return "userListView";
    }

    @GetMapping(value = "/count")
    public String cound(ModelMap modelMap) {
        long count = userService.count();
        modelMap.addAttribute("userList", count);
        return "userListView";
    }
}
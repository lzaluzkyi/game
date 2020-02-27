package com.rpg.controller;

import com.rpg.dto.UserDto;
import com.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public UserDto getModel(){
        return new UserDto();
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") UserDto userDto , BindingResult bindingResult){
        if (bindingResult.hasErrors())return "registration";
        userService.registration(userDto);
        return "redirect:/login";
    }


}

package com.rpg.controller;

import com.rpg.dto.UserDto;
import com.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/registration")
    public String getRegistration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@RequestParam(name = "login") String login ,
                               @RequestParam(name = "password")String password){
        userService.registration(new UserDto(login , password));
        return "redirect:/login";
    }


}

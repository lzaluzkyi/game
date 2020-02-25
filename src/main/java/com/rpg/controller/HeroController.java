package com.rpg.controller;

import com.google.gson.Gson;
import com.rpg.dto.HeroDto;
import com.rpg.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping("gethero/{id}")
    @ResponseBody
    public String getOne(@PathVariable(name = "id") Long id){
        Gson gson = new Gson();
        return gson.toJson(new HeroDto(heroService.getOneWithClassBonus(id)));

    }


}

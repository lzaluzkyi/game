package com.rpg.dto;

import com.rpg.entity.Location;
import com.rpg.entity.Monster;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocationDto {

    private Long id;

    private String name;

    private List<MonsterDto> monsters = new ArrayList<>();

    public LocationDto(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        if (location.getMonsters() != null){
            for (Monster monster : location.getMonsters()) {
                this.monsters.add(new MonsterDto(monster));
            }
        }
    }
}

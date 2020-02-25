package com.rpg.service;

import com.rpg.entity.Monster;

public interface MonsterService {

    Monster save(Monster monster);

    Monster getOne(Long id);
}

package com.rpg.service.impl;

import com.rpg.entity.Monster;
import com.rpg.repository.MonsterRepository;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRepository repository;

    @Override
    public Monster save(Monster monster) {
        return repository.save(monster);
    }

    @Override
    public Monster getOne(Long id) {
        return repository.getOne(id);
}
}

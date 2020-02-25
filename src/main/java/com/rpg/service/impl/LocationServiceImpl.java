package com.rpg.service.impl;

import com.rpg.entity.Location;
import com.rpg.entity.Monster;
import com.rpg.repository.LocationRepository;
import com.rpg.service.LocationService;
import com.rpg.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Autowired
    private MonsterService monsterService;

    @Override
    public Location save(Location location) {
        return repository.save(location);
    }

    @Override
    public Location getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Location> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Location getLocationByMonsterId(Long monsterId) {
        Monster monster = monsterService.getOne(monsterId);
        return monster.getLocation();
    }
}

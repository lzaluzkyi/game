package com.rpg.service;

import com.rpg.entity.Location;

import java.util.List;

public interface LocationService {

    Location save (Location location);

    Location getOne(Long id);

    List<Location>getAll();

    void delete(Long id);

    Location getLocationByMonsterId(Long monsterId);


}

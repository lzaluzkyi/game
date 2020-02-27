package com.rpg.service;

import com.rpg.dto.UserDto;
import com.rpg.entity.User;

public interface UserService {

    User save(User user);

    User registration (UserDto userDto);

    User getOne(Long id);

}

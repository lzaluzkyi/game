package com.rpg.service.impl;

import com.rpg.dto.UserDto;
import com.rpg.entity.Role;
import com.rpg.entity.User;
import com.rpg.repository.UserRepository;
import com.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userDetailsService")
public class UserServiceImpl implements UserService , UserDetailsService {

    @Autowired
    private UserRepository repository;



    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User registration(UserDto userDto) {
        User user = new User();

        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getLogin());
        user.setRole(Role.USER);
        return save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byUserName = repository.findByUserName(s);
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(byUserName.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(
                byUserName.getUserName() ,
                byUserName.getPassword() ,
                simpleGrantedAuthorities
        );
    }
}

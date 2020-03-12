package com.rpg.service.impl;

import com.rpg.dto.UserDto;
import com.rpg.entity.Role;
import com.rpg.entity.User;
import com.rpg.repository.UserRepository;
import com.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User registration(UserDto userDto) {
//        if (!registrationValidation(userDto)) throw new AccessDeniedException("Bad data");

        User user = new User();
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setNickName(userDto.getLogin());
        if (userDto.getLogin().equals("admin")) user.setRole(Role.ADMIN);
        else user.setRole(Role.USER);
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        return save(user);
    }

    @Override
    public User getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byUserName = repository.findByNickName(s);
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + byUserName.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(
                byUserName.getNickName(),
                byUserName.getPassword(),
                simpleGrantedAuthorities
        );
    }

    private Boolean registrationValidation(UserDto userDto) {
        if (!userDto.getEmail().contains("@")) return false;
        if (!userDto.getPassword().equals(userDto.getPasswordRepeat())) return false;
        if (userDto.getPhone().length() != 10) return false;
        if (repository.countByEmail(userDto.getEmail()) > 0) return false;
        if (repository.countByNickName(userDto.getLogin()) > 0) return false;
        if (repository.countByPhone(userDto.getPhone()) > 0) return false;
        return true;
    }
}

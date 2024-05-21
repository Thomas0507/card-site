package com.site.card.site.services;

import com.site.card.site.entities.AppUser;
import com.site.card.site.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public AppUser addUser(AppUser user) {
        return userRepository.save(user);
    }


    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
}

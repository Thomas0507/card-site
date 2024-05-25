package com.site.card.site.services;

import com.site.card.site.entities.AppUser;
import com.site.card.site.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser addUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public Optional<AppUser> findUserByUserName(String username) {
        return appUserRepository
                .findByUserName(username);
    }

}

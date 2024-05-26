package com.site.card.site.repositories;

import com.site.card.site.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    Optional<AppUser> findByUserName(String username);
    Optional<AppUser> findById(long id);

//     List<AppUser> findAll();
}

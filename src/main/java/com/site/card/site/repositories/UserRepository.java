package com.site.card.site.repositories;

import com.site.card.site.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<AppUser, Integer> {

    public List<AppUser> findByName(String name);

    public List<AppUser> findAll();
}

package com.site.card.site.repositories;

import com.site.card.site.entities.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {

    public List<Card> findByName(String name);

    @Query(value = "SELECT * FROM card", nativeQuery = true)
    public List<Card> findAll();
}

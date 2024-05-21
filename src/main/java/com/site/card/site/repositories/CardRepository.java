package com.site.card.site.repositories;

import com.site.card.site.entities.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {

    public List<Card> findByName(String name);

    public List<Card> findAll();
}

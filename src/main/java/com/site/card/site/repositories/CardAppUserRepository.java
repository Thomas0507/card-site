package com.site.card.site.repositories;

import com.site.card.site.entities.CardAssociation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CardAppUserRepository extends CrudRepository<CardAssociation, Integer> {

    Optional<CardAssociation> findByAppUserIdAndCardId(long appUserId, long cardId);

    Optional<List<CardAssociation>> findByAppUserId(long appUserId);
}

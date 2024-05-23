package com.site.card.site.repositories;

import com.site.card.site.entities.CardAssociation;
import org.springframework.data.repository.CrudRepository;

public interface CardAppUserRepository extends CrudRepository<CardAssociation, Integer> {

    CardAssociation findByAppUserIdAndCardId(long appUserId, long cardId);
}

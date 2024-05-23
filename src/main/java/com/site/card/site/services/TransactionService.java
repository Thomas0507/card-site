package com.site.card.site.services;

import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.Card;
import com.site.card.site.entities.CardAssociation;
import com.site.card.site.repositories.CardAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    CardAppUserRepository cardAppUserRepository;

    public CardDTO buyCard(String appUserId, String cardId) {
        CardAssociation cardAssociation = findCardAssociation(Long.parseLong(appUserId), Long.parseLong(cardId));
        // check if already existing
        if (cardAssociation == null) {
            cardAssociation = new CardAssociation(Long.parseLong(appUserId), Long.parseLong(cardId), 1);
        }
        cardAppUserRepository.save(cardAssociation);
        return null;
    }

    public CardDTO sellCard(String appUserId, String cardId) {
        // todo: to be implemented
        return null;
    }

    public CardAssociation findCardAssociation(long appUserId, long cardId) {
        return cardAppUserRepository.findByAppUserIdAndCardId(appUserId, cardId);
    }
}

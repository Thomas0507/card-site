package com.site.card.site.services;

import com.site.card.site.associations.CardAssociationId;
import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.Card;
import com.site.card.site.entities.CardAssociation;
import com.site.card.site.repositories.CardAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    CardAppUserRepository cardAppUserRepository;

    public CardDTO buyCard(String appUserId, String cardId) {
        Optional<CardAssociation> cardAssociation = findCardAssociation(Long.parseLong(appUserId), Long.parseLong(cardId));
        // check if already existing
        if (cardAssociation.isPresent()) {
            CardAssociation cardAsso = cardAssociation.get();
            cardAppUserRepository.save(new CardAssociation(cardAsso.getAppUserId(), cardAsso.getCardId(), cardAsso.getQuantity() + 1));
        } else {
            cardAppUserRepository.save(new CardAssociation(Long.parseLong(appUserId), Long.parseLong(cardId), 1));
        }
        return null;
    }

    public CardDTO sellCard(String appUserId, String cardId) {
        Optional<CardAssociation> cardAssociation = findCardAssociation(Long.parseLong(appUserId), Long.parseLong(cardId));
        if (cardAssociation.isPresent()) {
            CardAssociation cardAsso = cardAssociation.get();
            if (cardAsso.getQuantity() > 1) {
                cardAppUserRepository.save(new CardAssociation(cardAsso.getAppUserId(), cardAsso.getCardId(), cardAsso.getQuantity() - 1));
            } else {
                cardAppUserRepository.delete(cardAsso);
            }
        }
        return null;
    }

    public Optional<CardAssociation> findCardAssociation(long appUserId, long cardId) {
        return cardAppUserRepository.findByAppUserIdAndCardId(appUserId, cardId);
    }

    public Optional<List<CardAssociation>> findCardAssociationsByUser(long appUserId) {
        return cardAppUserRepository.findByAppUserId(appUserId);
    }
}

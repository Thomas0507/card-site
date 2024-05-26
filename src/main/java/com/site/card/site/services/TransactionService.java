package com.site.card.site.services;

import com.site.card.site.associations.CardAssociationId;
import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.AppUser;
import com.site.card.site.entities.Card;
import com.site.card.site.entities.CardAssociation;
import com.site.card.site.repositories.AppUserRepository;
import com.site.card.site.repositories.CardAppUserRepository;
import com.site.card.site.repositories.CardRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    CardAppUserRepository cardAppUserRepository;

    public CardAssociation buyCard(AppUser appUser, Card card) {
        Optional<CardAssociation> cardAssociation = findCardAssociation(appUser.getId(), card.getId());
        float userMoney = appUser.getMoney();
        float cardPrice = card.getPrice();
        if(userMoney >= cardPrice){
            appUser.setMoney(userMoney - cardPrice);
            if (cardAssociation.isPresent()) {
                CardAssociation cardAsso = cardAssociation.get();
                return cardAppUserRepository.save(new CardAssociation(cardAsso.getAppUserId(), cardAsso.getCardId(), cardAsso.getQuantity() + 1));
            } else {
                return cardAppUserRepository.save(new CardAssociation(appUser.getId(), card.getId(), 1));
            }
        }
        return null;
    }

    public CardAssociation sellCard(AppUser appUser, Card card) {
        Optional<CardAssociation> cardAssociation = findCardAssociation(appUser.getId(), card.getId());
        float userMoney = appUser.getMoney();
        float cardPrice = card.getPrice();
        appUser.setMoney(userMoney + cardPrice);
        if (cardAssociation.isPresent()) {
            CardAssociation cardAsso = cardAssociation.get();
            if (cardAsso.getQuantity() > 1) {
                return cardAppUserRepository.save(new CardAssociation(cardAsso.getAppUserId(), cardAsso.getCardId(), cardAsso.getQuantity() - 1));
            } else {
                cardAppUserRepository.delete(cardAsso);
                return  cardAsso;
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

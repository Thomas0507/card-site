package com.site.card.site.services;

import com.site.card.site.entities.Card;
import com.site.card.site.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card addCard(Card card) {
        return cardRepository.save(card);
    }
    public Optional<Card> getCard(int id) {
        return cardRepository.findById(id);
    }
    public List<Card> findCard(String name) {
        return cardRepository.findByName(name);
    }
}

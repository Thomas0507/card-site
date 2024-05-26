package com.site.card.site.mappersImpl;

import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.Card;
import com.site.card.site.mappers.CardEntityToCardDTO;

public class CardEntityToCardDTOImpl implements CardEntityToCardDTO {

    public CardEntityToCardDTOImpl() {

    }

    @Override
    public CardDTO cardEntityToCardDTO(Card card) {
        return new CardDTO(card.getId(),
                card.getName(),
                card.getDescription(),
                card.getAffinity(),
                card.getFamily(),
                card.getEnergy(),
                card.getHp(),
                card.getPrice(),
                card.getUrl());
    }
}

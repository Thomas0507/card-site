package com.site.card.site.mappers;

import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.Card;

public interface CardEntityToCardDTO {
    CardDTO cardEntityToCardDTO(Card card);
}

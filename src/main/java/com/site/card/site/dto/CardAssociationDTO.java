package com.site.card.site.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CardAssociationDTO {
    private CardDTO card;
    private int quantity;

    public CardAssociationDTO(CardDTO card, int quantity) {
        this.card = card;
        this.quantity = quantity;
    }
}

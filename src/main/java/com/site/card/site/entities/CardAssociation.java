package com.site.card.site.entities;

import com.site.card.site.associations.CardAssociationId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "CARD_APPUSER")
@IdClass(CardAssociationId.class)
public class CardAssociation {
    @Id
    private long appUserId;
    @Id
    private long cardId;
    @Column(name="QUANTITY")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "appUserId", updatable = false, insertable = false)
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name="cardId", updatable = false, insertable = false)
    private Card card;

    public CardAssociation() {

    }

    public CardAssociation(long appUserId, long cardId, int quantity) {
        this.appUserId = appUserId;
        this.cardId = cardId;
        this.quantity = quantity;
    }
}

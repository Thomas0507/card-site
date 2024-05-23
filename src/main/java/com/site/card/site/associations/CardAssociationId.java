package com.site.card.site.associations;

import java.io.Serializable;

public class CardAssociationId implements Serializable {

    private long appUserId;
    private long cardId;


    public int hashcode() {
        return (int) (appUserId + cardId);
    }
    public boolean equals(Object object) {
        if (object instanceof CardAssociationId) {
            CardAssociationId otherId = (CardAssociationId) object;
            return (otherId.appUserId == this.appUserId) && (otherId.cardId == this.cardId);
        }
        return false;
    }
}

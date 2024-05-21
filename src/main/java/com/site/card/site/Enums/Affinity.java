package com.site.card.site.Enums;

import lombok.Getter;

public enum Affinity {
    NONE(""),
    FIRE("Fire");

    @Getter
    final
    String affinity;
    Affinity(String affinity) {
        this.affinity = affinity;
    }
}

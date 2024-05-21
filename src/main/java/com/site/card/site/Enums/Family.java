package com.site.card.site.Enums;

import lombok.Getter;

public enum Family {
    NONE(""),
    HTF("Happy Family Three");

    @Getter
    final
    String family;
    Family(String family) {
        this.family = family;
    }
}

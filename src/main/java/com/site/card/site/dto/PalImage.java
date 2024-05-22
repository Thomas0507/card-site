package com.site.card.site.dto;

import lombok.Getter;
import lombok.Setter;

public class PalImage {
    @Getter
    @Setter
    String imageUrl;
    public PalImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

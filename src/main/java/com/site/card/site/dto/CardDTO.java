package com.site.card.site.dto;

import lombok.Getter;
import lombok.Setter;

public class CardDTO {
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private String family;
    @Getter @Setter
    private String affinity;
    @Getter @Setter
    private float energy;
    @Getter @Setter
    private float hp;
    @Getter @Setter
    private float price;
    @Getter @Setter
    private String url;

    public CardDTO(long id, String name, String description, String affinity, String family, float energy, float hp, float price, String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.affinity = affinity;
        this.family = family;
        this.energy = energy;
        this.hp = hp;
        this.price = price;
        this.url = url;
    }
}

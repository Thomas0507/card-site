package com.site.card.site.entities;

import com.site.card.site.Enums.Affinity;
import com.site.card.site.Enums.Family;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Card {

    @Id
    @GeneratedValue
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private Family family;
    @Getter @Setter
    private Affinity affinity;
    @Getter @Setter
    private float energy;
    @Getter @Setter
    private float hp;
    @Getter @Setter
    private float price;

    public Card() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.family = Family.NONE;
        this.affinity = Affinity.NONE;
        this.energy = 0;
        this.hp = 0;
        this.price = 0;
    }
    public Card(int id, String name, String description, String affinity, String family, float energy, float hp, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.affinity = Affinity.valueOf(affinity);
        this.family = Family.valueOf(family);
        this.energy = energy;
        this.hp = hp;
        this.price = price;
    }
}

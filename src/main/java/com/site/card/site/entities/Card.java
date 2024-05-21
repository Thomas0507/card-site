package com.site.card.site.entities;

import com.site.card.site.Enums.Affinity;
import com.site.card.site.Enums.Family;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "family")
    private Family family;
    @Column(name = "affinity")
    private Affinity affinity;
    @Column(name = "energy")
    private float energy;
    @Column(name = "hp")
    private float hp;
    @Column(name = "price")
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

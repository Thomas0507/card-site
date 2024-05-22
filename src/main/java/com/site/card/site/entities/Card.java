package com.site.card.site.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false, updatable = false)
    @Getter @Setter
    private int id;
    @Getter @Setter
    @Column(name = "name")
    private String name;
    @Getter @Setter
    @Column(name = "description")
    private String description;
    @Getter @Setter
    @Column(name = "family")
    private String family;
    @Getter @Setter
    @Column(name = "affinity")
    private String affinity;
    @Getter @Setter
    @Column(name = "energy")
    private float energy;
    @Getter @Setter
    @Column(name = "hp")
    private float hp;
    @Getter @Setter
    @Column(name = "price")
    private float price;

    public Card() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.family = "";
        this.affinity = "";
        this.energy = 0;
        this.hp = 0;
        this.price = 0;
    }
    public Card(int id, String name, String description, String affinity, String family, float energy, float hp, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.affinity = affinity;
        this.family = family;
        this.energy = energy;
        this.hp = hp;
        this.price = price;
    }
}

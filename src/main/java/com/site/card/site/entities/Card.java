package com.site.card.site.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Card {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    private long id;
    private String name;
    private String description;
    private String family;
    private String affinity;
    private float energy;
    private float hp;
    private float price;
    private String url;

    @OneToMany(mappedBy = "card")
    private List<CardAssociation> appUsers;

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
    public Card(int id, String name, String description, String affinity, String family, float energy, float hp, float price, String url) {
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

    public void addUser(AppUser appUser, int quantity) {
        CardAssociation cardAssociation = new CardAssociation();
        cardAssociation.setAppUser(appUser);
        cardAssociation.setCard(this);
        cardAssociation.setAppUserId(appUser.getId());
        cardAssociation.setCardId(this.getId());
        cardAssociation.setQuantity(quantity);
        if (this.appUsers == null) {
            this.appUsers = new ArrayList<>();
        }
        this.appUsers.add(cardAssociation);
        appUser.getCards().add(cardAssociation);
    }
}

package com.site.card.site.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class AppUser {
    @Id
    private long id;
    String name;
    private String password;

    @OneToMany(mappedBy = "appUserId")
    private List<CardAssociation> cards;

    public AppUser() {
        this.id = 0;
        this.password = "";
    }
    // todo: refacto pour sécuriser le password
    public AppUser(int id, String password) {
        this.id = id;
        this.password = password;
    }
}

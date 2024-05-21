package com.site.card.site.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String password;

    // todo: refacto pour sécuriser le password
    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }
}

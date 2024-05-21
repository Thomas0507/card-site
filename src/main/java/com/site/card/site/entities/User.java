package com.site.card.site.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "password")
    private String password;

    public User() {
        this.id = 0;
        this.password = "";
    }
    // todo: refacto pour sécuriser le password
    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }
}

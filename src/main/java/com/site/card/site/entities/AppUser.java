package com.site.card.site.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "password")
    private String password;

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

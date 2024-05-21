package com.site.card.site.controllers;

import com.site.card.site.entities.AppUser;
import com.site.card.site.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public AppUser addUser(AppUser user) {
        return userService.addUser(user);
    }


}
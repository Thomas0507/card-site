package com.site.card.site.controllers;

import com.site.card.site.dto.AppUserDto;
import com.site.card.site.entities.AppUser;
import com.site.card.site.entities.CardAssociation;
import com.site.card.site.repositories.CardAppUserRepository;
import com.site.card.site.services.AppUserService;
import com.site.card.site.services.JwtService;
import com.site.card.site.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private JwtService jwtService;

    @GetMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public AppUser addUser(AppUser user) {
        return appUserService.addUser(user);
    }


    @GetMapping(value = "/infos")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(exposedHeaders = "Authorization", origins = "http://localhost:5173")
    public ResponseEntity<AppUserDto> getUserData(@RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.substring(7));
        AppUserDto appUserDto = appUserService.retrieveUserInfos(username);
        return ResponseEntity.ok(appUserDto);
    }

}

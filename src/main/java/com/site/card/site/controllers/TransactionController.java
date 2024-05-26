package com.site.card.site.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.AppUser;
import com.site.card.site.services.AppUserService;
import com.site.card.site.services.JwtService;
import com.site.card.site.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/transaction")

// Buy and Sell with the Server directly,
// todo: exchange with player
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AppUserService appUserService;

    @PostMapping(value = "/buy")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<CardDTO> buyCard(@RequestBody String card, @RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.substring(7));
        JsonObject cardJson = new Gson().fromJson(card, JsonObject.class);
        Optional<AppUser> user = appUserService.findUserByUserName(username);
        if (user.isPresent() && cardJson.get("id") != null) {
            CardDTO resCard = transactionService.buyCard(Long.toString(user.get().getId()), cardJson.get("id").getAsString());
            return ResponseEntity.ok(resCard);
        }
        
        return ResponseEntity.internalServerError().build();
    }
    @PostMapping(value = "/sell")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<CardDTO> sellCard(@RequestBody String card, @RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsername(token.substring(7));
        JsonObject cardJson = new Gson().fromJson(card, JsonObject.class);
        Optional<AppUser> user = appUserService.findUserByUserName(username);
        if (user.isPresent() && cardJson.get("id") != null) {
            CardDTO resCard = transactionService.sellCard(Long.toString(user.get().getId()), cardJson.get("id").getAsString());
            return ResponseEntity.ok(resCard);
        }

        return ResponseEntity.internalServerError().build();
    }
}

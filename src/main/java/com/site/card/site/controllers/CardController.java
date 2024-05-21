package com.site.card.site.controllers;

import com.site.card.site.entities.Card;
import com.site.card.site.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cards-api/v1")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping(value = "/cards")
    @ResponseStatus(HttpStatus.OK)
    public List<Card> cards() {
        return cardService.findCard("test");
    }


}

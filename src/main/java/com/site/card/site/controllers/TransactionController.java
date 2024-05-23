package com.site.card.site.controllers;

import com.site.card.site.dto.CardDTO;
import com.site.card.site.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/transaction")

// Buy and Sell with the Server directly,
// todo: exchange with player
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/buy")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:5173")
    public CardDTO buyCard(@RequestParam String cardId, @RequestParam String appUserId) {
        // todo: contrôle de l'user authentification
        //
            return transactionService.buyCard(appUserId, cardId);
    }
    @GetMapping(value = "/sell")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:5173")
    public CardDTO sellCard(@RequestParam String cardId, @RequestParam String appUserId) {
        // todo: contrôle de l'user authentification
        return transactionService.sellCard(appUserId, cardId);
    }
}

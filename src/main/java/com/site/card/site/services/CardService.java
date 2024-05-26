package com.site.card.site.services;

import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.Card;
import com.site.card.site.mappersImpl.CardEntityToCardDTOImpl;
import com.site.card.site.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    private final CardEntityToCardDTOImpl cardEntityToCardDTO = new CardEntityToCardDTOImpl();

    public Card addCard(Card card) {
        return cardRepository.save(card);
    }
    public Optional<Card> getCard(int id) {
        return cardRepository.findById(id);
    }
    public List<Card> findCard(String name) {
        return cardRepository.findByName(name);
    }
    public List<CardDTO> findAll() {
        List <Card>cardList = cardRepository.findAll();
        List <CardDTO> cardDTOList = new ArrayList<>();
        for(Card card: cardList) {
            CardDTO cardDTO = cardEntityToCardDTO.cardEntityToCardDTO(card);
            cardDTOList.add(cardDTO);
        }
        return cardDTOList;
    }
    private String getCardImgUrl(String name) {
        return "http://localhost:8080/"+ nameFormatter(name.toLowerCase()) + ".jpg";
    }
    private String nameFormatter(String name) {
        return name.replace(' ','_');
    }
}

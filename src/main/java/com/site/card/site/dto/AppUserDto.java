package com.site.card.site.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AppUserDto {
    private String username;
    private int money;
    private List<CardAssociationDTO> cards;
}

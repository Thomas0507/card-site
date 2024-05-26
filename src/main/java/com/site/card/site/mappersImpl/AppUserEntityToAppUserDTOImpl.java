package com.site.card.site.mappersImpl;

import com.site.card.site.dto.AppUserDto;
import com.site.card.site.entities.AppUser;
import com.site.card.site.mappers.AppUserEntityToAppUserDTO;
import com.site.card.site.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AppUserEntityToAppUserDTOImpl implements AppUserEntityToAppUserDTO {


    @Autowired
    private CardService cardService;
    @Override
    public AppUserDto appUserEntityToAppUserDTO(AppUser appUser) {
        AppUserDto appUserDto = new AppUserDto();

        appUserDto.setUsername(appUser.getUsername());
        appUserDto.setMoney(100);
        appUserDto.setCards(new ArrayList<>());
        return appUserDto;
    }
}

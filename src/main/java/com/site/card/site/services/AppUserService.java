package com.site.card.site.services;

import com.site.card.site.dto.AppUserDto;
import com.site.card.site.dto.CardAssociationDTO;
import com.site.card.site.dto.CardDTO;
import com.site.card.site.entities.AppUser;
import com.site.card.site.entities.Card;
import com.site.card.site.entities.CardAssociation;
import com.site.card.site.mappersImpl.AppUserEntityToAppUserDTOImpl;
import com.site.card.site.mappersImpl.CardEntityToCardDTOImpl;
import com.site.card.site.repositories.AppUserRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;
    private final AppUserEntityToAppUserDTOImpl appUserEntityToAppUserDTO = new AppUserEntityToAppUserDTOImpl();

    private final CardEntityToCardDTOImpl cardEntityToCardDTO  = new CardEntityToCardDTOImpl();;

    public AppUser addUser(AppUser user) {
        return appUserRepository.save(user);
    }

    public AppUserDto retrieveUserInfos(String username) {
        Optional<AppUser> appUser = appUserRepository.findByUserName(username);
        if (appUser.isPresent()) {
            AppUserDto appUserDto = appUserEntityToAppUserDTO.appUserEntityToAppUserDTO(appUser.get());
            for(CardAssociation cardAssociation: appUser.get().getCards()) {
                appUserDto.getCards().add(
                        new CardAssociationDTO(cardEntityToCardDTO.cardEntityToCardDTO(cardAssociation.getCard()), cardAssociation.getQuantity())
                        );
            }
            return appUserDto;
        } else
            return null;
    }
    public Optional<AppUser> findUserByUserName(String username) {
        return appUserRepository
                .findByUserName(username);
    }

}

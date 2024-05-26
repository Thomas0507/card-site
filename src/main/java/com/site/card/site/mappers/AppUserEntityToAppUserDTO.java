package com.site.card.site.mappers;

import com.site.card.site.dto.AppUserDto;
import com.site.card.site.entities.AppUser;

public interface AppUserEntityToAppUserDTO {
    AppUserDto appUserEntityToAppUserDTO(AppUser appUser);
}

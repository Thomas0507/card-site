package com.site.card.site.services;

import com.site.card.site.dto.LogInUserDto;
import com.site.card.site.dto.RegisterUserDto;
import com.site.card.site.entities.AppUser;
import com.site.card.site.repositories.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public AppUser signup(RegisterUserDto registerUserDto) {
        AppUser appUser = new AppUser(registerUserDto.getUsername(), passwordEncoder.encode(registerUserDto.getPassword()));
        return appUserRepository.save(appUser);
    }
    public AppUser authenticate(LogInUserDto logInUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        logInUserDto.getUsername(),
                        logInUserDto.getPassword()
                )
        );
        return appUserRepository.findByUserName(logInUserDto.getUsername())
                .orElseThrow();
    }
}

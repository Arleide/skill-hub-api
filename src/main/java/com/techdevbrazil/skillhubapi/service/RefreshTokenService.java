package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.RefreshToken;
import com.techdevbrazil.skillhubapi.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    @Value("${security.jwt.refresh-expiration-minutes}")
    private long refreshExpiration;


    public RefreshToken create(Long userId) {
        RefreshToken token = new RefreshToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(
                LocalDateTime.now().plusMinutes(refreshExpiration));
        token.setRevoked(false);
        return repository.save(token);
    }
}


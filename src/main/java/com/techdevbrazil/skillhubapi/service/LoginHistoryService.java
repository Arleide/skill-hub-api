package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.LoginHistory;
import com.techdevbrazil.skillhubapi.repository.LoginHistoryRepository;
import com.techdevbrazil.skillhubapi.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;


    public void save(CustomUserDetails user, String token) {
        LoginHistory history = new LoginHistory();
        history.setUserId(user.getId());
        history.setEmail(user.getEmail());
        history.setAccessToken(token);
        loginHistoryRepository.save(history);
    }

}

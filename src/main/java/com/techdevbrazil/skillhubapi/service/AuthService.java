package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.dto.JwtResponse;
import com.techdevbrazil.skillhubapi.dto.LoginRequest;
import com.techdevbrazil.skillhubapi.dto.RegisterRequest;
import com.techdevbrazil.skillhubapi.entity.RefreshToken;
import com.techdevbrazil.skillhubapi.entity.Usuario;
import com.techdevbrazil.skillhubapi.repository.UsuarioRepository;
import com.techdevbrazil.skillhubapi.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final LoginHistoryService loginHistoryService;
    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public JwtResponse login(LoginRequest request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(), request.password()));

        CustomUserDetails user =
                (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken(user);
        RefreshToken refreshToken =
                refreshTokenService.create(user.getId());

        loginHistoryService.save(user, accessToken);

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register(RegisterRequest request) {

        if (userRepository.findByEmail(request.email()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario user = new Usuario();
        user.setNome(request.nome());
        user.setEmail(request.email());
        user.setSenha(passwordEncoder.encode(request.senha()));
        user.setAtivo(Boolean.TRUE);
        userRepository.save(user);
    }
}


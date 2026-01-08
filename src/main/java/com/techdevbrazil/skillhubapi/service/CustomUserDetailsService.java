package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.Usuario;
import com.techdevbrazil.skillhubapi.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByEmail(email);
        if (usuario == null) {
           throw  new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(usuario);
    }
}

package com.techdevbrazil.skillhubapi.dto;


public record RegisterRequest(
        String nome,
        String email,
        String senha
) {}

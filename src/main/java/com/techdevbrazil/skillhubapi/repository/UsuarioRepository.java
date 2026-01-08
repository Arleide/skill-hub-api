package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}

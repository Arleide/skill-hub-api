package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.ServicoOferecido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Long> {

    List<ServicoOferecido> findByUsuarioId(Long usuarioId);
}

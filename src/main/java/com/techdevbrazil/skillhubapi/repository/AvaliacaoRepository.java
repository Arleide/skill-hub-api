package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    Optional<Avaliacao> findBySolicitacaoServicoId(Long solicitacaoId);

}

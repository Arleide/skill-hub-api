package com.techdevbrazil.skillhubapi.repository;

import com.techdevbrazil.skillhubapi.entity.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoServicoRepository extends JpaRepository<SolicitacaoServico, Long> {

    List<SolicitacaoServico> findByUsuarioSolicitanteId(Long usuarioId);

    List<SolicitacaoServico> findByUsuarioPrestadorId(Long usuarioId);
}

package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.SolicitacaoServico;
import com.techdevbrazil.skillhubapi.enums.StatusSolicitacao;
import com.techdevbrazil.skillhubapi.repository.SolicitacaoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitacaoServicoService {

    private final SolicitacaoServicoRepository solicitacaoServicoRepository;

    public SolicitacaoServicoService(SolicitacaoServicoRepository solicitacaoServicoRepository) {
        this.solicitacaoServicoRepository = solicitacaoServicoRepository;
    }

    public List<SolicitacaoServico> findAll() {
        return solicitacaoServicoRepository.findAll();
    }

    public List<SolicitacaoServico> findAllSent(Long usuarioId) {
        return solicitacaoServicoRepository.findByUsuarioSolicitanteId(usuarioId);
    }

    public List<SolicitacaoServico> findAllReceived(Long usuarioId) {
        return solicitacaoServicoRepository.findByUsuarioPrestadorId(usuarioId);
    }

    public SolicitacaoServico findById(Long id) {
        return solicitacaoServicoRepository.findById(id).get();
    }

    public SolicitacaoServico save(SolicitacaoServico solicitacaoServico) {
        return solicitacaoServicoRepository.save(solicitacaoServico);
    }

    public SolicitacaoServico updateStatus(Long id, StatusSolicitacao status) {
        SolicitacaoServico solicitacao = findById(id);
        solicitacao.setStatus(status);
        return solicitacaoServicoRepository.save(solicitacao);
    }

    public void delete(Long id) {
        solicitacaoServicoRepository.deleteById(id);
    }
}

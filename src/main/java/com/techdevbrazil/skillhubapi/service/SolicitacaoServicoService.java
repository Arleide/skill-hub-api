package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.SolicitacaoServico;
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

    public SolicitacaoServico findById(Long id) {
        return solicitacaoServicoRepository.findById(id).get();
    }

    public SolicitacaoServico save(SolicitacaoServico solicitacaoServico) {
        return solicitacaoServicoRepository.save(solicitacaoServico);
    }

    public void delete(Long id) {
        solicitacaoServicoRepository.deleteById(id);
    }
}

package com.techdevbrazil.skillhubapi.service;

import com.techdevbrazil.skillhubapi.entity.Avaliacao;
import com.techdevbrazil.skillhubapi.repository.AvaliacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    private final  AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public Optional<Avaliacao> findBySolicitacaoServicoId(Long solicitacaoId) {
        return avaliacaoRepository.findBySolicitacaoServicoId(solicitacaoId);
    }

    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }

}

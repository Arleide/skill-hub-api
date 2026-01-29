package com.techdevbrazil.skillhubapi.controller;

import com.techdevbrazil.skillhubapi.entity.Avaliacao;
import com.techdevbrazil.skillhubapi.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Avaliações")
@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll() {
        return ResponseEntity.ok(avaliacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Long id) {
            return ResponseEntity.ok(avaliacaoService.findById(id));
    }

    @GetMapping("/solicitacao/{solicitacaoId}")
    public ResponseEntity<Avaliacao> findBySolicitacaoServico(
            @PathVariable Long solicitacaoId) {

        return avaliacaoService.findBySolicitacaoServicoId(solicitacaoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> save(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoService.save(avaliacao));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        avaliacaoService.delete(id);
    }

}

package com.techdevbrazil.skillhubapi.controller;

import com.techdevbrazil.skillhubapi.entity.SolicitacaoServico;
import com.techdevbrazil.skillhubapi.security.CustomUserDetails;
import com.techdevbrazil.skillhubapi.service.SolicitacaoServicoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Solicitações Serviços")
@RestController
@RequestMapping("/solicitacoes-servicos")
public class SolicitacaoServicoController {

    private final SolicitacaoServicoService solicitacaoServicoService;

    public SolicitacaoServicoController(SolicitacaoServicoService solicitacaoServicoService) {
        this.solicitacaoServicoService = solicitacaoServicoService;
    }

    @GetMapping
    public ResponseEntity<List<SolicitacaoServico>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoServicoService.findAll());
    }

    @GetMapping("/enviadas")
    public ResponseEntity<List<SolicitacaoServico>> findAllSent(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoServicoService.findAllSent(user.getId()));
    }

    @GetMapping("/recebidas")
    public ResponseEntity<List<SolicitacaoServico>> findAllReceived(Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(solicitacaoServicoService.findAllReceived(user.getId()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoServico> findById(@PathVariable Long id) {
        return ResponseEntity.ok(solicitacaoServicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SolicitacaoServico> save(@RequestBody SolicitacaoServico solicitacaoServico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitacaoServicoService.save(solicitacaoServico));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        solicitacaoServicoService.delete(id);
    }
}

package com.techdevbrazil.skillhubapi.entity;

import com.techdevbrazil.skillhubapi.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitacoes_servicos", schema = "skillhub")
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_solicitante_id")
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_ptrstador_id")
    private Usuario usuarioPrestador;

    @ManyToOne
    @JoinColumn(name = "servico_oferecido_id")
    private ServicoOferecido servicoOferecido;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao status;

    private LocalDateTime dataRealizacao;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

}

package com.techdevbrazil.skillhubapi.dto;

import com.techdevbrazil.skillhubapi.enums.StatusSolicitacao;
import lombok.Data;

@Data
public class AtualizarStatusSolicitacaoDTO {
    private StatusSolicitacao status;
}
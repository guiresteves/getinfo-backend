package com.getinfo.contratos.DTOs;


import com.getinfo.contratos.entity.Contrato;
import com.getinfo.contratos.enums.StatusContrato;
import com.getinfo.contratos.enums.TipoContrato;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContratoCreateDTO {

    private Long empresaId;
    private StatusContrato status;
    private BigDecimal valor;
    private String descricao;
    private TipoContrato tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ContratoCreateDTO() {
    }

    public ContratoCreateDTO(Contrato contrato) {
        empresaId = contrato.getEmpresaId().getId();
        status = contrato.getStatus();
        valor = contrato.getValor();
        descricao = contrato.getDescricao();
        tipo = contrato.getTipo();
        dataInicio = contrato.getDataInicio();
        dataFim = contrato.getDataFim();
    }

}

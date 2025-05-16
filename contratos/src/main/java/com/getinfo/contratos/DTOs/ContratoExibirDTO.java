package com.getinfo.contratos.DTOs;

import com.getinfo.contratos.enums.StatusContrato;
import com.getinfo.contratos.enums.TipoContrato;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ContratoExibirDTO {

    private Long id;
    private StatusContrato status;
    private BigDecimal valor;
    private TipoContrato tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String nomeFantasiaEmpresa;

    public ContratoExibirDTO() {
    }
}

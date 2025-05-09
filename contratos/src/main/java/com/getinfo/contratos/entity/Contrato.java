package com.getinfo.contratos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getinfo.contratos.enums.StatusContrato;
import com.getinfo.contratos.enums.TipoContrato;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "id_empresa")
    private Empresa empresa;

    //@ManyToMany
    //@JoinTable(
            //name= "contrato_funcionario",
            //joinColumns = @JoinColumn(name = "id_contrato"),
            //inverseJoinColumns = @JoinColumn(name = "id_funcionario")
    //)
   // private List<Funcionario> funcionarios;

    //@OneToMany(mappedBy = "contrato", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
   //private List<Entregavel> entregaveis;


    @Enumerated(EnumType.STRING)
    private StatusContrato statusContrato;



    private BigDecimal valor;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;
    @Lob
    private byte[] anexo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}

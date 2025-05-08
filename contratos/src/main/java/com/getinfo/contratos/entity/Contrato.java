package com.getinfo.contratos.entity;

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
    @JoinColumn(name= "id_empresa", unique = true, nullable = false)
    private Empresa empresa;

    //@ManyToMany
    //@JoinTable(
            //name = "contrato_funcionario",
            //joinColumns = @JoinColumn(name = "contrato_id"),
           // inverseJoinColumns = @JoinColumn(name = "funcionario_id")
    //)
    //private List<Funcionario> funcionarios;

    @Enumerated(EnumType.STRING)
    private StatusContrato statusContrato;

    //@OneToMany
    //@JoinColumn(name = "id_entregavel")
    //private List<Entregavel> entregavel;

    private BigDecimal valor;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;
    @Lob
    private byte[] anexo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}

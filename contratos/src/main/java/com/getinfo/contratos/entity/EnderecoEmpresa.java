package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class EnderecoEmpresa {

    @Id
    @GeneratedValue
    private Long idEndereco;

    @OneToOne
    @JoinColumn(name = "id_empresa", unique = true, nullable = false)
    private Empresa empresa;

    private String logradouro;
    private String cep;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;


}

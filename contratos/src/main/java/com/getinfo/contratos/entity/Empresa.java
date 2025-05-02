package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    private Long idEndereco;
    private Long idResponsavel;
//    @ManyToOne
//    @JoinColumn(name = "id_telefone")
//    private TelefoneEmpresa telefone;

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Short tipo;
}

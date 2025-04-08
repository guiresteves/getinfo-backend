package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String endereco;

}

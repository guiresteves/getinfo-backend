package com.getinfo.contratos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Short tipo;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String telefone;
    private String email;
    private String cidade;
    private String complemento;
    private String nomeResponsavel;
    private String emailResponsavel;
    private String telefoneResponsavel;
    private String cpfResponsavel;
}

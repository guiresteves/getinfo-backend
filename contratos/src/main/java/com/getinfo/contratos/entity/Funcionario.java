package com.getinfo.contratos.entity;

import com.getinfo.contratos.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToMany
    //@JoinColumn(name = "id_contrato")
    //private List<Contrato> contratos;

    private String nome;
    private String sobrenome;
    private FuncionarioStatus status;
    private String cpf;
    private String email;
    private String telefone;
    private String cargo;

}

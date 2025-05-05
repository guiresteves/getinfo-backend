package com.getinfo.contratos.entity;

import com.getinfo.contratos.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.Data;

// // CREATE TABLE `funcionario` (
//     `id_funcionario` INT NOT NULL,
//     `nome` VARCHAR(255),
//     `ativo` TINYINT(1),
//     `cpf` VARCHAR(255),
//     `contato` VARCHAR(255),
//     `id_cargo` INT,
//     PRIMARY KEY (`id_funcionario`),
//     FOREIGN KEY (`id_cargo`) REFERENCES `cargo`(`id_cargo`)
//         ON UPDATE CASCADE ON DELETE RESTRICT
// );
//
@Entity
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private FuncionarioStatus status;

    private String cpf;


    private String email;
    private String telefone;
    // Aind a ser adicionado
//    private Long idCargo;
}
